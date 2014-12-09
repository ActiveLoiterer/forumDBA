package com.example.dynamiforum2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DiscussionActivity extends Activity {
	//TextView titre;
	String titre;
	ListView listeDiscussions;
	Vector<Hashtable<String,String>> vecteur;
	EditText ajoutDiscussion;
	Button retour, ajouter;
	Calendar cal;
	SimpleDateFormat date;
	SimpleDateFormat heure;
	String dateDisc;
	String heureDisc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discussion);
		
		//titre = (TextView) findViewById(R.id.textTitreDiscussion);
		listeDiscussions = (ListView) findViewById(R.id.listDiscussDiscussion);
		ajoutDiscussion = (EditText) findViewById(R.id.editDiscussDiscussion);
		retour = (Button) findViewById(R.id.buttonRetourDiscussion);
		ajouter = (Button) findViewById(R.id.buttonAjouterDiscussion);
		
		vecteur = new Vector<Hashtable<String,String>>();
		
		SimpleAdapter adapteur = new SimpleAdapter(
				this, 
				vecteur, 
				R.layout.element_de_discussion, 
				new String[]{"nom","discussion","date","heure"}, 
				new int[]{R.id.textNomElemdisc,R.id.textDiscElemdisc,R.id.textDateElemdisc,R.id.textHeureElemdisc});
		listeDiscussions.setAdapter(adapteur);
		
		cal = Calendar.getInstance();
		date = new SimpleDateFormat("yyyy/MM/dd");
		heure = new SimpleDateFormat("hh:mm:ss");
		
		Ecouteur ec = new Ecouteur();
		listeDiscussions.setOnItemClickListener(ec);
		listeDiscussions.setOnItemLongClickListener(ec);
		retour.setOnClickListener(ec);
		ajouter.setOnClickListener(ec);
	}
	private class Ecouteur implements OnItemClickListener, OnClickListener, OnItemLongClickListener
	{
		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			// si createur - supprimer
			
			return false;
		}

		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.buttonAjouterDiscussion)
			{
				// ajouter son post au sujet choisi
				
			}
			else // retour au choix des sujets
				finish();
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
