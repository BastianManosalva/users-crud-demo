# demo-registro-usuarios

Demo de aplicación de gestión de usuarios.

Utiliza las siguientes tecnologías.

- Springboot (v2.7.18).
- Java (jdk-11.0.0.2).
- Maven como gestor de dependencias y para generar build (v3.9.10).
- Persistencia JPA con Hibernate.
- Banco de datos persistente con H2.
- Swagger.



# Pasos Previos
Previo a la descarga del servicio, es necesario contar con las siguientes herramientas y configuraciones:

- Visual Studio Code (Editor utilizado para el desarrollo).
- Postman (Para probar ejecuciones sobre los endpoints).
- Java version 11.0.0.2 (con variable JAVA_HOME configurada).
- Maven version 3.9.10 (con variable de entorno configurada).

Dado que el desarrollo se llevo a cabo en Visual Code, también es necesario contar con las siguientes extensiones:

![image](https://user-images.githubusercontent.com/32346999/187487347-566da33e-8c57-4474-bd70-31423ef3bbf0.png)




# Descarga e Inicio de la Aplicación

El primer paso consta de clonar el repositorio en un directorio local, para posteriormente abrir el proyecto en vscode, abrir una terminal y ejecutar el siguiente comando: 

**mvn spring-boot:run**

Validamos el correcto inicio de la aplicación en la terminal:

![image](https://github.com/user-attachments/assets/9165cbfc-1322-4159-995a-1d6df5f9fc9a)


**IMPORTANTE:** Dentro de la carpeta del proyecto, en la carpeta "complementos" se encuentra la tanto la colección de Postman como los diagramas de la solución.

![image](https://github.com/user-attachments/assets/89a21328-120c-4f3b-9171-ab1e49ba13b5)




# Ejecución de Endpoints

## Ingreso de Usuario

Para la validación de formato del email y la password, se especificaron las expresiones regulares en el archivo application.yaml de tal modo que sean configurables, en el caso de la contraseña, esta debe contar con las siguientes condiciones:
- Minimo una letra minuscula.
- Minimo una letra mayuscula.
- Minimo un numero.
- Minimo un caracter especial.
- Minimo 5 de largo.

![image](https://user-images.githubusercontent.com/32346999/187508776-a71fd382-e32c-448a-829a-207cf695f425.png)

Procedemos a porbar el enpoint "Ingresar Usuario", para esto hacemos unas primeras pruebas tanto con un nombre, email y password invalidos.

![image](https://github.com/user-attachments/assets/e67110d7-c361-48c0-bc05-fba957c81b53)

![image](https://github.com/user-attachments/assets/08ecfa1f-d63b-4e07-92d6-4b34a9cfda5d)

![image](https://github.com/user-attachments/assets/f86daf18-ea8a-4603-bddc-848932c644cc)


Volvemos a intentar el registro, esta vez con un nombre, email y password validos. Visualizamos el correcto registro del usuario con codigo HTTP 201 CREATED.

**IMPORTANTE:** Considerar el id de usuario y token asociado.

![image](https://github.com/user-attachments/assets/d92235dd-c6a7-4eeb-aea8-213c7395bf03)

Podemos intentar nuevamente el registro para detonar la excepcion de que email ya se encuentra registrado.

![image](https://github.com/user-attachments/assets/dfb173db-d949-4419-b37b-f3f3b4d437cf)


## Buscar Usuario por ID

Mediante el endpoint "Buscar Usuario" de la colección postman, podemos buscar el usuario recién creado. Para ello copiamos el ID entregado en el registro y lo cargamos como un PATH Variable en la url.

Prueba con token indalido:

![image](https://github.com/user-attachments/assets/a0803665-05af-4dba-81d0-b020b35a1018)


El servicio responde con la información del usuario:

![image](https://github.com/user-attachments/assets/f5594587-d876-4469-a2b3-8dbd771af7c2)


## Modificar Usuario

Con el endpoimt "Modificar Usuario", intentamos modificar usuario que no existe y otro usuario NO asociado a nuestro token.

![image](https://github.com/user-attachments/assets/dab236eb-25a5-44be-9120-a398fa2779f6)

![image](https://github.com/user-attachments/assets/389833b7-71a0-45ee-b37f-697d36cf803a)

Prueba modificacion cargando dos telefonos duplicados.

![image](https://github.com/user-attachments/assets/518a4381-3a0e-45d9-9024-dda7f6e0fea6)

Realizamos la modificacion en el usuario recien ingresado, identificando el ID en la url.

![image](https://github.com/user-attachments/assets/74a30f28-8697-47fd-9208-0f4a0e287d0f)


## Cambiar Estado Usuario

Se intenta activar un usuario ya activo: 

![image](https://github.com/user-attachments/assets/e6ed2bac-4f74-4c2b-8b28-2297ed0c2efd)

Se cambia estado del usuario:

![image](https://github.com/user-attachments/assets/d1c2e166-0c8e-40a6-9dbc-95f71fd130df)


## Eliminar Usuario

Se elimina usuario creado

![image](https://github.com/user-attachments/assets/0f186254-147c-4802-8273-d5dd72b2fdab)


## Login

Intento de login con usuario inactivo:

![image](https://github.com/user-attachments/assets/8d07ca3e-83ff-4a8e-b604-47a37dd722e5)


Login con usuario valido:

![image](https://github.com/user-attachments/assets/4cd973ec-3f57-416b-b4f5-482b6d079da7)


## Listar Usuarios

Se habilitó endpoint utilizatio para listar todos los usuarios creados (ejecutar con token jwt valido):

![image](https://github.com/user-attachments/assets/56e326dc-fcc8-450c-a7da-e5e8496c1a90)




# Acceso a consola H2.

Para acceder a la consola de H2, cargamos la siguiente ruta en el navegado http://localhost:8001/h2-console/login.jsp e introducimos los siguientes datos de conexion:

![image](https://github.com/user-attachments/assets/4f9e5157-87da-4661-99d1-31d6e1f3be8e)

Podemos visualizar los usuarios creados:

![image](https://github.com/user-attachments/assets/e4345139-9bf8-4fb0-b289-34af75fffd24)




# Swagger

Para visualizar el swagger el servicio, accederemos a la interfaz cargando el numero de puerto en un navegador.

En este caso la url sera: http://localhost:8001/swagger-ui/index.html

![image](https://github.com/user-attachments/assets/d0df5659-7baf-41ef-9736-1e159a68087f)

