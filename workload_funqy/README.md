# Quarkus-Funqy-Standalone-Demo
Quarkus Funqy HTTP-Binding - Standalone Demo

## Test:

### Run in Dev Mode:
```
mvn compile quarkus:dev
```
### In another termnal:
```
curl "http://localhost:8080/greet" \
-X POST \
-H "Content-Type: application/json" \
-d '{"name":"Moses"}'


curl "http://localhost:8080/greet?name=sashvin"


curl "http://localhost:8080/lower" \
-X POST \
-H "Content-Type: application/json" \
-d '"HELLO QUARKUS"'


curl "http://localhost:8080/double" \
-X POST \
-H "Content-Type: application/json" \
-d '3443'

```


