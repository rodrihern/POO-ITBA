# Ruby

@@ variables de clase

@ valiabres de instancia, todas son privadas

def para los metodos

intialize es el constructior

snake case para las variables

pueden definirse secciones privadas

los protected hace que otra instancia de mi mismo tipo pueda verlo

visibilidad

|           | clase externa | hijo | otro objeto de mi misma clase |
|-----------|---------------|------|-------------------------------|
| private   | NO            | SI   | NO                            |
| protected | NO            | SI   | SI                            |

to_s : es el toString 

se usa "para texto con formato #{num}" 'para texto plano'

hay un metodo inspect que se imprime cuando uno debuggea con p

raise es para throwear excepciones

para hacer una clase abstracta lo hacemos artificialmente tirando una excepcion en 
el constructor

super llama al mismo metodo en el que esta pero del padre

aca se sobreescribe el ==

los errores se pueden recuperar onda un try-catch que aca se llama begin-rescue
las excepciones son cosas que no se espera que el programa se recupere
(exactamente al reves de java)

los modulos son como una libreria o una interfaz con metodos default