package ar.edu.unju.fi.pvisual.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.model.OfertaLaboral;
import ar.edu.unju.fi.pvisual.model.Usuario;
import ar.edu.unju.fi.pvisual.service.IEmpleadorService;
import ar.edu.unju.fi.pvisual.service.OfertaLaboralService;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

	Logger logger = LoggerFactory.getLogger(EmpleadorController.class);

	@Autowired
	private IEmpleadorService empleadorService;
	
	private Long id;
	
	@GetMapping("/formulario")
	public String getEmpleador(Model model) {
		model.addAttribute("datosEmpleador", new Empleador());
		logger.info("Muestro el formulario del Empleador");
		return "empleador_form";
	}

	@PostMapping("/guardar")
	public String empleadoGuardar(@Valid @ModelAttribute("datosEmpleador") Empleador empleador,BindingResult bindingResult, ModelMap model) {

		if(bindingResult.hasErrors()) {
			logger.info("Si ubo error se muestra de nuevo el formulario del Empleador");
			model.addAttribute("datosEmpleador", empleador);
			return "empleador_form";
		}else {
			
			empleadorService.guardarEmpleador(empleador);
			logger.info("Guardo los datos de Empleador");
			id = empleador.getId();
			return "redirect:/empleo/logging";
		}
	}

	@GetMapping("/principal")
	public String VerDatosEmpleador(Model model,Authentication auth,HttpSession session) {
		
		String username = auth.getName();
		Long cuit = Long.parseLong(username);
		if(session.getAttribute(username)==null) {
			 Empleador buscar = empleadorService.findByCuit(cuit);
			 buscar.setContrasena(null);
			 session.setAttribute("d", buscar);
			 model.addAttribute("datos", empleadorService.bucarEmpleador(buscar.getId()));			 
			
			 //se buscar el id de empleador q esta en la tabla Oferta_Empleos
			 List<OfertaLaboral> traerOferta = empleadorService.bucarEmpleador(buscar.getId()).getOfertas();
				
		     model.addAttribute("ofertas", traerOferta);
		}	  		
		logger.info("Se muestra la pagina principal del Empleador");
		return "principal";
	}

	@GetMapping("/editar/{id}")
	public String editarEmp(@PathVariable("id") Long id, Model model) {
		Empleador modEmpleador = empleadorService.bucarEmpleador(id);
		model.addAttribute("datosEmpleador", modEmpleador);
		logger.info("Se muestra el formulario editar");
		model.addAttribute("datos", empleadorService.bucarEmpleador(id));
		return "empleador_form";

	}
	
}
