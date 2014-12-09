package com.example.dynamiforum2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	public DatabaseHelper(Context context) {
		super(context, "bdDynamiForum", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase bdDynamiForum) {
		// créer les tables
		
		bdDynamiForum.execSQL("CREATE TABLE usager(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT,password TEXT);");
		//bdDynamiForum.execSQL("CREATE TABLE usager(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT PRIMARY KEY,password TEXT);");
		
		bdDynamiForum.execSQL("CREATE TABLE sujet(_id INTEGER PRIMARY KEY AUTOINCREMENT, titre TEXT,nb_msg INTEGER,date_dernier TEXT,id_createur INTEGER,FOREIGN KEY(id_createur) REFERENCES usager(id));");
		bdDynamiForum.execSQL("CREATE TABLE post(_id INTEGER PRIMARY KEY AUTOINCREMENT, text TEXT, date TEXT, heure TEXT,id_createur INTEGER,id_sujet INTEGER,FOREIGN KEY(id_createur) REFERENCES usager(id),FOREIGN KEY(id_sujet) REFERENCES sujet(id));");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase bdDynamiForum, int oldVersion, int newVersion) {
		bdDynamiForum.execSQL("DROP TABLE IF EXIST post");
		bdDynamiForum.execSQL("DROP TABLE IF EXIST sujet");
		bdDynamiForum.execSQL("DROP TABLE IF EXIST usager");
		onCreate(bdDynamiForum);		
	}
	/*
	public void ajouterSujet (Equipe e, SQLiteDatabase db)
	{
		ContentValues cv = new ContentValues();
		cv.put("nom", e.getNom());
		cv.put("division", e.getDivision());
		cv.put("arena", e.getArena());
		cv.put("capacite", e.getCapacite());
		
		db.insert("villes", null, cv);
	}*/
}
