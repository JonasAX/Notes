// Atalho para printar
    sout

// O que o pós-decremento faz?
    int num = 1;
    int result = 4 - num--; // seria 4, mas é 3.
                            // modificado depois

// Convenção de: classe, método, constante, elementos de controle de fluxo
    MinhaClasse
    meuMetodo()
    MINHA_CONSTANTE
    minhaVariavel
    if (condicao) {}; //usa-se espaço

// Text blocks?
    """
    Meu texto
    for ma ta do
    """ + minhaVariavel;
    // válido apenas na versão 15

// Como comparar String
    minhaVariavel.equals(outraString)
    // se eu fosse usar "==" compararia se são mesmo objeto na memória.
    minhaVariavel.equalsIgnorCase(outraString)

// Formatar String
    System.out.println(String.format("Meu nome é %s; %d anos; e gastei %.2f reais", nome, idade, valor));

// Casting
    int hello = (int) (media /2);
    // não necessário de int >> double

// Declarar char
    char lalala = 'c';

// alternativa ao if else
    switch (expression) {
        case valor1:

            break;
        case valor 2:

            break;
        default:

            break;
    }

// receber um input do teclado


    import java.util.Scanner;
    //
    Scanner leitura = new Scanner(System.in);
    String filme = leitura.nextLine();
    int data = leitura.nextInt();

