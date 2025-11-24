import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        short opcao = -1;
        ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas();



        while (opcao != 0) {
            System.out.println("""
                            Conversor de Moedas
                    1. Real para Dólar (BRL -> USD)
                    2. Dólar para Real (USD -> BRL)
                    3. Real para Peso Argentino (BRL -> ARS)
                    4. Peso Argentino para Real (ARS -> BRL)
                    5. Real para Peso Chileno (BRL -> CLP)
                    6. Peso Chileno para Real (CLP -> BRL)
                    0. Sair da Aplicação
                    """);
            System.out.print("Digite a opção: ");
            opcao = entrada.nextShort();

            if (opcao == 1) {
                conversorDeMoedas.chamarApi("BRL", "USD");
            } else if (opcao == 2) {
                conversorDeMoedas.chamarApi("USD", "BRL");
            } else if (opcao == 3) {
                conversorDeMoedas.chamarApi("BRL", "ARS");
            } else if (opcao == 4) {
                conversorDeMoedas.chamarApi("ARS", "BRL");
            } else if (opcao == 5) {
                conversorDeMoedas.chamarApi("BRL", "CLP");
            } else if (opcao == 6) {
                conversorDeMoedas.chamarApi("CLP", "BRL");
            } else if (opcao == 0) {
                System.out.println("Finalizando...");
            } else {
                System.out.println("Opcção inválida, digite novamente");
            }
        }
        entrada.close();
        System.out.println("Fim do programa");
    }
}
