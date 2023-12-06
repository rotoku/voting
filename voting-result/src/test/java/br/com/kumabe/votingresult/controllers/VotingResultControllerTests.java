package br.com.kumabe.votingresult.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import br.com.kumabe.votingresult.services.VotingService;

public class VotingResultControllerTests {
	private VotingResultController votingResultController;
	private VotingService votingService;
	
	@BeforeEach
	public void setUp() {
		this.votingService = Mockito.mock(VotingService.class);
		this.votingResultController = new VotingResultController(votingService);
	}
	
	@Test
	public void testIndex() {
		ModelAndView modelAndView = this.votingResultController.index();
		assertEquals("index", modelAndView.getViewName());
	}
}
