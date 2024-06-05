import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedicoTest {

    @Test
    public void testGerarRelatorioPaciente() {
        // Mudar a saída padrão para um fluxo de bytes para poder ver a saída do método
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar um paciente para testar
        Paciente paciente = new Paciente("Maria", "12345687900", "F", "01/05/2005");
        paciente.setLeito(new Leito(1, true));
        paciente.setSinaisVitais(new AdicionarSinaisVitais(37.0, 70, 120, 18, 98));

        //Criar medico
        Medico medico = new Medico("Dr. Guilherme", "88495433100", "M", "01/01/2004", "Cardiologia", "Diurno", Permissao.MEDICO);

        // Execução do metodo
        medico.gerarRelatorioPaciente(paciente);

        // Captura da saída do metodo
        String output = outputStream.toString();

        // Verifica a saída
        assertTrue(output.contains("Médico gerando relatório do paciente: Maria"));
        assertTrue(output.contains("Temperatura: 37.0"));


        System.setOut(System.out);
    }
}
