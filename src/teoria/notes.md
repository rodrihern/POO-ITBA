

# Paradigma
Polimorfismo: puedo tener distintos metodos con el mismo nombre y diferentes implementaciones

Herencia (es-un)

Composicion (tiene-un)

tell dont ask

tratamos de evitar usar excesivos if (eso es muy imperativo)

cuando llamo a un constructor tiene que quedar "ready to work"


# java

## Metodos comunes a todos los objetos

### equals()

[video: equals() vs ==](https://www.youtube.com/watch?v=AoUVdLWLFQw)

para mi class tengo que sobreescribir el metodo .equals() para usarlo </br>

.equals(Object obj) es de la clase Object

Ejemplo
```
@Override
public boolean equals(Object obj) {
    return obj instanceof Date date &&
    year == date.year &&
    month == date.month &&
    day == date.day;
}
```



### hashCode()
siempre que se implemente <b>equals()</b>
se debe implementar <b>hashCode()</b>

en hashCode() se deben poner las mismas propiedades 
que se comparan en equals

```
@Override
public int hashCode() {
    return Objects.hash( /*aca van las props*/ );
}
```

### toString()

Ejemplo de toString()
```
@Override
public String toString() {
    return "%d/%d/%d".formatted(day, month, year);
}
```

## for-each
```
for(int x : v1) {
    ...
}
```
donde x es cada elemento del array v1 (parecido al for de python) </br>
la variable x es read-only

## Argumentos variables
```
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


## Manejo de errores

[video: Checked vs Unchecked](https://www.youtube.com/watch?v=bCPClyGsVhc)

[video: Error handling](https://www.youtube.com/watch?v=1XAfapkBQjk)

Cuando hay un error se genera un objeto Exception

Hay de 2 tipos:
* checked exception (extienden a exception)
* unchecked exception (extienden a RunTimeException o Error)

Uno puede capturar estos errores y evitar que el programa aborte

```
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

```
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
+ ordinal
+ valueOf
+ values

Se pueden dar metodos abstractos a cada una de las instancias

Ejemplo:
```
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
```
public class Date implements ObjectToCsv {
    ...
}
```

Igual para hacer bien una interfaz se deben usar tipos de datos genericos


## Clase abstracta vs interfaz
[video: Abstract classes](https://www.youtube.com/watch?v=HvPlEJ3LHgE)

Clase abstracta | interfaz
---|---
Tiene que ver con el comportamiento principal del objeto|Comportamiento que van a usar varias clases que no tienen nada que ver. Tiene que ver con un comportamiento adicional



## Tipos genericos

[video: Generics](https://youtu.be/K1iu1kXkVoA?si=li8nvRSyFkGMfsCU)

+ Permiten la parametrización de tipos de datos (clases e interfaces)
+ Permiten escribir código reusable por objetos de distinto tipo

Como declarar una interfaz con generics
```
public interface Comparable<T> {
   int compareTo(T other);
}
```
Como implementarla en una clase
```
public class Date implements Comparable<Date> {
    ...
    @Override
    public int compareTo(Date d) {
        ...
    }
}
```

# uml

+ herencia (es-un) <|--
+ composicion (tiene-un) *--
+ {abstract} para poner un metodo que las clases hijas tienen que implementar

