public class ProcessadorVendaPadrao implements ProcessadorVenda{

    private ArquivoVenda arquivo;

    public ProcessadorVendaPadrao(ArquivoVenda arquivo){
        this.arquivo = arquivo;
    }

    @Override
    public void processarVenda(Venda venda) throws EstoqueInsuficienteException {
        venda.calcularTotal();
        for (int i = 0; i < venda.getMedicamentos().size(); i++) {
            venda.getMedicamentos().get(i).atualizarEstoque(1);

        }

        arquivo.salvarVenda(venda);
        System.out.println("Venda processada! Total: R$ " + venda.getValorTotal());
    }

}
