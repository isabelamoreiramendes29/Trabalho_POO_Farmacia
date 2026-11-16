import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Farmaceutico farmaceutico = new Farmaceutico("Joao", "20563552045", "456654");
        Farmaceutico farmaceutico2 = new Farmaceutico("Laura", "98765432112", "465987");

        ArquivoVenda arquivo = new ArquivoVenda("vendas.txt");
        ProcessadorVendaPadrao processadorvendapadrao = new ProcessadorVendaPadrao(arquivo);

        List<Cliente> clientes = new ArrayList<>();
        List<Farmaceutico> farmaceuticos = new ArrayList<>();
        List<Medicamento> medicamentos = arquivo.carregarMedicamentos();

        farmaceuticos.add(farmaceutico);
        farmaceuticos.add(farmaceutico2);

        int opcao = 0;
        while (opcao != 5) {

            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar cliente ");
            System.out.println("2 - Listar clientes ");
            System.out.println("3 - Listar medicamentos ");
            System.out.println("4 - Realizar venda");
            System.out.println("5 - Sair ");

            try {
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

                        Cliente cliente = new Cliente(nome, cpf, telefone);
                        clientes.add(cliente);
                        System.out.println("Cliente cadastrado!");
                        break;
                    case 2:
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.print((i + 1) + " - ");
                            clientes.get(i).exibirDados();
                        }
                        break;
                    case 3:
                        for (int i = 0; i < medicamentos.size(); i++) {
                            System.out.print((i + 1) + " - ");
                            medicamentos.get(i).exibirDados();
                        }
                        break;

                    case 4:
                        System.out.println("Escolha o cliente: ");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.print((i + 1) + " - ");
                            clientes.get(i).exibirDados();
                        }
                        int numeroCliente = entrada.nextInt();
                        Cliente Cescolhido = clientes.get(numeroCliente - 1);


                        System.out.println("Escolha o farmaceutico:");
                        for (int i = 0; i < farmaceuticos.size(); i++) {
                            System.out.print((i + 1) + " - ");
                            farmaceuticos.get(i).exibirDados();
                        }
                        int numeroFarmaceutico = entrada.nextInt();
                        Farmaceutico Fescolhido = farmaceuticos.get(numeroFarmaceutico - 1);

                        Venda venda = new Venda(Cescolhido, Fescolhido, processadorvendapadrao);

                        int numeroMedicamento = -1;
                        while (numeroMedicamento != 0) {
                            System.out.println("Escolha o medicamento (0 para finalizar a venda):");
                            for (int i = 0; i < medicamentos.size(); i++) {
                                System.out.print((i + 1) + " - ");
                                medicamentos.get(i).exibirDados();
                            }
                            numeroMedicamento = entrada.nextInt();
                            if (numeroMedicamento != 0) {
                                venda.adicionarMedicamento(medicamentos.get(numeroMedicamento - 1));
                                System.out.println("Medicamento adicionado!");
                            }
                        }

                        venda.finalizarVenda();
                        break;

                    case 5:
                        System.out.print("Processo encerrado! ");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                entrada.nextLine();
                opcao = 0;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido! Escolha um número da lista.");
            } catch (EstoqueInsuficienteException e) {
                System.out.println("Venda não realizada: " + e.getMessage());
            }
        }

    }
}
