package com.global.menu;

import com.global.authenticator.CadastroRegistro;
import com.global.data.Registro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Classe MenuCadastroRegistro
    Esta classe representa o menu para o cadastro de novos registros no sistema.
    Ela solicita ao usuário os detalhes do registro, como nome do rio, modelo do sensor, status do sensor, latitude, longitude e os níveis de pH, oxigênio dissolvido e turbidez da água.
    Após receber os dados, realiza o cadastro do registro chamando o método cadastrarRegistro da classe CadastroRegistro.

    Funcionalidades:
    - Solicita ao usuário os detalhes do registro.
    - Converte as entradas do usuário para os tipos de dados adequados.
    - Chama o método cadastrarRegistro da classe CadastroRegistro para armazenar o registro no sistema.
    - Adiciona o registro à lista de registros para fins de controle.

    Exemplo de uso:
    - Digite o nome do rio: Amazonas
    - Digite o modelo do sensor: Modelo 1
    - Digite o status do sensor (FUNCIONANDO/DESLIGADO): Funcionando
    - Digite a latitude do sensor: -3.4657
    - Digite a longitude do sensor: -62.2159
    - Digite o nível de pH da água: 6.8
    - Digite o nível de oxigênio dissolvido da água: 4.2
    - Digite o nível de turbidez da água: 8.5
    - Registro cadastrado com sucesso!
*/


public class MenuCadastroRegistro {
    private static final CadastroRegistro cadastroRegistro = new CadastroRegistro();
    private static final List<Registro> registros = new ArrayList<>();

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Registro ===");

        System.out.print("Digite o nome do rio: ");
        String rioName = scanner.nextLine();

        System.out.print("Digite o modelo do sensor: ");
        String sensorModelo = scanner.nextLine().toUpperCase();

        System.out.print("Digite o status do sensor (FUNCIONANDO/DESLIGADO): ");
        String sensorStatus = scanner.nextLine();

        System.out.print("Digite a latitude do sensor: ");
        String sensorLatitudeStr = scanner.nextLine();
        float sensorLatitude = Float.parseFloat(sensorLatitudeStr);

        System.out.print("Digite a longitude do sensor: ");
        String sensorLongitudeStr = scanner.nextLine();
        float sensorLongitude = Float.parseFloat(sensorLongitudeStr);

        System.out.print("Digite o nível de pH da água: ");
        String phLevelStr = scanner.nextLine();
        float phLevel = Float.parseFloat(phLevelStr);

        System.out.print("Digite o nível de oxigênio dissolvido da água: ");
        String dissolvedOxygenLevelStr = scanner.nextLine();
        float dissolvedOxygenLevel = Float.parseFloat(dissolvedOxygenLevelStr);

        System.out.print("Digite o nível de turbidez da água: ");
        String turbidityLevelStr = scanner.nextLine();
        float turbidityLevel = Float.parseFloat(turbidityLevelStr);

        Registro registro = new Registro(rioName, sensorModelo, sensorStatus, sensorLatitude, sensorLongitude,
                phLevel, dissolvedOxygenLevel, turbidityLevel);

        try {
            cadastroRegistro.cadastrarRegistro(registro);
            registros.add(registro);
            System.out.println("Registro cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar registro: " + e.getMessage());
        }
    }

    public static List<Registro> getRegistros() {
        return registros;
    }

    public static void main(String[] args) {
        menu();
    }
}
