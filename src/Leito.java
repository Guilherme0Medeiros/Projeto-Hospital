public class Leito {
    private int numero;
    private boolean disponivel;
    private Paciente paciente;

    public Leito(int numero, boolean disponivel) {
        this.numero = numero;
        this.disponivel = disponivel;
        this.paciente = null;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        try {
            this.paciente = paciente;
            this.disponivel = (paciente == null); // se o paciente for null, o leito fica disponível
        } catch (Exception e) {
            System.out.println("Erro ao definir paciente para o leito: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        try {
            return "Leito{" +
                    "numero=" + numero +
                    ", disponivel=" + disponivel +
                    ", paciente=" + (paciente != null ? paciente.getNome() : "Nenhum") +
                    '}';
        } catch (Exception e) {
            return "Erro ao converter leito para String: " + e.getMessage();
        }
    }
}
