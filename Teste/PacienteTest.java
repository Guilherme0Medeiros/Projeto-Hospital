import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    void testSetLeito() {
        Paciente paciente = new Paciente("João", "12345678900", "M", "01/01/1990");
        Leito leito = new Leito(1, true);
        paciente.setLeito(leito);
        assertEquals(leito, paciente.getLeito());
    }

    @Test
    void testSetSinaisVitais() {
        Paciente paciente = new Paciente("João", "12345678900", "M", "01/01/1990");
        AdicionarSinaisVitais sinais = new AdicionarSinaisVitais(37.5, 80, 120, 18, 98);
        paciente.setSinaisVitais(sinais);
        assertEquals(sinais, paciente.getSinaisVitais());
    }
}
