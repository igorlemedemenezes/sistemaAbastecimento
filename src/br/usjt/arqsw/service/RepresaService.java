package br.usjt.arqsw.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.RepresaDAO;
import br.usjt.arqsw.entity.Represa;


@Service
public class RepresaService {
	
	RepresaDAO dao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	public RepresaService(RepresaDAO dao){
		this.dao = dao;
	}
	
	public void novaRepresa(Represa represa) throws IOException {
			represa.setPluviometriaDiaAnterior(represa.getVolumeArmazenado());
			represa.setVolumeTotal(represa.getVolumeUtil() + represa.getVolumeReservaTecnica());
			represa.setCalcIndice1(indice1(represa));
			represa.setCalcIndice2(indice2(represa));
			represa.setCalcIndice3(indice3(represa));
			dao.inserir(represa);
	}
	
	public Represa carregarRepresa(int id) throws IOException{
		return dao.carregar(id);
	}
	
	@Transactional
	public int excluirRepresa(int id) throws IOException {
		return dao.excluir(id);
	}
	
	@Transactional
	public int editarRepresa(Represa represa) throws IOException {
		/*represa.setPluviometriaDiaAnterior(represa.getPluviometriaDiaAnterior() + represa.getVolumeArmazenado());
		represa.setVolumeTotal(represa.getVolumeUtil() + represa.getVolumeReservaTecnica());
		*/represa.setCalcIndice1(indice1(represa));
		represa.setCalcIndice2(indice2(represa));
		represa.setCalcIndice3(indice3(represa));
		return dao.editar(represa);
	}
	
	public List<Represa> listarRepresas() throws IOException{
		return dao.listar();
	}
	
	public Double indice1(Represa represa) {
		return (represa.getVolumeArmazenado()/represa.getVolumeUtil())*100;
	}
	
	public Double indice2(Represa represa) {
		Double volumeTotal = represa.getVolumeUtil() + represa.getVolumeReservaTecnica();
		return represa.getVolumeArmazenado() / volumeTotal * 100;
	}
	
	public Double indice3(Represa represa) {
		return (represa.getVolumeArmazenado() - represa.getVolumeReservaTecnica()) / represa.getVolumeUtil() * 100;
	}
	
	public List<Represa> buscarPorChave(String chave) {
		return dao.listar(chave);
	}
}
