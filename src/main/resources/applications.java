server.port=80
server.servlet.contextPath=/glarimy/assessments-api

spring.datasource.url=jdbc:h2:mem:assessments-db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto= update
spring.h2.console.enabled=true
