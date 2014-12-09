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
		cv.put("pssword", u.getPassword());
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
}
