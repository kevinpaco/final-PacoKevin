package ar.edu.unju.fi.pvisual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.pvisual.model.Curso;
import ar.edu.unju.fi.pvisual.model.Usuario;
import ar.edu.unju.fi.pvisual.service.CursoService;
import ar.edu.unju.fi.pvisual.service.UsuarioService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private UsuarioService usuarioService;

	private Long usuarioId;
 
	@GetMapping("/crear")
	public String mostrarCurso(Model model) {
		
		Curso cursos = new Curso("Desarrollo Web",
				"En este curso aprenderás a crear tu sitio web partiendo del prototipo en papel. Te sumergirás en las mejores prácticas del desarrollo web, trabajando con HTML y CSS",
				"Programacion", 0, "02/04/2022", "10 semanas");
		Curso cursos1 = new Curso("Curso de Trading",
				"En este curso aprenderás las nociones centrales del Trading y cómo aplicarlas para operar en el mercado financiero. A su vez, conocerás sobre el manejo de emociones al operar en Trading.",
				"inversiones y Finansas", 0, "23/01/2021", "8 semanas");
		Curso cursos2 = new Curso("After Effects",
				"En este curso aprenderás las nociones básicas de After Effects, el programa por excelencia para crear motion graphics. Comenzarás desde cero y hasta crear tu propia animación, manipulando todo tipo de detalles y movimientos.",
				"Artes Dejitales", 0, "12/12/2021", "12 semanas");
		Curso cursos3 = new Curso("Marketing Digital: Community Manager & Publicidad",
				"En este curso de Community Manager & Publicidad aprenderás cómo crear un plan de Marketing Digital, y también a utilizar las principales herramientas de gestión para negocios digitales.",
				"Marketing Dijital", 0, "02/04/2022", "15 semanas");
		// "En este curso aprenderás a crear tu sitio web partiendo del prototipo en
		// papel. Te sumergirás en las mejores prácticas del desarrollo web, trabajando
		// con HTML y CSS. Conocerás herramientas para optimizar al máximo tu sitio web,
		// implementando prácticas de versionado de código con GIT, y preprocesadores
		// como SASS. Al finalizar, sabrás cómo aplicar Bootstrap a tus proyectos, y
		// comprenderás lo importante del SEO en tus desarrollos. Subirás tu sitio a un
		// servidor, y aprenderás a interactuar con este servicio. También sabrás cómo
		// presentar un presupuesto y atender a tu cliente final."
		cursoService.guardarCurso(cursos);
		cursoService.guardarCurso(cursos1);
		cursoService.guardarCurso(cursos2);
		cursoService.guardarCurso(cursos3);

		// arreglar las veses q el curso se guarda en las base de datos
		return "";
	}
   
	@GetMapping({ "/listar/{id}", "/listar" })
	public String ver(@PathVariable("id") Long id, Curso curso, Model model) {
       
		usuarioId = id;
		
		Curso cursos = new Curso("Desarrollo Web",
				"En este curso aprenderás a crear tu sitio web partiendo del prototipo en papel. Te sumergirás en las mejores prácticas del desarrollo web, trabajando con HTML y CSS",
				"Programacion", 0, "02/04/2022", "10 semanas");
		Curso cursos1 = new Curso("Curso de Trading",
				"En este curso aprenderás las nociones centrales del Trading y cómo aplicarlas para operar en el mercado financiero. A su vez, conocerás sobre el manejo de emociones al operar en Trading.",
				"inversiones y Finansas", 0, "23/01/2021", "8 semanas");
		Curso cursos2 = new Curso("After Effects",
				"En este curso aprenderás las nociones básicas de After Effects, el programa por excelencia para crear motion graphics. Comenzarás desde cero y hasta crear tu propia animación, manipulando todo tipo de detalles y movimientos.",
				"Artes Dejitales", 0, "12/12/2021", "12 semanas");
		Curso cursos3 = new Curso("Marketing Digital: Community Manager & Publicidad",
				"En este curso de Community Manager & Publicidad aprenderás cómo crear un plan de Marketing Digital, y también a utilizar las principales herramientas de gestión para negocios digitales.",
				"Marketing Dijital", 0, "02/04/2022", "15 semanas");
		
		cursoService.guardarCurso(cursos);
		cursoService.guardarCurso(cursos1);
		cursoService.guardarCurso(cursos2);
		cursoService.guardarCurso(cursos3);
		
		model.addAttribute("cursos", cursoService.listarCurso());
		return "cursos";
	}

	@GetMapping("/guardar/{id}")
	public String guardarCurso(@PathVariable("id") Long id, Curso cursos) {

		Curso curso = cursoService.buscarCurso(id);
		System.out.println(curso);
		Usuario usuario = usuarioService.buscarUsuario(usuarioId);
		System.out.println(usuarioId);
		usuario.añadirCurso(curso);
		usuarioService.guardarUsuario(usuario);

		return "redirect:/usuario/principal";
	}
	@GetMapping("/buscar/{id}")
	public String buscarCurso(@PathVariable("id")Long id,Model model) {
		model.addAttribute("cursos", cursoService.buscarCurso(id));
		return "cursos";
	}
}
