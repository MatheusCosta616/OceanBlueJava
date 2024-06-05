package com.global.menu;

import java.util.Scanner;

public class MenuPrincipal {

    /*
    Classe MenuPrincipal
    Esta classe representa o menu principal do sistema.
    Oferece opções para o usuário interagir com o sistema, como cadastrar usuário, editar usuário, cadastrar registro,
    analisar registro e sair do sistema.

    Funcionalidades:
    - Exibe o menu principal com as opções disponíveis.
    - Solicita ao usuário que escolha uma opção.
    - Encaminha para a funcionalidade correspondente de acordo com a opção escolhida.

    Exemplo de uso:
    - === Menu Principal ===
      1. Cadastrar Usuário
      2. Editar Usuário
      3. Cadastrar Registro
      4. Analisar Registro
      5. Sair
    - Escolha uma opção: 3
    - [O programa executa a funcionalidade correspondente ao usuário escolhido]
*/


    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Editar Usuário");
            System.out.println("3. Cadastrar Registro");
            System.out.println("4. Analisar Registro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    MenuCadastro.menu();
                    break;
                case 2:
                    MenuEditarUser.menu();
                    break;
                case 3:
                    MenuCadastroRegistro.menu();
                    break;
                case 4:
                    MenuAnaliseRegistro.menu();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
