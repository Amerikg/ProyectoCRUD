
# ProyectoCRUD

Aplicación de escritorio en Java utilizando Swing y conexión a base de datos, que implementa operaciones CRUD para gestionar empleados.

## Características

- Interfaz gráfica desarrollada con Java Swing.
- Patrón de diseño MVC (Modelo-Vista-Controlador).
- Acceso a base de datos mediante JDBC.
- Funcionalidad CRUD completa (Crear, Leer, Actualizar, Eliminar) para registros de empleados.
- Organización modular del código.

## Requisitos

- Java 8 o superior
- Maven
- Un gestor de base de datos compatible con JDBC (por ejemplo, MySQL o PostgreSQL)

## Estructura del proyecto

```
ProtecyoCRUD/
├── src/
│   └── test/
│       └── java/
│           └── org/example/plazi/
│               ├── main/                 # Clase principal (Main.java)
│               ├── model/                # Modelo de datos (Employee.java)
│               ├── repository/           # Repositorio de datos
│               ├── util/                 # Utilidades (conexión a BD)
│               └── view/                 # Interfaz gráfica (SwingApp.java)
├── pom.xml                              # Configuración del proyecto Maven
└── .idea/                                # Configuraciones de IntelliJ IDEA
```

## Instrucciones de uso

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Amerikg/ProyectoCRUD.git
   cd ProtecyoCRUD
   ```

2. Compila el proyecto con Maven:

   ```bash
   mvn compile
   ```

3. Ejecuta la aplicación:

   Puedes correr la clase `Main.java` desde tu IDE o con el comando:

   ```bash
   mvn exec:java -Dexec.mainClass="org.example.plazi.main.Main"
   ```

4. Asegúrate de configurar correctamente la conexión a tu base de datos en `DatabaseConnection.java`.




