package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aluguel {
    private int idAluguel;
    private Veiculo veiculo;
    private LocalDate dataAluguel;
    private LocalDateTime horaAluguel;
    private LocalDateTime horaDevolucao;

    public Aluguel(int idAluguel, Veiculo veiculo, LocalDate dataAluguel, LocalDateTime horaAluguel) {
        this.idAluguel = idAluguel;
        this.veiculo = veiculo;
        this.dataAluguel = dataAluguel;
        this.horaAluguel = horaAluguel;
        this.horaDevolucao = null;
    }

    public int getIdAluguel() { return idAluguel; }
    public Veiculo getVeiculo() { return veiculo; }
    public LocalDate getDataAluguel() { return dataAluguel; }
    public LocalDateTime getHoraAluguel() { return horaAluguel; }
    public LocalDateTime getHoraDevolucao() { return horaDevolucao; }

    public void setHoraDevolucao(LocalDateTime horaDevolucao) { this.horaDevolucao = horaDevolucao; }

    public long calcularCusto() {
        if (horaDevolucao != null) {
            long horas = ChronoUnit.HOURS.between(horaAluguel, horaDevolucao);
            return horas * 10; // Exemplo: R$10 por hora de aluguel
        }
        return 0;
    }

    public String apresentarRegistroAluguel() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluguel ID: ").append(idAluguel).append("\n");
        sb.append("Veículo: ").append(veiculo).append("\n");
        sb.append("Data de Aluguel: ").append(dataAluguel).append("\n");
        sb.append("Hora de Retirada: ").append(horaAluguel.toLocalTime()).append("\n");
        if (horaDevolucao != null) {
            sb.append("Hora de Devolução: ").append(horaDevolucao.toLocalTime()).append("\n");
            sb.append("Custo Total: R$").append(calcularCusto()).append("\n");
        }
        return sb.toString();
    }
}
