# GestionProduit
-Projet de gestion des produits CRUD comme environnement Spring Boot avec comme base de données MYSQL.
-pour démarrer le projet vous devez avoir:
-une base donnée MYSQL dans le fichier Application.properties pour ces lignes
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=user_name_yourdatabase
spring.datasource.password=user_password_yourdatabase
vous devez replacez your_database par le nom de votre base et user_name_yourdatabase, user_password_yourdatabase par le nom d’utilisateur et son mot de passe.
-aussi pour pouvoir tester soit par postman ou par swagger via le lien (Swagger UI) ci-dessous un exemple de produit sous format json.

 {
        "code": "P001",
        "name": "Produit 1",
        "description": "Description du produit 1",
        "image": "image1.jpg",
        "category": "Catégorie A",
        "price": 29.99,
        "quantity": 100,
        "internalReference": "INT001",
        "shellId": 1,
        "inventoryStatus": "INSTOCK",
        "rating": 4.5        
    }
