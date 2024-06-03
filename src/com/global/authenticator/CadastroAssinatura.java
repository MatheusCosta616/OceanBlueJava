package com.global.authenticator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.global.model.AssinaturaModel;

import java.io.File;
import java.io.IOException;

public class CadastroAssinatura {
    private static final File arquivoJson = new File("dataUser.json");

    /*
    Classe Cadastro de Assinatura
    Este método utiliza da biblioteca Jackson databind para criar um Json externo para armazenar os valores das
    assinaturas do serviço, este método armazena os valores como id da assinatura, tipo de assinatura,
    data de inicio da assinatura e data de vencimento da assinatura.
    Sua funcionalidade utiliza da criação de nodes atraves do jackson para criar os indices do json
    e armazenar os valores dentro desse node, mantendo o json legivel
     */

    public void cadastrarAssinatura(AssinaturaModel assinaturaModel) {
        if (!arquivoJson.exists()) {
            System.out.println("Arquivo JSON não encontrado. A operação de cadastro de assinatura não pode ser realizada.");
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            JsonNode rootNodeJson = objectMapper.readTree(arquivoJson);
            ObjectNode rootNode;
            if (rootNodeJson.isObject()) {
                rootNode = (ObjectNode) rootNodeJson;
            } else {
                System.out.println("Estrutura do arquivo JSON inválida.");
                return;
            }

            ArrayNode assinaturasArray = (ArrayNode) rootNode.get("assinaturas");
            if (assinaturasArray == null) {
                assinaturasArray = objectMapper.createArrayNode();
                rootNode.set("assinaturas", assinaturasArray);
            }

            ObjectNode assinaturaNode = objectMapper.createObjectNode();
            assinaturaNode.put("assinaturaId", assinaturaModel.getAssinaturaId());
            assinaturaNode.put("tipoDeAssinatura", assinaturaModel.getTipoDeAssinatura());
            assinaturaNode.put("dataInicio", assinaturaModel.getDataInicio().toString());
            assinaturaNode.put("dataFim", assinaturaModel.getDataFim().toString());

            assinaturasArray.add(assinaturaNode);
            objectMapper.writeValue(arquivoJson, rootNode);
            System.out.println("Assinatura adicionada ao arquivo JSON com assinaturaId: " + assinaturaModel.getAssinaturaId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}