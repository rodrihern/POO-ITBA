

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

Es inmutable, osea que los metodos siepre devuelven una nueva instancia

usar StringBuilder para concatenaciones usando .append() <b>especialmente en ciclos</b>

"este es un string en una dimension"

""" </br>
este es un string</br>
en 2 dimensiones</br>
"""


## Manejo de errores
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





# uml
herencia (es-un) <|--

composicion (tiene-un) *--

{abstract} para poner un metodo que las clases hijas tienen que implementar

