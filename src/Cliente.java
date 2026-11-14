

public class Cliente extends Pessoa{

    private String telefone;
    public Cliente(String nome, String cpf, String telefone){
        super(nome, cpf);
        this.telefone = telefone;
    }


    @Override
    public void exibirDados(){
        System.out.println("Nome:" + nome + " " + "CPF:" + cpf + " " + "Telefone:" + telefone);

    }


}
