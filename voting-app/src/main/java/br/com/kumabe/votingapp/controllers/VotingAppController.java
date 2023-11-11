package br.com.kumabe.votingapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.kumabe.votingapp.dtos.FormPreferredLanguageDTO;
import br.com.kumabe.votingapp.services.VotingAppService;

@Controller
public class VotingAppController {
	private static final Logger LOGGER = LoggerFactory.getLogger(VotingAppController.class);
	
	private VotingAppService votingAppService;
	
	@Autowired
	public VotingAppController(VotingAppService votingAppService) {
		this.votingAppService = votingAppService;		
	}

	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@GetMapping("/success")
	public ModelAndView success() {
		ModelAndView modelAndView = new ModelAndView("success");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView create(@ModelAttribute FormPreferredLanguageDTO formPreferredLanguageDTO) {
		String language = formPreferredLanguageDTO.getLanguage();
		LOGGER.info("Voto para a linguagem: {}", language);
		String key = language;
		Object value = votingAppService.retrieve(key);
		if(value == null) {
			value = 1L;
		}else {
			Long prior = (Long)value;
			Long actual = prior + 1;
			value = actual;
		}
		votingAppService.create(key, value);
		ModelAndView modelAndView = new ModelAndView("redirect:/success");
		modelAndView.addObject("language", language);
		return modelAndView;
	}
	
}
