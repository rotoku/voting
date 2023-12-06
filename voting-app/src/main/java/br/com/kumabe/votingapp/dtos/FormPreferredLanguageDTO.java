package br.com.kumabe.votingapp.dtos;

import java.io.Serializable;

public class FormPreferredLanguageDTO implements Serializable {
	private static final long serialVersionUID = -3041233079425551757L;
	private String language;
	
	public FormPreferredLanguageDTO() {}

	public FormPreferredLanguageDTO(String language) {
		super();
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
