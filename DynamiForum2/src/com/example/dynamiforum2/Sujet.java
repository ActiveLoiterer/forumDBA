package com.example.dynamiforum2;

public class Sujet {
	private String titre;
	private int nb_msg;
	private String date_dernier;
	private int id_createur;
	
	public Sujet(String titre, int nb_msg, String date_dernier,int id_createur)
	{
		this.titre = titre;
		this.nb_msg = nb_msg;
		this.date_dernier = date_dernier;
		this.id_createur = id_createur;
	}

	public String getTitre() {
		return titre;
	}

	public int getNb_msg() {
		return nb_msg;
	}

	public String getDate_dernier() {
		return date_dernier;
	}

	public int getId_createur() {
		return id_createur;
	}
	
}
