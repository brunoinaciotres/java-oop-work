package State;

import Models.*;

import java.util.ArrayList;

public class Dados {
    public static ArrayList<Usuario> getUsuarios() {
        if (usuarios.isEmpty()) {
            Administrador adm = new Administrador();
            adm.setNome("Admin");
            adm.setEmail("admin@email.com");
            adm.setSenha("@dmin123");
            usuarios.add(adm);
            padrao();
        }

        return usuarios;
    }

    public static void padrao() {
        Corretor cor = new Corretor();
        cor.setNome("James Corretor");
        cor.setEmail("c");
        cor.setSenha("c");
        cor.setPrimeiroLogin(false);
        Administrador adm = new Administrador();
        adm.setNome("Rafael Administrador");
        adm.setEmail("a");
        adm.setSenha("a");
        adm.setPrimeiroLogin(false);
        usuarios.add(adm);
        usuarios.add(cor);

        Imovel imv = new Imovel();
        imv.setInscricao("1");
        imv.setPreco(1500.00);
        imv.setArea(1);
        imoveis.add(imv);
    }

    private static ArrayList<Imovel> imoveis = new ArrayList<>();

    public static ArrayList<Imovel> getImoveis() {
        return imoveis;
    }
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        Dados.usuarioLogado = usuarioLogado;
    }

    private static Usuario usuarioLogado = null;

    public static void incluirVenda(Venda venda){
        vendas.add(venda);
    }
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Venda> vendas = new ArrayList<Venda>();

    public static ArrayList<Venda> getVendas() {
        return vendas;
    }

}
