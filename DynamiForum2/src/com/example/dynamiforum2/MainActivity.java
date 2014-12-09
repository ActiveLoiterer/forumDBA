package com.example.dynamiforum2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button inscr,connex;
	//Operations op;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inscr = (Button) findViewById(R.id.buttonInscrMain);
		connex = (Button) findViewById(R.id.buttonConnexMain);
		
		//op = new Operations(this);
		//op.ouvrirBD();
		
		Ecouteur ec = new Ecouteur();
		inscr.setOnClickListener(ec);
		connex.setOnClickListener(ec);
	}
	/*
	protected void onStop(){
		super.onStop();
		op.fermerBD();
	}*/
	private class Ecouteur implements OnClickListener
    {
		
		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.buttonInscrMain) //inscription
			{
				// verifier la connexion à la BD
				
				// passer à l'inscription
				Intent i = new Intent(MainActivity.this, InscriptionActivity.class);
				startActivity(i);
			}
			else
			{
				// verifier la connexion à la BD
				
				// passer à la connexion
				Intent i = new Intent(MainActivity.this, ConnexionActivity.class);
				startActivity(i);
			}
		}
    }
}
