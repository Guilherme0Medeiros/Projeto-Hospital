import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciamentoDeLeitosTest {

    @Test
    void testAdicionarEListarLeitosDisponiveis() {
        GerenciamentoDeLeitos gerenciamentoDeLeitos = new GerenciamentoDeLeitos();

        // Adicionar leitos
        Leito leito1 = new Leito(1, true);
        Leito leito2 = new Leito(2, false);

        gerenciamentoDeLeitos.adicionarLeito(leito1);
        gerenciamentoDeLeitos.adicionarLeito(leito2);

        // Verificar se os leitos foram adicionados corretamente
        List<Leito> leitosDisponiveis = gerenciamentoDeLeitos.listarLeitosDisponiveis();
        assertEquals(1, leitosDisponiveis.size()); // Apenas leito1 deve estar disponível
        assertTrue(leitosDisponiveis.contains(leito1));
        assertFalse(leitosDisponiveis.contains(leito2)); // leito2 não está disponível
    }

    @Test
    void testAtualizarStatusLeito() {
        GerenciamentoDeLeitos gerenciamentoDeLeitos = new GerenciamentoDeLeitos();

        // Adicionar um leito disponível
        Leito leito = new Leito(1, true);
        gerenciamentoDeLeitos.adicionarLeito(leito);

        // Verificar o status inicial do leito
        assertTrue(leito.isDisponivel());

        // Atualizar o status do leito para indisponível
        gerenciamentoDeLeitos.atualizarStatusLeito(1, "indisponivel");

        // Verificar se o status foi atualizado corretamente
        assertFalse(leito.isDisponivel());
    }

    @Test
    void testRemoverLeito() {
        GerenciamentoDeLeitos gerenciamentoDeLeitos = new GerenciamentoDeLeitos();

        // Adicionar um leito
        Leito leito = new Leito(1, true);
        gerenciamentoDeLeitos.adicionarLeito(leito);

        // Remover o leito
        gerenciamentoDeLeitos.removerLeito(1);

        // Verificar se o leito foi removido corretamente
        assertNull(gerenciamentoDeLeitos.obterLeito(1));
    }

    @Test
    void testAtribuirPacienteAoLeito() {
        GerenciamentoDeLeitos gerenciamentoDeLeitos = new GerenciamentoDeLeitos();

        // Adicionar um leito disponível
        Leito leito = new Leito(1, true);
        gerenciamentoDeLeitos.adicionarLeito(leito);

        // Criar paciente
        Paciente paciente = new Paciente("João", "12345678900", "M", "01/01/1990");

        // Atribuir o paciente ao leito
        gerenciamentoDeLeitos.atribuirPacienteAoLeito(1, paciente);

        // Verificar se o paciente foi atribuído corretamente ao leito
        assertEquals(paciente, leito.getPaciente());
    }
}
