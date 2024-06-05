import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdicionarSinaisVitaisTest {

    @Test
    void testGetTemperatura() {
        AdicionarSinaisVitais sinais = new AdicionarSinaisVitais(37.5, 80, 120, 18, 98);
        assertEquals(37.5, sinais.getTemperatura());
    }

}
