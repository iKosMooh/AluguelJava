import model.Aluguel;
import model.Caminhao;
import model.Carro;
import model.Moto;
import model.Veiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarControleAluguel {
    private List<Veiculo> veiculosDisponiveis;
    private List<Aluguel> alugueisRealizados;
    private int contadorAlugueis;

    public GerenciarControleAluguel() {
        veiculosDisponiveis = new ArrayList<>();
        alugueisRealizados = new ArrayList<>();
        contadorAlugueis = 0;
        inicializarVeiculos(); // Inicializando veículos de exemplo
    }

    // Inicializando veículos
    private void inicializarVeiculos() {
        veiculosDisponiveis.add(new Carro("ABC-1234", "BMW", 2023, "Roxo", 2));
        veiculosDisponiveis.add(new Moto("DEF-5678", "Kawasaki", 2017, "Preta", false));
        veiculosDisponiveis.add(new Caminhao("GHI-9101", "Mercedes-Benz", 2006, "Vermelho", 1000));
    }

    // Listando veículos disponíveis
    public void listarVeiculos() {
        System.out.println("Veículos disponíveis para aluguel:");
        for (Veiculo veiculo : veiculosDisponiveis) {
            System.out.println(veiculo);
        }
    }

    // Realizando aluguel
    public void realizarAluguel(String placa) {
        for (Veiculo veiculo : veiculosDisponiveis) {
            if (veiculo.getPlaca().equals(placa)) {
                contadorAlugueis++;
                LocalDateTime dataHoraRetirada = LocalDateTime.now();
                Aluguel aluguel = new Aluguel(contadorAlugueis, veiculo, LocalDate.now(), dataHoraRetirada);

                System.out.println("Veículo alugado: " + veiculo);
                System.out.println("Aluguel registrado: ");
                System.out.println(aluguel.apresentarRegistroAluguel());

                try {
                    Thread.sleep(1000); // Espera de 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                veiculosDisponiveis.remove(veiculo); // Remover da lista de disponíveis
                alugueisRealizados.add(aluguel); // Adicionar à lista de aluguéis
                return;
            }
        }
        System.out.println("Veículo com placa " + placa + " não encontrado.");
    }

    // Realizando devolução
    public void realizarDevolucao(int idAluguel) {
        for (Aluguel aluguel : alugueisRealizados) {
            if (aluguel.getIdAluguel() == idAluguel) {
                LocalDateTime dataHoraDevolucao = LocalDateTime.now();
                aluguel.setHoraDevolucao(dataHoraDevolucao);
                veiculosDisponiveis.add(aluguel.getVeiculo()); // Recoloca o veículo na lista de disponíveis

                System.out.println("Veículo devolvido: " + aluguel.getVeiculo());
                System.out.println("Registro da devolução: ");
                System.out.println(aluguel.apresentarRegistroAluguel());

                try {
                    Thread.sleep(1000); // Espera de 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return;
            }
        }
        System.out.println("Aluguel com ID " + idAluguel + " não encontrado.");
    }

    // Listando aluguéis realizados
    public void listarAlugueisRealizados() {
        System.out.println("Aluguéis realizados:");
        for (Aluguel aluguel : alugueisRealizados) {
            System.out.println(aluguel.apresentarRegistroAluguel());
        }
    }

    public static void main(String[] args) {
        GerenciarControleAluguel controleAluguel = new GerenciarControleAluguel();
        Scanner scanner = new Scanner(System.in);

        // Listar veículos disponíveis
        controleAluguel.listarVeiculos();

        // Realizar aluguel
        System.out.print("Digite a placa do veículo que deseja alugar: ");
        String placa = scanner.nextLine();
        controleAluguel.realizarAluguel(placa);

        // Listar veículos após o aluguel
        controleAluguel.listarVeiculos();

        // Realizar devolução
        System.out.print("Digite o ID do aluguel que deseja devolver: ");
        int idAluguel = scanner.nextInt();
        controleAluguel.realizarDevolucao(idAluguel);

        // Listar aluguéis realizados
        controleAluguel.listarAlugueisRealizados();
    }
}
