# Proyecto Spring

**1.** Ubuntu y docker:

```
docker run -p 3305:3306 –name springmysql -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=springmysql -d mysql:8.0.25
```

Run en dicha imagen en docker.

**2.** Dbeaver:

   - Base de datos/nueva conexión/mysql*
   - General:  
     - Port: 305
     - Database: springmysql
     - Contraseña: admin
   - Driver properties:
      - allowPublicKeyRetrieval: true
     
**3.** Eclipse:

```
mvn spring-boot:start
```




* Pinchar en el mysql donde aparece mysql:8 o más cuando se deja el ratón encima