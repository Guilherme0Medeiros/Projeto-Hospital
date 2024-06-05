public class AdicionarSinaisVitais {
    private double temperatura;
    private int frequenciaCardiaca;
    private int pressaoArterial;
    private int taxaRespiratoria;
    private double saturacaoDeOxigenio;

    public AdicionarSinaisVitais(double temperatura, int frequenciaCardiaca, int pressaoArterial, int taxaRespiratoria, double saturacaoDeOxigenio) {
        this.temperatura = temperatura;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.pressaoArterial = pressaoArterial;
        this.taxaRespiratoria = taxaRespiratoria;
        this.saturacaoDeOxigenio = saturacaoDeOxigenio;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public int getPressaoArterial() {
        return pressaoArterial;
    }

    public int getTaxaRespiratoria() {
        return taxaRespiratoria;
    }

    public double getSaturacaoDeOxigenio() {
        return saturacaoDeOxigenio;
    }
}