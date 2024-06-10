package Services;

import Models.Venda;
import State.Dados;

import java.util.ArrayList;

public class VendaService {
    public void inserirVenda(Venda venda){
        Dados.incluirVenda(venda);
    }

    public void listarVendas(){
        ArrayList<Venda> vendas = Dados.getVendas();
        if (vendas.isEmpty()){
            System.out.println("Não há vendas");
            return;
        }
        for (Venda venda: vendas){
            System.out.println("Venda: ");
            System.out.printf("     CPF Comprador = %s \n", venda.getCpfComprador());
            System.out.printf("     Meio de Pagamento = %s \n", venda.getMeioDePagamento());
            System.out.printf("     Taxa de Comissão = %.2f %% \n", venda.getTaxaCorretor());
            System.out.printf("     Preço da Comissão = R$%.2f \n", venda.getComissaoCorretor());
            System.out.printf("     Corretor Responsável = %s \n", venda.getCorretorResponsavel());
            System.out.println("-------------");
        }
    }
}
