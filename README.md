
# Programación orientada a objetos (Java)

Repositorio usado a modo de apoyo para impartir la asignatura de Programación orientada a objetos en la Universidad de Málaga.


## Dependencias

Para poder usar este proyecto sera necesario tener instalado:

* Java SDK 17
* IntelliJ IDEA Community Edition


## Estructura del proyecto:

El proyecto es un proyecto ```Maven``` desarrollado en IntelliJ, recordar que para poder traeros las dependencias asociadas al proyecto (JUnit5), es necesario hacer click derecho sobre el fichero "pom.xml" > Maven > Reload project.

* Trasparencias: Trasparencias proporcionadas a traves del campus virtual.
* src/main/java/...: Aqui estaran todas las clases que vayamos creando encapsuladas mediante "paquetes". Dichos paquetes representaran distintos ejercicios/practicas/conceptos que iremos viendo en clase. Dentro de cada paquete los ficheros "Test..." contendran distintos "main" para poder testear dicho paquete.

        * src/main/java/Conceptos/...: Ejemplos de los distintos conceptos de la asignatura.
        * src/main/java/Practicas/...: Practicas propuestas en el campus.
        * src/main/java/Examenes/...: Examenes de años anteriores.
* Test/...: Ficheros de Test en Junit5 proporcionados en el cv para poder testear las practicas propuestas. Para ejecutarlas simplemente hacer click derecho sobre la carpeta y pulsar sobre Run all test, o pulsar sobre el test concreto que quieras ejecutar y pulsar sobre Run test.
