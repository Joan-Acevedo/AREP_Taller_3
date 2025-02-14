# Web Server con IoC y Rutas REST dinámicas

## Autor

Escuela Colombiana de Ingeniería Julio Garavito

Arquitectura Empresarial

Joan S. Acevedo Aguilar

---

## Descripción

Este proyecto es un servidor web en Java que incluye las siguientes características:

- Servir archivos estáticos (HTML, CSS, JS, imágenes, etc.).
- Manejar una API REST dinámica mediante funciones lambda.
- Definir rutas REST de manera flexible con `get()`.
- Soporte para parámetros en las rutas mediante `@RequestParam`.
- Inversión de Control (IoC) para la carga automática de POJOs con `@RestController`.
- Registro automático de rutas mediante `@GetMapping`.

El servidor escucha peticiones en el puerto 35000 y responde tanto a solicitudes de archivos estáticos como a endpoints REST definidos dinámicamente.

---

## Instalación

### **1. Prerrequisitos**
Para ejecutar este proyecto, asegúrate de tener instalado lo siguiente:
- **Java 17 o superior**
- **Maven**
- **Un editor de texto o IDE como IntelliJ IDEA o VS Code**

### **2. Clonar el Repositorio**
Abre una terminal y ejecuta el siguiente comando para clonar el proyecto:
```sh
    git clone https://github.com/Joan-Acevedo/AREP_Taller_3.git
```

Luego, navega al directorio del proyecto:
```sh
   cd Taller_3 - copia\web-server
```

### **3. Compilar el Proyecto**
Ejecuta el siguiente comando dentro de la carpeta del proyecto:
```sh
    mvn clean compile
```

---

## Ejecución del Servidor

### Tenemos dos opciones para ejecutar el servidor:

### Opción 1: Forma tradicional

Para iniciar el servidor, dirigete a la clase HttpServer y corre/ejecuta la clase.

Una vez iniciado, puedes acceder a la aplicación desde tu navegador ingresando a:

---

Para ver el index.html:
```
http://localhost:35000/
```

Para ver el numero Pi:

```
http://localhost:35000/pi
```

Para consultar una imagen:

```
http://localhost:35000/oP.png
```

Para ver una situación donde no se encuentra el recurso:

```
http://localhost:35000/cualquier_cosa
```

### Opción 2: Desde la terminal de tu IDE usando Maven

Ingresa el siguiente comando para ejecutar el servidor:

```sh
  mvn exec:java "-Dexec.mainClass=org.example.HttpServer"
```

Posteriormente, sin terminar la ejecución, abre otra terminal y consulta las mismas URL que la "opción 1" solo que esta 
vez desde la terminal y con el comando `curl`.

**Ejemplo 1:**

```sh
   curl http://localhost:35000/pi
```

**Ejemplo 2:**

```sh
   curl "http://localhost:35000/api/suma?a=5&b=3"
```

**Ejemplo 3:**

```sh
   curl http://localhost:35000/api/saludo?name=TuNombre
```

---

## Arquitectura del Código

El proyecto sigue una arquitectura modular, estructurada de la siguiente manera:

1. **Servidor HTTP (`HttpServer.java`)**
   - Maneja conexiones entrantes y analiza solicitudes HTTP.
   - Permite definir rutas REST con `get()` y funciones lambda.
   - Sirve archivos estáticos desde una carpeta `recursos/`.
   - Incluye un contenedor IoC para cargar automáticamente POJOs con `@RestController`.

2. **Archivos Estáticos (`recursos/`)**
   - Incluye archivos HTML, CSS, JS, imágenes, etc.
   - Se sirven automáticamente desde esta carpeta.

3. **Contenedor IoC (`IoCContainer.java`)**
   - Escanea el classpath para encontrar clases con `@RestController`.
   - Instancia dinámicamente estas clases y las guarda en un contenedor (`Map<String, Object>`). 
   - Registra automáticamente las rutas definidas con `@GetMapping`.

4. **Anotaciones (`org.example.framewor`)**
   - `@RestController`: Marca una clase como controlador REST.
   - `@GetMapping`: Define rutas HTTP `GET`.
   - `@RequestParam`: Mapea parámetros de consulta en los métodos de los controladores.

---

## API REST Implementada

### **1. Obtener un saludo personalizado**
**Endpoint:**
```
GET /api/saludo?name={nombre}
```
**Ejemplo de Uso:**
```
http://localhost:35000/api/saludo?name=Juliana
```
**Respuesta JSON:**
```json
{
  "name": "Juliana",
  "mensaje": "Hola, Juliana!"
}
```

### **2. Obtener el valor de PI**
**Endpoint:**
```
GET /pi
```
**Ejemplo de Uso:**
```
http://localhost:35000/pi
```
**Respuesta:**
```
3.141592653589793
```

---

## Pruebas Realizadas

Por conflictos con las dependencias, para este laboratorio no se implementarón pruebas.

---

## Conclusión

Este proyecto demuestra cómo construir un servidor web en Java flexible y eficiente con soporte para archivos 
estáticos y una API REST modular. Gracias a la implementación de Inversión de Control (IoC) y el uso de anotaciones, la gestión de rutas REST es más dinámica y fácil de extender en futuras mejoras.