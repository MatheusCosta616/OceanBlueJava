package com.global.menu;

import com.global.authenticator.CadastroRegistro;
import com.global.data.Registro;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCadastroRegistro {

    /*
    Classe MenuCadastroRegistro
    Este menu permite ao usuário interagir com o sistema para cadastrar novos registros.
    O usuário pode escolher entre as opções de cadastrar um novo registro ou sair do sistema.
    Ao escolher a opção de cadastro de registro, são solicitadas informações como nome do rio, modelo do sensor,
    status do sensor, latitude e longitude do sensor.
    A latitude e a longitude são convertidas para float utilizando o método `Float.parseFloat()`.
    Após o preenchimento dos dados, um novo objeto Registro é criado com as informações fornecidas e passado para o método
    `cadastrarRegistro()` da classe CadastroRegistro para realizar o cadastro.
    Se uma opção inválida for inserida, o sistema informa ao usuário e solicita uma nova entrada.
*/



    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        CadastroRegistro cadastroRegistro = new CadastroRegistro();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Registro");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do rio: ");
                        String rioName = scanner.nextLine();

                        System.out.print("Digite o modelo do sensor: ");
                        String sensorModelo = scanner.nextLine();

                        System.out.print("Digite o status do sensor: ");
                        String sensorStatus = scanner.nextLine();

                        System.out.print("Digite a latitude do sensor: ");
                        float sensorLatitude = Float.parseFloat(scanner.nextLine());

                        System.out.print("Digite a longitude do sensor: ");
                        float sensorLongitude = Float.parseFloat(scanner.nextLine());
                        scanner.nextLine();

                        Registro registro = new Registro(rioName, sensorModelo, sensorStatus, sensorLatitude, sensorLongitude);

                        try {
                            cadastroRegistro.cadastrarRegistro(registro);
                        } catch (IOException e) {
                            System.out.println("Erro ao cadastrar registro: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção Inválida! Tente novamente.");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
