public class Farmaceutico extends Pessoa {

    private String crf;
    public Farmaceutico(String nome, String cpf, String crf){
        super(nome, cpf);
        this.crf = crf;
    }


    @Override
    public void exibirDados(){
        System.out.println("Nome:" + nome + " " + "CPF:" + cpf + " " + "CRF:" + crf);

    }


}

