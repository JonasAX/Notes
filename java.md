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
    List<String> argumentos = Arrays.asList(args);
  }
```
</details>

