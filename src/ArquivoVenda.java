import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArquivoVenda {

    private String caminho;

    public ArquivoVenda(String caminho) {
        this.caminho = caminho;
    }

    public void salvarVenda(Venda v) {
        try {
            Path arquivo = Paths.get(caminho);

            String texto = "";

            if (Files.exists(arquivo)) {
                texto = Files.readString(arquivo);
            }

            texto += "Cliente: " + v.getCliente().getNome() + "\n";
            texto += "Valor total: " + v.getValorTotal() + "\n\n";

            Files.writeString(arquivo, texto);

        } catch (IOException e) {
            System.out.println("Erro ao salvar venda!");
        }
    }

    public List<Medicamento> carregarMedicamentos() {

        List<Medicamento> medicamentos = new ArrayList<>();

        try {
            Path arquivo = Paths.get("medicamentos.txt");
            List<String> linhas = Files.readAllLines(arquivo);

            for (String linha : linhas) {
                String[] dados = linha.split(";");

                if (dados[0].equals("Generico")) {
                    medicamentos.add(new MedicamentoGenerico(
                            dados[1],
                            Double.parseDouble(dados[2]),
                            Integer.parseInt(dados[3]),
                            dados[4]
                    ));
                }

                if (dados[0].equals("Referencia")) {
                    medicamentos.add(new MedicamentoReferencia(
                            dados[1],
                            Double.parseDouble(dados[2]),
                            Integer.parseInt(dados[3]),
                            dados[4]
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar medicamentos!");
        }

        return medicamentos;
    }
}