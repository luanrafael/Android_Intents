package org.example.intentaction;

import java.io.File;

import roboguice.activity.RoboActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

public class Intents extends RoboActivity {

	String sdcard = Environment.getExternalStorageDirectory() + "/exercicio/";

	public Intent actionPicture() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.jpg"));
		intent.setDataAndType(uri, "image/*");
		System.out.println(sdcard);
		System.out.println(uri);
		return intent;
	}

	public Intent actionPDF() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.pdf"));
		intent.setDataAndType(uri, "application/pdf");
		return intent;
	}

	public Intent actionText() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.txt"));
		intent.setDataAndType(uri, "text/plain");
		return intent;
	}

	public Intent actionAudio() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("oneshot", 0);
		intent.putExtra("configchange", 0);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.m4a"));
		intent.setDataAndType(uri, "audio/*");
		return intent;
	}

	public Intent actionVideo() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("oneshot", 0);
		intent.putExtra("configchange", 0);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.mp4"));
		intent.setDataAndType(uri, "video/*");
		return intent;
	}
	//Não teste... precisa de um arquivo .CHM
	public Intent actionCHM() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.chm"));
		intent.setDataAndType(uri, "application/x-chm");
		return intent;
	}

	public Intent actionDOC() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.doc"));
		intent.setDataAndType(uri, "application/msword");
		return intent;
	}

	public Intent actionXLS() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.xls"));
		intent.setDataAndType(uri, "application/vnd.ms-excel");
		return intent;
	}

	public Intent actionPPT() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(sdcard + "exercicio.ppt"));
		intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
		return intent;
	}

	public Intent actionHTML() {
		Uri uri = Uri.parse("http://www.google.com");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		return intent;
	}

	public Intent actionMAP() {
		Uri uri = Uri.parse("geo: -23.162191, -45.795469");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		return intent;
	}

	public Intent actionCALL() {
		Uri uri = Uri.parse("tel: 102");
		Intent intent = new Intent(Intent.ACTION_DIAL, uri);
		return intent;
	}

	public Intent actionSMS() {
		Uri uri = Uri.parse("smsto: 102");
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		intent.putExtra("sms_body", "The SMS text");
		return intent;
	}

	public Intent actionCALLtoSMS() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.putExtra("sms_body", "The SMS text");
		intent.setType("vnd.android-dir/mms-sms");
		return intent;
	}

	public Intent actionMMS() {
		Uri uri = Uri.parse("content://media/external/images/media/23");
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra("sms_body", "some text");
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		intent.setType("image/png");
		return intent;
	}

	public Intent actionEMAIL() {
		Uri uri = Uri.parse("mailto: xxx@abc.com");
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		return intent;
	}

	public Intent actionEMAILBODY() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_EMAIL, "me@abc.com");
		intent.putExtra(Intent.EXTRA_TEXT, "The email body text");
		intent.setType("text/plain");
		return Intent.createChooser(intent, "Choose Email Client");
	}

	public Intent actionEMAILBODYTOCC() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		String[] tos = { "me@abc.com" };
		String[] ccs = { "you@abc.com" };
		intent.putExtra(Intent.EXTRA_EMAIL, tos);
		intent.putExtra(Intent.EXTRA_CC, ccs);
		intent.putExtra(Intent.EXTRA_TEXT, "The email body text");
		intent.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
		intent.setType("message/rfc822");
		return Intent.createChooser(intent, "Choose Email Client");
	}

	public Intent actionEMAILATTACH() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
		intent.putExtra(Intent.EXTRA_STREAM, sdcard + "exercicio.mp3");
		intent.setType("audio/mp3");
		return Intent.createChooser(intent, "Choose Email Client");
	}

	public Intent actionUNISTALL() {
		Uri uri = Uri.parse("package:org.example.intentaction");
		Intent intent = new Intent(Intent.ACTION_DELETE, uri);
		return intent;
	}

	//Não esta funcionando
	public Intent actionINSTALL() {
		Uri uri = Uri.parse("package:org.example.intentaction");
		Intent intent = new Intent(Intent.ACTION_PACKAGE_ADDED, uri);
		return intent;
	}

	public Intent actionSEARCH() {
		Uri uri = Uri
				.parse("https://play.google.com/store/apps/details?id=pt.portoeditora.android.dicionario.lingua_portuguesa");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		return intent;
	}

	public Intent actionWEBBROWSER() {
		Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
		String term = "Android";
		intent.putExtra(SearchManager.QUERY, term);
		return intent;
	}

	public Intent actionSENDTEXT() {
		Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
		String msgBody = "This is message";
		intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "message subject");
		intent.putExtra(Intent.EXTRA_TEXT, msgBody);
		return Intent.createChooser(intent, "TESTE");
	}

	//Não esta funcionando
	public Intent actionSHORTCUT() {
		Intent shortcutIntent = new Intent(getApplicationContext(),
				MainActivity.class);

		shortcutIntent.setAction(Intent.ACTION_MAIN);

		Intent addIntent = new Intent();
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "HelloWorldShortcut");
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
				Intent.ShortcutIconResource.fromContext(
						getApplicationContext(), R.drawable.ic_launcher));

		addIntent.setAction("android.permission.INSTALL_SHORTCUT");
		return addIntent;
	}
}
