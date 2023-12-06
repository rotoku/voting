package br.com.kumabe.votingresult.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.kumabe.votingresult.models.Voting;
import br.com.kumabe.votingresult.services.VotingService;

@Controller
public class VotingResultController {
	private VotingService votingService;
	
	@Autowired
	public VotingResultController(VotingService votingService) {
		this.votingService = votingService;
	}
	
	@GetMapping
	public ModelAndView index() {
		BigDecimal totalDeVotos = votingService.somaTotalDeVotos();
		List<Voting> votings = votingService.list();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("votings", votings);
		modelAndView.addObject("totalDeVotos", totalDeVotos);
		return modelAndView;
	}
	
}
