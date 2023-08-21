import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    public boolean menu(Petshop petshop) {
        Scanner scanner = new Scanner(System.in);
        opcoes();
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1 -> adicionarCliente(petshop);
            case 2 -> adicionarCachorro(petshop);
            case 3 -> System.out.println(petshop.listarPessoas());
            case 4 -> listarCachorroCpf(petshop);
            case 5 -> removerPessoa(petshop);
            case 6 -> removerCachorro(petshop);
            case 7 -> listarVacinados(petshop);
            case 8 -> listarTodosVacinados(petshop);
            case 9 -> {
                return false;
            }
            default -> {
            }
        }
        return true;
    }

    public void opcoes() {
        System.out.println("""
                     --- Menu ---
                1- Adicionar cliente
                2- Adicionar cachorro
                3- Listar clientes
                4- Listar cachorros do cliente
                5- Remover cliente
                6- Remover cachorro
                7- Listar cachorros vacinados do cliente
                8- Listar todos vacinados
                9- Sair""".indent(0));
    }

    public void adicionarCliente(Petshop petshop) {
        Scanner scanner = new Scanner(System.in);
        /*
        if (!verificarCPF(cpf)) {
            System.out.println("CPF inválido, utilize o formato xxx.xxx.xxx-xx");
            return;
        }
        */
        System.out.println("Nome do cliente");
        String nome = scanner.nextLine();
        System.out.println("Cpf do cliente");
        String cpf = scanner.nextLine();
        System.out.println(petshop.addPessoa(cpf, nome));
    }

    public boolean verificarCPF(String cpf){
            Pattern pattern = Pattern.compile("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher((cpf));
            return matcher.find() && cpf.length() == 14;
    }

    public static void adicionarCachorro(Petshop petshop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cpf do cliente");
        String cpf = scanner.nextLine();
        System.out.println("Nome do cachorro");
        String nome = scanner.nextLine();
        System.out.println("Raça do cachorro");
        String raca = scanner.nextLine();
        System.out.println("Digite sim caso o cachorro for vacinado");
        String vacinado = scanner.nextLine();
        System.out.println(petshop.addCachorroCliente(cpf, nome, raca, vacinado.equals("sim")));
    }

    public void listarCachorroCpf(Petshop petshop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cpf da pessoa");
        String cpf = scanner.nextLine();
        System.out.println(petshop.listarCachorrosCliente(cpf));
    }

    public void removerPessoa(Petshop petshop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cpf do cliente");
        String cpf = scanner.nextLine();
        System.out.println(petshop.removePessoa(cpf));
    }

    public static void removerCachorro(Petshop petshop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cpf do cliente");
        String cpf = scanner.nextLine();
        System.out.println("Nome do cachorro");
        String nome = scanner.nextLine();
        System.out.println(petshop.removerCachorroCliente(cpf, nome));
    }

    public static void listarVacinados(Petshop petshop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cpf do cliente");
        String cpf = scanner.nextLine();
        System.out.println("Digite sim para mostar os cachorros vacinados e não para não vacinados");
        String vacinado = scanner.nextLine();
        System.out.println(petshop.listarCachorrosVacinadosCliente(cpf, vacinado.equals("sim")));
    }

    public static void listarTodosVacinados(Petshop petshop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sim para mostar os cachorros vacinados e não para não vacinados");
        String vacinado = scanner.nextLine();
        System.out.println(petshop.listarCachorrosVacinados(vacinado.equals("sim")));
    }

}