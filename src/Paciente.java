public class Paciente extends Pessoa {
    private Leito leito;
    private AdicionarSinaisVitais sinaisVitais;

    public Paciente(String nome, String CPF, String sexo, String dataDeNascimento) {
        super(nome, CPF, sexo, dataDeNascimento, null);
    }

    public Leito getLeito() {
        return leito;
    }

    public void setLeito(Leito leito) {
        this.leito = leito;
    }

    public AdicionarSinaisVitais getSinaisVitais() {
        return sinaisVitais;
    }

    public void setSinaisVitais(AdicionarSinaisVitais sinaisVitais) {
        try {
            if (sinaisVitais != null) {
                this.sinaisVitais = sinaisVitais;
            } else {
                throw new IllegalArgumentException("Os sinais vitais não podem ser nulos.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir os sinais vitais: " + e.getMessage());
        }
    }
}
