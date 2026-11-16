# Trabalho_POO_Farmacia

Sistema de farmácia em Java, desenvolvido como projeto final da disciplina C06 – Programação Orientada a Objetos.

## Utilização de Inteligência Artificial no Desenvolvimento

Cada integrante da dupla usou uma ferramenta de IA diferente, por isso as declarações estão separadas.

---

### Parte da Isabela

**Ferramenta utilizada:** Claude — Anthropic (Claude Code, pelo aplicativo Claude para desktop)

**Modelo:** Claude Opus 5.5

#### Como a IA foi utilizada

Usei a conversa com a IA principalmente para compreender melhor o conteúdo de Programação Orientada a Objetos aplicado ao projeto. Antes de começar a escrever o código, fiz um combinado com ela:

> "voce vai me ajudar com o projeto mas nao quero em nenhum momento que me fale a resposta voce pode me ajudar com erros ou duvidas que eu tenho, apenas me indique uma ordem do que fazer mas nunca de a resposta completa"

A partir daí, a IA passou a indicar a ordem dos passos, explicar os erros de compilação e tirar dúvidas de conceito. Para mostrar a sintaxe, ela usava exemplos de outro tema, como uma classe `Cachorro`, e não as classes da farmácia. Com essas explicações, digitei as classes `Pessoa`, `Cliente` e `Farmaceutico`, a maior parte da `Venda`, a interface `ProcessadorVenda`, o atributo e o construtor da `ProcessadorVendaPadrao` e a primeira versão do menu do `Main`.

Nos últimos dias, por causa do prazo, pedi explicitamente que a IA escrevesse alguns trechos. Esses pedidos estão listados em uma seção separada, mais abaixo, e em cada um deles a IA explicou linha por linha o que tinha feito.

#### Prompts utilizados: discussões sobre o conteúdo

**Prompt 1: Revisão do UML**

"claude vou te passar veja se o uml esta correto" e "monte o diagrama corrigido"

Resposta aceita integralmente: a IA revisou o UML inicial da dupla, comparou com os requisitos do enunciado e montou o diagrama corrigido. A discussão passou pelas relações entre as classes e pelo que cada critério do enunciado exigia no diagrama.

**Prompt 2: Notação do UML**

"o que e esse <<usa>>? nao aprendi isso. tire o validar receita"

Resposta aceita parcialmente: a IA explicou que «usa» representa uma dependência, uma relação mais fraca que a associação. Como essa notação não foi vista em aula, preferi retirar essas setas do diagrama, junto com o método `validarReceita()`.

**Prompt 3: Classe abstrata e método abstrato**

"porque pessoa e uma classe abstrata? porque o metodo abstrato de mamifero nao tem { }, o metodo abstrato mamifero seria a mesma coisa que exibirDados?" e "para ser abstrato precisa ser a classe mae?"

Resposta aceita integralmente: a IA explicou que uma classe abstrata não pode ser instanciada e serve de modelo para as filhas, e que o método abstrato não tem corpo porque cada filha é obrigada a escrever a sua versão. Relacionamos isso com o exercício de interface da aula: o `exibirDados()` da `Pessoa` faz o mesmo papel, e `Cliente` e `Farmaceutico` sobrescrevem o método, cada uma mostrando os seus dados.

**Prompt 4: Atributos da subclasse, visibilidade e super**

"o atributo telefone nao esta na mae como eu faço para incluir ele?" e "para que serve o -?"

Resposta aceita integralmente: a IA explicou que o `telefone` pertence só ao cliente, por isso fica declarado na `Cliente`, e que o construtor da filha recebe todos os dados e repassa nome e CPF para a mãe com `super`. Também explicou os símbolos do UML: `-` é private, `#` é protected e `+` é public, e o `protected` permite que as filhas usem os atributos da mãe.

**Prompt 5: Relações entre as classes**

"como chama isso que estamos fazendo de criar um atributo que e uma classe?" e "farmaceutico e pessoa e um, porque um farmaceutico e uma pessoa, entre venda e farmaceutico e tem um. mas agora pensando nisso seria uma agregação ja que um farmaceutico existe sem uma venda"

