# Java e Java.util: Collections e lambda

## Equals e listas

<details>
<summary>ArrayList vantagem e desvantagem</summary>
Rápida para iterar, mas se remover

```java
list.remove(1);
```
muda toda a indexação da lista  
</details>


<details>
<summary>java.util.LinkedList reorganiza os elementos sem custos porém...</summary>
Cada elemento sabe o index do anterior e do próximo. Fácil alterar.

Mas iterar é difícil pois tem que começar do início.
</details>


<details>
<summary>java.util.LinkedList compartilha...</summary>
Mesmos métodos

```java
myList.remove();
myList.size();
myList.contains();   
```

Isso é devido a interface List

```java
List<Integer> myList = new LinkedList<>(); 
```
</details>

<details>
    <summary>
    It is possible to change main args to a list
    </summary>


```java
public static void main(String[] args) {
    (args);
}
```
</details>

## Vector & Collection

<details>
<summary>
Vector
</summary>
The same thing as ArrayList, but threadsafe.It came before ArrayList and List (interface). Most of the time it's not necessary.
</details>

<details>
<summary>
Set
</summary>
Because List accepts duplicate entries. Both extends Collection. Vector is under List.
</details>

## Wrapper


<details>
<summary>
Why do I need references in List < Integer >
</summary>
No mundo de arrays existem primitivos e referências.
No mundo de Lists existem somente referências (they are objetcs)
Actually Java will convert primitives to objects

```java
myList.add(15);
//it should not be possible
//it's called autoboxing
//from Double to double is Unboxing (for example)
```
</details>

<details>
<summary>
Deprecated way to convert to reference
</summary>

```java
//Deprecated way
Integer numero = new Integer(22);

//New way
Integer numero = Integer.valueOf(22);
```
</details>

<details>
<summary>
Some methods or atributes for Integer</summary>

```java
//Deprecated way
Integer.MAX_VALUE;
Integer.intValue();
//parse is a static method that receives something
Integer.parseInt(...);
```
</details>

<details>
<summary>
Qual o problema de Integer.valueOf</summary>

Integer.valueOf("22"); retorna uma referência. E se for necessário uma int haveria um unboxing, então não seria a melhor opção, e sim:

Integer.parseInt("22"); devolve um int diretamente
</details>

<details>
<summary> Number </summary>
Mother class of Long, Integer, Double...
</details>

<details>
<summary>
Initialize a reference to an Integer object</summary>
Integer myInt = Integer.valueOf("22");
</details>

## Sort

<details>
<summary>
How to sort a list of String?
</summary>

```java
import java.util.Collections;
Collections.sort(minhaStrList);
```
</details>

<details>
<summary>
How to reversevely sort a list of Strings?
</summary>

```java
Collections.reverse(minhaStrList)
```
</details>

<details>
<summary>
Why today list.sort() is used instead of another static Class?
</summary>
Because that how it should be in OO world, where each object is responsible for itself.
</details>

<details>
<summary>
How to implement list.sort( ) ?
</summary>
list.sort() needs a Comparator class

```java
list.sort(new NomeTitularComparator());
```
For strings

```java
class TitularDaContaComparator implements Comparator<Conta> {
    @Override
    public int compare(Conta c1, Conta c2) {

       return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
    }
}
```

For integers

```java
class NumeroDaContaComparator  implements Comparator<Conta> {
    @Override
    public int compare(Conta c1, Conta c2) {
        return c1.getNumero() - c2.getNumero();
        //return Integer.compare(c1.getNumero(), c2.getNumero());
    }
}
```
</details>

<details>
<summary>
Old way to sort a list
</summary>

```java
Collections.sort(lista, new TitularContaComparator());
```
</details>

<details>
<summary>
How to order by natural order
</summary>

```java
//Old way
//Collections.sort(lista);

//New way
list.sort(null);
```
Then 

```java
class Conta implements Comparable<Conta> {
    /* */
    @Override
    public int compareTo(Conta o) {
        return Double.compare(this.saldo, o.saldo);
        //possible to access because its inside the class
    }
}
```
</details>

