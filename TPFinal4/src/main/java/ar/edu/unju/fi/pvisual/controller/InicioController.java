package ar.edu.unju.fi.pvisual.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleo")
public class InicioController {
    
	Logger logger = LoggerFactory.getLogger(InicioController.class);
	
	@GetMapping("/inicio")
	public String inicio() {
		return "logout";
	}
	
	@GetMapping("/logging")
	public String getLogging(Model model) {
		
		return "logearse";
	}
	
}
