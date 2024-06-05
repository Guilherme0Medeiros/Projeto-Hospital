public class Pessoa {
    private String nome;
    private String CPF;
    private String sexo;
    private String dataDeNascimento;
    private Permissao permissao;

    public Pessoa(String nome, String CPF, String sexo, String dataDeNascimento, Permissao permissao) {
        this.nome = nome;
        this.CPF = CPF;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.permissao = permissao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
