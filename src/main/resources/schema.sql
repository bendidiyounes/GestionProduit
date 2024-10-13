CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    image VARCHAR(255),
    category VARCHAR(100),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    internalReference VARCHAR(50),
    shellId INT,
    inventoryStatus ENUM('INSTOCK', 'LOWSTOCK', 'OUTOFSTOCK') NOT NULL,
    rating DECIMAL(3, 1),  -- Champ d'évaluation du produit
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);