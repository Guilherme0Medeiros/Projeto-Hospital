import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeitoTest {

    @Test
    void testGetNumero() {
        Leito leito = new Leito(1, true);
        assertEquals(1, leito.getNumero());
    }

    @Test
    void testIsDisponivel() {
        Leito leito = new Leito(1, true);
        assertTrue(leito.isDisponivel());
    }

    @Test
    void testSetDisponivel() {
        Leito leito = new Leito(1, true);
        leito.setDisponivel(false);
        assertFalse(leito.isDisponivel());
    }

    @Test
    void testSetPaciente() {
        Leito leito = new Leito(1, true);
        Paciente paciente = new Paciente("João", "12345678900", "M", "01/01/1990");
        leito.setPaciente(paciente);
        assertFalse(leito.isDisponivel());
        assertEquals(paciente, leito.getPaciente());
    }
}
