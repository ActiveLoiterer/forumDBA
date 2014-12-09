package com.example.dynamiforum2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InscriptionActivity extends Activity {
	EditText nom,pass,confPass;
	Button inscr;
	Operations op;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inscription);
		
		nom = (EditText) findViewById(R.id.editNomInscr);
		pass = (EditText) findViewById(R.id.editPassInscr);
		confPass = (EditText) findViewById(R.id.editConfPassInscr);
		inscr = (Button) findViewById(R.id.buttonInscrInscr);
		
		op = new Operations(this);
		
		Ecouteur ec = new Ecouteur();
		inscr.setOnClickListener(ec);
	}
	private class Ecouteur implements OnClickListener
    {
		@Override
		public void onClick(View v) {			
			// verifier la connexion à la BD
			
			// verifier si le nom est entré
			if(nom.getText().toString().length() == 0)
				nom.requestFocus();
			else
			{
				op.ouvrirBD();
				// verifier si le nom est déjà present dans la BD
				
				// si OUI - message d'erreur
				
				// verifier si le mot de passe est le même que sa confirmation
				if(!(pass.getText().toString().equals(confPass.getText().toString())))
				{
					// si NON - effacer les champs de mot de passe,message d'erreur
					pass.setText("");
					confPass.setText("");
					pass.requestFocus();
					op.fermerBD();
				}
				else
				{
					// ajouter le nom et le mot de passe dans la BD
					op.ajouterUsager(new Usager(nom.toString(),pass.toString()));
					// afficher message de confirmation d'inscription
					
					op.fermerBD();
					// retour dans le choix INSCRIPTION/CONNEXION
					finish();
				}	
			}					
		}		
    }
}
