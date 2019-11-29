package br.usjt.arqsw.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.arqsw.entity.Represa;
import br.usjt.arqsw.entity.SistemaAbastecimento;
import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.RepresaService;
import br.usjt.arqsw.service.SistemaAbastecimentoService;
import br.usjt.arqsw.service.UsuarioService;

@Transactional
@Controller
public class ManterController {
	private UsuarioService usuarioService;
	private RepresaService represaService;
	private SistemaAbastecimentoService sistemaAbastecimentoService;

	@Autowired
	public ManterController(UsuarioService us, RepresaService rs, SistemaAbastecimentoService ss) {
		usuarioService = us;
		represaService = rs;
		sistemaAbastecimentoService = ss;
	}

	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("fazer_login")
	public String efetuarLogin(Usuario usuario, HttpSession session, Model model) {
		try {
			if (usuarioService.validarUsuario(usuario)) {
				session.setAttribute("usuarioLogado", usuario);
				return "redirect:index";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("Erro", e);
			return "Erro";
		}
		return "redirect:loginForm";
	}

	// public String logout(HTTP)

	/* USU�RIO */
	@RequestMapping("/cadastrar_usuario")
	public String cadastrarUsuario() {
		return "usuario/CadastrarUsuario";
	}

	@RequestMapping("/novo_usuario")
	public String novoUsuario(Model model, Usuario usuario) {
		try {
			usuarioService.inserirUsuario(usuario);
			return "redirect:/listar_usuarios";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/listar_usuarios")
	public String listarUsuarios(@Valid Usuario usuario, BindingResult result, Model model) {
		try {
			// TODO Código para carregar os chamados
			List<Usuario> usuarios = usuarioService.listarUsuarios(usuario);
			model.addAttribute("usuarios", usuarios);

			return "usuario/ListarUsuarios";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/visualizar_usuario")
	public String visualizarUsuario(@RequestParam int id, @Valid Usuario usuario, BindingResult result, Model model) {
		try {
			// TODO Código para carregar os chamados
			usuario = usuarioService.carregarUsuario(id);
			model.addAttribute("usuario", usuario);

			return "usuario/VisualizarUsuario";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/excluir_usuario")
	public ModelAndView excluirUsuario(@RequestParam int id) throws IOException {
		usuarioService.excluirUsuario(id);
		return new ModelAndView("redirect:/listar_usuarios");
	}

	@RequestMapping("/editar_usuario")
	public String editarUsuario(@Valid Usuario usuario, Model model) {
		try {
			usuarioService.editarUsuario(usuario);
			return "redirect:/listar_usuarios";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/editar_usuario_pesquisa")
	public String editarUsuarioPesquisa(@RequestParam int id, @Valid Usuario usuario, BindingResult result,
			Model model) {
		try {
			// TODO Código para carregar os chamados
			usuario = usuarioService.carregarUsuario(id);
			model.addAttribute("usuario", usuario);

			return "usuario/EditarUsuario";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	/* REPRESA */
	@RequestMapping("/cadastrar_represa")
	public String cadastrarRepresa() {
		return "represa/CadastrarRepresa";
	}

	@RequestMapping("/nova_represa")
	public String novaRepresa(Model model, Represa represa) throws ParseException, IOException {
		represaService.novaRepresa(represa);
		return "redirect:/listar_represas";
	}

	@RequestMapping("/listar_represas")
	public String listarRepresas(@Valid Represa represa, BindingResult result, Model model) {
		try {
			// TODO Código para carregar os chamados
			List<Represa> represas = represaService.listarRepresas();
			model.addAttribute("represas", represas);

			return "represa/ListarRepresas";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	/*@RequestMapping("/buscar_data")
	public String buscarPorData(@RequestParam String nome , @Valid Represa represa, BindingResult result, Model model) throws IOException {
		List<Represa> represas = represaService.buscarPorChave(nome);
		model.addAttribute("represas", represas);
		return "represa/ListarRepresas";
	}*/
	
	@RequestMapping("/buscar_data")
	public String buscarPorData(@RequestParam String dataAbertura , @Valid Represa represa, BindingResult result, Model model) throws IOException {
		List<Represa> represas = represaService.buscarPorChave(dataAbertura);
		model.addAttribute("represas", represas);
		return "represa/ListarRepresas";
	}
	
	@RequestMapping("/visualizar_represa")
	public String visualizarRepresa(@RequestParam int id, @Valid Represa represa, BindingResult result, Model model) {
		try {
			// TODO Código para carregar os chamados
			represa = represaService.carregarRepresa(id);
			model.addAttribute("represa", represa);

			return "represa/VisualizarRepresa";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/relatorio_represa")
	public String gerarRelatorioRepresa(@RequestParam int id, @Valid Represa represa, BindingResult result,
			Model model) {
		try {
			// TODO Código para carregar os chamados
			represa = represaService.carregarRepresa(id);
			model.addAttribute("represa", represa);

			return "represa/RelatorioRepresa";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/excluir_represa")
	public ModelAndView excluirRepresa(@RequestParam int id) throws IOException {
		represaService.excluirRepresa(id);
		return new ModelAndView("redirect:/listar_represas");
	}

	@RequestMapping("/editar_represa")
	public String editarRepresa(@Valid Represa represa, Model model) {
		try {
			represaService.editarRepresa(represa);
			return "redirect:/listar_represas";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/editar_represa_pesquisa")
	public String editarRepresaPesquisa(@RequestParam int id, @Valid Represa represa, BindingResult result,
			Model model) {
		try {
			// TODO Código para carregar os chamados
			represa = represaService.carregarRepresa(id);
			model.addAttribute("represa", represa);

			return "represa/EditarRepresa";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	/* SISTEMA ABASTECIMENTO */
	@RequestMapping("/cadastrar_sistema_abastecimento")
	public String cadastrarSistemaAbastecimento() {
		return "sistema_abastecimento/CadastrarSistemaAbastecimento";
	}

	@RequestMapping("/novo_sistema_abastecimento")
	public String novoSistemaAbastecimento(Model model, SistemaAbastecimento sistemaAbastecimento) {
		try {
			sistemaAbastecimentoService.novoSistemaAbastecimento(sistemaAbastecimento);
			;
			return "redirect:/listar_sistemas_abastecimentos";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/listar_sistemas_abastecimentos")
	public String listarSistemasAbastecimentos(@Valid SistemaAbastecimento sistemaAbastecimento, BindingResult result,
			Model model) {
		try {
			// TODO Código para carregar os chamados
			List<SistemaAbastecimento> sistemasAbastecimentos = sistemaAbastecimentoService
					.listarSistemasAbastecimentos(sistemaAbastecimento);
			model.addAttribute("sistemasAbastecimentos", sistemasAbastecimentos);

			return "sistema_abastecimento/ListarSistemasAbastecimentos";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/visualizar_sistema_abastecimento")
	public String visualizarSistemaAbastecimento(@RequestParam int id, @Valid SistemaAbastecimento sistemaAbastecimento,
			BindingResult result, Model model) {
		try {
			// TODO Código para carregar os chamados
			sistemaAbastecimento = sistemaAbastecimentoService.carregarSistemaAbastecimento(id);
			model.addAttribute("sistemaAbastecimento", sistemaAbastecimento);

			return "sistema_abastecimento/VisualizarSistemaAbastecimento";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/excluir_sistema_abastecimento")
	public ModelAndView excluirSistemaAbastecimento(@RequestParam int id) throws IOException {
		sistemaAbastecimentoService.excluirSistemaAbastecimento(id);
		return new ModelAndView("redirect:/listar_sistemas_abastecimentos");
	}

	@RequestMapping("/editar_sistema_abastecimento")
	public String editarSistemaAbastecimento(@Valid SistemaAbastecimento sistemaAbastecimento, Model model) {
		try {
			sistemaAbastecimentoService.editarSistemaAbastecimento(sistemaAbastecimento);
			return "redirect:/listar_sistemas_abastecimentos";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/editar_sistema_abastecimento__pesquisa")
	public String editarSistemaAbastecimentoPesquisa(@RequestParam int id,
			@Valid SistemaAbastecimento sistemaAbastecimento, BindingResult result, Model model) {
		try {
			// TODO Código para carregar os chamados
			sistemaAbastecimento = sistemaAbastecimentoService.carregarSistemaAbastecimento(id);
			model.addAttribute("sistemaAbastecimento", sistemaAbastecimento);

			return "sistema_abastecimento/EditarSistemaAbastecimento";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

}
