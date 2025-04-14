import java.util.Scanner;

public class MainFilaSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaSimplesAtv fila = new FilaSimplesAtv(4);

        int opcao,vlr;
        String resp = "";
        String resp2 = "";


        do {
            System.out.println("\n*****SAFEFIL-|-|-MENU*****");
            System.out.println("1. Inserir Elemento");
            System.out.println("2. Inserir Elemento em Índice");
            System.out.println("3. Inserir Sequência");
            System.out.println("4. Remover Primeiro Elemento");
            System.out.println("5. Remover por Índice");
            System.out.println("6. Remover Sequencia");
            System.out.println("7. Remover Todas Ocorrências");
            System.out.println("8. Buscar Elemento");
            System.out.println("9. Buscar por Índice");
            System.out.println("10. Ordenar Crescente");
            System.out.println("11. Ordenar Decrescente");
            System.out.println("12. Verificar se está cheia");
            System.out.println("13. Verificar se está vazia");
            System.out.println("14. Quantidade de Elementos");
            System.out.println("15. Dobrar Capacidade");
            System.out.println("16. Editar Elemento");
            System.out.println("17. Limpar Fila");
            System.out.println("18. Exibir Fila");
            System.out.println("19. Obter Primeiro Elemento");
            System.out.println("20. Obter Último Elemento");
            System.out.println("21. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor: ");
                    vlr = scanner.nextInt();
                    fila.inserirElemento(vlr);
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Digite o valor: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite o índice: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();
                    fila.inserirElementoIndice(valor, indice);
                    break;
                case 3:
                    while(!resp.equalsIgnoreCase("n")){
                        System.out.println("coloque numero");
                        int num = scanner.nextInt();
                        fila.inserirSequencia(num);
                        System.out.println("De novo? (s/n)");
                        resp = scanner.next();}
                case 4:
                    fila.removerElemento();
                    break;
                case 5:
                    System.out.print("Digite o índice: ");
                    vlr = scanner.nextInt();
                    fila.removerIndice(vlr);
                    scanner.nextLine();
                    break;
                case 6:
                    while (!resp2.equalsIgnoreCase("n")) {
                        System.out.println("Coloque um número");
                        int num = scanner.nextInt();
                        fila.removerSequencia(num);
                        System.out.println("De novo? (s/n)");
                        resp2 = scanner.next();
                    }
                case 7:
                    System.out.print("Digite o valor: ");
                    vlr = scanner.nextInt();
                    fila.removerTodasOcorrencias(vlr);
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.print("Digite o valor: ");
                    vlr = scanner.nextInt();
                    System.out.println(fila.buscarElemento(vlr));
                    scanner.nextLine();
                    break;
                case 9:
                    System.out.print("Digite o índice: ");
                    vlr = scanner.nextInt();
                    fila.buscarElementoIndice(vlr);
                    scanner.nextLine();
                    break;
                case 10:
                    fila.ordenarCrescente();
                    fila.exibir();
                    break;
                case 11:
                    fila.ordenarDecrescente();
                    fila.exibir();
                    break;
                case 12:
                    System.out.println("Fila cheia? ");
                    if(fila.estaCheia()){
                        System.out.println("Sim, a fila está cheia");
                    }else{
                        System.out.println("Não, a fila tem indíces livres");
                    }
                    break;
                case 13:
                    System.out.print("Fila vazia? ");
                    if (fila.estaVazia()) {
                        System.out.print("SIm, a fila está vazia");
                    }else{
                        System.out.print("Não, a fila não está vazia");
                    }
                    break;
                case 14:
                    System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
                    break;
                case 15:
                    fila.dobrarCapacidade();
                    break;
                case 16:
                    System.out.print("Digite o valor antigo: ");
                    int antigo = scanner.nextInt();
                    System.out.print("Digite o valor novo: ");
                    int novo = scanner.nextInt();
                    scanner.nextLine();
                    fila.editarElemento(antigo, novo);
                    break;
                case 17:
                    fila.limpar();
                    break;
                case 18:
                    fila.exibir();
                    break;
                case 19:
                    fila.obterPrimeiroElemento();
                    break;
                case 20:
                    fila.obterUltimoElemento();
                    break;
                case 21:
                    System.out.println("Safefil diz adeus");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            if (opcao != 21) {
                System.out.println("\n<ENTER>");
                scanner.nextLine();
            }

        } while (opcao != 21);

        scanner.close();
    }
}
