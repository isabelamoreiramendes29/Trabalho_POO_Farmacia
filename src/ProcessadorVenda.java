public interface ProcessadorVenda {

    void processarVenda(Venda venda) throws EstoqueInsuficienteException;
}
