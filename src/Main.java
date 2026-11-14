import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Farmaceutico farmaceutico = new Farmaceutico("Joao", "205635520", "456654");
        ProcessadorVendaPadrao processadorvendapadrao = new ProcessadorVendaPadrao();

        List<Cliente> clientes = new ArrayList<>();
        List<Farmaceutico> farmaceuticos = new ArrayList<>();

        farmaceuticos.add(farmaceutico);


        int opcao = 0;
        while (opcao != 5) {

            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar cliente ");
            System.out.println("2 - Listar clientes ");
            System.out.println("3 - Listar medicamentos ");
            System.out.println("4 - Realizar venda");
            System.out.println("5 - Sair ");

            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();
                    System.out.print("CPF: ");
                    String cpf = entrada.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = entrada.nextLine();

                    Cliente cliente = new Cliente(nome , cpf,telefone );
                    clientes.add(cliente);
                    System.out.print("Cliente cadastrado!");
                    break;
                case 2:
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.print((i + 1) + " - ");
                        clientes.get(i).exibirDados();
                    }
                    break;
                case 3:

                    break;

                case 4:
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.print((i + 1) + " - ");
                        clientes.get(i).exibirDados();

                    }
                    int numeroCliente = entrada.nextInt();

                    for (int i = 0; i < farmaceuticos.size(); i++) {
                        System.out.print((i+1) + " - ");
                        farmaceuticos.get(i).exibirDados();
                    }
                    int numeroFarmaceutico = entrada.nextInt();
                    break;

                case 5:
                    System.out.print("Processo encerrado! ");
                      break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

    }
}