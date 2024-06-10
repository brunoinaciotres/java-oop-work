package Views;
import java.util.Scanner;

import Models.Imovel;
import Models.Usuario;
import Models.Venda;
import Services.ImovelService;
import Services.VendaService;

public class VendaView {


    public static void apresentarMenu(Usuario usuarioLogado){

        String meioDePagamento="";
        String cpfComprador;
        Scanner sc = new Scanner(System.in);

        ImovelService service = new ImovelService();
        System.out.println("Forneça os dados para realizar a venda.");
        System.out.print("Digite a inscrição do imóvel que será vendido: ");
        String inscricao = sc.nextLine();
        Imovel imovel = service.getImovelPorInscricao(inscricao);
        if (imovel == null){
            System.out.println("Não existe um imóvel cadastrado para essa inscrição!");
            return;
        }
        System.out.println("Imóvel selecionado:");
        System.out.printf(" Inscrição: %s - Preço: R$%.2f \n", imovel.getInscricao(), imovel.getPreco());

        while (true) {
            System.out.print("Informe o CPF do comprador (11 dígitos): ");
            cpfComprador = sc.nextLine();
            if (cpfComprador.length() != 11 ) {
                System.out.println("O CPF deve ter 11 digitos");
            } else {
                break;
            }

        }

        System.out.print("Informe a taxa de comissão do corretor em porcentagem (sem o símbolo): ");
        double taxaComissao = sc.nextDouble();

        while(true) {
            System.out.println("Informe o meio de pagamento do comprador (digite o número desejado): ");
            System.out.println(" 1 - Cartão ");
            System.out.println(" 2 - Dinheiro ");
            System.out.println(" 3 - Cheque ");
            System.out.print("Opção: ");
            double codMeioDePagamento = sc.nextDouble();
            if (codMeioDePagamento > 3 || codMeioDePagamento < 1){
                System.out.println("Meio de Pagamento Inválido! ");
            } else {
                if (codMeioDePagamento == 1) {
                    meioDePagamento = "Cartão";
                }
                if (codMeioDePagamento == 2) {
                    meioDePagamento = "Dinheiro";
                }
                if (codMeioDePagamento == 3) {
                    meioDePagamento = "Cheque";
                }
                break;
            }
        }

        System.out.println("Confira os dados da venda: ");
        System.out.printf("     Incrição = %s Preço = R$%.2f \n", imovel.getInscricao(), imovel.getPreco());
        System.out.printf("     CPF Comprador = %s \n", cpfComprador);
        System.out.printf("     Meio de Pagamento = %s \n", meioDePagamento);
        System.out.printf("     Taxa de Comissão = %.2f %% \n", taxaComissao);
        System.out.printf("     Preço da Comissão = R$%.2f \n", (taxaComissao / 100)*imovel.getPreco());
        System.out.printf("     Corretor Responsável = %s \n", usuarioLogado.getNome());

        Venda venda = new Venda();
        venda.setComissaoCorretor((taxaComissao / 100)*imovel.getPreco());
        venda.setTaxaCorretor(taxaComissao);
        venda.setCpfComprador(cpfComprador);
        venda.setMeioDePagamento(meioDePagamento);
        venda.setCorretorResponsavel(usuarioLogado.getNome());
        VendaService vendaService = new VendaService();
        ImovelService imovService = new ImovelService();
        try {
            //Insere venda no Array de vendas
            vendaService.inserirVenda(venda);
            //Remove imóvel do Array de imóveis, pois foi vendido.
            imovService.excluir(inscricao);

            System.out.println("Venda Realizada!");
        } catch (Exception e) {
            System.out.printf("Não foi possível registrar a venda: %s", e.getMessage());
        }


    }

    public static void listarVendas(Usuario usuarioLogado) {
        VendaService vendaService = new VendaService();
        vendaService.listarVendas();
    }
}
