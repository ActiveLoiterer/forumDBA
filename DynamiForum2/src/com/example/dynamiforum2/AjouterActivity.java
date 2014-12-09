package com.example.dynamiforum2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AjouterActivity extends Activity {
	EditText sujet;
	Button ajouter, annuler;
	Operations op;
	Calendar cal;
	SimpleDateFormat date;
	String dateSujet;
	Hashtable<String,String> temp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajouter);
		
		sujet = (EditText) findViewById(R.id.editSujetAjouter);
		ajouter = (Button) findViewById(R.id.buttonAjouterAjouter);
		annuler = (Button) findViewById(R.id.buttonAnnulerAjouter);
		
		op = new Operations(this);
		
		cal = Calendar.getInstance();
		date = new SimpleDateFormat("yyyy/MM/dd");
		
		Ecouteur ec = new Ecouteur();
		ajouter.setOnClickListener(ec);
		annuler.setOnClickListener(ec);
	}
	private class Ecouteur implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.buttonAjouterAjouter)
			{
				// verifier si le sujet est entré
				if(sujet.getText().toString().length() != 0)
				{
					// trouver la date
					dateSujet = date.format(cal.getTime());
					//time.format(cal.getTime());
					op.ouvrirBD();
					// trouver id_createur
					
					
					// ajouter le nouveau sujet
					op.ajouterSujet(new Sujet(sujet.toString(),0,dateSujet,777));
					op.fermerBD();
					// ajouter le sujet dans le vecteur pour la liste
					temp = new Hashtable<String,String>();
					temp.put("sujet", sujet.getText().toString());
					temp.put("nbSujets", String.valueOf(0));
					temp.put("date", dateSujet);
					SujetsActivity.vecteur.add(temp);
					// retour au choix des sujets
					finish();
					Intent i = new Intent(AjouterActivity.this, SujetsActivity.class);
					startActivity(i);
				}				
			}
			else // bouton annuler - retour au choix des sujets
				finish();
		}
		
	}
}
