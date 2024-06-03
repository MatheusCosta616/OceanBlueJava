package com.global.menu;

import com.global.authenticator.CadastroUser;
import com.global.model.UserModel;
import com.global.model.AssinaturaModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCadastro {

    /*
    Classe MenuCadastro
    Este menu permite ao usuário interagir com o sistema para cadastrar novos usuários.
    O usuário pode escolher entre as opções de cadastrar um novo usuário ou sair do sistema.
    Ao escolher a opção de cadastro de usuário, são solicitados o nome, email, senha e tipo de assinatura do usuário.
    Após o preenchimento dos dados, um novo objeto UserModel é criado com as informações fornecidas e passado para o método
    `cadastrarUser()` da classe CadastroUser para realizar o cadastro.
    Se uma opção inválida for inserida, o sistema informa ao usuário e solicita uma nova entrada.
*/

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        CadastroUser cadastro = new CadastroUser();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do usuário: ");
                        String userName = scanner.nextLine();
                        System.out.print("Digite o email do usuário: ");
                        String userEmail = scanner.nextLine();
                        System.out.print("Digite a senha do usuário: ");
                        int userPassword = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Digite o tipo de assinatura: ");
                        String tipoDeAssinatura = scanner.nextLine();

                        AssinaturaModel assinatura = new AssinaturaModel( tipoDeAssinatura);

                        UserModel userModel = new UserModel(userName, userEmail, userPassword, assinatura);

                        cadastro.cadastrarUser(userModel);
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
