# Proyecto Spring

**1.** A la hora de crear el proyecto, se selecciona la versión 2.5.3. y luego se marca las casillas de dependencias:
   - Spring Boot DevTools
   - SpringData JPA
   - MySQL Driver
   - Spring Web

**2.** Ubuntu y docker:

```
docker run -p 3305:3306 –name springmysql -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=springmysql -d mysql:8.0.25
```

Run en dicha imagen en docker.

**3.** Dbeaver:

   - Base de datos/nueva conexión/mysql*
   - General:  
     - Port: 305
     - Database: springmysql
     - Contraseña: admin
   - Driver properties:
      - allowPublicKeyRetrieval: true
     
**4.** Eclipse:

```
mvn spring-boot:start
```




* Pinchar en el mysql donde aparece mysql:8 o más cuando se deja el ratón encima
