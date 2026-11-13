import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Pessoa cliente = new Cliente("Maria", 132077585, 123123);
        Pessoa farmaceutico = new Farmaceutico("Joao", 205635520, 456654);
        Venda venda = new Venda(Cliente, Farmaceutico);

        String nomeDigitado = entrada.nextLine();

        cliente.exibirDados();
        farmaceutico.exibirDados();

    }
}