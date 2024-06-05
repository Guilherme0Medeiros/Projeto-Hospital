import java.util.ArrayList;
import java.util.List;

public class GerenciamentoDeLeitos {
    private List<Leito> leitos;

    public GerenciamentoDeLeitos() {
        this.leitos = new ArrayList<>();
    }

    public void adicionarLeito(Leito leito) {
        try {
            leitos.add(leito);
        } catch (NullPointerException e) {
            System.out.println("Erro ao adicionar leito: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro desconhecido ao adicionar leito: " + e.getMessage());
        }
    }

    public void removerLeito(int numeroLeito) {
        try {
            leitos.removeIf(leito -> leito.getNumero() == numeroLeito);
        } catch (Exception e) {
            System.out.println("Erro ao remover leito: " + e.getMessage());
        }
    }

    public List<Leito> listarLeitosDisponiveis() {
        List<Leito> leitosDisponiveis = new ArrayList<>();
        for (Leito leito : leitos) {
            if (leito.isDisponivel()) {
                leitosDisponiveis.add(leito);
            }
        }
        return leitosDisponiveis;
    }

    public void atualizarStatusLeito(int numeroLeito, String novoStatus) {
        boolean novoStatusDisponivel = novoStatus.equalsIgnoreCase("disponivel");
        try {
            for (Leito leito : leitos) {
                if (leito.getNumero() == numeroLeito) {
                    leito.setDisponivel(novoStatusDisponivel);
                    return;
                }
            }
            throw new IllegalArgumentException("Leito não encontrado.");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar status do leito: " + e.getMessage());
        }
    }

    public Leito obterLeito(int numeroLeito) {
        try {
            for (Leito leito : leitos) {
                if (leito.getNumero() == numeroLeito) {
                    return leito;
                }
            }
            throw new IllegalArgumentException("Leito não encontrado.");
        } catch (Exception e) {
            System.out.println("Erro ao obter leito: " + e.getMessage());
            return null;
        }
    }

    public String obterDetalhesLeito(int numeroLeito) {
        try {
            Leito leito = obterLeito(numeroLeito);
            if (leito != null) {
                return leito.toString();
            } else {
                throw new IllegalArgumentException("Leito não encontrado.");
            }
        } catch (Exception e) {
            return "Erro ao obter detalhes do leito: " + e.getMessage();
        }
    }

    public void atribuirPacienteAoLeito(int numeroLeito, Paciente paciente) {
        Leito leito = obterLeito(numeroLeito);
        try {
            if (leito != null && leito.isDisponivel()) {
                leito.setPaciente(paciente);
                System.out.println("Paciente " + paciente.getNome() + " atribuído ao leito " + numeroLeito);
            } else {
                throw new IllegalArgumentException("Leito não está disponível ou não foi encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atribuir paciente ao leito: " + e.getMessage());
        }
    }
}
