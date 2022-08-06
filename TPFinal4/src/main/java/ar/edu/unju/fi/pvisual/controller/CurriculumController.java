package ar.edu.unju.fi.pvisual.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import ar.edu.unju.fi.pvisual.model.Curriculum;
import ar.edu.unju.fi.pvisual.model.Usuario;
import ar.edu.unju.fi.pvisual.service.CurriculumService;
import ar.edu.unju.fi.pvisual.service.UsuarioService;

@Controller
@RequestMapping("/curriculum")
public class CurriculumController {

	Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private CurriculumService curriculumService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private Curriculum curriculum;

	
	@GetMapping("/nuevo/{id}")
	public String MostrarCurri(@PathVariable("id")Long id, Model model) {	
		 Usuario idUsuario = usuarioService.buscarUsuario(id);
		 curriculum.setUsuario(idUsuario);
		 model.addAttribute("datos",new Curriculum());
		 logger.info("Se muestra el formulario de curriculum");
		 model.addAttribute("dad", usuarioService.buscarUsuario(id));
		return "curriculum";
	}
	
	@PostMapping("/guardar/{id}")
	public String guardarCurriculum(
			@Validated @ModelAttribute("curriculum") Curriculum curriculum,BindingResult bindingResult,@PathVariable("id")Long id, ModelMap model ) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("datos", curriculum);
			return "curriculum";
		}else {
		Usuario encontrarUsuario = usuarioService.buscarUsuario(id);
		curriculum.setUsuario(encontrarUsuario);
		curriculumService.guardarCurricullum(curriculum);
		
        encontrarUsuario.setNombre(curriculum.getNombre());
        usuarioService.guardarUsuario(encontrarUsuario);
		logger.info("Se guarda el Curriculum");
		 return "redirect:/usuario/principal";}
	}
	
	@GetMapping("/editar/{id}")
	public String editarCurriculum(@PathVariable("id")Long id,Model model) {
		Curriculum buscarCurriculum = usuarioService.buscarUsuario(id).getCurriculum().get(0);
		model.addAttribute("datos", buscarCurriculum);
		return "curriculum";
	}
}
