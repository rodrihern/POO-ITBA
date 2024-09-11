

# java

[Cursito de freeCodeCamp](https://www.youtube.com/watch?v=A74TOX803D0)

## Metodos comunes a todos los objetos

### equals()

[video: equals() vs ==](https://www.youtube.com/watch?v=AoUVdLWLFQw)

para mi class tengo que sobreescribir el metodo .equals() para usarlo </br>

.equals(Object obj) es de la clase Object

Ejemplo
``` java
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

en hashCode() se deben poner las mismas propiedades 
que se comparan en equals

``` java
@Override
public int hashCode() {
    return Objects.hash( /*aca van las props*/ );
}
```

### toString()

Ejemplo de toString()
``` java
@Override
public String toString() {
    return "%d/%d/%d".formatted(day, month, year);
}
```

## for-each
``` java
for(int x : v1) {
    ...
}
```
donde x es cada elemento del array v1 (parecido al for de python) </br>
la variable x es read-only

## Argumentos variables
``` java
int foo(int... values) {

}
```

## Strings

[video: Why strings are inmutable](https://www.youtube.com/watch?v=Bj9Mx_Lx3q4&list=PLkeaG1zpPTHhXOfy-mFbdqd1Zz4GnjcpC&index=34)

Es inmutable, osea que los metodos siepre devuelven una nueva instancia

usar StringBuilder para concatenaciones usando .append() <b>especialmente en ciclos</b>

"este es un string en una dimension"

""" </br>
este es un string</br>
en 2 dimensiones</br>
"""

## Arrays

En java son medio cualquier cosa porque no son ni primitivos ni objetos.

ejemplo de resize

``` java
private void resize() {
    myArray = Arrays.copyOf(myArray, myArray.length + BLOCK);
}
```


## Manejo de errores

[video: Checked vs Unchecked](https://www.youtube.com/watch?v=bCPClyGsVhc)

[video: Error handling](https://www.youtube.com/watch?v=1XAfapkBQjk)

Cuando hay un error se genera un objeto Exception

Hay de 2 tipos:
* checked exception (extienden a exception)
* unchecked exception (extienden a RunTimeException o Error)

Uno puede capturar estos errores y evitar que el programa aborte

``` java
try {
    method();
} catch (DataAccessException e) {
     ...
}
```

Uno puede crear sus propias excepciones extendiendo a Exception o RuntimeException

siempre debe invocarse un metodo que lance <b>checked</b> exceptions
dentro de un bloque try-catch. Si en un programa de prueba aparece 
un metodo que lanza excepcion fuera de un bloque try-catch,
esa es una **unchecked** exception.




## Enums

[video: Enums](https://www.youtube.com/watch?v=wq9SJb8VeyM)

Como toda clase, puede tener metodos y atributos

Son constantes que podemos tratar como objetos

Ejemplo:

``` java
public enum Rating {
  SUCCESS("Success", 10),
  GOOD("Good", 7),
  REGULAR("Regular", 5),
  BAD("Bad", 2);

  private final String description;
  private final int value;

  Rating(String description, int value){
      this.description = description;
      this.value = value;
  }

  @Override
  public String toString() {
      return description;
  }

  public int intValue() {
      return value;
  }
}
```

En este caso crea una instancia para success, una sola para good, etc,<br/>
en total se harian cuatro instancias.

Nadie de afuera puede llamar al constructor mas que la jvm

Algunos metodos de clase:
* ordinal
* valueOf
* values

Se pueden dar metodos abstractos a cada una de las instancias

se busca que los enum tengan el mayor comportamiento posible

Ejemplo:
``` java
public enum Operation {
   ADD("+") {
       @Override
       public double apply(double op1, double op2) {
           return op1 + op2;
       }
   },
   SUBTRACT("-") { ... }, MULTIPLY("*") { ... }, DIVIDE("/") { ... };

   private final String symbol;

   Operation(String symbol) { this.symbol = symbol; }

   public abstract double apply(double op1, double op2);

   public static double evaluate(String op1, String op2, String op) {
       double n1 = Double.parseDouble(op1); 
       double n2 = Double.parseDouble(op2);
       for (Operation instance : values()) {
           if (instance.symbol.equals(op)) {
               return instance.apply(n1, n2);
           }
       }
       throw new IllegalArgumentException();
   }

```



## Interfaces

Los metodos de las interfaces son todos abstractos y publicos

Hay herencia multiple de interfaces ya que no tienen estado interno

Para que una clase implemente una interfaz:
``` java
public class Date implements ObjectToCsv {
    ...
}
```


## Clase abstracta vs interfaz
[video: Abstract classes](https://www.youtube.com/watch?v=HvPlEJ3LHgE)

| Clase abstracta                                          | interfaz                                                                                                              |
|----------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| Tiene que ver con el comportamiento principal del objeto | Comportamiento que van a usar varias clases que no tienen nada que ver. Tiene que ver con un comportamiento adicional |



## Tipos genericos

[video: Generics](https://youtu.be/K1iu1kXkVoA?si=li8nvRSyFkGMfsCU)

* Permiten la parametrización de tipos de datos (clases e interfaces)
* Permiten escribir código reusable por objetos de distinto tipo

Como declarar una interfaz con generics
``` java
public interface Comparable<T> {
   int compareTo(T other);
}
```
Como implementarla en una clase
``` java
public class Date implements Comparable<? super Date> {
    ...
    @Override
    public int compareTo(Date d) {
        ...
    }
}
```


## Funcional interfaces

Es una interfaz que tiene un solo metodo abstracto, (puede tener mas defaults pero uno solo abstracto)

Ejemplo

``` java
@FunctionalInterface
public interface Operation {
    double apply(double n1, double n2);
}
```

### Comparable

Una clase que implemente comparable tiene que definir un compareTo()

Ejemplo:

``` java
public class Date implements Comparable<Date> {
    ...
    @Override
    public int compareTo(Date otherDate) {
        ...
    }
}
```

### Comparator

Es una interfaz funcional que tiene la funcion compare

Ejemplo de implementacion:

``` java
public class DateComparator implements Comparator<Date> {
    ...
    @Override
    public int compare(Date d1, Date d2) {
        ...
    }
    
}
```

Un metodo default util que se puede usar de Comparator es el siguiente:

``` java
Arrays.sort(myArray, Comparator.reverseOrder());
```

donde myArray es un array que implementa Comparable

### Function

``` java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
	...
}
```

### Predicate

``` java
@FunctionalInterface
public interface Predicate<T, R> {
    boolean test(T t);
	...
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




