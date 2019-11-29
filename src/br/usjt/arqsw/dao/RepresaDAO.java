package br.usjt.arqsw.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Represa;
import br.usjt.arqsw.entity.Usuario;

@Repository
public class RepresaDAO {
	@PersistenceContext
	EntityManager manager;
	
	public int inserir(Represa represa) throws IOException {
		manager.persist(represa);
		return represa.getId();
	}
	
	@SuppressWarnings("unchecked")
	public List<Represa> listar() throws IOException{
		//conectei minha fila com a persistencia			
				String jpql = "select r from Represa r";
				
				Query query = manager.createQuery(jpql);

				List<Represa> result = query.getResultList();
				return result;
	}
	
	public Represa carregar(int id) throws IOException {
		return manager.find(Represa.class, id);
	}
	
	public int excluir(int id) throws IOException {
		Represa represa = manager.find(Represa.class, id);
		manager.remove(represa);
		return represa.getId();
	}
	
	public int editar(Represa represa) throws IOException {
		manager.merge(represa);		
		return represa.getId();
	}
	
	@SuppressWarnings("unchecked")
	public List<Represa> listar(String chave) {
		
		//String jpql = "select r from Represa r where nome like '%" + chave + "%'";
		String jpql = "select r from Represa r where dataAbertura = '" + chave + "'";
		
		Query query = manager.createQuery(jpql);

		List<Represa> result = query.getResultList();
		
		return result;
	}

}
