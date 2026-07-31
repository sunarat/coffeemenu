# My First REST API — "Coffee Menu Service"

**รายวิชา:** CP353002 — Principles of Software Design and Development  
**พัฒนาโดย:** Sunarat Budsabong 
**รหัสนักศึกษา:** 633020425-5
**การเก็บข้อมูล:** In-Memory (`List<Coffee>`)  

---
## 1. วิธีการรันโปรเจกต์ (How to Run)

เปิด Terminal ในโฟลเดอร์โปรเจกต์แล้วใช้คำสั่ง:

chmod +x mvnw
./mvnw spring-boot:run

คำสั่งทดสอบ API (curl Commands)
GET /coffees: curl http://localhost:8080/coffees

GET /coffees/1: curl http://localhost:8080/coffees/1

POST /coffees:
curl -X POST http://localhost:8080/coffees 
-H "Content-Type: application/json" 
-d '{"name":"Cappuccino","price":60.0}'

PUT /coffees/2:
curl -X PUT http://localhost:8080/coffees/2 
-H "Content-Type: application/json" 
-d '{"name":"Latte","price":50.0}'

DELETE /coffees/3: curl -X DELETE http://localhost:8080/coffees/3