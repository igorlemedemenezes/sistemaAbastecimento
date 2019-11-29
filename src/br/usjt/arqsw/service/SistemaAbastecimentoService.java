package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.SistemaAbastecimentoDAO;
import br.usjt.arqsw.entity.SistemaAbastecimento;

@Service
public class SistemaAbastecimentoService {
	SistemaAbastecimentoDAO dao;
	
	@Autowired
	public SistemaAbastecimentoService(SistemaAbastecimentoDAO dao){
		this.dao = dao;
	}
	
	public void novoSistemaAbastecimento(SistemaAbastecimento sistemaAbastecimento) throws IOException{
		dao.inserir(sistemaAbastecimento);
	}
	
	public SistemaAbastecimento carregarSistemaAbastecimento(int id) throws IOException{
		return dao.carregar(id);
	}
	
	@Transactional
	public int excluirSistemaAbastecimento(int id) throws IOException {
		return dao.excluir(id);
	}
	
	@Transactional
	public int editarSistemaAbastecimento(SistemaAbastecimento sistemaAbastecimento) throws IOException {
		return dao.editar(sistemaAbastecimento);
	}
	
	public List<SistemaAbastecimento> listarSistemasAbastecimentos(SistemaAbastecimento sistemaAbastecimento) throws IOException{
		return dao.listar(sistemaAbastecimento);
	}

}
