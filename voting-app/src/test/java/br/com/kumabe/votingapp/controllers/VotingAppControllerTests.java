package br.com.kumabe.votingapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import br.com.kumabe.votingapp.dtos.FormPreferredLanguageDTO;
import br.com.kumabe.votingapp.services.VotingAppService;

public class VotingAppControllerTests {
	private VotingAppController votingAppController;
	private VotingAppService votingAppService;
	
	@BeforeEach
	public void setUp() {
		this.votingAppService = Mockito.mock(VotingAppService.class);
		this.votingAppController = new VotingAppController(votingAppService);		
	}
	
	@Test
	public void testIndex() {
		ModelAndView modelAndView = this.votingAppController.index();
		assertEquals("index", modelAndView.getViewName());
	}
	
	@Test
	public void testSuccess() {
		ModelAndView modelAndView = this.votingAppController.success();
		assertEquals("success", modelAndView.getViewName());
	}
	
	@Test
	public void testCreate() {
		FormPreferredLanguageDTO formPreferredLanguageDTO = new FormPreferredLanguageDTO();
		String language = "java";
		formPreferredLanguageDTO.setLanguage(language);
		when(votingAppService.retrieve(language)).thenReturn(10L);
		ModelAndView modelAndView = this.votingAppController.create(formPreferredLanguageDTO, new ModelMap());
		assertNotNull(modelAndView);
	}
}
