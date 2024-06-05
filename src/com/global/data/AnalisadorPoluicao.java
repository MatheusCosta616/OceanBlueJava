package com.global.data;

import com.global.data.Registro;

import java.util.List;

/*
    Classe AnalisadorPoluicao
    Esta classe analisa a poluição de um registro de dados de um sensor em um rio. Ele verifica se os dados do sensor
    indicam que o rio está poluído, comparando os níveis de pH, oxigênio dissolvido e turbidez com limiares predefinidos.
    Os limiares são definidos como pH > 7.0, oxigênio dissolvido < 5.0 mg/L e turbidez > 10.0 NTU. Se algum desses
    critérios for atendido, o método retorna true, indicando poluição; caso contrário, retorna false.

    Cálculo da poluição:
    - Se o pH for maior que 7.0, o rio é considerado poluído.
    - Se o nível de oxigênio dissolvido for menor que 5.0 mg/L, o rio é considerado poluído.
    - Se a turbidez for maior que 10.0 NTU, o rio é considerado poluído.

    Exemplos de valores:
    Exemplo de rio poluído:
    - Nome do rio: Rio Contaminado
    - Modelo do sensor: Sensor Poluição 2000
    - Status do sensor: Funcionando
    - Latitude: -20.1234
    - Longitude: -40.5678
    - Nível de pH: 8.2
    - Nível de oxigênio dissolvido: 3.8
    - Nível de turbidez: 12.6

    Neste exemplo, o nível de pH é maior que 7.0 (8.2), o nível de oxigênio dissolvido é menor que 5.0 mg/L (3.8),
    e a turbidez é maior que 10.0 NTU (12.6), portanto, o rio é considerado poluído.

    Exemplo de rio não poluído:
    - Nome do rio: Rio Limpo
    - Modelo do sensor: Sensor Pureza 3000
    - Status do sensor: Funcionando
    - Latitude: -15.6789
    - Longitude: -50.9876
    - Nível de pH: 7.5
    - Nível de oxigênio dissolvido: 6.3
    - Nível de turbidez: 8.4

    Neste exemplo, todos os critérios para poluição não são atendidos, portanto, o rio é considerado não poluído.
*/


public class AnalisadorPoluicao {

    private List<Registro> registros;

    public AnalisadorPoluicao(List<Registro> registros) {
        this.registros = registros;
    }

    public String analisaPoluicao(int registerId) {
        Registro registro = null;

        for (Registro r : registros) {
            if (r.getRegisterId() == registerId) {
                registro = r;
                break;
            }
        }

        if (registro == null) {
            return "Registro com registerId " + registerId + " não encontrado.";
        }

        float phLimiar = 7.0f;
        float dissolvedOxygenLimiar = 5.0f;
        float turbidityLimiar = 10.0f;

        boolean isPolluted = registro.getPhLevel() > phLimiar ||
                registro.getDissolvedOxygenLevel() < dissolvedOxygenLimiar ||
                registro.getTurbidityLevel() > turbidityLimiar;

        return "Análise do Registro ID " + registerId + ":\n" +
                "Nome do Rio: " + registro.getRioName() + "\n" +
                "Modelo do Sensor: " + registro.getSensorModelo() + "\n" +
                "Status do Sensor: " + registro.getSensorStatus() + "\n" +
                "Latitude: " + registro.getSensorLatitude() + "\n" +
                "Longitude: " + registro.getSensorLongitude() + "\n" +
                "Nível de pH: " + registro.getPhLevel() + "\n" +
                "Nível de Oxigênio Dissolvido: " + registro.getDissolvedOxygenLevel() + "\n" +
                "Nível de Turbidez: " + registro.getTurbidityLevel() + "\n" +
                "Poluído: " + (isPolluted ? "Sim" : "Não");
    }
}
