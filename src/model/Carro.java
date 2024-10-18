package model;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String placa, String marca, int ano, String cor, int numeroPortas) {
        super(placa, marca, ano, cor);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() { return numeroPortas; }
    public void setNumeroPortas(int numeroPortas) { this.numeroPortas = numeroPortas; }

    @Override
    public String toString() {
        return "Carro - " + super.toString() + ", Número de Portas: " + numeroPortas;
    }
}

