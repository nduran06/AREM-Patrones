# Laboratory 6-Patrones Arquitecturales


## Prerequisitos

- Se debe tener una cuenta en AWS o AWS Educate

[AWS](https://signin.aws.amazon.com/signin?redirect_uri=https%3A%2F%2Faws.amazon.com%2Fmarketplace%2Fmanagement%2Fsignin%3Fstate%3DhashArgs%2523%26isauthcode%3Dtrue&client_id=arn%3Aaws%3Aiam%3A%3A015428540659%3Auser%2Faws-mp-seller-management-portal&forceMobileApp=0)

[AWS Educate](https://www.awseducate.com/signin/SiteLogin)

## Repositorios 

[EC2](https://github.com/nduran06/AREM-PatternsEC2)
[S3](https://github.com/nduran06/Patterns-Static.git)

## Video explicación

[Video](https://github.com/nduran06/AREM-Patrones/blob/master/video/videoA.mp4)

## Instalaciones

- Entramos a modo super usuario

```markdown
$ sudo su
```
### Instalación de Git

```markdown
# yum install git
```
### Instalación de Java

```markdown
# yum install -y java-1.8.0-openjdk-devel
```
* Cambiamos la versión de java

```markdown
# update-alternatives --config java
```
* Ingresamos el número que indica la que vamos a utilizar y presionamos enter

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/instalacion/1.png)

### Instalación de Maven

```markdown
# cd /usr/local/src
```
```markdown
# wget http://www-us.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz
```
```markdown
# tar -xf apache-maven-3.5.4-bin.tar.gz
```
```markdown
# mv apache-maven-3.5.4/ apache-maven/
```
```markdown
# cd /etc/profile.d/
```
```markdown
# nano maven.sh
```
- Copiamos lo siguiente en maven.sh:

```markdown
# Apache Maven Environment Variables
# MAVEN_HOME for Maven 1 - M2_HOME for Maven 2
export M2_HOME=/usr/local/src/apache-maven
export PATH=${M2_HOME}/bin:${PATH}
```
- Guardamos (ctrl+o ; enter)

```markdown
# chmod +x maven.sh
```
```markdown
# source /etc/profile.d/maven.sh
```
- Para salir del modo super usuario

```markdown
# exit
```
Ref: https://www.tecmint.com/install-apache-maven-on-centos-7/

## Tutorial

### Creación de Grupo de Seguridad-Base de datos

1. Buscar en los servicios ofrecidos VPC

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/vpc/1.png)

2. Dar click en Security Groups al costado izquierdo

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/vpc/2.png)

3. Insertar información del grupo

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/vpc/3.png)

4. Dar click sobre el grupo recién creado

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/vpc/4.png)

5. Dar click en Edit rules

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/vpc/5.png)

6. Crear una nueva regla. En esta ocasión se va a realizar para el acceso a la base de datos Postgresql cuyo puerto es el 5432, y se está permitiendo el acceso a todos (0.0.0.0/0 - ::/0)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/vpc/6.png)

### Creación de la Base de Datos

1. Buscamos el tipo de base de datos que vamos a utilizar (en este caso es relacional → RDS)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/1.png)

2. Damos click en Create database

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/2.png)

3. Elegimos Easy Create

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/3.png)

4. Se elige qué base de datos se va a utilizar (en este caso PostgreSQL)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/4.png)

5. Elegimos el tamaño de la base de datos (En este caso Free tier)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/5.png)

6. Elegimos el nombre de la base de datos

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/6.png)

7. Elegimos el nombre del usuario

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/7.png)

8. Le asignamos una contraseña a la base de datos

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/8.png)

9. Damos click en Create database

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/9.png)

10. Al crear la base de datos, nos aparecerá un cuadro donde aparecen las ya creadas

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/10.png)

- Cuando el valor de Status sea Available

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/11.png)

- Seleccionamos la instancia

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/12.png)

- Damos click en Modify

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/13.png)

11. Buscamos la sección Network & Security

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/14.png)

12. En la parte de Security Groups

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/15.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/16.png)

- Asignamos el VPC que creamos al principio (MyWebServerGroup)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/17.png)

13. Vamos a la parte Public accessibility y elegimos la opción Yes

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/18.png)

14. Damos click en continue y luego en Modify DB Instance

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/19.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/20.png)

- Copiamos esta configuración en el aplication.properties de nuestra app

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/bd/21.png)

### Creación de instancia EC2

1. Escribimos y seleccionamos EC2 en el buscador de servicio

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/1.png)

- Aparecerá esta pantalla 

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/2.png)

2. Damos click sobre Launch Instance

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/3.png)

3. Elegimos la máquina virtual que queremos crear (En este caso se elige la segunda opción que la que tiene Java)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/4.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/5.png)

4. Dejamos la opción por defecto y damos click en Next: Configure Instance Details

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/6.png)

5. Dejamos las opciones por defecto y damos click Next: Add Storage

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/7.png)

6. Dejamos las opciones por defecto y damos click Next: Add Tags

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/8.png)

7.  Dejamos las opciones por defecto y damos click Next: Configure Security Group

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/9.png)

8. Nos aparecerá esta pantalla 

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/10.png)

- Damos click sobre Add Rules

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/11.png)

- Buscamos la opción Custom TCP Rule

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/12.png)

