package com.example.dynamiforum2;

import java.util.Hashtable;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SujetsActivity extends Activity {
	ListView listeSujets;
	static Vector<Hashtable<String,String>> vecteur = new Vector<Hashtable<String,String>>();
	Button ajouter;
	Hashtable<String,String> map;
	//Hashtable<String,String> temp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sujets);
		
		listeSujets = (ListView) findViewById(R.id.listSujetsSujets);
		ajouter = (Button) findViewById(R.id.buttonAjouterSujets);
				
		
		SimpleAdapter adapteur = new SimpleAdapter(
				this, 
				vecteur, 
				R.layout.element_de_sujets, 
				new String[]{"sujet","nbSujets","date"}, 
				new int[]{R.id.textSujetElemsuj,R.id.textNbsujElemsuj,R.id.textDateElemsuj});
		listeSujets.setAdapter(adapteur);
		
		Ecouteur ec = new Ecouteur();
		listeSujets.setOnItemClickListener(ec);
		listeSujets.setOnItemLongClickListener(ec);
		ajouter.setOnClickListener(ec);
	}
	private class Ecouteur implements OnItemClickListener, OnClickListener, OnItemLongClickListener
	{
		@Override
		public void onClick(View v) {
			// passser à Ajouter
			Intent i = new Intent(SujetsActivity.this, AjouterActivity.class);
			startActivity(i);
			// todo - fermer activité...
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View sujetSelectionne, int position,
				long id) {
			// choisir le sujet
			map = (Hashtable<String,String>)listeSujets.getItemAtPosition(position);
			
			
			Intent i = new Intent(SujetsActivity.this, DiscussionActivity.class);
			Intent current = getIntent();
			String nom = current.getStringExtra("nom");
			//Faut aller chercher le nom du sujet...
			//int id_sujet = ...
			
			//Ensuite il faut putExtra le nom de l'usager et le id Sujet, pour pouvoir créer les posts
			
			startActivity(i);
		}
		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			// si createur - supprimer
			
			return false;
		}
	}
	public String getTitreSujet()
	{
		return map.get("sujet");
	}
}
