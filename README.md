<h1 align="center"> Challenge Conversor de Monedas </h1>

<h2> Descripcion del proyecto </h2>
Se crea una API con Spring Boot con rutas implementadas siguiendo las mejores prácticas del modelo REST;
Validaciones realizadas según las reglas de negocio;
Implementación de una base de datos relacional para la persistencia de la información;
Servicio de autenticación/autorización para restringir el acceso a la información.

<h2> Estado del proyecto </h2>
Aún se pueden implementar la lógica de todas las tablas sugeridas en el reto ONE. Este proyecto
cuenta con los registros necesarios para las reglas de negocio excepto las opcionales.

<h2> Funcionalidad </h2>: 
Nuestra API se centra específicamente en los tópicos, y debe permitir a los usuarios:
Crear un nuevo tópico;
Mostrar todos los tópicos creados;
Mostrar un tópico específico;
Actualizar un tópico;
Eliminar un tópico.

Una vez que se creó la lógica para Crear, Consultar, Actualizar y Eliminar tópicos, esa información se actualizaba en la tabla del mismo nombre con la información id, título, mensaje, fecha de creación, status (estado del tópico), autor, curso.

Para el registro de un nuevo tópico

La API cuenta con un endpoint (punto final) para el registro de tópicos, y acepta solicitudes del tipo POST para la URI /tópicos.
Los datos del tópico (título, mensaje, autor y curso) son enviados en el cuerpo de la solicitud, en formato JSON.
Se usó la anotación @RequestBody para recibir correctamente los datos del cuerpo de la solicitud.
Se usó el método save del JpaRepository para realizar la persistencia de los datos del tópico creado.
Para la validación de los datos, se utilizó la anotación Java integrada en Spring @Valid.
La API no debe permitir el registro de tópicos duplicados (con el mismo título y mensaje).

Para el listado de tópicos

La API debe cuenta con un punto final para el listado de todos los tópicos, y debe aceptar solicitudes del tipo GET para la URI /tópicos.
Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso) son devueltos en el cuerpo de la respuesta, en formato JSON.
Al tratar con el CRUD se trabaja con JpaRepository asociado al tópico, especialmente en la lista de datos de la base de datos se utiliza el método findAll.
Se implementó el listado de resultados con paginación utilizando la anotación @PageableDefault

Para detallar los tópicos

La API cuenta con un endpoint (punto final) para el listado de todos los tópicos, y acepta solicitudes del tipo GET para la URI /tópicos/{id}.
Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso) son  devueltos en el cuerpo de la respuesta, en formato JSON.
Se usó la anotación @‌PathVariable para recibir el campo de ID de la solicitud GET.
También se verifica si el campo ID se ingresó correctamente, de lo contrario arroja una respuesta que inidica que el id no existe.

Para actualizar los tópicos

La API cuenta con un endpoint (punto final) para la actualización de los datos de un determinado tópico, y acepta solicitudes del tipo PUT para la URI /tópicos/{id}.
Para verificar si el tópico existe en la base de datos para realizar su actualización se usó el método isPresent() de la clase Java llamada Optional.

Para eliminar un tópico

La API cuenta con un endpoint para la eliminación de un tópico específico, el cual acepta solicitudes del tipo DELETE para la URI /tópicos/{id}.
Al tratarse de la eliminación de un elemento específico de la base de datos, se usó el método deleteById del JpaRepository.



Al robustecer el programa al brindar seguridad y un token, se genero una tabla de registro de usuarios para poder autenticar y autorizar 
sus peticiones, todas las fases fueron verificadas con Insomnia para facilitar la creación, el envío y la depuración de solicitudes HTTP y API.


<em> Acceso al proyecto </em>: 
Una vez instaladas todas las herramientas de desarrollo, se deben configurar los accesos a la base de datos, un consejo al usar un sistema MAC es verificar el nombre del usuario en la base desde la instalacion, generalmente es el nombre del usuario de sesión que está abierto y no postgres.
Al crear las tablas verifica que se inicialicen todos los valores por default debido a que una de las reglas es que ningún campo puede estar nulo, algo que se puede implementar de no ser así, es que en una interfaz se coloquen las condiciones y aplicarlas en la clase que extiende a CommandLineRunner para que inicialice la aplicación con lo ya establecido.



<em> Tecnologías utilizadas </em>: 


