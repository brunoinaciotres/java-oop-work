package Views;

import Models.Imovel;
import Services.ImovelService;
import Models.Usuario;
import java.util.Scanner;

public class ImovelView {
    public static void apresentarMenu(Usuario usuarioLogado) {
        System.out.println("Menu de imóveis (escolha uma opção):");
        System.out.println(" 1 - Listar");
        System.out.println(" 2 - Inserir");
        System.out.println(" 3 - Alterar");
        System.out.println(" 4 - Excluir");
        System.out.println(" 5 - Voltar");
        System.out.print("Opção: ");

        boolean continuar;

        do {
            continuar = false;

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    listar();
                    break;
                case 2:
                    inserir();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    excluir();
                    break;
                case 5:
                    SistemaView.apresentarMenu(usuarioLogado);
                    break;
                default:
                    continuar = true;
                    System.out.print("Opção inválida! Por favor, tente novamente: ");
            }
        } while (continuar);
    }

    private static void listar() {
        ImovelService servico = new ImovelService();

        System.out.println("\nLista de Imóveis do Sistema:");

        for (Imovel imovel : servico.getImoveis()) {
            System.out.printf("Inscrição: %s - Endereço: %s - Preço: %.2f - Área: %.2f metros quadrados\n",
                    imovel.getInscricao(), imovel.getEndereco(), imovel.getPreco(), imovel.getArea());
        }

        System.out.println("-----------------------------\n");
    }

    private static void inserir() {
        System.out.println("\nInserindo Imóvel:");
        Imovel imovel = new Imovel();
        lerImovel(imovel);
        ImovelService servico = new ImovelService();
        servico.inserir(imovel);
    }

    private static void lerImovel(Imovel imovel) {
        Scanner sc = new Scanner(System.in);

        System.out.print("  Inscrição: ");
        imovel.setInscricao(sc.nextLine());
        System.out.print("  Endereço: ");
        imovel.setEndereco(sc.nextLine());
        System.out.print("  Preço: ");
        imovel.setPreco(sc.nextDouble());
        System.out.print("  Área: ");
        imovel.setArea(sc.nextDouble());
        sc.nextLine();
    }

    private static void alterar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inscrição do imóvel a ser alterado: ");
        String inscricao = sc.nextLine();
        ImovelService servico = new ImovelService();

        Imovel imovel = servico.getImovelPorInscricao(inscricao);

        if (imovel == null) {
            System.out.println("Imóvel não encontrado");
            return;
        }

        System.out.print("  Endereço: ");
        imovel.setEndereco(sc.nextLine());
        System.out.print("  Preço: ");
        imovel.setPreco(sc.nextDouble());
        System.out.print("  Área: ");
        imovel.setArea(sc.nextDouble());
        sc.nextLine();

        try {
            servico.alterar(imovel);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void excluir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inscrição do imóvel a ser excluído: ");
        String inscricao = sc.nextLine();
        ImovelService servico = new ImovelService();

        Imovel imovel = servico.getImovelPorInscricao(inscricao);

        if (imovel == null) {
            System.out.println("Imóvel não encontrado");
            return;
        }

        try {
            servico.excluir(inscricao);
            System.out.println("Imóvel excluído com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}