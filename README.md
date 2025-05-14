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

### Descripción: 
Este proyecto es una aplicación Java para la gestión de citas de un buffet de abogados. Permite registrar, buscar y eliminar abogados, así como manejar la información necesaria para agendar citas con usuarios. 

### Problema Identificado: 
Los abogados no contaban con una herramienta digital que facilitara la gestión de citas, datos de los clientes y la información de los profesionales del despacho. El registro manual causaba errores y pérdida de datos.

### Solución:
Se desarrolló una solución en Java con interfaz gráfica (GUI) y persistencia en archivos de texto para simplificar la gestión de citas y el registro de abogados.

### Arquitectura:
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

### 1. Clonar el repositorio
```bash
git clone https://github.com/usuario/proyecto-abogados.git
cd proyecto-abogados
