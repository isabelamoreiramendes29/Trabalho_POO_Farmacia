import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private Farmaceutico farmaceutico;
    private double valorTotal;
    private ProcessadorVenda processador;
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Venda(Cliente cliente, Farmaceutico farmaceutico, ProcessadorVenda processador) {
        this.cliente = cliente;
        this.farmaceutico = farmaceutico;
        this.processador = processador;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void adicionarMedicamento(Medicamento m) {
        medicamentos.add(m);
    }


    public double calcularTotal() {
        valorTotal = 0;
        for (int i = 0; i < medicamentos.size(); i++) {
            valorTotal = valorTotal + medicamentos.get(i).getPreco();
        }
        return valorTotal;
    }

    public void finalizarVenda() throws EstoqueInsuficienteException {
        processador.processarVenda(this);
    }

}
