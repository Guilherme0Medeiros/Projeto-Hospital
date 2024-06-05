import java.util.List;

public class Medico extends Pessoa {
    private String especialidade;
    private String turno;

    public Medico(String nome, String CPF, String sexo, String dataDeNascimento, String especialidade, String turno, Permissao permissao) {
        super(nome, CPF, sexo, dataDeNascimento, permissao);
        this.especialidade = especialidade;
        this.turno = turno;
    }

    public void gerarRelatorioPaciente(Paciente paciente) {
        try {
            if (this.getPermissao() == Permissao.MEDICO) {
                System.out.println("Médico gerando relatório do paciente: " + paciente.getNome());
                System.out.println("Leito: " + (paciente.getLeito() != null ? paciente.getLeito().getNumero() : "Nenhum"));
                if (paciente.getSinaisVitais() != null) {
                    System.out.println("Sinais Vitais: ");
                    System.out.println("Temperatura: " + paciente.getSinaisVitais().getTemperatura());
                    System.out.println("Frequência Cardíaca: " + paciente.getSinaisVitais().getFrequenciaCardiaca());
                    System.out.println("Pressão Arterial: " + paciente.getSinaisVitais().getPressaoArterial());
                    System.out.println("Taxa Respiratória: " + paciente.getSinaisVitais().getTaxaRespiratoria());
                    System.out.println("Saturação de Oxigênio: " + paciente.getSinaisVitais().getSaturacaoDeOxigenio());
                }
            } else {
                throw new IllegalAccessException("Permissão negada.");
            }
        } catch (IllegalAccessException e) {
            System.out.println("Erro ao gerar relatório do paciente: " + e.getMessage());
        }
    }

    public void solicitarEmpregados() {
        try {
            if (this.getPermissao() == Permissao.MEDICO) {
                System.out.println("Solicitando empregados...");
            } else {
                throw new IllegalAccessException("Permissão negada.");
            }
        } catch (IllegalAccessException e) {
            System.out.println("Erro ao solicitar empregados: " + e.getMessage());
        }
    }

    public void listagemPaciente(List<Paciente> pacientes) {
        try {
            if (this.getPermissao() == Permissao.MEDICO) {
                System.out.println("Listagem de pacientes:");
                for (Paciente paciente : pacientes) {
                    System.out.println(paciente.getNome());
                }
            } else {
                throw new IllegalAccessException("Permissão negada.");
            }
        } catch (IllegalAccessException e) {
            System.out.println("Erro ao listar pacientes: " + e.getMessage());
        }
    }

    public void processarAltaPaciente(Paciente paciente, GerenciamentoDeLeitos gerenciamentoDeLeitos) {
        try {
            if (this.getPermissao() == Permissao.MEDICO) {
                System.out.println("Processando alta do paciente: " + paciente.getNome());
                gerenciamentoDeLeitos.atualizarStatusLeito(paciente.getLeito().getNumero(), "disponível");
            } else {
                throw new IllegalAccessException("Permissão negada.");
            }
        } catch (IllegalAccessException e) {
            System.out.println("Erro ao processar alta do paciente: " + e.getMessage());
        }
    }
}
