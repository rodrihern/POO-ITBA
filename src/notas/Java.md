

# java

[Cursito de freeCodeCamp](https://www.youtube.com/watch?v=A74TOX803D0)

## Metodos comunes a todos los objetos

### equals()

[video: equals() vs ==](https://www.youtube.com/watch?v=AoUVdLWLFQw)

Es un metodo de la clase Object que debo sobreescribir si quiero que mi clase tenga comportamiento de equivalencia

Ejemplo
```java
@Override
public boolean equals(Object obj) {
    return obj instanceof Date date &&
    year == date.year &&
    month == date.month &&
    day == date.day;
}
```



### hashCode()
siempre que se implemente **equals()**
se debe implementar **hashCode()**

en *hashCode()* se deben poner las mismas propiedades 
que se comparan en equals

```java
@Override
public int hashCode() {
    return Objects.hash( /* aca van las props */ );
}
```

### toString()

Ejemplo de toString()
```java
@Override
public String toString() {
    return "%d/%d/%d".formatted(day, month, year);
}
```

## for-each
``` java
for(int x : myIntArray) {
    // ...
}
```
la variable x es read-only

## Argumentos variables
``` java
int foo(int... values) {
    // ...
}
```

## Arrays

En java son medio cualquier cosa porque no son ni primitivos ni objetos.

Formas de crear un array

````java
int[] intArray = {1, 2, 3, 4};
int[] intArray2 = new int[3]; // [ 0 , 0 , 0 ]
String[] words = new String[]{"hola", "que", "tal"}; 
Object[] objArray = new Object[3]; // [null, null, null]
````

Ejemplo de resize

```java
private void resize() {
    myArray = Arrays.copyOf(myArray, myArray.length + BLOCK);
}
```

Como remover un elemento en la posicion i del array
```` java
System.arraycopy(myArr, i + 1, myArr, i, dim - 1 - i);
// (src, srcIdx, dest, destIdx, size)
// el size es de lo que estoy pegando
````

## Strings

[video: Why strings are inmutable](https://www.youtube.com/watch?v=Bj9Mx_Lx3q4&list=PLkeaG1zpPTHhXOfy-mFbdqd1Zz4GnjcpC&index=34)

Son inmutables, osea que los metodos siepre devuelven una nueva instancia

Usar **StringBuilder** para concatenaciones usando .append() *especialmente en **ciclos***

```` java
StringBuilder str = new StringBuilder();
String[] words = new String[]{"hola", "que", "tal"};
for(String word : words) {
    str.append(word).append(" ");
}
System.out.println(str.toString()); // hola que tal 

````

## Manejo de errores

[video: Checked vs Unchecked](https://www.youtube.com/watch?v=bCPClyGsVhc)

[video: Error handling](https://www.youtube.com/watch?v=1XAfapkBQjk)

Cuando hay un error se genera un objeto Exception

Hay de 2 tipos:
* Checked exception 
* Unchecked exception 

Uno puede capturar estos errores y evitar que el programa aborte

``` java
try {
    method();
} catch (Exception e) {
    // ...
}
```

| Checked                                                                   | Unchecked                         |
|---------------------------------------------------------------------------|-----------------------------------|
| Debe estar dentro de un bloque try-catch o declarar que le haces un throw | No hace falta hacer nada especial |
| Extiende a Exception                                                      | Extiende a RunTimeException       |

Para crear tu propia exception

````java
public class myException extends RuntimeException {
    private static final String MESSAGE = "Pasaron cosas";
    public myException() {
        super(MESSAGE);
    }
}
````



## Enums

[video: Enums](https://www.youtube.com/watch?v=wq9SJb8VeyM)

Como toda clase, puede tener metodos y atributos

Son constantes que podemos tratar como objetos

Algunos metodos de clase:
* ordinal
* valueOf
* values

Se busca que los enum tengan el mayor comportamiento posible

Ejemplo:

```java
public enum Operation {
    ADD("+") {
        @Override
        public double apply(double op1, double op2) {
            return op1 + op2;
        }
    },
    SUBTRACT("-") { /* ... */ },
    MULTIPLY("*") { /* ... */ },
    DIVIDE("/") { /* ... */ };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double op1, double op2);
}
```

Ejemplo de como usarlo

```` java
Operation myOperation = Operation.ADD;
System.out.println(myOperation.apply(2, 3)); // 5
for(Operation op : Operation.values()) {
    System.out.println(op.apply(4, 2)); // 6  2  8  2
}
````

## Interfaces

En general los metodos de las interfaces son *abstractos* y *publicos* salvo que se los declare *default* y se provea una implementacion

Hay herencia multiple de interfaces ya que no tienen estado interno

Para que una clase implemente una interfaz:

```java
public class myClass implements myInterface {
    // ...
}
```


## Clase abstracta vs interfaz
[video: Abstract classes](https://www.youtube.com/watch?v=HvPlEJ3LHgE)

| Clase abstracta                                                        | interfaz                                                                                                              |
|------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| Tiene que ver con el comportamiento principal del objeto y la herencia | Comportamiento que van a usar varias clases que no tienen nada que ver. Tiene que ver con un comportamiento adicional |
| Puede tener atributos                                                  | **No** tiene atributos                                                                                                |


## Tipos genericos

[video: Generics](https://youtu.be/K1iu1kXkVoA?si=li8nvRSyFkGMfsCU)

* Permiten la parametrización de tipos de datos (clases e interfaces)
* Permiten escribir código reusable por objetos de distinto tipo

Como declarar una interfaz con generics
```java
public interface Comparable<T> {
   int compareTo(T other);
}
```

Como implementarla en una clase
```java
public class Date implements Comparable<? super Date> {
    // ... 
    @Override
    public int compareTo(Date d) {
        // ... 
    }
}
```

Como crear un array de tipos genericos
``` java
@SuppressWarnings("unchecked")
T[] myArray = (T[]) new Object[INITIAL_DIM];
```


## Funcional interfaces

Es una interfaz que tiene un solo metodo abstracto, (puede tener mas defaults pero uno solo abstracto)

Ejemplo

```java
@FunctionalInterface
public interface Operation {
    double apply(double n1, double n2);
}
```

### Comparable

Una clase que implemente comparable tiene un metodo de instancia *compareTo(other)* que devuelve:
* **0** si son iguales
* **Negativo** si es menor que el otro
* **Positivo** si es mayor que el otro

Ejemplo:

``` java
public class myClass<T> implements Comparable<T> {
    ...
    @Override
    public int compareTo(T other) {
        ...
    }
}
```

### Comparator

Interfaz funcional que tiene la funcion **compare()**

Ejemplo de implementacion:

```java
public class myComparator implements Comparator<T> {
    // ...
    @Override
    public int compare(T o1, T o2) {
        // ...
    }
    
}
```

Un metodo default util que se puede usar de Comparator es el siguiente:

``` java
Arrays.sort(myArray, Comparator.reverseOrder());
```

donde myArray es un array que implementa Comparable

### Function

Interfaz funcional que tiene el metodo **apply()**

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
    // ...
}
```

### Predicate

Interfaz funcional que tiene el metodo **test()**

```java
@FunctionalInterface
public interface Predicate<T, R> {
    boolean test(T t);
    // ...
}
```


### Lambda expressions

[video: lambda expressions](https://www.youtube.com/watch?v=tj5sLSFjVj4)

Son como las arrow functions de javascript

``` java
(x, y) -> x + y

// es una funcion anonima que devuelve la suma de los dos argumentos que recibe
```

Sirve para pasar como parametro una interfaz funcional sin la necesidad de declararla


### Iterable e iterator

Una clase iterable tiene un metodo **iterator()** que devuelve un iterador de dicha clase

Un iterador tiene los metodos **next()** y **hasNext()**

Una coleccion que implementa iterable permite hacerle un for-each

Ejemplo:

````java
import java.util.Iterator;
import java.util.NoSuchElementException;

public class myIterableClass<T> implements Iterable<T> {
    // ...
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                // ...
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                // ...
            }
        };
    }
}
````

## Collections

Collections es una interfaz que tiene los siquientes metodos:



