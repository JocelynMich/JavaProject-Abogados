# Sistema de Gestión de Citas para Abogados

## Tabla de Contenidos
- [Descripción](#-descripción)
- [Problema Identificado](#-problema-identificado)
- [Solución](#-solución)
- [Arquitectura](#-arquitectura)
- [Requerimientos](#-requerimientos)
- [Instalación](#-instalación)
- [Configuración](#-configuración)
- [Uso](#-uso)
- [Contribución](#-contribución)
- [Roadmap](#-roadmap)

### Descripción
Este proyecto es una aplicación Java para la gestión de citas de un buffet de abogados. Permite registrar, buscar y eliminar abogados, así como manejar la información necesaria para agendar citas con usuarios. 

### Problema Identificado
Los abogados no contaban con una herramienta digital que facilitara la gestión de citas, datos de los clientes y la información de los profesionales del despacho. El registro manual causaba errores y pérdida de datos.

### Solución
Se desarrolló una solución en Java con interfaz gráfica (GUI) y persistencia en archivos de texto para simplificar la gestión de citas y el registro de abogados.

### Arquitectura
[Usuario Final]
|
[Interfaz Gráfica en Java GUI]
|
[Controladores]
|
[DAO (AbogadoCRUD.java, CitaCRUD.java, ClienteCRUD.java)]
|
[Archivos de Texto con datos almacenados]

### Requerimientos

- **Java**: Java SE 11 o superior
- **IDE recomendado**: IntelliJ IDEA o Eclipse
- **JUnit**: Versión 5 para pruebas
- **Sistema operativo**: Windows, Linux o Mac
- **Dependencias**:
  - `junit-jupiter-api`
  - `junit-jupiter-engine`
    
### Instalación

#### 1. Clonar el repositorio
```bash
git clone https://github.com/usuario/proyecto-abogados.git
cd proyecto-abogados
```

#### 2. Configurar el entorno

- Abrir el proyecto en tu IDE preferido.
- Agregar las librerías de JUnit 5 si no usas un manejador de dependencias como Maven/Gradle.
- Las dependencias que se tienen que descargar son:
  - junit-jupiter-api
  - junit-jupiter-engine
  - apiguardian-api
  - opentest4j
  - junit-platform-commons
  - junit-platform-engine
-Guarda los JArs descargados en una carpeta dentro de la raiz del proyecto y agregalos como dependencia en la estructura del proyecto.

#### 3. Ejecutar pruebas manualmente
Desde tu IDE, haz clic derecho sobre el archivo de tests que quieras ejecutar (AbogadoTest.java, ClienteTest.java y CitaTest.java) y selecciona Run.

#### 4. Despliegue en producción

Hay dos formas de ejecutar el programa en la etapa de producción:
- En ambiente local: Ejecutar desde el .jar generado por tu IDE.
- En la nube: Subir el jar a un contenedor java y definir el comando para ejecutarlo.

### Configuración

#### Archivos de configuración
    listaAbogado.txt: Archivo de texto con la información de abogados.
    listaCliente.txt: Archivo de texto con la información de clientes.
    listaCita.txt: Archivo de texto con la información de las citas.

#### Configuración de requerimientos
Tener la version Java 11 minimo instalada e instalar las líbrerias de JUnit en caso de correr las tests de cada Entidad

### Uso

#### Manual para Usuario:
    Al ejecutar la aplicación, el usuario solo puede acceder al apartado de citas.
    El usuario solo puede crear, modificar, buscar y eliminar citas con su ID de citas.

#### Manual para Administrador:
    Administradores pueden acceder a todos los registros.
    Pueden acceder a todas las funciones del CRUD para cada entidad (Abogados, Clientes y Cita).
    También pueden modificar la estructura del archivo de persistencia (listaAbogado.txt) en caso de emergencias.

### Contribución

En caso de querer contribuir en el proyecto los pasos son:

#### Clona el repositorio:
```bash
git clone https://github.com/usuario/proyecto-abogados.git
```
#### Crea una nueva rama:
```bash

git checkout -b mi-rama-feature
```  
#### Realiza tus cambios y súbelos:
```bash
git add .
git commit -m "Añadir nueva funcionalidad"
git push origin mi-rama-feature
```
#### Crea un Pull Request desde GitHub y espera revisión para el merge.

### Roadmap

- En el futuro se busca la integracipon con base de datos relacional (MySQL/PostgreSQL).
- Agregar un panel web de administración (React o Angular).
- Módulo de gestión de citas con recordatorios/notificaciones.
- Hasheado de los datos personales de los usuarios para mayor seguridad.
