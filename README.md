
### Evidencia: Probar y verificar el despliegue de la aplicación

1. Se creó la instancia "hack-03" con una clave "labuser.pem". Se editaron las reglas de entrada, agregando un TCP personalizado para que tenga acceso al puerto 8080.

   <p align="center">
     <img src="img/creacion-configuracion-instancia.png" alt="creacion-configuracion-instancia" width="70%" style="display:block; margin:auto;">
   </p>

2. Se ingresó al entorno virtual utilizando SSH: `ssh -i /Users/bladimiralferez/labsuser.pem ubuntu@34.229.173.66`, y se instaló Java y PostgreSQL.

   <p align="center">
     <img src="img/ingreso_entorno_virtual.png" alt="ingreso-entorno-virtual" width="70%" style="display:block; margin:auto;">
   </p>

3. Se creó la base de datos hack-03 en RDS.

   <p align="center">
     <img src="img/creacion-bd.png" alt="creacion-bd" width="70%" style="display:block; margin:auto;">
   </p>

4. Se empacó la aplicación en un archivo sem08-0.0.1-SNAPSHOT.jar .

   <p align="center">
     <img src="img/empacar-app-jar.png" alt="empacar-app-jar" width="70%" style="display:block; margin:auto;">
   </p>

5. Se creó el bucket "hack-03" donde se subirá el archivo .jar.

   <p align="center">
     <img src="img/crea-bucket.png" alt="crea-bucket" width="70%" style="display:block; margin:auto;">
   </p>

6. Se cargó correctamente el archivo .jar en el bucket.

    <p align="center">
      <img src="img/carga-jar-bucket.png" alt="carga-jar-bucket" width="70%" style="display:block; margin:auto;">
    </p>

7. Se copió la aplicación de Spring Boot en la instancia de EC2 usando el comando: `aws s3 cp s3://hack-03/sem08-0.0.1-SNAPSHOT.jar /home/ubuntu/sem08-0.0.1-SNAPSHOT.jar`.

    <p align="center">
      <img src="img/copiar-app-EC2.png" alt="copiar-app-EC2" width="70%" style="display:block; margin:auto;">
    </p>

8. Ejecutamos la aplicación usando el comando: `java -jar sem08-0.0.1-SNAPSHOT.jar`

    <p align="center">
      <img src="img/ejecutar-app.png" alt="ejecutar-app" width="70%" style="display:block; margin:auto;">
    </p>

9. Utilizando Postman, se hicieron los Request dentro de la aplicación para comprobar el funcionamiento. Se hizo un POST, GET, GET/id , PUT. y DELETE. 

    <p align="center">
      <img src="img/post.png" alt="post-probando" width="70%" style="display:block; margin:auto;">
    </p>

    <p align="center">
      <img src="img/get.png" alt="post-probando" width="70%" style="display:block; margin:auto;">
    </p>

    <p align="center">
      <img src="img/get_id.png" alt="post-probando" width="70%" style="display:block; margin:auto;">
    </p>

    <p align="center">
      <img src="img/put.png" alt="post-probando" width="70%" style="display:block; margin:auto;">
    </p>

    <p align="center">
      <img src="img/delete.png" alt="post-probando" width="70%" style="display:block; margin:auto;">
    </p>


