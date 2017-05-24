package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.model.Autore;
import it.uniroma3.repository.AutoreRepository;

public class AutoreService {
	
	private AutoreRepository productRepository;
	private EntityTransaction tx;
	public AutoreService(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prodotti-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AutoreRepository productRepository = new AutoreRepository(em);
		this.productRepository = productRepository;
		this.tx = tx;
	}
	
	public Autore inseriscAutore(Autore autore){
		tx.begin();
		productRepository.save(autore);
		tx.commit();
		return autore;
	}
	
	public List<Autore> getAutori(){
		tx.begin();
		//TypedQuery<Prodotto> query = em.createNamedQuery("findAll", Prodotto.class);
		//List<Prodotto> prodotti = query.getResultList();
		List<Autore> autori = productRepository.findAll(); 
		tx.commit();
		return autori;
	}

	public Autore getAutoreDaId(Long id) {
		tx.begin();
		//Prodotto prodotto = em.find(Prodotto.class, id);
		Autore autore = productRepository.findOne(id);
		tx.commit();
		return autore;
	}
	
	public void eliminaAutore(Long id){
		Autore toDelete = this.getAutoreDaId(id);
		tx.begin();
		this.productRepository.delete(toDelete);
		tx.commit();
	}

}
