# ProductPriceInfoInquiry

Este servicio recibe como dato de entrada el ID de la cadena de tiendas, el ID del producto y una fecha específica. A partir de estos datos, el servicio realiza una consulta en la base de datos para obtener el precio del producto correspondiente en esa fecha y para esa cadena en particular. La respuesta es un objeto JSON que contiene la información del precio, ID del producto, ID de la cadena, tarifa a aplicar, fecha de aplicación junto con un código y descripción de estado que indica si la transacción fue exitosa o si se produjo un error.

## Requerimientos

- Java 17 o superior
- Maven 3.6.6

## Instalación

1. Clonar el repositorio
2. Ejecutar el comando `mvn clean install` en la carpeta del proyecto
4. Ejecutar el comando `mvn spring-boot:run` en la carpeta del proyecto
3. Acceder a la API en `http://localhost:8080`

## Scripts Data Base H2
INSERT INTO PRICES_MODEL (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) 
VALUES (1, 1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR');

INSERT INTO PRICES_MODEL (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) 
VALUES (2, 1, '2020-06-14T15:00:00', '2020-06-14T18:30:00', 2, 35455, 1, 25.45, 'EUR');

INSERT INTO PRICES_MODEL (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) 
VALUES (3, 1, '2020-06-15T00:00:00', '2020-06-15T11:00:00', 3, 35455, 1, 30.50, 'EUR');

INSERT INTO PRICES_MODEL (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) 
VALUES (4, 1, '2020-06-16T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR');

## Endpoints

### `/v1/ProductPriceInfoInquiry`

- `GET /getProductPrice`: Consulta precios de productos

## Autor

Harby Arturo Plata Serrano

