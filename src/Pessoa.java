public abstract class Pessoa {

    protected String nome;
    protected int cpf;

    public Pessoa(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public abstract void exibirDados();

}
