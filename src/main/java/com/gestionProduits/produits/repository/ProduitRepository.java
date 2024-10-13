package com.gestionProduits.produits.repository;

import com.gestionProduits.produits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    @Query("SELECT MAX(p.id) FROM Produit p")
    Integer findMaxId();
}