Resposta aceita integralmente: a IA explicou que um atributo cujo tipo é outra classe forma uma associação. A discussão diferenciou a relação "é um", que é herança, da relação "tem um", que é associação, e o caso da agregação, em que a parte existe sem o todo.

**Prompt 6: Lista de medicamentos na venda**

"porque dentro do <> nos usamos medicamento e fora medicamentos. entao venda precisa de array ja que uma venda precisa de varios medicamentos?"

Resposta aceita integralmente: a IA explicou que o tipo entre `< >` diz o que cada item da lista é, e que o nome fora dele é só o nome da variável, no plural por convenção. Como uma venda tem vários medicamentos, a `Venda` precisa de uma lista, e usamos `List` com `ArrayList`.

**Prompt 7: Interface ProcessadorVenda**

"o que e o processador venda?" e "ProcessadorVendaPadrao: nao entendi."

Resposta aceita integralmente: a IA explicou que a interface é um contrato, que diz o que precisa ser feito sem dizer como, e que a `ProcessadorVendaPadrao` é a classe que cumpre esse contrato. Depois, com o retorno do professor, de que a interface deveria ser usada por outra classe, a discussão levou à mudança no projeto: a `Venda` passou a guardar um `ProcessadorVenda` e a delegar a ele o processamento no `finalizarVenda()`.

**Prompt 8: Funcionamento do menu**

"para realizar a venda, eu seleciono o cliente, seleciono o farmacêutico, listo os medicamentos, a quantidade que eu quero de cada um, e ele já calcula o valor total, certo?" e "a venda e criada em primeiro plano, porque o cliente o farmaceutico e quais medicamentos fazem parte da venda"

Resposta aceita integralmente: a IA confirmou o fluxo e ajudou a organizar o menu em cadastrar cliente, listar clientes, listar medicamentos, realizar venda e sair. Como o projeto não tem uma classe para a quantidade, cada medicamento escolhido conta como uma unidade.

**Prompt 9: @Override, public, this e add**

"para que serve o override mesmo? porque precisa colocar public antes de void? nao entendi como fazer o processador processar o this. o que adiciona e o lista add"

Resposta aceita integralmente: a IA explicou que o `@Override` pede ao compilador para conferir se o método realmente sobrescreve outro; que os métodos de uma interface são públicos, e a classe que implementa não pode diminuir essa visibilidade; que o `this` é a própria venda, entregue ao processador; e que o `add` coloca um objeto dentro da lista.

**Prompt 10: Chamada de métodos e lugar dos getters**

"para chamar um metodo de uma classe na main, eu coloco a classe e depois o metodo e abro parenteses?" e "porque nos colocamos o get dentro de venda e nao da propria classe que vem os metodos?"

Resposta aceita integralmente: a IA explicou que o método é chamado pelo objeto, e não pela classe, a não ser em métodos `static`. Também explicou que o getter fica sempre na classe dona do atributo: como o atributo é `private`, o getter é a forma controlada de outras classes lerem o valor, o que é encapsulamento.

**Prompt 11: Buscar um objeto na lista**

"para buscar o cliente apenas colocando um for ja iria funcionar?" e "nao estou entendendo como arrumar essa parte no int e cliente"

Resposta aceita integralmente: a IA explicou que o `for` serve para percorrer a lista inteira, enquanto o `get` busca um único objeto pela posição. O número digitado é só a posição, e não o cliente, e por isso não pode ser guardado numa variável do tipo `Cliente`. Como a lista começa na posição 0 e o menu começa no 1, a busca usa o número menos 1.

**Prompt 12: Exceções, try/catch, throw e throws**

"try e catch e a mesma coisa que exceção?", "o try/catch deve ser incluido na main?", "dentro da estrutura do catch o que vai entre parenteses seria o erro, certo?", "o que e throws?" e "throw e a mesma coisa que try/catch? qual a diferença"

