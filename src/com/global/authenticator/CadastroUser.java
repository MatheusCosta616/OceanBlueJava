package com.global.authenticator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.global.menu.MenuCadastro;
import com.global.model.UserModel;
import com.global.model.AssinaturaModel;

import java.io.File;
import java.io.IOException;

public class CadastroUser {
    private static final File arquivoJson = new File("dataUser.json");

    /*
    Classe CadastroUser
    Este método utiliza da biblioteca Jackson databind para criar um Json externo para armazenar os clientes do serviço,
    este método armazena os valores como nome, email, senha e os valores passado pelo outro método de armazenagem dos
    valores da assinatura. Sua funcionalidade utiliza da criação de nodes atraves do jackson para criar os indices do json
    e armazenar os valores dentro desse node, mantendo o json legivel
     */

    public void cadastrarUser(UserModel userModel) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            ObjectNode rootNode;
            if (arquivoJson.exists()) {
                JsonNode rootNodeJson = objectMapper.readTree(arquivoJson);

                if (rootNodeJson.isObject()) {
                    rootNode = (ObjectNode) rootNodeJson;
                } else {
                    rootNode = objectMapper.createObjectNode();
                    rootNode.set("users", objectMapper.createArrayNode());
                }
            } else {
                rootNode = objectMapper.createObjectNode();
                rootNode.set("users", objectMapper.createArrayNode());
            }

            ArrayNode usersArray = (ArrayNode) rootNode.get("users");

            ObjectNode userNode = objectMapper.createObjectNode();


            userNode.put("userId", userModel.getUserId());
            userNode.put("userEmail", userModel.getUserEmail());
            userNode.put("userPassword", userModel.getUserPassword());
            userNode.put("userName", userModel.getUserName());
            userNode.put("Data de cadastro", userModel.getUserDateAsString());

            if (userModel.getAssinatura() != null) {
                AssinaturaModel assinatura = userModel.getAssinatura();
                ObjectNode assinaturaNode = objectMapper.createObjectNode();
                assinaturaNode.put("assinaturaId", assinatura.getAssinaturaId());
                assinaturaNode.put("tipoDeAssinatura", assinatura.getTipoDeAssinatura());
                assinaturaNode.put("dataInicio", assinatura.getDataInicio().toString());
                assinaturaNode.put("dataFim", assinatura.getDataFim().toString());
                userNode.set("assinatura", assinaturaNode);
            }

            usersArray.add(userNode);

            objectMapper.writeValue(arquivoJson, rootNode);
            System.out.println("Usuário adicionado ao arquivo JSON com userId: " + userModel.getUserId());
            AssinaturaModel assinaturaModel = userModel.getAssinatura();
            System.out.println("Assinatura adicionada ao arquivo JSON com assinaturaId: " + assinaturaModel.getAssinaturaId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
