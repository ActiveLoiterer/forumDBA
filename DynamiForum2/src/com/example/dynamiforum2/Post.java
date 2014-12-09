package com.example.dynamiforum2;

public class Post {
	private String text;
	private String date;
	private String heure;
	private int id_createur;
	private int id_sujet;
	
	public Post(String text, String date, String heure, int id_createur, int id_sujet)
	{
		this.text = text;
		this.date = date;
		this.heure = heure;
		this.id_createur = id_createur;
		this.id_sujet = id_sujet;
	}

	public String getText() {
		return text;
	}

	public String getDate() {
		return date;
	}

	public String getHeure() {
		return heure;
	}

	public int getId_createur() {
		return id_createur;
	}

	public int getId_sujet() {
		return id_sujet;
	}
}
