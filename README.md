# spring-boot-rest-jpa-h2-example
Una aplicacion:
 - Spring Boot
 - JPA
 - H2
 - RXJAVA
 - DockerFile
 - Swagger

 Para generar el JAR

### Build

```
mvn package
```

### Run

```
cd target
java -jar spring-boot-rest-jpa-h2-example-0.0.1-SNAPSHOT.jar
```

### Browse

h2 web ui
http://localhost:8082/h2-console

swagge web ui
http://localhost:8082/swagger-ui.html


### Dockerizar Jar

- Descargar el proyecto
- Correr el "PACKAGE"  de Maven
- Verificar el JAR en el "target" y compararlo en DockerFile

### Una vez tengas instalado Docker

- docker image ls (para ver las imagenes que tienes)
- docker build -t wabregu/backend:1.0.0 (Para usar el dockerFile y crear la imagen)
- docker container run -d -p 8082:8082 wabregu/backend:1.0.0 .  (Para levantar la imagen y se mantenga activo)
- docker container logs [id de la imagen]
- docker container rn [id de la imagen]
- docker container stop [id de la imagen]
- docker container ls (lista todas las imagenes activas y con "-a" las que estuvieron activas)


### Pruebas en Postman :

POST : http://localhost:8082/tipo-cambio

Request :
```
{
    "monto":"100",
    "moneda_origen":"soles",
    "moneda_destino":"dolares"
}
```
Response:
```
{
      "id": 1,
      "monto": "100",
      "moneraOrigen": "soles",
      "moneraDestino": "dolares",
      "montoTipoCambio": "$ 31.84713375796178",
      "tipoCambio": "3.14"
  }
  ```
 GET : http://localhost:8082/tipo-cambio
 ```
 [
    {
        "id": 1,
        "monto": "27.98",
        "moneraOrigen": "soles",
        "moneraDestino": "dolares",
        "montoTipoCambio": "$ 27.98",
        "tipoCambio": "3.14"
    },
    {
        "id": 2,
        "monto": "100",
        "moneraOrigen": "soles",
        "moneraDestino": "dolares",
        "montoTipoCambio": "$ 31.84713375796178",
        "tipoCambio": "3.14"
    }
]
```
GET: http://localhost:8082/moneda
```
[
    {
        "id": 1,
        "monedaDestino": "dolares",
        "value": "3.14",
        "simbolo": "$"
    },
    {
        "id": 2,
        "monedaDestino": "soles",
        "value": "1",
        "simbolo": "S/"
    }
]
```
POST: http://localhost:8082/moneda/1

Request :
```
{
    "id": 1,
    "monedaDestino": "dolares",
    "value": "3.19",
    "simbolo": "$"
}
```
Response:
```
{
    "id": 1,
    "monedaDestino": "dolares",
    "value": "3.19",
    "simbolo": "$"
}
```
