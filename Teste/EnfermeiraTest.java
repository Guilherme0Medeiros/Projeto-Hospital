import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnfermeiraTest {

    @Test
    void testGerarRelatorioPaciente() {
        Paciente paciente = new Paciente("João", "12345678900", "M", "01/01/1990");
        Enfermeira enfermeira = new Enfermeira("Ana", "11111111100", "F", "04/04/1980", Permissao.ENFERMEIRA);
        enfermeira.gerarRelatorioPaciente(paciente);

    }
}
