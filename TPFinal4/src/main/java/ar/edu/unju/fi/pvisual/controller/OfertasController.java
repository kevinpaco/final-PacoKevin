package ar.edu.unju.fi.pvisual.controller;

import java.util.ArrayList;
import java.util.List; 
import java.util.Optional;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.pvisual.model.Curriculum;
import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.model.OfertaLaboral;
import ar.edu.unju.fi.pvisual.model.Usuario;
import ar.edu.unju.fi.pvisual.service.CurriculumService;
import ar.edu.unju.fi.pvisual.service.IEmpleadorService;
import ar.edu.unju.fi.pvisual.service.OfertaLaboralService;
import ar.edu.unju.fi.pvisual.service.UsuarioService;

@Controller
@RequestMapping("/oferta")
public class OfertasController {

	Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private OfertaLaboralService ofertaLaboralService;
	@Autowired
	private OfertaLaboral ofertasLaborales;
     @Autowired
     private IEmpleadorService encontrarEmpleador;
     
     @Autowired
     private UsuarioService usuarioService; 
     
     @Autowired
     private CurriculumService curriculumService;
     
     private Long idEmpleador;
     
	@GetMapping("/crear/{id}")
	public String getOfertar( @PathVariable("id") Long id, Model model) {
        Empleador encontrado = encontrarEmpleador.bucarEmpleador(id);
	    idEmpleador = id;
        ofertasLaborales.setEmpleador(encontrado);
        model.addAttribute("ofertas", ofertasLaborales);
        
        model.addAttribute("datos", encontrarEmpleador.bucarEmpleador(id));
        logger.info("Se muestra el formulario para crear una oferta Laboral");
		return "crear_oferta";
	}
	
	@PostMapping("/guardar")
	public String guardarOferta(@Valid @ModelAttribute("oferta")OfertaLaboral oferta,BindingResult bindingResult, ModelMap model ) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("ofertas", oferta);
			logger.info("Si ubo error se buelve a mostrar el fomulario");
			return "crear_oferta";
		}else {
			oferta.setEmpleador(encontrarEmpleador.bucarEmpleador(idEmpleador));
			ofertaLaboralService.guardarOferta(oferta);
			logger.info("Se guarda la oferta");
			return "redirect:/empleador/principal";
		}
	}

	   Long idOferta1;
		@GetMapping("/postulante/{id}")
		public String verDatosPostulante(@PathVariable("id")Long id,Model model) {
			/*List<Usuario> listPostulante = ofertaLaboralService.buscarOferta(id).getUsuario();	  
		    Usuario buscarPostulante = usuarioService.buscarUsuario(listPostulante.get(0).getId());
		    Long b = buscarPostulante.getId();
		    System.out.println(b);*/			
			List<Usuario> listOferta2 = ofertaLaboralService.buscarOferta(id).getUsuario();
		   
		   List<Curriculum> listCurriculum = ofertaLaboralService.buscarOferta(id).getUsuario().get(0).getCurriculum();
		   System.out.println(listCurriculum.get(0).getId());
			/*List<Curriculum> listCurriculum = buscarPostulante.getCurriculum();		  
		    for(int i=0;i<listCurriculum.size();i++) {
		           System.out.println(i);
		    }*/
		      //Aqui tengo que enviar listCurriculum porque listOferta2 solo esta de prueva y los dos solo debuelven 1 objeto
		       model.addAttribute("datoPostulante", listOferta2 );
		       model.addAttribute("idOferta", ofertaLaboralService.buscarOferta(id));
		       OfertaLaboral buscarOferta = ofertaLaboralService.buscarOferta(id);
				idOferta1 = buscarOferta.getId();
				
		       buscarOferta.setCantidadVacantes(buscarOferta.getCantidadVacantes()-1);
				ofertaLaboralService.guardarOferta(buscarOferta);
		       logger.info("Se muestra la informacion del Postulante");
			return "ver_dato_postulante";
		}
		
		  @GetMapping("/eliminar/{id}")
		    public String eliminarOferta(@PathVariable("id")Long id) {
		    	 
		    	ofertaLaboralService.eliminarOferta(id);
		    	logger.info("Se elimina la ofefrta");
		    	return "redirect:/empleador/principal";
		    }
		  
		  @GetMapping("/perfiles") 
		  public String perfilesPostulantes(@Param("palabraClave")String palabraClave,Model model) {
			  
			  model.addAttribute("datosPostulante", usuarioService.filtrarProvincia(palabraClave));
			  
			  return "perfiles";
		  }
		  
		  @GetMapping("/datoPostulante/{id}")
		  public String datoPsotulantes(@PathVariable("id")Long id,Model model) {
			  
			  Curriculum buscarCurriculum = curriculumService.buscarCurricullum(usuarioService.buscarUsuario(id).getCurriculum().get(0).getId());
			  model.addAttribute("datoPostulante", buscarCurriculum);
			  
			  OfertaLaboral listOferta = ofertaLaboralService.buscarOferta(idOferta1);
			  model.addAttribute("idOferta", listOferta);
			  System.out.println(listOferta.getId());
			  return "ver-curriculum-postulante";
		  }
}
