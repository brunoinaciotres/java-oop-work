package Services;

import Models.Imovel;
import State.Dados;

import java.util.ArrayList;

public class ImovelService {
    public ArrayList<Imovel> getImoveis() {
        return Dados.getImoveis();
    }

    public void inserir(Imovel imovel) {
        Dados.getImoveis().add(imovel);
    }

    public Imovel getImovelPorInscricao(String inscricao) {
        for (Imovel imovel : Dados.getImoveis()) {
            if (imovel.getInscricao().equals(inscricao)) {
                return imovel;
            }
        }
        return null;
    }

    public void alterar(Imovel imovelAlterado) throws Exception {
        Imovel imovel = getImovelPorInscricao(imovelAlterado.getInscricao());

        if (imovel == null) {
            throw new Exception("Não foi possível alterar. O imóvel não foi encontrado.");
        }

        imovel.setPreco(imovelAlterado.getPreco());
        imovel.setArea(imovelAlterado.getArea());
    }

    public void excluir(String inscricao) throws Exception {
        Imovel imovel = getImovelPorInscricao(inscricao);

        if (imovel == null) {
            throw new Exception("Não foi possível excluir. O imóvel não foi encontrado.");
        }

        Dados.getImoveis().remove(imovel);
    }
}