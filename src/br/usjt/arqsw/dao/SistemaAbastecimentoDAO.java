package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.SistemaAbastecimento;

@Repository
public class SistemaAbastecimentoDAO {
	@PersistenceContext
	EntityManager manager;
	
	public int inserir(SistemaAbastecimento sistemaAbastecimento) throws IOException {
		manager.persist(sistemaAbastecimento);
		return sistemaAbastecimento.getId();
	}
	
	public List<SistemaAbastecimento> listar(SistemaAbastecimento sistemaAbastecimento) throws IOException{
		//conectei minha fila com a persistencia			
				String jpql = "select s from SistemaAbastecimento s";
				
				Query query = manager.createQuery(jpql);

				List<SistemaAbastecimento> result = query.getResultList();
				return result;
	}
	
	public SistemaAbastecimento carregar(int id) throws IOException {
		return manager.find(SistemaAbastecimento.class, id);
	}
	
	public int excluir(int id) throws IOException {
		SistemaAbastecimento sistemaAbastecimento = manager.find(SistemaAbastecimento.class, id);
		manager.remove(sistemaAbastecimento);
		return sistemaAbastecimento.getId();
	}
	
	public int editar(SistemaAbastecimento sistemaAbastecimento) throws IOException {
		manager.merge(sistemaAbastecimento);		
		return sistemaAbastecimento.getId();
	}

}
