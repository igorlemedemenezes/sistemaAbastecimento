package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

@Repository
public class UsuarioDAO {
	@PersistenceContext
	EntityManager manager;
	
	public int inserir(Usuario usuario) throws IOException {
		manager.persist(usuario);
		return usuario.getId();
	}
	
	public List<Usuario> listar(Usuario usuario) throws IOException{
		//conectei minha fila com a persistencia			
				String jpql = "select u from Usuario u";
				
				Query query = manager.createQuery(jpql);

				@SuppressWarnings("unchecked")
				List<Usuario> result = query.getResultList();
				return result;
	}
	
	public Usuario carregar(int  id) throws IOException {	
		return manager.find(Usuario.class, id);
	}
	
	public int excluir(int id) throws IOException {
		Usuario produto = manager.find(Usuario.class, id);
		manager.remove(produto);
		return produto.getId();
	}
	
	public int editar(Usuario produto) throws IOException {
		manager.merge(produto);		
		return produto.getId();
	}
	
	public Usuario findByLogin(String login) {
		
		String jpql = "select u from Usuario u where u.login = '" + login + "'";
		
		Query query = manager.createQuery(jpql);
		
		//query.getResultList()
		Usuario usuario  = (Usuario) query.getSingleResult();
		return usuario;
	}
	
	public boolean validar(Usuario usuario) throws IOException {
		Usuario resultado = findByLogin(usuario.getLogin());
		return (resultado != null && resultado.getSenha().equals(usuario.getSenha()));
	}
}
