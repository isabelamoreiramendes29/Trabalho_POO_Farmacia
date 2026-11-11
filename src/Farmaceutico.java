public class Farmaceutico extends Pessoa {

    private int crf;
    public Farmaceutico(String nome, int cpf, int crf){
        super(nome, cpf);
        this.crf = crf;
    }


    @Override
    public void exibirDados(){
        System.out.println("Nome:" + nome + " " + "CPF:" + cpf + " " + "CRF:" + crf);

    }


}