<details>
<summary>
Origin of Comparable and Comparator
</summary>
Para natural order:
java.lang.Comparable
To any order:
java.util.Comparator
</details>

<details>
<summary>
O que é ordem natural?
</summary>
Ordem usada pelo próprio elemento da lista
</details>

<details>
<summary>
Difference between Arrays and Collections
</summary>
Arrays is also a class full of static methods inside java.util. But it works with arrays
</details>


## Anonymous classes & lambas

<details>
<summary>
Functional Objects
</summary>
Some classes exists only to store a single method. The objects from those clases are "Functional Objects".
</details>

<details>
<summary>
Anonymous classes
</summary>
When you initialize without declaring a class first. The implementation of the class comes together with it.

Example of anonymous class. **Necessary to add () to call the constructor**.

```java
    lista.sort(new Comparator<Conta>() {
        @Override
        public int compare(Conta c1, Conta c2) {
            return Integer.compare(c1.getNumero(), c2.getNumero());
        }
    });
```

How it was before.

```java
class NumeroDaContaComparator2 implements Comparator<Conta> {
	@Override
	public int compare(Conta c1, Conta c2) {
		return Integer.compare(c1.getNumero(), c2.getNumero());
	}
}
```

But this will sacrifice readability. But it is also possible to store the anonymous classes inside a variable.

```java
Comparator<Conta> comp = new Comparator<Conta>() {
    @Override
    public int compare(Conta c1, Conta c2) {
        return Integer.compare(c1.getNumero(), c2.getNumero());
    }
} 
```

</details>


<details>
<summary>
Lambdas</summary>
To clean the code and showing only the parameters.<br>
From this:

```java
lista.sort(new Comparator<Conta>() {
    @Override
    public int compare(Conta c1, Conta c2) {
        return c1.getNumero() - c2.getNumero();
    }
});
```
To this:

```java
lista.sort((c1, c2) -> c1.getNumero() - c2.getNumero());
```
</details>


<details>
<summary>
In a list using OO who should know how to loop?
</summary>
The list itself. That's why this exists:

```java
list.forEach( conta -> System.out.println("Conta "+ conta) )
```
</details>

<details>
<summary>
Iterator</summary>

```java
List<String> nomes = new ArrayList<>();
nomes.add("Super Mario");
nomes.add("Yoshi"); 
nomes.add("Donkey Kong"); 

Iterator<String> it = nomes.iterator();

while(it.hasNext()) {
  System.out.println(it.next());
}
```
</details>

<br><br>

# Java.io 
Link: https://unibb.alura.com.br/course/java-trabalhando-com-io

## Leitura

<details><summary> Boilerplate para ler linha </summary>

```java
//public static void main(String[] args) throws IOException {
FileInputStream fis = new FileInputStream("lorem.txt");
InputStreamReader isr = new InputStreamReader(fis);
BufferedReader br = new BufferedReader(isr);
String linha = br.readLine();
// System.out.println(linha);
br.close();

```
</details>

<details><summary> FileNotFoundException é uma exception de quem?</summary>
FileInputStream</details>

<details><summary> Hierarquia de FileNotFoundException</summary>
Exception > IOException > FileNotFoundException
</details>

<details><summary> InputStreamReader e FileInputStream não precisam ser fechados</summary>
pois o BufferedReader já fecha eles.</details>

<details><summary>Boilerplate para ler TODO o arquivo</summary>

```java
while (linha != null) {
    System.out.println(linha);
    linha = br.readLine();
}
br.close();
```
</details>

<details><summary> Substituir pela classe mãe é possível </summary>

```java
//FileInputStream fis = new FileInputStream("lorem.txt");
InputStream fis = new FileInputStream("lorem.txt");
//InputStreamReader isr = new InputStreamReader(fis);
Reader isr = new InputStreamReader(fis);
// Aqui não por causa da br.readLine();
BufferedReader br = new BufferedReader(isr);
```
</details>


## Escrita

<details><summary> Boiler para escrita é semelhante </summary>

