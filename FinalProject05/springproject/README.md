# Proyecto Spring

**1.** A la hora de crear el proyecto, se selecciona la versión 2.5.3. y luego se marca las casillas de dependencias:
   - Spring Boot DevTools
   - SpringData JPA
   - MySQL Driver
   - Spring Web

**2.** Apache Tomcat

https://www.youtube.com/watch?v=bklP__WoDf8

**3.** Ubuntu y docker:

https://www.padok.fr/en/blog/docker-windows-10

```
docker run -p 3305:3306 -–name springmysql -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=springmysql -d mysql:8.0.25
```

Run en dicha imagen en docker.

**4.** Dbeaver:

   - Base de datos/nueva conexión/mysql*
   - General:  
     - Port: 305
     - Database: springmysql
     - Contraseña: admin
   - Driver properties:
      - allowPublicKeyRetrieval: true
     
**5.** Eclipse:

```
mvn spring-boot:start
```




* Pinchar en el mysql donde aparece mysql:8 o más cuando se deja el ratón encima
