
# EA4 - Proyecto Integrador: Cafetería

## Descripción del proyecto

Aplicación desarrollada en Java que permite calcular
descuentos sobre los pedidos de una cafetería.

El proyecto integra programación orientada a objetos,
programación funcional, interfaces gráficas Swing,
conexión a bases de datos mediante JDBC y control
de versiones con GitHub.

## Objetivo

Desarrollar una aplicación en Java que gestione los
descuentos aplicables a los pedidos de una cafetería,
utilizando POO, expresiones lambda, interfaz gráfica
y conexión con SQLite.

## Tecnologías utilizadas

- Java
- Programación Orientada a Objetos
- Programación funcional (lambda)
- Java Swing
- JDBC
- SQLite
- Git y GitHub
- Visual Studio Code

## Arquitectura del proyecto

El proyecto se organiza en las siguientes carpetas:

- src/modelo: Producto, Bebida y Comida.
- src/servicios: reglas y cálculos de descuento.
- src/persistencia: conexión JDBC con SQLite.
- src/vista: interfaz gráfica Swing.
- src/Principal.java: punto de entrada del programa.
- lib: librería SQLite JDBC.
- datos: ubicación de la base de datos.
- evidencias: capturas de ejecución y diagrama UML.

## Funcionalidades

1. Representación de productos mediante herencia
   y polimorfismo.
2. Cálculo de descuentos utilizando una expresión
   lambda y una interfaz funcional.
3. Aplicación de un 15 % de descuento cuando
   el total del pedido supera $10.
4. Interfaz gráfica para ingresar el monto.
5. Visualización del descuento y total final.
6. Validación de montos incorrectos.
7. Comprobación de conexión con SQLite.
8. Manejo de excepciones y cierre automático
   de recursos con try-with-resources.

## Requisitos para ejecutar

- Java JDK instalado.
- Archivo sqlite-jdbc.jar en la carpeta lib.
- Carpeta datos existente.
- Ejecutar desde la raíz del proyecto.

## Compilación y ejecución en Windows

Abrir una terminal PowerShell desde la carpeta
principal del proyecto.

Compilar:

    javac -cp "lib/*" -d out src/modelo/*.java src/servicios/*.java src/persistencia/*.java src/vista/*.java src/Principal.java

Ejecutar:

    java -cp "out;lib/*" Principal

## Pruebas realizadas

Monto: $20
Descuento: $3
Total final: $17

Monto: $10
Descuento: $0
Total final: $10

Monto: $50
Descuento: $7.50
Total final: $42.50

También se realizaron pruebas con valores negativos
y entradas de texto no numéricas.

## Base de datos

El programa utiliza SQLite mediante JDBC.

Al iniciar, comprueba la conexión con la base de datos
datos/cafeteria.db mediante una consulta sencilla.

La aplicación muestra mensajes de conexión exitosa
o error en la interfaz gráfica.

## Evidencias

La carpeta evidencias incluye:

- Pruebas de lógica y descuentos.
- Verificación de conexión SQLite.
- Interfaz gráfica en funcionamiento.
- Diagrama de clases UML.

## Código fuente en CSV

El archivo codigo_fuente.csv contiene el código
fuente Java organizado por nombre, ruta y contenido.

Los archivos originales .java se encuentran en src.

## Repositorio

https://github.com/wendymos-sys/EA4_Proyecto_Integrador_Cafeteria

## Información académica

Institución Universitaria Digital de Antioquia

Asignatura: Programación Orientada a Objetos II

Docente: Leonardo Montes

Actividad: EA4 - Proyecto integrador

Año: 2026

