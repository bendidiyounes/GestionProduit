package com.gestionProduits.produits.controller;

import com.gestionProduits.produits.dto.ProduitDto;
import com.gestionProduits.produits.service.ProduitService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Operation(summary = "Récupérer tous les produits", description = "Renvoie la liste de tous les produits disponibles.")
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public ResponseEntity<List<ProduitDto>> getProduits() {
        return new ResponseEntity<>(produitService.getProduits(), HttpStatus.OK);
    }

    @Operation(summary = "Récupérer un produit par ID", description = "Renvoie un produit spécifique selon son identifiant.")
    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public ResponseEntity<ProduitDto> getProduit(@PathVariable Integer id) {
        return new ResponseEntity<>(produitService.getProduit(id), HttpStatus.OK);
    }

    @Operation(summary = "Ajouter un nouveau produit", description = "Permet d'ajouter un nouveau produit.")
    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public ResponseEntity<Void> addProduit(@RequestBody ProduitDto produitDto) {
        produitService.addProduit(produitDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Modifier un produit", description = "Permet de modifier un produit.")
    @RequestMapping(method = RequestMethod.PATCH, value = "/products/{id}")
    public ResponseEntity<Void> updateProduit(@PathVariable Integer id, @RequestBody ProduitDto produitDto) {
        produitService.updateProduit(id, produitDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Supprimer un produit par ID", description = "Permet de supprimer un produit par son Id.")
    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Integer id) {
        produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
