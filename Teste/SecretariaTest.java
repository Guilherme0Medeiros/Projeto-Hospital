import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecretariaTest {

    @Test
    void testAtualizarStatusDoLeito() {
        Leito leito = new Leito(1, true);
        GerenciamentoDeLeitos gerenciamentoDeLeitos = new GerenciamentoDeLeitos();
        gerenciamentoDeLeitos.adicionarLeito(leito);
        Secretaria secretaria = new Secretaria("Carla", "33333333300", "F", "06/06/1990", Permissao.SECRETARIA);
        secretaria.atualizarStatusDoLeito(gerenciamentoDeLeitos, 1, "false");
        assertFalse(leito.isDisponivel());
    }
}
