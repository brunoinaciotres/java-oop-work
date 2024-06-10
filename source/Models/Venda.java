package Models;

public class Venda {
    private String cpfComprador;
    private double comissaoCorretor;
    private double taxaCorretor;
    private String meioDePagamento;
    private String corretorResponsavel;

    public String getCpfComprador() {
        return cpfComprador;
    }

    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    public double getComissaoCorretor() {
        return comissaoCorretor;
    }

    public void setComissaoCorretor(double comissaoCorretor) {
        this.comissaoCorretor = comissaoCorretor;
    }

    public double getTaxaCorretor() {
        return taxaCorretor;
    }

    public void setTaxaCorretor(double taxaCorretor) {
        this.taxaCorretor = taxaCorretor;
    }

    public String getMeioDePagamento() {
        return meioDePagamento;
    }

    public void setMeioDePagamento(String meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }

    public String getCorretorResponsavel() {
        return corretorResponsavel;
    }

    public void setCorretorResponsavel(String corretorResponsavel) {
        this.corretorResponsavel = corretorResponsavel;
    }
}
