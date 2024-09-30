package Main;

import Service.ReservaService;
import Service.SalaService;
import Service.UsuarioService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioService usuarioService = new UsuarioService();
    private static SalaService salaService = new SalaService();
    private static ReservaService reservaService = new ReservaService();

    public static void main(String[] args) {
        System.out.println("Seja bem-vindo(a) ao Sistema de Reservas de Sala utilizando JPA e Hibernate.");
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            executarAcao(opcao);
        } while (opcao != 0);

        System.out.println("Encerrando o sistema.");
    }

    private static void exibirMenu() {
        System.out.println("\n---- Menu ----");
        System.out.println("1. Cadastrar Novo Usuário");
        System.out.println("2. Cadastrar Nova Sala");
        System.out.println("3. Cadastrar Nova Reserva");
        System.out.println("4. Buscar Usuário por ID");
        System.out.println("5. Verificar Disponibilidade de Sala");
        System.out.println("6. Buscar Reservas por Usuário");
        System.out.println("7. Buscar Reservas por Período");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void executarAcao(int opcao) {
        switch (opcao) {
            case 1:
                dialogCadastrarUsuario();
                break;
            case 2:
                dialogCadastrarSala();
                break;
            case 3:
                dialogCadastrarReserva();
                break;
            case 4:
                dialogBuscarUsuario();
                break;
            case 5:
                dialogVerificarSalaDisponivel();
                break;
            case 6:
                dialogBuscarReserva();
                break;
            case 7:
                dialogBuscarReservaPorPeriodo();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void dialogCadastrarUsuario() {
        System.out.println("Digite o seu nome.");
        String nome = scanner.nextLine();
        System.out.println("Digite seu e-mail.");
        String email = scanner.nextLine();
        usuarioService.cadastrarUsuario(nome, email);
    }

    private static void dialogCadastrarSala() {
        System.out.println("Digite o nome da sala.");
        String nome = scanner.nextLine();
        System.out.println("Digite a capacidade da sala.");
        Integer capacidade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a descrição da sala.");
        String descricao = scanner.nextLine();
        salaService.cadastrarSala(nome, capacidade, descricao);
    }

    private static void dialogCadastrarReserva() {
        System.out.println("Digite o horário de início da reserva (formato: yyyy-MM-ddTHH:mm):");
        LocalDateTime dataInicio = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Digite o horário de fim da reserva (formato: yyyy-MM-ddTHH:mm):");
        LocalDateTime dataFim = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Digite seu ID de usuário para realizar uma reserva.");
        Integer idUsuario = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a sala que deseja reservar.");
        Integer idSala = scanner.nextInt();
        reservaService.cadastrarReserva(dataInicio, dataFim, idUsuario, idSala);
    }

    private static void dialogBuscarUsuario() {
        System.out.println("Digite o ID do usuário que deseja pesquisar.");
        Integer id = scanner.nextInt();
        usuarioService.buscarUsuario(id);
    }

    private static void dialogBuscarReserva() {
        System.out.println("Digite o ID do usuário que deseja pesquisar as reservas realizadas.");
        Integer id = scanner.nextInt();
        reservaService.buscarReserva(id);
    }

    private static void dialogVerificarSalaDisponivel() {
        System.out.println("Digite o ID da sala que deseja verificar a disponibilidade.");
        Integer id = scanner.nextInt();
        salaService.verificarSalaDisponivel(id);
    }

    private static void dialogBuscarReservaPorPeriodo() {
        System.out.println("Digite a data e hora de início do período (formato: yyyy-MM-ddTHH:mm):");
        LocalDateTime dataInicio = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Digite o horário de fim do período (formato: yyyy-MM-ddTHH:mm):");
        LocalDateTime dataFim = LocalDateTime.parse(scanner.nextLine());
        reservaService.buscarReservaPorPeriodo(dataInicio, dataFim);
    }

}
