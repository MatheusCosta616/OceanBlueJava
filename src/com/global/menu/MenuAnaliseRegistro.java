package com.global.menu;

import com.global.data.AnalisadorPoluicao;
import com.global.data.Registro;

import java.util.Scanner;

/*
    Classe MenuAnaliseRegistro
    Esta classe representa o menu para análise de registros de poluição.
    Ela permite ao usuário digitar o ID do registro que deseja analisar e exibe o resultado da análise de poluição para esse registro.

    Funcionalidades:
    - Solicita ao usuário o ID do registro para análise.
    - Utiliza a classe AnalisadorPoluicao para realizar a análise com base nos registros cadastrados.
    - Exibe o resultado da análise de poluição para o registro selecionado.

    Exemplo de uso:
    - Digite o ID do registro para análise: 123
    - Análise do Registro ID 123:
      Nome do Rio: Amazonas
      Modelo do Sensor: Modelo 1
      Status do Sensor: Funcionando
      Latitude: -3.4657
      Longitude: -62.2159
      Nível de pH: 6.8
      Nível de Oxigênio Dissolvido: 4.2
      Nível de Turbidez: 8.5
      Poluído: Não
*/


public class MenuAnaliseRegistro {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do registro para análise: ");
        int registerId = scanner.nextInt();
        scanner.nextLine();

        AnalisadorPoluicao analisador = new AnalisadorPoluicao(MenuCadastroRegistro.getRegistros());
        String resultadoAnalise = analisador.analisaPoluicao(registerId);
        System.out.println(resultadoAnalise);
    }
}
