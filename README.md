####Semplice Server RestFul

Questo esempio realizza un semplice server RestFul attraverso Spring DATA REST.

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-rest</artifactId>
	</dependency>

**Non fa uso dei RestController**, e attraverso la direttiva:
	
	spring.data.rest.base-path=/api

vengono specificati dove saranno esposti i servizi.

Per accedere quindi sara' sufficiente utilizzare il seguente indirizzo web:

	http://localhost:8080/api/

Operazioni permesse:

GET : ottenere l'oggetto o gli oggetti
POST : inserire l'oggetto o gli oggetti
PUT : modificare l'oggetto o gli oggetti
DELETE : cancellare l'oggetto o gli oggetti

Alcune operazioni possono disabilitate modificato i repository o agendo sul RepositoryRestConfigurer.