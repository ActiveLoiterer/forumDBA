package com.example.dynamiforum2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Operations {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	public Operations(Context c)
	{
		databaseHelper = new DatabaseHelper(c);
	}
	public void ouvrirBD()
	{
		database = databaseHelper.getWritableDatabase();
	}
	public void fermerBD()
	{
		database.close();
	}
	public void ajouterUsager(Usager u)
	{
		ContentValues cv = new ContentValues();
		cv.put("nom", u.getNom());
		cv.put("password", u.getPassword());
		database.insert("usager", null, cv);		
	}
	public void ajouterSujet(Sujet s)
	{
		ContentValues cv = new ContentValues();
		cv.put("titre", s.getTitre());
		cv.put("nb_msg", s.getNb_msg());
		cv.put("date_dernier", s.getDate_dernier());
		cv.put("id_createur", s.getId_createur());
		database.insert("sujet", null, cv);
	}
	
	public void ajouterPost(Post p)
	{
		//Il faut ajouter le post et modifier les valeurs du sujet correspondant dans la BD
		ContentValues cv = new ContentValues();
		cv.put("text", p.getText());
		cv.put("date", p.getDate());
		cv.put("heure", p.getHeure());
		cv.put("id_createur", p.getId_createur());
		cv.put("id_sujet", p.getId_sujet());
		database.insert("post", null, cv);
		
		updateSujet(p);
	}
	
	public void updateSujet(Post p)
	{
		//nb_msg INTEGER,date_dernier
		database.execSQL("UPDATE sujet SET nb_msg = nb_msg + 1, date_dernier = ?, WHERE _id = ?", new String [] {p.getDate(), String.valueOf((p.getId_sujet() )) });
	}
}
