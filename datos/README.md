
# Base de datos de la cafetería

Esta carpeta almacena la base de datos SQLite utilizada
por el sistema de descuentos de la cafetería.

Archivo de base de datos: cafeteria.db

La aplicación utiliza JDBC para establecer la conexión
con SQLite.

Cuando se ejecuta el programa desde la carpeta principal
del proyecto, SQLite crea automáticamente cafeteria.db
si el archivo todavía no existe.

La conexión utiliza try-with-resources y contempla
las excepciones SQLException y ClassNotFoundException.
