package model;

public class Veiculo {
    private String placa;
    private String marca;
    private int ano;
    private String cor;

    public Veiculo(String placa, String marca, int ano, String cor) {
        this.placa = placa;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
    }

    // Getters e Setters
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Marca: " + marca + ", Ano: " + ano + ", Cor: " + cor;
    }
}
