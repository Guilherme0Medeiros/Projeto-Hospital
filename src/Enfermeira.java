import java.util.List;

public class Enfermeira extends Pessoa {
    public Enfermeira(String nome, String CPF, String sexo, String dataDeNascimento, Permissao permissao) {
        super(nome, CPF, sexo, dataDeNascimento, permissao);
    }

    public void gerarRelatorioPaciente(Paciente paciente) {
        if (this.getPermissao() == Permissao.ENFERMEIRA) {
            System.out.println("Enfermeira gerando relatório do paciente: " + paciente.getNome());
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
            System.out.println("Permissão negada.");
        }
    }

    public void solicitarEmpregados() {
        if (this.getPermissao() == Permissao.ENFERMEIRA) {
            System.out.println("Solicitando empregados...");
        } else {
            System.out.println("Permissão negada.");
        }
    }

    public void listagemPaciente(List<Paciente> pacientes) {
        if (this.getPermissao() == Permissao.ENFERMEIRA) {
            System.out.println("Listagem de pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.getNome());
            }
        } else {
            System.out.println("Permissão negada.");
        }
    }
}