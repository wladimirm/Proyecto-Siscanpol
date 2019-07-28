package gob.ec.siscan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gob.ec.siscan.domain.model.Persona;
import gob.ec.siscan.domain.service.PersonaServicio;


@Controller
public class PersonaController {
	@Autowired
private PersonaServicio personaservicio;
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("list",personaservicio.getall());
		return "index";
	}
	@GetMapping("/save/{id}")
	public String showsave(@PathVariable("id") Long id,Model model)
	{
		if(id != null && id != 0) {
			model.addAttribute("persona", personaservicio.get(id));
		}else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}
	
	
	@PostMapping("/save")
	public String save(Persona persona,Model model)
	{
			personaservicio.save(persona);
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id,Model model)
	{
	personaservicio.delete(id);
		return "redirect:/";
	}
	
	
	
	
	
}