```java
OutputStream fos = new FileOutputStream("lorem2.txt");
Writer osw = new OutputStreamWriter(fos);
BufferedWriter bw = new BufferedWriter(osw);

bw.write("asjkdfasdço asdifja sodfijaosidgjaoisdjgoiaj");
// 2 newline = 1 newline
bw.newLine();
bw.newLine();
bw.write("lajksdfasdojiasdgio aoinavsdnasdion asodifjaodf");

bw.close();
```
</details>


<details><summary> Boiler para cópia </summary>

```java
FileInputStream fis = new FileInputStream("lorem-copia.txt");
InputStreamReader isr = new InputStreamReader(fis);
BufferedReader br = new BufferedReader(isr);
String linha = br.readLine();

OutputStream fos = new FileOutputStream("lorem-copia2.txt");
Writer osw = new OutputStreamWriter(fos);
BufferedWriter bw = new BufferedWriter(osw);

while (linha != null) {
    bw.write(linha);
    bw.newLine();
    linha = br.readLine();
}

br.close();
bw.close();
```
</details>

<details> <summary>Boiler para copia e cola no console.
</summary>

```java
FileInputStream fis = System.out;
//InputStreamReader isr = new InputStreamReader(fis);
//BufferedReader br = new BufferedReader(isr);
//String linha = br.readLine();

OutputStream fos = System.in; //new FileOutputStream("lorem-copia2.txt");
//Writer osw = new OutputStreamWriter(fos);
//BufferedWriter bw = new BufferedWriter(osw);

while (linha != null && !linha.isEmpty()) {
    //bw.write(linha);
    //bw.newLine();
    bw.flush();
    //linha = br.readLine();
}

br.close();
bw.close();
```

</details>


## FileWriter e PrintStream

<details><summary>Boiler com FileWriter </summary>

```java
BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

bw.write("teste teste");
bw.newLine();
bw.newLine();
bw.write("out out out");

bw.close();
```
</details>

<details><summary>FileWriter é um</summary>
Writer e não um OutputStream
</details>

<details><summary>A classe deve ter o mesmo nome do arquivo se...</summary>
caso ela seja "public class" e não apenas "class"</details>

<details><summary>PrintStream </summary>
Mais antigo que os Reads e os Writers

```java
PrintStream ps = new PrintStream(new File("lorem2.txt"));
ps.println("teste teste");
ps.println();
ps.println("out out out");
ps.close();
```
</details>

<details><summary> PrintWriter </summary>
Alternativa pra não confundir qual usar

```java
PrintWriter ps = new PrintWriter"lorem2.txt");
ps.println("teste teste");
ps.println();
ps.println("out out out");
ps.close();
```
</details>

<details><summary> Pode ser usado métodos para melhorar a compatibilidade entre sistemas nas newlines </summary>

```java
FileWriter fw = new FileWriter("arquivo.txt");

fw.write("Lorem ipsum dolor sit amet ...");
//fw.write("\n");
fw.write(System.lineSeparator();
// ou trocar pelo PrintWriter com o .println();

fw.write("tempor incididunt ut labore ...");

fw.close();
```
</details>

<details><summary>Medir tempo de execução</summary>

```java
long ini = System.currentTimeMillis();

BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
bw.close();

long fim = System.currentTimeMillis();
System.out.println("Passaram " + (fim - ini) + " milissegundos");

```
</details>


## Scanner 
<details><summary>Read from file using Scanner
</summary>

```java
Scanner sc = new Scanner(new File("contas.csv"));
while (sc.hasNextLine()) System.out.println(sc.nextLine());
sc.close();
```
</details>


<br><br>

# Novidades Java 8

<details>
<summary>
Qual a interface que o novo método forEach recebe como parâmetro?</summary>
Comsumer que possui um único método chamado accept
</details>


<details><summary>O que são default methods?</summary>
São métodos que surgem com o java 8. Antes não era possível adicionar métodos com corpo na interface (chamados métodos concretos).

```java
void myMethod(); //método sem corpo, ou absrtrato
```
Default métodos tem corpo e são aplicados automaticamente. Sem quebrar.
</details>

<details><summary>Comparator factory</summary>
É uma expressão que gera um comparator.

```java
palavras.sort(Comparator.comparing(myString -> myString.length()));
```