Resposta aceita integralmente: a IA explicou que a exceção é o problema e o try/catch é o tratamento. O `throw` lança a exceção, como no `atualizarEstoque()`, e o `throws` avisa, na assinatura do método, que ele repassa a exceção para quem o chamou. Assim, a `EstoqueInsuficienteException` sobe do `Medicamento` para a `ProcessadorVendaPadrao` e para a `Venda` até chegar ao `Main`, onde é tratada. Também vimos que entre os parênteses do `catch` vão o tipo da exceção e uma variável, e como ler a mensagem de erro para descobrir esse tipo.

**Prompt 13: Exceções do Java no menu e no arquivo**

"o que significa esse catch IndexOutOfBoundsException" e "o que é esse try catch que esta no arquivo"

Resposta aceita integralmente: a IA explicou que a `IndexOutOfBoundsException` acontece quando se pede a uma lista uma posição que não existe, e que o Java não obriga a tratá-la, ao contrário das exceções que herdam de `Exception`. Explicou também o tratamento da `IOException` na `ArquivoVenda`, feito dentro da própria classe.

**Prompt 14: Arquivo de texto ou banco de dados**

"a yasmin adicionou um arquivo txt com os medicamentos, nao seria melhor adicionar eles no proprio codigo?" e "antes eu tinha combinado que nos iamos puxar do banco de dados"

Resposta aceita integralmente: a IA lembrou que o enunciado pede arquivo ou banco de dados, e que o `medicamentos.txt` cumpre esse critério. Colocar os medicamentos direto no código faria o projeto perder esse ponto, e um banco de dados exigiria ligar o Java a um servidor. Mantivemos os arquivos de texto.

**Prompt 15: Nomes de variáveis**

"porque para adicionar no array o objeto precisa estar no plural" e "entao por que o nome declarado dentro no array list tem que ser diferente do declarado para criar um objeto farmaceutico?"

Resposta aceita integralmente: a IA explicou que o Java não exige plural: ele exige que o nome seja exatamente o que foi declarado, e o plural é só uma convenção para indicar uma lista. Também explicou que, dentro do mesmo método, cada variável precisa de um nome único, e que `farmaceutico` e `farmaceuticos` são nomes diferentes para o Java.

**Prompt 16: Código sem uso**

"tudo o que nao for usado na programação deve ser removido, logo o que aparece no usages deve ser removido da programação"

Resposta aceita parcialmente: a IA mostrou que o aviso "no usages" do IntelliJ estava desatualizado e marcava métodos que eram usados. Conferindo o projeto inteiro, só o `getFarmaceutico()` da `Venda` e o `getNome()` da `Medicamento` não eram chamados. Decidi remover esses dois.

#### Trechos de código escritos pela IA, a meu pedido

Nestes pedidos, a IA escreveu o código e depois explicou cada linha.

**Pedido 1:** "arrume o case 2 para mim"

Resposta aceita integralmente: a IA corrigiu o laço do `case 2` do `Main`, que lista os clientes cadastrados.

**Pedido 2:** "ela enviou agora temos que juntar tudo, vou te mandar os arquivos adicione na programação"

Resposta aceita integralmente: a IA copiou para o projeto, sem alterar, os arquivos da Yasmim (`Medicamento`, `MedicamentoGenerico`, `MedicamentoReferencia`, `EstoqueInsuficienteException`, `ArquivoVenda` e `medicamentos.txt`) e testou se compilavam junto com o resto.

**Pedido 3:** "arrume o getPreco e getNome para mim"

Resposta aceita integralmente: a IA criou o `getPreco()` e o `getNome()` na `Medicamento`. Depois, o `getNome()` foi removido por não ser usado.

**Pedido 4:** "arrume o getmedicamento e o adicionar medicamento"

Resposta aceita integralmente: na `Venda`, a IA criou o `getMedicamentos()` e acrescentou o parâmetro `Medicamento m` ao `adicionarMedicamento()`.

**Pedido 5:** "o que e throws? faça o restante do codigo e diga o que fez"

