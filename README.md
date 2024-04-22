

# Spring Boot Blog Post application using JPA and H2 Database

## Installation

- Clone this repo
- Import Project to IntelliJ IDEA (Jika ingin menjalankan via Docker bisa Run Images, kalau tidak berarti hanya run biasa)
  Noted: Jika running via VS Code dengan mvn spring-boot:run 
- Open Postman 
- (POST) http://localhost:9090/api/blogposts
{
    "title":"BERITA HARI INI",
    "body":"Pemilu di Rusia Hanya Sebuah Formalitas",
    "author":"wafi"
}
- (GET) http://localhost:9090/api/blogposts
- (GET) http://localhost:9090/api/blogposts/{id}
- (PUT) http://localhost:9090/api/blogposts/{id}
{
    "title":"Title yang mau diubah",
    "body":"Body Mau Diubah",
    "author":"wafi"
}
- (DELETE) http://localhost:9090/api/blogposts/{id}
- Check Data in H2 http://localhost:9090/h2-console/

