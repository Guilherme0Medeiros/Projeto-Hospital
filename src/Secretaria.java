import java.util.List;

public class Secretaria extends Pessoa {
    public Secretaria(String nome, String CPF, String sexo, String dataDeNascimento, Permissao permissao) {
        super(nome, CPF, sexo, dataDeNascimento, permissao);
    }

    public void atualizarStatusDoLeito(GerenciamentoDeLeitos gerenciamentoDeLeitos, int numeroLeito, String novoStatus) {
        if (this.getPermissao() == Permissao.SECRETARIA) {
            gerenciamentoDeLeitos.atualizarStatusLeito(numeroLeito, novoStatus);
        } else {
            System.out.println("Permissão negada.");
        }
    }

    public void verEmpregadosDisponiveis(List<Pessoa> empregados) {
        if (this.getPermissao() == Permissao.SECRETARIA) {
            System.out.println("Empregados disponíveis:");
            for (Pessoa empregado : empregados) {
                System.out.println(empregado.getNome() + " - " + empregado.getPermissao());
            }
        } else {
            System.out.println("Permissão negada.");
        }
    }

    public void solicitarEmpregados() {
        if (this.getPermissao() == Permissao.SECRETARIA) {
            System.out.println("Solicitando empregados...");
        } else {
            System.out.println("Permissão negada.");
        }
    }
}