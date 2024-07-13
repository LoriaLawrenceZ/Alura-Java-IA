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

# Persistindo Dados em Arquivos

## O Pacote *java.io*

O Java possui um pacote chamado java.io, que é um dos pacotes mais importantes da linguagem, pois fornece classes e interfaces para entrada e saída de dados em vários formatos, como arquivos, rede, teclado, dentre outros. Vamos conhecer as principais classes desse pacote.

### A classe *File*

A classe **File** representa um arquivo ou diretório no sistema de arquivos do computador, permitindo que você crie, delete, liste e manipule arquivos e diretórios. Para criar um objeto `File`, você precisa passar o caminho do arquivo ou diretório como argumento para o construtor. Por exemplo:

~~~Java
File file = new File("C:\\meuArquivo.txt");
~~~

No código anterior, foi criado um objeto `File` que aponta para o arquivo "meuArquivo.txt" localizado na raiz do disco `C:`.

A classe File tem vários métodos úteis para interagir com arquivos e diretórios, como `exists()`, `canRead()`, `canWrite()`, `isDirectory()`, `isFile()`, `mkdir()` e `delete()`.

### As classes *FileReader* e *FileWriter*

As classes **FileReader** e **FileWriter** são usadas para ler e escrever dados em arquivos de texto, sendo que a classe `FileReader` lê os caracteres de um arquivo de texto, enquanto a classe `FileWriter` escreve os caracteres.

Para usar a classe `FileReader`, você precisa criar um objeto passando um objeto `File` que deseja ler como argumento. Em seguida, você pode ler os dados do arquivo usando o método `read()` ou `read(char[])`. Por exemplo:

~~~Java
File file = new File("C:\\meuArquivo.txt");
FileReader reader = new FileReader(file);

int data = reader.read();
while (data != -1) {
    System.out.print((char) data);
    data = reader.read();
}
reader.close();
~~~

No código anterior, é feita a leitura do conteúdo do arquivo "meuArquivo.txt" e seu conteúdo é impresso no console.

Já a classe `FileWriter` segue o mesmo processo, porém fazendo o caminho inverso, ou seja, escrevendo caracteres no arquivo. Por exemplo:

~~~Java
File file = new File("C:\\saida.txt");
FileWriter writer = new FileWriter(file);
writer.write("Olá, mundo!");
writer.close();
~~~

No código anterior, é escrito uma mensagem no arquivo chamado "saida.txt".

O pacote java.io também fornece outras classes úteis, como:

- **BufferedReader** e **BufferedWriter**: são usadas para ler e gravar arquivos de texto de maneira eficiente, lendo e escrevendo uma linha por vez. Elas usam um buffer para armazenar os dados, o que torna a leitura e escrita mais rápida do que quando feita um caractere por vez;
- **FileInputStream** e **FileOutputStream**: são usadas para ler e gravar dados binários em um arquivo. Eles são usados para ler e gravar dados em arquivos que não são de texto, como imagens e arquivos de áudio;
- **ObjectInputStream** e **ObjectOutputStream**: são usadas para ler e gravar objetos em arquivos. Isso permite que você armazene objetos Java em arquivos para uso posterior ou para transferência entre diferentes aplicações. 
 
Claro, além dessas há também a classe **FileWriter**, que foi utilizada no curso para a escrita simples de um arquivo no computador, e também a classe `Scanner`, que é utilizada para ler arquivos do computador de uma maneira simples e será explicada posteriormente no curso.

### Lendo Arquivos com *Scanner*

Aprendemos a salvar um arquivo, via classe `FileWriter`, mas caso você queira fazer o caminho contrário, ou seja, ler o conteúdo de um arquivo existente em Java, pode fazer isso com a utilização da classe Scanner.

A classe `Scanner` é uma classe padrão do Java que permite ler dados de diferentes fontes, incluindo arquivos. Para ler um arquivo com essa classe, basta criar uma instância dela e passar como argumento um objeto do tipo `File`, contendo o caminho do arquivo. Por exemplo:

~~~Java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDeArquivo {
    public static void main(String[] args) {
        try {
            File arquivo = new File("arquivo.json");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }
}
~~~

No código anterior, estamos lendo um arquivo chamado `arquivo.json` e imprimindo o conteúdo do arquivo linha por linha no console. O método `hasNextLine()` verifica se há mais linhas a serem lidas, enquanto o método `nextLine()` lê a próxima linha do arquivo.

A classe Scanner também pode ser usada para ler dados de entrada de outras fontes, como o teclado e strings. Além disso, ela oferece muitas opções para personalizar a forma como os dados são lidos, incluindo a capacidade de usar expressões regulares para analisar o texto.