

public class Cliente extends Pessoa{

    private int telefone;
    public Cliente(String nome, int cpf, int telefone){
        super(nome, cpf);
        this.telefone = telefone;
    }


    @Override
    public void exibirDados(){
        System.out.println("Nome:" + nome + " " + "CPF:" + cpf + " " + "Telefone:" + telefone);

    }


}
