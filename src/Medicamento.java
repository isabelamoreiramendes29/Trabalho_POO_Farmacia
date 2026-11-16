public abstract class Medicamento {

    protected String nome;
    protected double preco;
    protected int quantidadeEstoque;

    public Medicamento(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract void exibirDados();

    public void atualizarEstoque(int qtd) throws EstoqueInsuficienteException {

        if (qtd < 0 || qtd > quantidadeEstoque) {
            throw new EstoqueInsuficienteException("Quantidade invalida ou estoque insuficiente!");
        }

        quantidadeEstoque = quantidadeEstoque - qtd;
    }
}