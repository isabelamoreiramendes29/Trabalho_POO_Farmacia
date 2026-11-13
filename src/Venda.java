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
     void finalizarVenda();
    
    //List<Medicamento> medicamentos = new ArrayList<>();

}
