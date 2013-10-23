package org.example.intentaction;

import javax.inject.Inject;

import roboguice.activity.RoboListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends RoboListActivity {

	@Inject Intents intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String[] opcoes = new String[]{"Picture","PDF","Text","Audio","Video","CHM","DOC","XLS","PPT","HTML","MAP","CALL","SMS","CALL to SMS","MMS","EMAIL","EMAIL with BODY","EMAIL with BODY TO CC","EMAIL ATTCH","UNISTALL","INSTALL","SEARCH","WEB BROWSER","SENDTEXT","SHORTCUT"};
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes);
		
		setListAdapter(adaptador);
	}

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Intent i = null;
				
		switch (position) {
		case 0:
			i = intent.actionPicture();
			break;
		case 1:
			i = intent.actionPDF();
			break;
		case 2:
			i = intent.actionText();
			break;
		case 3:
			i = intent.actionAudio();
			break;
		case 4:
			i = intent.actionVideo();
			break;
		case 5:
			i = intent.actionCHM();
			break;
		case 6:
			i = intent.actionDOC();
			break;
		case 7:
			i = intent.actionXLS();
			break;
		case 8:
			i = intent.actionPPT();
			break;
		case 9:
			i = intent.actionHTML();
			break;
		case 10:
			i = intent.actionMAP();
			break;
		case 11:
			i = intent.actionCALL();
			break;
		case 12:
			i = intent.actionSMS();
			break;
		case 13:
			i = intent.actionCALLtoSMS();
			break;
		case 14:
			i = intent.actionMMS();
			break;
		case 15:
			i = intent.actionEMAIL();
			break;
		case 16:
			i = intent.actionEMAILBODY();
			break;
		case 17:
			i = intent.actionEMAILBODYTOCC();
			break;
		case 18:
			i = intent.actionEMAILATTACH();
			break;
		case 19:
			i = intent.actionUNISTALL();
			break;
		case 20:
			i = intent.actionINSTALL();
			break;
		case 21:
			i = intent.actionSEARCH();
			break;
		case 22:
			i = intent.actionWEBBROWSER();
			break;
		case 23:
			i = intent.actionSENDTEXT();
			break;
		case 24:
			intent.actionSHORTCUT();
			break;
		default:
			System.err.println("PADRAO");
		}
		
		if(i != null){
			System.out.println("Não esta null");
			startActivity(i);
		} else {
			System.out.println("MERDA");
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
