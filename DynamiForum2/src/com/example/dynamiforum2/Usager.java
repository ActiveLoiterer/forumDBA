package com.example.dynamiforum2;

public class Usager {
	private String nom;
	private String password;
	
	public Usager(String nom, String password)
	{
		this.nom = nom;
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public String getPassword() {
		return password;
	}
}
