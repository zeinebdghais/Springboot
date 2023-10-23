package com.example.produits;

import java.util.Date;
import java.util.List;

import com.example.produits.entities.Produit;
import com.example.produits.entities.Categorie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.produits.Repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Test
	public void testCreateProduit() {
	Produit prod = new Produit("Souris ",50.0,new Date());
	produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit()
	{
	Produit p = produitRepository.findById(2L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit()
	{
	Produit p = produitRepository.findById(2L).get();
	p.setPrixProduit(1500.0);
	produitRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteProduit()
	{
		produitRepository.deleteById(4L);
	}
	
	@Test
	public void testFindAllProduit()
	{
		List<Produit> prods = produitRepository.findAll();
		
		for(Produit p : prods) {
			System.out.println(p);
		}

	}
	
	@Test
	public void testFindProduiByNom()
	{
	List<Produit> prods= produitRepository.findByNomProduit("PC Dell");
	
	for(Produit p : prods) {
		System.out.println(p);
	}
	}
	
	@Test
	public void testFindProduiByNomCountains()
	{
	List<Produit> prods= produitRepository.findByNomProduitContains("P");
	
	for(Produit p : prods) {
		System.out.println(p);
	}
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("PC hp", 1000.0);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Produit> prods = produitRepository.findByCategorie(cat);
	for (Produit p : prods)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
	for (Produit p : prods)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
	for (Produit p : prods) {
		System.out.println(p);
	}
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Produit> prods = produitRepository.trierProduitsNomsPrix();
	for (Produit p : prods)
	{
		System.out.println(p);
	}
	}




}
