package ar.edu.unju.fi.pvisual.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.pvisual.model.OfertaLaboral;
import ar.edu.unju.fi.pvisual.model.Usuario;
import ar.edu.unju.fi.pvisual.service.OfertaLaboralService;
import ar.edu.unju.fi.pvisual.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private OfertaLaboralService ofertaService;

	private Long id;

	@GetMapping("/formulario")
	public String getUsuario(Model model) {
		model.addAttribute("datos", new Usuario());
		logger.info("SSe muestra el formulario de Ciudadano");
		return "usuario_form";
	}

	@PostMapping("/guardar")
	public String guardarUsuario(@Validated @ModelAttribute("datos") Usuario datos, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			logger.info("Ubo un error en el formulario");
			model.addAttribute("datos", datos);
			return "usuario_form";
		} else {
			usuarioService.guardarUsuario(datos);
			id = datos.getId();
			logger.info("Se guardo los datos del Ciudadano");
			return "redirect:/empleo/logging";
		}
	}

	private Long idUsuario;
	// Asigno el id del usuario que se busca en este metodo
	private Long idUsuario2 = idUsuario;

	@GetMapping("/principal")
	public String vistaUsusario(Model model, @Param("palabraClave") String palabraClave, Authentication auth,
			HttpSession session) {

		String username = auth.getName();
		Long dni = Long.parseLong(username);
		if (session.getAttribute(username) == null) {
			Usuario usuario = usuarioService.findByDni(dni);
			idUsuario = usuario.getId();
			usuario.setContraseña(null);
			session.setAttribute("g", usuario);
			model.addAttribute("dad", usuarioService.buscarUsuario(usuario.getId()));
			List<OfertaLaboral> listarOferta = ofertaService.filtrarOferta(palabraClave);
			model.addAttribute("datosOfertas", listarOferta);
		}
		/*
		 * model.addAttribute("dad", usuarioService.buscarUsuario(id));
		 * List<OfertaLaboral> listarOferta = ofertaService.filtrarOferta(palabraClave);
		 * idUsuario = id; model.addAttribute("datosOfertas", listarOferta);
		 * model.addAttribute("palabraClave", palabraClave);
		 */
		logger.info("Se muestra la pagina Principal del Ciudadano");
		return "principal_usuario";
	}

	/*
	 * @GetMapping("/principal") public String vistaUsusario(Model model) {
	 * model.addAttribute("dad", usuarioService.buscarUsuario(id));
	 * List<OfertaLaboral> listarOferta = ofertaService.listarOferta(); idUsuario =
	 * id; model.addAttribute("datosOfertas", listarOferta); return
	 * "principal_usuario"; }
	 */

	@GetMapping("/postularse/{id}")
	public String postularUsuario(@PathVariable("id") Long id, Model model) {
		System.out.println(idUsuario2);
		System.out.println(id);
		OfertaLaboral buscarOferta = ofertaService.buscarOferta(id);
		Usuario bucarPostulante = usuarioService.buscarUsuario(idUsuario);

		buscarOferta.añadirUsuario(bucarPostulante);
		ofertaService.guardarOferta(buscarOferta);
		logger.info("el Ciudadano se postula y se envia el curriculum al Empleador");
		return "redirect:/usuario/principal";
	}

	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") Long id, Model model) {
		Usuario usuarioEncontrado = usuarioService.buscarUsuario(id);
		System.out.println("si llego");
		model.addAttribute("datos", usuarioEncontrado);
		idUsuario = usuarioEncontrado.getId();
		logger.info("Se muestra el formulario Editar");
		return "usuario_form";
	}

	// rebisar aqui porque me esta llegando el ID de la oferta laboral en nulo

}
