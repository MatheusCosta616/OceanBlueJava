package com.global.authenticator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.global.data.Registro;

import java.io.File;
import java.io.IOException;

/*
    Classe CadastroRegistro
    Este método utiliza a biblioteca Jackson databind para criar um JSON externo a fim de armazenar os registros do serviço.
    O método `cadastrarRegistro` armazena os valores provenientes de um objeto da classe `Registro`, incluindo informações
    como `registerId`, `rioName`, `sensorId`, `sensorModelo`, `sensorStatus`, `sensorLatitude` e `sensorLongitude`.

    A funcionalidade do método envolve a criação de nós (nodes) através do Jackson para estruturar os índices do JSON
    e armazenar os valores dentro desses nós, garantindo que o JSON gerado permaneça legível. Se o arquivo JSON já existir,
    o método o lê e atualiza, caso contrário, cria um novo arquivo JSON para armazenar os registros.
*/

public class CadastroRegistro {
    private static final File arquivoJson = new File("dataRegistro.json");

    public void cadastrarRegistro(Registro registro) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectNode rootNode = null;

        if (arquivoJson.exists()) {
            JsonNode rootNodeJson = objectMapper.readTree(arquivoJson);
            if (rootNodeJson.isObject()) {
                rootNode = (ObjectNode) rootNodeJson;
            }
        }

        if (rootNode == null) {
            rootNode = objectMapper.createObjectNode();
            rootNode.putArray("register");
        }

        ArrayNode registerArray = (ArrayNode) rootNode.get("register");

        ObjectNode dataNode = objectMapper.createObjectNode();
        dataNode.put("registerId", registro.getRegisterId());
        dataNode.put("rioName", registro.getRioName());
        dataNode.put("sensorId", registro.getSensorId());
        dataNode.put("sensorModelo", registro.getSensorModelo());
        dataNode.put("sensorStatus", registro.getSensorStatus());
        dataNode.put("sensorLatitude", registro.getSensorLatitude());
        dataNode.put("sensorLongitude", registro.getSensorLongitude());
        dataNode.put("phLevel", registro.getPhLevel());
        dataNode.put("dissolvedOxygenLevel", registro.getDissolvedOxygenLevel());
        dataNode.put("turbidityLevel", registro.getTurbidityLevel());

        registerArray.add(dataNode);

        objectMapper.writeValue(arquivoJson, rootNode);
        System.out.println("Registro cadastrado com sucesso!");
    }
}

