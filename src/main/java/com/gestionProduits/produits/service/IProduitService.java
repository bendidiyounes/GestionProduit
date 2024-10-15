package com.gestionProduits.produits.service;

import com.gestionProduits.produits.dto.ProduitDto;

import java.util.List;

public interface IProduitService {

    List<ProduitDto> getProduits();

    ProduitDto getProduit(Integer id);

    void addProduit(ProduitDto produitDto);

    void updateProduit(Integer id, ProduitDto produitDto);

    void deleteProduit(Integer id);
}
