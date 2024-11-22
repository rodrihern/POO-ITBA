# Ruby

## Variables

Es **no** tipado

@@ variables de clase

@ valiabres de instancia, todas son privadas


## Visibilidad


|           | clase externa | hijo | otro objeto de mi misma clase |
|-----------|---------------|------|-------------------------------|
| private   | NO            | SI   | NO                            |
| protected | NO            | SI   | SI                            |


## Metodos

### Instanciar una clase

```ruby
myObject = MyClass.new(parameter1, parameter2)
```

### to_s

````ruby
def to_s
  return "hoy es #{@day} / #{@month} / #{year}"
end
````

se usa "para texto con formato #{num}" 'para texto plano'

### Equivalencia ==, eql? hash

````ruby
def ==(other)
  return false unless other.is_a?(MyClassDay)
  [@day, @month, @year] == [other.day, other.month, other.year]
end
alias_method :eql?, :==

def hash
  [@day, @month, @year].hash
end

attr_reader :day, :month, :year
````

### Orden natural <=>
```ruby
include Comparable
def <=>(other)
  return nil unless other.is_a?(MyClassDay)
  [@day, @month, @year] <=> [other.day, other.month, other.year]
end
```

## Herencia

```ruby
class MyClass < MyFather
  def initialize
    super
  end
end
```

el metodo super llama al mismo metodo que se esta sobreescribiendo pero de la clase padre

## Como hacer clases abstractas

para hacer una clase abstracta lo hacemos artificialmente tirando una excepcion en 
el constructor

```ruby
def initialize
  raise 'esta es una clase abstracta pa'
end
```

## Excepciones

```ruby
def foo(myNum)
  raise 'myNum must be numeric' unless myNum.is_a?(Numeric)
end
```

## Array

Lista de elementos que se puede usar como stack, admite repetidos

```ruby
myArr = []
myArr << 1
myArr.push(2)
myArr << 1
puts myArr # [1, 2, 1]
myArr.pop
puts myArr # [1, 2]
puts myArr[1] # 2
```

## Set

No tiene orden, no admite repetidos

## SortedSet

como un set pero con orden natural

### Hash

es un mapa y se desreferencia usando la key como si fuera un indice de un array

```ruby
myMap = Hash.new { 0 } # para ponerle un valor default
puts myMap['una key cualquiera'] # 0
myMap = {} # para hacer un mapa vacio
```

algunos metodos:

* .keys
* .values
* key?(key)
* value?(value)

## Las funciones basicas

```ruby

# if de una linea
raise 'es nulo pa' if element.nil?

# if elsif y else
if num == 0
  puts 'es cero'
elsif num == 1
  puts 'es 1'
else
  'no es ni cero ni uno'
end

# while
while count <= 5 
  puts "El contador es #{count}"
  contador += 1  
end

# entre parentesis va el valor inicial del acumulador 
# (si no tiene toma como valor inicial el primer elemento)
# retorna la + de todos los elementos de la coleccion
myCollection.reduce(0) { |accum, elem| accum + elem } 
# retorna "hola" concatenado con cada string de la coleccion
myCollection.reduce("hola") { |accum, elem| accum + elem }

# map devuelve una nueva coleccion aplicandole una funcion a cada elemento
# en este caso devuelve una coleccion con cada elemento multiplicado por 2
myCollection.map { |elem| elem * 2 }
# con map! hacemos que modifique la coleccion original

# el mas parecido a un for-each
# imprime todos los elementos de la coleccion
myCollection.each {|elem| puts elem }




```