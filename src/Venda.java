import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private Farmaceutico farmaceutico;
    private double valorTotal;
    private ProcessadorVenda processador;

    public Venda(Cliente cliente, Farmaceutico farmaceutico, ProcessadorVenda processador) {
        this.cliente = cliente;
        this.farmaceutico = farmaceutico;
        this.processador = processador;

    }
    public Cliente getCliente(){
        return cliente;
    }
    public Farmaceutico getFarmaceutico(){
        return farmaceutico;
    }
    public double getValorTotal(){
        return valorTotal;
    }
    public void finalizarVenda(){
        processador.processarVenda(this);
     }

   // List<Medicamento> medicamentos = new ArrayList<>();

}
