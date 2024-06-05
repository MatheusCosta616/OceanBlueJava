package com.global.authenticator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.global.model.AssinaturaModel;
import com.global.model.UserModel;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
    Classe BuscarUser
    Esta classe é responsável por buscar informações de um usuário a partir do seu ID em um arquivo JSON.
    Ela lê o arquivo JSON que contém informações de usuários e percorre o array de usuários para encontrar o usuário com o ID especificado.
    Ao encontrar o usuário, ela extrai as informações relevantes, como nome, email, senha, data de cadastro e assinatura (se existir).
    Se o usuário for encontrado, um objeto UserModel é criado com as informações encontradas e retornado.
    Caso contrário, se o arquivo JSON não existir, estiver vazio ou o usuário não for encontrado, é exibida uma mensagem apropriada e retorna null.
*/

public class BuscarUser {
    private final File arquivoJson = new File("dataUser.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserModel buscarUser(int userId) {
        try {
            if (!arquivoJson.exists()) {
                System.out.println("Arquivo JSON não existe.");
                return null;
            }

            JsonNode rootNodeJson = objectMapper.readTree(arquivoJson);
            if (!rootNodeJson.isObject()) {
                System.out.println("Formato de arquivo JSON inválido.");
                return null;
            }

            ArrayNode usersArray = (ArrayNode) rootNodeJson.get("users");

            for (JsonNode userNode : usersArray) {
                if (userNode.get("userId").asInt() == userId) {
                    String userName = userNode.get("userName").asText();
                    String userEmail = userNode.get("userEmail").asText();
                    int userPassword = userNode.get("userPassword").asInt();
                    LocalDate userDate = LocalDate.parse(userNode.get("Data de cadastro").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    AssinaturaModel assinatura = null;
                    if (userNode.has("assinatura")) {
                        JsonNode assinaturaNode = userNode.get("assinatura");
                        int assinaturaId = assinaturaNode.get("assinaturaId").asInt();
                        String tipoDeAssinatura = assinaturaNode.get("tipoDeAssinatura").asText();
                        LocalDate dataInicio = LocalDate.parse(assinaturaNode.get("dataInicio").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        LocalDate dataFim = LocalDate.parse(assinaturaNode.get("dataFim").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        assinatura = new AssinaturaModel(tipoDeAssinatura);
                        assinatura.setAssinaturaId(assinaturaId);
                        assinatura.setDataInicio(dataInicio);
                        assinatura.setDataFim(dataFim);
                    }

                    UserModel userModel = new UserModel(userName, userEmail, userPassword, assinatura);
                    userModel.setUserId(userId);
                    userModel.setUserDate(userDate);
                    return userModel;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
