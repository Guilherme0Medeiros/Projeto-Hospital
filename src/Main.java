import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciamentoDeLeitos gerenciamentoDeLeitos = new GerenciamentoDeLeitos();
        Scanner scanner = new Scanner(System.in);


        for (int i = 1; i <= 5; i++) {
            gerenciamentoDeLeitos.adicionarLeito(new Leito(i, true));
        }
// esses aray lists foram criados para adicionar novos empregados e novos pacientes caso necessário
        List<Pessoa> empregados = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
// delimitamos para o sistema um numero predefinido de pacientes e empregados já com seus dados informados no mesmo

        Paciente paciente1 = new Paciente("João Silva", "12345678900", "M", "01/01/1990");
        Paciente paciente2 = new Paciente("Maria Souza", "98765432100", "F", "02/02/1985");
        Paciente paciente3 = new Paciente("Carlos Pereira", "45678912300", "M", "03/03/1970");

        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);


        paciente1.setSinaisVitais(new AdicionarSinaisVitais(37.5, 80, 120, 18, 98));
        paciente2.setSinaisVitais(new AdicionarSinaisVitais(36.8, 75, 115, 16, 99));
        paciente3.setSinaisVitais(new AdicionarSinaisVitais(38.0, 85, 130, 20, 97));





        Enfermeira enfermeira1 = new Enfermeira("Ana", "11111111100", "F", "04/04/1980", Permissao.ENFERMEIRA);
        Enfermeira enfermeira2 = new Enfermeira("Beatriz", "44444444400", "F", "07/07/1985", Permissao.ENFERMEIRA);
        Secretaria secretaria1 = new Secretaria("Carla", "33333333300", "F", "06/06/1990", Permissao.SECRETARIA);
        Medico medico1 = new Medico("Dr. Roberto", "22222222200", "M", "05/05/1975", "Cardiologia", "Noturno", Permissao.MEDICO);

        empregados.add(enfermeira1);
        empregados.add(enfermeira2);
        empregados.add(secretaria1);
        empregados.add(medico1);


        paciente1.setLeito(gerenciamentoDeLeitos.obterLeito(1));
        gerenciamentoDeLeitos.atualizarStatusLeito(1, "false");

        paciente2.setLeito(gerenciamentoDeLeitos.obterLeito(2));
        gerenciamentoDeLeitos.atualizarStatusLeito(2, "false");

        System.out.println("Selecione o tipo de usuário:");
        System.out.println("0 - Secretaria");
        System.out.println("1 - Enfermeira");
        System.out.println("2 - Médico");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        switch (tipoUsuario) {
            case 0:
                listarEmpregados(empregados);
                System.out.println("Escolha o número do funcionário para solicitar:");
                int funcionarioIndex = scanner.nextInt();
                scanner.nextLine();
                if (funcionarioIndex >= 0 && funcionarioIndex < empregados.size()) {
                    System.out.println("Secretaria está solicitando " + empregados.get(funcionarioIndex).getNome());
                } else {
                    System.out.println("Funcionário inválido.");
                }
                break;
            case 1:
                listarPacientes(pacientes);
                System.out.println("Escolha uma opção: (1 - Solicitar Empregados, 2 - Gerar Relatório do Paciente, 3 -gerenciamento de leitos)");
                int opcaoEnfermeira = scanner.nextInt();
                scanner.nextLine();
                if (opcaoEnfermeira == 1) {
                    listarEmpregados(empregados);
                    System.out.println("Escolha o número do funcionário para solicitar:");
                    funcionarioIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (funcionarioIndex >= 0 && funcionarioIndex < empregados.size()) {
                        System.out.println("Enfermeira está solicitando Funcionário" + funcionarioIndex);
                    } else {
                        System.out.println("Funcionário inválido.");
                    }
                } else if (opcaoEnfermeira == 2) {
                    System.out.println("Escolha o paciente pelo número:");
                    int pacienteIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (pacienteIndex >= 0 && pacienteIndex < pacientes.size()) {
                        gerarRelatorioPaciente(pacientes.get(pacienteIndex));
                    } else {
                        System.out.println("Paciente inválido.");
                    }
                } else if(opcaoEnfermeira == 3){
                    while (true) {
                        System.out.println("Selecione uma opção:");
                        System.out.println("1. Adicionar leito");
                        System.out.println("2. Remover leito");
                        System.out.println("3. Listar leitos disponíveis");
                        System.out.println("4. Atualizar status de leito");
                        System.out.println("5. Obter detalhes de leito");
                        System.out.println("6. Atribuir paciente a um leito");
                        System.out.println("7. Sair");

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                System.out.println("Número do leito:");
                                int numeroLeito = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Leito disponível (true/false):");
                                boolean disponivel = scanner.nextBoolean();
                                scanner.nextLine();
                                Leito leito = new Leito(numeroLeito, disponivel);
                                gerenciamentoDeLeitos.adicionarLeito(leito);
                                System.out.println("Leito adicionado com sucesso.");
                                break;

                            case 2:
                                System.out.println("Número do leito a remover:");
                                int numeroRemover = scanner.nextInt();
                                scanner.nextLine();
                                gerenciamentoDeLeitos.removerLeito(numeroRemover);
                                System.out.println("Leito removido com sucesso.");
                                break;

                            case 3:
                                List<Leito> leitosDisponiveis = gerenciamentoDeLeitos.listarLeitosDisponiveis();
                                System.out.println("Leitos disponíveis:");
                                for (Leito leitoDisp : leitosDisponiveis) {
                                    System.out.println(leitoDisp);
                                }
                                break;

                            case 4:
                                System.out.println("Número do leito a atualizar:");
                                int numeroAtualizar = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Novo status do leito (disponivel/indisponivel):");
                                String novoStatus = scanner.nextLine();
                                gerenciamentoDeLeitos.atualizarStatusLeito(numeroAtualizar, novoStatus);
                                System.out.println("Status do leito atualizado com sucesso.");
                                break;

                            case 5:
                                System.out.println("Número do leito para obter detalhes:");
                                int numeroDetalhes = scanner.nextInt();
                                scanner.nextLine();
                                String detalhesLeito = gerenciamentoDeLeitos.obterDetalhesLeito(numeroDetalhes);
                                System.out.println(detalhesLeito);
                                break;

                            case 6:
                                System.out.println("Número do leito para atribuir paciente:");
                                int numeroLeitoAtribuir = scanner.nextInt();
                                scanner.nextLine();
                                listarPacientes(pacientes);
                                System.out.println("Escolha o número do paciente para atribuir ao leito:");
                                int pacienteIndex = scanner.nextInt();
                                scanner.nextLine();
                                if (pacienteIndex >= 0 && pacienteIndex < pacientes.size()) {
                                    gerenciamentoDeLeitos.atribuirPacienteAoLeito(numeroLeitoAtribuir, pacientes.get(pacienteIndex));
                                } else {
                                    System.out.println("Paciente inválido.");
                                }
                                break;

                            case 7:
                                System.out.println("Saindo...");
                                scanner.close();
                                return;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }

                } else{System.out.println("Opção inválida.");}
                break;
            case 2:
                listarPacientes(pacientes);
                System.out.println("Escolha uma opção: (1 - Solicitar Empregados, 2 - Gerar Relatório do Paciente, 3 - Gerenciamento de leitos)");
                int opcaoMedico = scanner.nextInt();
                scanner.nextLine();
                if (opcaoMedico == 1) {
                    listarEmpregados(empregados);
                    System.out.println("Escolha o número do funcionário para solicitar:");
                    funcionarioIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (funcionarioIndex >= 0 && funcionarioIndex < empregados.size()) {
                        System.out.println("Médico está solicitando Funcionário" + funcionarioIndex);
                    } else {
                        System.out.println("Funcionário inválido.");
                    }
                } else if (opcaoMedico == 2) {
                    System.out.println("Escolha o paciente pelo número:");
                    int pacienteIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (pacienteIndex >= 0 && pacienteIndex < pacientes.size()) {
                        gerarRelatorioPaciente(pacientes.get(pacienteIndex));
                    } else {
                        System.out.println("Paciente inválido.");
                    }
                } else if(opcaoMedico == 3) {
                    while (true) {
                        System.out.println("Selecione uma opção:");
                        System.out.println("1. Adicionar leito");
                        System.out.println("2. Remover leito");
                        System.out.println("3. Listar leitos disponíveis");
                        System.out.println("4. Atualizar status de leito");
                        System.out.println("5. Obter detalhes de leito");
                        System.out.println("6. Atribuir paciente a um leito");
                        System.out.println("7. Sair");

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                System.out.println("Número do leito:");
                                int numeroLeito = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Leito disponível (true/false):");
                                boolean disponivel = scanner.nextBoolean();
                                scanner.nextLine();
                                Leito leito = new Leito(numeroLeito, disponivel);
                                gerenciamentoDeLeitos.adicionarLeito(leito);
                                System.out.println("Leito adicionado com sucesso.");
                                break;

                            case 2:
                                System.out.println("Número do leito a remover:");
                                int numeroRemover = scanner.nextInt();
                                scanner.nextLine();
                                gerenciamentoDeLeitos.removerLeito(numeroRemover);
                                System.out.println("Leito removido com sucesso.");
                                break;

                            case 3:
                                List<Leito> leitosDisponiveis = gerenciamentoDeLeitos.listarLeitosDisponiveis();
                                System.out.println("Leitos disponíveis:");
                                for (Leito leitoDisp : leitosDisponiveis) {
                                    System.out.println(leitoDisp);
                                }
                                break;

                            case 4:
                                System.out.println("Número do leito a atualizar:");
                                int numeroAtualizar = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Novo status do leito (disponivel/indisponivel):");
                                String novoStatus = scanner.nextLine();
                                gerenciamentoDeLeitos.atualizarStatusLeito(numeroAtualizar, novoStatus);
                                System.out.println("Status do leito atualizado com sucesso.");
                                break;

                            case 5:
                                System.out.println("Número do leito para obter detalhes:");
                                int numeroDetalhes = scanner.nextInt();
                                scanner.nextLine();
                                String detalhesLeito = gerenciamentoDeLeitos.obterDetalhesLeito(numeroDetalhes);
                                System.out.println(detalhesLeito);
                                break;

                            case 6:
                                System.out.println("Número do leito para atribuir paciente:");
                                int numeroLeitoAtribuir = scanner.nextInt();
                                scanner.nextLine();
                                listarPacientes(pacientes);
                                System.out.println("Escolha o número do paciente para atribuir ao leito:");
                                int pacienteIndex = scanner.nextInt();
                                scanner.nextLine();
                                if (pacienteIndex >= 0 && pacienteIndex < pacientes.size()) {
                                    gerenciamentoDeLeitos.atribuirPacienteAoLeito(numeroLeitoAtribuir, pacientes.get(pacienteIndex));
                                } else {
                                    System.out.println("Paciente inválido.");
                                }
                                break;

                            case 7:
                                System.out.println("Saindo...");
                                scanner.close();
                                return;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }

                }else{System.out.println("Opção inválida.");}
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
        }
        scanner.close();
    }
    private static void listarEmpregados(List<Pessoa> empregados) {
        System.out.println("Lista de Funcionários:");
        for (int i = 0; i < empregados.size(); i++) {
            System.out.println(i + " - " + empregados.get(i).getNome());
        }
    }
    private static void listarPacientes(List<Paciente> pacientes) {
        System.out.println("Lista de Pacientes:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + " - " + pacientes.get(i).getNome());
        }
    }
    private static void gerarRelatorioPaciente(Paciente paciente) {
        System.out.println("Gerando relatório para: " + paciente.getNome());
        System.out.println("CPF: " + paciente.getCPF());
        System.out.println("Sexo: " + paciente.getSexo());
        System.out.println("Data de Nascimento: " + paciente.getDataDeNascimento());
        System.out.println("Leito: " + (paciente.getLeito() != null ? paciente.getLeito().getNumero() : "Nenhum"));
        System.out.println("Sinais Vitais:");
        System.out.println("Temperatura: " + paciente.getSinaisVitais().getTemperatura());
        System.out.println("Frequencia cardiaca: " + paciente.getSinaisVitais().getFrequenciaCardiaca());
        System.out.println("Pressão arterial: " + paciente.getSinaisVitais().getPressaoArterial());
        System.out.println("Taxa Respiratoria: " + paciente.getSinaisVitais().getTaxaRespiratoria());
        System.out.println("Saturação de Oxigenio: " + paciente.getSinaisVitais().getSaturacaoDeOxigenio());

    }
}
