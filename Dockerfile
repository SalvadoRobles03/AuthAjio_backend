# Usar una imagen oficial de Maven con JDK 17 como base
FROM maven:3.8.5-openjdk-17-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar todos los archivos del repositorio al contenedor
COPY . .

# Instalar las dependencias y construir el proyecto
RUN mvn install -U

# Exponer el puerto (necesario para Cloud Run)
EXPOSE 8080

# Comando para ejecutar la aplicación usando Maven con VM arguments
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=prod"]