- Adicionamos el puerto por el cual se va a acceder a nuestra aplicación. En esta ocasión utilizamos a Spring por lo que el puerto a utilizar es el 8080

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/13.png)

- Elegimos quien puede acceder (todos)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/14.png)

- Y si se desea se adiciona una descripción

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/15.png)

9. Damos click en Review and Launch

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/16.png)

10. Damos click sobre Launch

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/17.png)

11. Luego nos aparecerá el siguiente recuadro

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/18.png)

- Le asignamos un nombre a la llave, presionamos sobre Download Key Pair para descargarla y luego damos click sobre Launch Instances

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/19.png)

- Aparecerá el siguiente recuadro con las instrucciones de conexión a la máquina

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/20.png)

12. Esta es la dirección de nuestra máquina

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/21.png)

- Vamos a apiclient donde tenemos

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/22.png)

- Y lo cambiamos Localhost por la dirección de nuestra máquina

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/ec2/23.png)

### Creación de instancia S3

1. Escribimos y seleccionamos S3 en el buscador de servicios

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/1.png)

- Aparecerá esta pantalla

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/2.png)

2. Damos click en Crear bucket

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/3.png)

3. Elegimos el nombre del bucket y damos click en Siguiente

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/4.png)

- Damos click en Siguiente en los cuadrantes posteriores

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/5.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/6.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/7.png)

4. Luego aparecerá esta pantalla

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/8.png)

- Quitamos la opción de Bloquear todo acceso público, aceptamos el reconocimiento de los riesgos que se corren y damos click en Siguiente

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/9.png)

- Damos click en Crear bucket

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/10.png)

5. Después nos aparecerá esta pantalla

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/11.png)

- Damos click sobre el nombre de la instancia creada

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/12.png)

- Aparecerá esta pantalla

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/13.png)

6. Damos click sobre el botón de cargar

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/14.png)

- Damos click sobre el botón de Añadir archivos

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/15.png)

7. Arrastramos los archivos que se desean subir (los del repositorio [S3](https://github.com/nduran06/Patterns-Static.git))

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/16.png)

8. Damos click en siiguiente

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/17.png)

- Los archivos recién subidos deberían aparecer en este recuadro

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/18.png)

9. Damos click sobre index.html

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/19.png)

10. Buscamos URL del objeto, que es el medio por el cual podremos acceder a nuestro recurso

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/s3/20.png)

```markdown
https://jpatterns.s3.amazonaws.com/index.html
```
### Conexión a instancia EC2

1. Abrimos la terminal donde se encuentra la llave descargada anteriormente 

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/conexion/1.png)

2. Nos conectamos de acuerdo a las instrucciones recibidas anteriormente

```markdown
ssh -i "MyFirstKey.pem" ec2-user@ec2-3-85-221-208.compute-1.amazonaws.com
```
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/conexion/2.png)

3. Realizamos las instalaciones necesarias (git, java, maven) indicadas previamente

4.  Clonamos el repositorio de git [EC2](https://github.com/nduran06/AREM-Patrones.git)

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/conexion/3.png)

5. Entramos al directorio 

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/conexion/4.png)

6. 

- Empaquetamos el proyecto 

```markdown
mvn package
``` 

- Ejecutamos el proyecto

```markdown
mvn spring-boot:run
```

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/conexion/5.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/conexion/6.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/conexion/7.png)

- URLs accesos

```markdown
[](http://ec2-3-85-221-208.compute-1.amazonaws.com:8080/index.html)
[](http://ec2-3-85-221-208.compute-1.amazonaws.com:8080/user.html)
[](http://ec2-3-85-221-208.compute-1.amazonaws.com:8080/patterns)
```
### Funcionamiento

#### EC2

```markdown
http://ec2-3-85-221-208.compute-1.amazonaws.com:8080/index.html
```
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/1.png)

```markdown
http://ec2-3-85-221-208.compute-1.amazonaws.com:8080/user.html
```
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/2.png)

#### S3

```markdown
[](https://jpatterns.s3.amazonaws.com/index.html)
```
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/3.png)

- Desde S3 se puede acceder a las páginas de EC2

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/4.png)

1)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/5.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/6.png)

2)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/7.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/8.png)

3)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/9.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/funcionalidad/10.png)


### Costos

#### EC2

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/costos/ec2.png)

#### S3

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/costos/s3.png)

#### Base de datos RDS-PostgreSQL

![](https://github.com/nduran06/AREM-Patrones/blob/master/images/costos/db1.png)
![](https://github.com/nduran06/AREM-Patrones/blob/master/images/costos/db2.png)

## Built With

*   [`Maven`](https://maven.apache.org/) - Dependency Management
*   [`Spring`](https://spring.io/) - Framework

## Authors

```markdown
* Natalia Durán Vivas
```

## License

This project is licensed under the GNU License - see the [LICENSE.md](LICENSE) file for details

## Badge CircleCI

[![CircleCI](https://circleci.com/gh/nduran06/AREM-04.svg?style=svg)](https://circleci.com/gh/nduran06/AREM-05)

## Codacy

[![Codacy](https://app.codacy.com/legacy/versioned/images/grades/grade-a.png)](https://app.codacy.com/manual/nduran06/AREM-05/dashboard)
