## Anotaciones de ajustes

1. Tarjeta: S0 - Pame
2. Fecha: 23-04-2026
3. Cambio realizado: se creo el package `main` y la clase `Principal` base (sin logica) para completar la estructura inicial.

1. Tarjeta: S1.1 - Kim
2. Fecha: 23-04-2026
3. Cambio realizado: se ajusto la clase Conexion con constructor privado, manejo de SQLException y validacion de conexion nula para evitar errores posteriores.

1. Tarjeta: S1.2 - Pame
2. Fecha: 23-04-2026
3. Cambios realizados:
	1. En Categoria se modifico el constructor con parametro para que use setNombre(nombre) y aplique validacion tambien al crear el objeto.
	2. En Categoria se agrego validacion de longitud maxima (45) y normalizacion con trim() en setNombre para alinear con varchar(45) de la base.
	3. En Producto se ajusto el constructor con parametros para que use los setters y aplique las validaciones existentes al crear el objeto.
	4. En Producto se agrego validacion de longitud y normalizacion para campos string (codigo maximo 20 y nombre maximo 45) para alinear con el script SQL.
	5. En Producto se agrego validacion de precio para alinear con decimal(10,2): maximo 2 decimales y valor maximo 99999999.99.