package model;

public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String placa, String marca, int ano, String cor, double capacidadeCarga) {
        super(placa, marca, ano, cor);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() { return capacidadeCarga; }
    public void setCapacidadeCarga(double capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }

    @Override
    public String toString() {
        return "Caminhão - " + super.toString() + ", Capacidade de Carga: " + capacidadeCarga + " kg";
    }
}