Resposta aceita integralmente: a IA escreveu o corpo do `processarVenda()`, que calcula o total, baixa o estoque de cada medicamento e salva a venda no arquivo; acrescentou o `throws EstoqueInsuficienteException` na interface, na `ProcessadorVendaPadrao` e no `finalizarVenda()`; e, no `Main`, criou a `ArquivoVenda`, carregou a lista de medicamentos, completou o `case 3`, montou a escolha dos medicamentos no `case 4` e colocou o menu dentro de um `try` com três `catch`.

**Pedido 6:** "remova o getFarmaceutico e o getNome da medicamento"

Resposta aceita integralmente: a IA removeu os dois métodos sem uso.

#### Outras tarefas feitas pela IA

- **Repositório e projeto:** a pedido ("crie o repositorio para mim"), a IA criou o repositório no GitHub e, depois, a estrutura do projeto no IntelliJ, com a pasta `src`, o arquivo `.iml` e o JDK 17.
- **Diagrama UML:** a IA desenhou o UML no draw.io a partir do diagrama da dupla e das correções discutidas, aplicou as mudanças que pedi e exportou a imagem enviada ao professor ("mande em um arquivo o uml completo para eu mandar para o professor").
- **Planejamento:** a IA montou um cronograma de 10 a 16/11, com perguntas para levar ao professor ("claude faça um plano de estudos para eu me organizar com esse projeto").
- **Git e testes:** a IA fez os commits e os envios ao GitHub quando pedi, e compilou e testou o projeto a cada versão que eu pedia para ela conferir.

---

### Parte da Yasmim

**Ferramenta utilizada:** ChatGPT — OpenAI

**Modelo:** GPT-6

A inteligência artificial foi utilizada como ferramenta de apoio na implementação e revisão das classes Java, considerando o diagrama UML definido para o sistema de farmácia e os conteúdos estudados na disciplina de Programação Orientada a Objetos.

#### Principais prompts utilizados (resumidos)

1. **Implementação conforme o UML**

   “Preciso implementar minha parte do sistema de farmácia em Java. Utilize o diagrama UML como referência, respeitando os atributos, métodos, construtores e relacionamentos definidos. Mantenha o código simples e compatível com os conteúdos estudados.”

2. **Classe abstrata Medicamento**

   “Na classe Medicamento, preciso definir os atributos nome, preço e quantidade em estoque, além do construtor, do método abstrato exibirDados() e do método atualizarEstoque(). Como implementar essa estrutura respeitando a herança das subclasses?”

3. **Herança e sobrescrita de métodos**

   “Preciso implementar MedicamentoGenerico e MedicamentoReferencia herdando de Medicamento. Utilize super() para inicializar os atributos herdados e sobrescreva exibirDados() para apresentar as informações específicas de cada tipo.”

4. **Exceção personalizada para o estoque**

   “Preciso criar EstoqueInsuficienteException conforme o UML. Verifique como utilizar essa exceção no método atualizarEstoque() para impedir que a quantidade disponível fique negativa, seguindo o conteúdo de exceções da disciplina.”

5. **Leitura e escrita de arquivos**

   “Preciso implementar ArquivoVenda com os métodos salvarVenda() e carregarMedicamentos(). Utilize os recursos de leitura e escrita de arquivos apresentados na Aula 14, evitando bibliotecas ou soluções que não foram estudadas.”

6. **Utilização de listas**

   “Como utilizar List e ArrayList para armazenar os medicamentos carregados do arquivo de texto, considerando que o sistema possui medicamentos genéricos e de referência?”

7. **Revisão e compatibilidade**

   “Confira se as classes implementadas correspondem ao UML, se utilizam os conceitos estudados nas aulas e se são compatíveis com as classes já desenvolvidas pela minha colega.”

8. **Testes do sistema**

   “Preciso verificar o funcionamento do projeto no IntelliJ IDEA. Oriente os testes de cadastro de clientes, listagem, seleção de farmacêutico e processamento de vendas, identificando quais funcionalidades ainda precisam ser integradas.”
