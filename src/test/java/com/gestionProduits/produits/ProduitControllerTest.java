package com.gestionProduits.produits;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionProduits.produits.dto.ProduitDto;
import com.gestionProduits.produits.repository.ProduitRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProduitControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProduitRepository repository;

    private static Integer createdProduitId;

    @Order(1)
    @Test
    public void testGetProduits() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Order(2)
    @Test
    public void testAddProduit() throws Exception {
        ProduitDto produitDto = ProduitDto.builder()
                .code("code")
                .name("Produit Test")
                .price(BigDecimal.valueOf(100.0))
                .quantity(10)
                .inventoryStatus(ProduitDto.InventoryStatus.INSTOCK)
                .build();
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produitDto)))
                .andExpect(status().isCreated());
        createdProduitId = repository.findMaxId();
    }

    @Order(3)
    @Test
    public void testGetProduit() throws Exception {
        mockMvc.perform(get("/products/{id}", createdProduitId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":" + createdProduitId + ",\"name\":\"Produit Test\"}"));
    }

    @Order(4)
    @Test
    public void testUpdateProduit() throws Exception {
        ProduitDto produitDto = ProduitDto.builder()
                .name("Produit Mis à Jour")
                .build();
        mockMvc.perform(patch("/products/{id}", createdProduitId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produitDto)))
                .andExpect(status().isOk());
    }

    @Order(5)
    @Test
    public void testDeleteProduit() throws Exception {
        mockMvc.perform(delete("/products/{id}", createdProduitId))
                .andExpect(status().isNoContent());
    }
}

