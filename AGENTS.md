# Tintero Social

## Dev Commands
- Run: `./mvnw spring-boot:run`
- Test: `./mvnw test`

## Quirks
- Server port: **8082** (not default 8080)
- H2 console: http://localhost:8082/h2-console (JDBC URL: `jdbc:h2:mem:db_books`)
- Database resets on restart (`ddl-auto: create-drop`)
- GraphQL codegen plugin in pom.xml but not used; safe to ignore