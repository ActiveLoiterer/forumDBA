package com.example.dynamiforum2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ConnexionActivity extends Activity {
	EditText nom,pass;
	Button connex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_connexion);
		
		nom = (EditText) findViewById(R.id.editNomConnex);
		pass = (EditText) findViewById(R.id.editPassConnex);
		connex = (Button) findViewById(R.id.buttonConnexConnex);
		
		Ecouteur ec = new Ecouteur();
		connex.setOnClickListener(ec);
	}
	private class Ecouteur implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			// verifier la connexion à la BD
			
			// passser à la liste des sujets
			Intent i = new Intent(ConnexionActivity.this, SujetsActivity.class);
			startActivity(i);
		}
		
    }
}
