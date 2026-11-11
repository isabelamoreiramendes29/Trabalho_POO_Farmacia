public class Main {

    public static void main(String[] args) {


        Pessoa cliente = new Cliente("Maria", 132077585, 123123);
        Pessoa farmaceutico = new Farmaceutico("Joao", 205635520, 456654);


        cliente.exibirDados();
        farmaceutico.exibirDados();

    }
}