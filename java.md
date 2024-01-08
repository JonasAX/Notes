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
