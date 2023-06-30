# GAP API

## Usage

* Swagger UI: http://localhost:80/glarimy/assessments-api/swagger-ui/index.html
* Database: http://localhost:80/glarimy/assessments-api/h2-console/ with jdbc:h2:mem:assessments-db
* curl -X 'POST' 'http://localhost/glarimy/assessments-api/question' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"description": "What is the capital of India?", "optionOne": "Bengaluru", "optionTwo": "New Delhi", "optionThree": "Mumbai", "optionFour": "Kolkota", "subject":"Politics", "topic":"India", "answer": 2}'
* curl -X 'POST' 'http://localhost/glarimy/assessments-api/assessment?subject=Test&topic=Test' -H 'accept: */*' -d ''