package Models;

public class Imovel {
    private String endereco;
    private double preco;
    private double area;
    private String inscricao;

    public Imovel() {
    }

    public Imovel(String endereco, double preco, double area, String inscricao) {
        this.endereco = endereco;
        this.preco = preco;
        this.area = area;
        this.inscricao = inscricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
}
