public class MedicamentoReferencia extends Medicamento {

    private String fabricante;

    public MedicamentoReferencia(String nome, double preco, int quantidadeEstoque, String fabricante) {
        super(nome, preco, quantidadeEstoque);
        this.fabricante = fabricante;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + nome + " Preço: " + preco + " Estoque: " + quantidadeEstoque + " Fabricante: " + fabricante);
    }
}