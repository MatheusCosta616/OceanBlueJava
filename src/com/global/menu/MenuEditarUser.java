package com.global.menu;

import com.global.authenticator.BuscarUser;
import com.global.authenticator.EditarUser;
import com.global.model.AssinaturaModel;
import com.global.model.UserModel;

import java.util.Scanner;

/*
    Classe MenuEditarUser
    Esta classe representa o menu para edição de usuários no sistema.
    Ela permite ao usuário buscar um usuário pelo ID e editar suas informações, como email, senha e nome.
    Além disso, também oferece a opção de editar o tipo de assinatura do usuário, se aplicável.

    Funcionalidades:
    - Solicita ao usuário o ID do usuário que deseja editar.
    - Busca o usuário com o ID fornecido.
    - Permite ao usuário editar o email, senha e nome do usuário.
    - Se o usuário tiver uma assinatura, permite editar o tipo de assinatura.
    - Chama o método editarUser da classe EditarUser para realizar as alterações no arquivo JSON.

    Exemplo de uso:
    - === Menu de Edição de Usuário ===
      1. Editar Usuário
      2. Sair
    - Escolha uma opção: 1
    - Digite o ID do usuário: 123
    - Digite o novo email do usuário: novoemail@example.com
    - Digite a nova senha do usuário (somente números): 123456
    - Digite o novo nome do usuário: Novo Usuário
    - Digite o novo tipo de assinatura: Assinatura Premium
    - Usuário editado no arquivo JSON com userId: 123
*/


public class MenuEditarUser {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        BuscarUser buscarUser = new BuscarUser();
        EditarUser editarUser = new EditarUser();

        while (true) {
            System.out.println("=== Menu de Edição de Usuário ===");
            System.out.println("1. Editar Usuário");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o ID do usuário: ");
                int userId = scanner.nextInt();
                scanner.nextLine();

                UserModel userModel = buscarUser.buscarUser(userId);
                if (userModel == null) {
                    System.out.println("Usuário com ID " + userId + " não encontrado.");
                    continue;
                }

                System.out.print("Digite o novo email do usuário: ");
                String userEmail = scanner.nextLine();

                int userPassword;
                while (true) {
                    System.out.print("Digite a nova senha do usuário (somente números): ");
                    if (scanner.hasNextInt()) {
                        userPassword = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Erro: A senha deve conter apenas números. Por favor, tente novamente.");
                        scanner.nextLine();
                    }
                }

                System.out.print("Digite o novo nome do usuário: ");
                String userName = scanner.nextLine();

                AssinaturaModel assinatura = userModel.getAssinatura();
                if (assinatura != null) {
                    System.out.print("Digite o novo tipo de assinatura: ");
                    String tipoDeAssinatura = scanner.nextLine();
                    assinatura.setTipoDeAssinatura(tipoDeAssinatura);
                }

                userModel.setUserEmail(userEmail);
                userModel.setUserPassword(userPassword);
                userModel.setUserName(userName);

                editarUser.editarUser(userModel);
            } else if (opcao == 2) {
                System.out.println("Saindo do menu de edição.");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
