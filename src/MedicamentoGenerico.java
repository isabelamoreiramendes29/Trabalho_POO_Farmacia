public class MedicamentoGenerico extends Medicamento {

    private String nomeReferencia;

    public MedicamentoGenerico(String nome, double preco, int quantidadeEstoque, String nomeReferencia) {
        super(nome, preco, quantidadeEstoque);
        this.nomeReferencia = nomeReferencia;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + nome + " Preço: " + preco + " Estoque: " + quantidadeEstoque + " Referência: " + nomeReferencia);
    }
}