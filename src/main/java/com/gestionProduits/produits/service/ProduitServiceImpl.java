package com.gestionProduits.produits.service;

import com.gestionProduits.produits.dto.ProduitDto;
import com.gestionProduits.produits.exception.ResourceNotFoundException;
import com.gestionProduits.produits.model.Produit;
import com.gestionProduits.produits.repository.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements IProduitService{

    @Autowired
    private ProduitRepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<ProduitDto> getProduits() {
        List<Produit> produits = repository.findAll();
        return produits.stream()
                .map(produit -> mapper.map(produit, ProduitDto.class))
                .collect(Collectors.toList());
    }

    public ProduitDto getProduit(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("le produit avec l'id " + id + " n'existe pas");
        }
        return mapper.map(repository.findById(id), ProduitDto.class);
    }

    public void addProduit(ProduitDto produitDto) {
        repository.save(mapper.map(produitDto, Produit.class));
    }

    public void updateProduit(Integer id, ProduitDto produitDto) {
        Produit produit = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("le produit avec l'id " + id + " n'existe pas"));
        mapper.map(produitDto, produit);

        repository.save(produit);
    }

    public void deleteProduit(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("le produit avec l'id " + id + " n'existe pas");
        }
        repository.deleteById(id);
    }
}
