package model;

public class Moto extends Veiculo {
    private boolean possuiPartidaEletrica;

    public Moto(String placa, String marca, int ano, String cor, boolean possuiPartidaEletrica) {
        super(placa, marca, ano, cor);
        this.possuiPartidaEletrica = possuiPartidaEletrica;
    }

    public boolean isPossuiPartidaEletrica() { return possuiPartidaEletrica; }
    public void setPossuiPartidaEletrica(boolean possuiPartidaEletrica) { this.possuiPartidaEletrica = possuiPartidaEletrica; }

    @Override
    public String toString() {
        return "Moto - " + super.toString() + ", Partida Elétrica: " + (possuiPartidaEletrica ? "Sim" : "Não");
    }
}

