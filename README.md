# Alura-Java-IA

O **HTTP** (Hypertext Transfer Protocol) é um protocolo de comunicação que permite a transferência de informações na internet. Ele é a base para a comunicação entre navegadores e servidores Web, sendo utilizado para a transmissão de conteúdo como textos, imagens e vídeos.

O **HTTP** foi desenvolvido na década de 1990 e é baseado em um modelo cliente-servidor, onde um cliente (navegador Web) faz requisições a um servidor para obter informações, e o servidor responde com os dados solicitados. O **HTTP** utiliza o **TCP* (Transmission Control Protocol) como protocolo de transporte para garantir a entrega confiável dos dados.

O **HTTP** utiliza métodos para especificar o tipo de operação que deve ser realizada no servidor. Os principais métodos são **GET**, **POST**, **PUT** e **DELETE** . O método **GET** é utilizado para solicitar dados do servidor, enquanto o **POST** é utilizado para enviar informações para o servidor. O **PUT** é utilizado para atualizar informações no servidor e o **DELETE** é utilizado para remover informações.

Além dos métodos, o **HTTP** utiliza códigos de status para indicar o resultado da operação realizada. Os códigos de status variam de 100 a 599 e são divididos em cinco classes:

- 1xx: Informações
- 2xx: Sucesso
- 3xx: Redirecionamento
- 4xx: Erro do cliente
- 5xx: Erro do servidor

---

# Lidando com Exceções

## Hierarquia de Exceptions no JAVA

No Java, as exceções são organizadas em uma hierarquia de classes. Todas as exceções são subclasses da classe Throwable, sendo que ela possui duas subclasses principais: Exception e Error.

As exceções que herdam da classe Exception são chamadas de exceções verificadas (checked exceptions). Isso significa que essas exceções devem ser tratadas explicitamente em um bloco try-catch ou declaradas em uma cláusula throws na assinatura do método. Um exemplo é a classe de exceção `IOException`, que indica algum problema relacionado com leitura/escrita de dados.

As exceções que herdam da classe Error representam erros irrecuperáveis pelo sistema, como falta de memória ou falhas internas. Um exemplo é a classe de exceção `OutOfMemoryError`, que indica que o Java não conseguiu memória suficiente do sistema operacional para executar corretamente a aplicação.

Além disso, existe ainda a classe de exceção RuntimeException, que é uma subclasse direta de `Exception`, e as classes que herdam dela são chamadas de exceções não verificadas (unchecked exception). As exceções não verificadas indicam erros lógicos no código, como a `NullPointerException`, que indica o acesso a algum atributo ou método de um objeto que é nulo, ou seja, que não foi instanciado ou foi atributo ao valor `null`.

Ao lidar com exceções em um bloco try-catch, é importante considerar a hierarquia de exceções. É possível capturar exceções de uma classe mãe em um bloco catch que captura exceções de uma classe filha. No entanto, o inverso não é possível. Isso significa que, se um bloco catch captura exceções de uma classe filha, ele não será capaz de capturar exceções de uma classe mãe.

Exemplo: Imagine uma exceção `IOException` (classe mãe) e uma exceção `FileNotFoundException` (classe filha). Um bloco catch que captura `IOException` irá capturar tanto `IOException` quanto `FileNotFoundException`, pois `FileNotFoundException` é um tipo específico de `IOException`. No entanto, um bloco catch que captura `FileNotFoundException` não irá capturar `IOException`.

É importante lembrar que, ao usar a hierarquia de classes para tratar exceções, devemos priorizar o tratamento específico de exceções de classes filhas. Em seguida, podemos incluir um bloco catch mais genérico para tratar exceções de classes mães.

## Multi-catch

A partir do Java 7, a linguagem introduziu uma nova funcionalidade chamada "multi-catch", que permite capturar várias exceções em um único bloco catch. Essa funcionalidade pode tornar o código mais conciso e legível, reduzindo a repetição de código.

O uso de multi-catch é muito simples. Em vez de ter vários blocos catch para lidar com diferentes exceções, você pode agrupá-las em um único bloco usando o caractere | para separar as exceções. Por exemplo, suponha que você tenha escrito o seguinte código:

~~~Java
try {
    metodoQuePodeLancarExcecao();
} catch (NumberFormatException e) {
    System.out.println("tratando erro...");
} catch (IllegalArgumentException e) {
    System.out.println("tratando erro...");
}
~~~

Como o tratamento do erro é o mesmo para ambas as exceções, o código anterior poderia ter sido escrito utilizando o multi-catch:

~~~Java
try {
    metodoQuePodeLancarExcecao();
} catch (NullPointerException | IllegalArgumentException e) {
    System.out.println("tratando erro...");
}
~~~

No exemplo anterior, estamos lidando com duas exceções diferentes: `NullPointerException` e `IllegalArgumentException`. Se qualquer uma dessas exceções for lançada dentro do bloco try, o mesmo bloco catch será executado.

Uma observação importante de lembrar, é que o uso de multi-catch só é permitido para exceções que não estão relacionadas por uma hierarquia de herança. Se duas exceções compartilham uma hierarquia de herança, você deve lidar com elas em blocos catch separados.
