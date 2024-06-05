package com.global.authenticator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.global.model.AssinaturaModel;
import com.global.model.UserModel;

import java.io.File;
import java.io.IOException;

/*
    Classe EditarUser
    Esta classe é responsável por editar as informações de um usuário no arquivo JSON "dataUser.json".
    Ela recebe um objeto UserModel contendo as informações atualizadas do usuário e busca no arquivo JSON o usuário correspondente pelo userId.
    Se o usuário for encontrado, suas informações são atualizadas com os novos valores fornecidos no UserModel.
    Se o usuário possuir uma assinatura, as informações da assinatura também são atualizadas.
    Caso contrário, se o arquivo JSON não existir, estiver vazio, o usuário não for encontrado ou não possuir uma assinatura,
    são exibidas mensagens apropriadas e nenhum arquivo JSON é modificado.
*/


public class EditarUser {
    private final File arquivoJson = new File("dataUser.json");
    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public void editarUser(UserModel userModel) {
        try {
            if (!arquivoJson.exists()) {
                System.out.println("Arquivo JSON não existe.");
                return;
            }

            JsonNode rootNodeJson = objectMapper.readTree(arquivoJson);
            if (!rootNodeJson.isObject()) {
                System.out.println("Formato de arquivo JSON inválido.");
                return;
            }

            ObjectNode rootNode = (ObjectNode) rootNodeJson;
            ArrayNode usersArray = (ArrayNode) rootNode.get("users");

            for (JsonNode userNode : usersArray) {
                if (userNode.get("userId").asInt() == userModel.getUserId()) {
                    ((ObjectNode) userNode).put("userEmail", userModel.getUserEmail());
                    ((ObjectNode) userNode).put("userPassword", userModel.getUserPassword());
                    ((ObjectNode) userNode).put("userName", userModel.getUserName());

                    AssinaturaModel assinatura = userModel.getAssinatura();
                    if (assinatura != null) {
                        JsonNode assinaturaNode = userNode.get("assinatura");
                        if (assinaturaNode != null) {
                            ((ObjectNode) assinaturaNode).put("tipoDeAssinatura", assinatura.getTipoDeAssinatura());
                            ((ObjectNode) assinaturaNode).put("dataInicio", assinatura.getDataInicio().toString());
                            ((ObjectNode) assinaturaNode).put("dataFim", assinatura.getDataFim().toString());
                        } else {
                            ObjectNode newAssinaturaNode = objectMapper.createObjectNode();
                            newAssinaturaNode.put("assinaturaId", assinatura.getAssinaturaId());
                            newAssinaturaNode.put("tipoDeAssinatura", assinatura.getTipoDeAssinatura());
                            newAssinaturaNode.put("dataInicio", assinatura.getDataInicio().toString());
                            newAssinaturaNode.put("dataFim", assinatura.getDataFim().toString());
                            ((ObjectNode) userNode).set("assinatura", newAssinaturaNode);
                        }
                    }

                    objectMapper.writeValue(arquivoJson, rootNode);
                    System.out.println("Usuário editado no arquivo JSON com userId: " + userModel.getUserId());
                    return;
                }
            }

            System.out.println("Usuário com userId " + userModel.getUserId() + " não encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
