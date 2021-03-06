package com.arrived1.kiedyprzelew;

import java.util.ArrayList;
import java.util.List;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	private Date paymentTime;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addAdView();
		
		BankDatabase banks = new BankDatabase(this);
		
		setTimePickerProperties();
		
		addItemsToSpinnersList(banks, R.id.spinnerBank1, "Przelew z banku");
		addItemsToSpinnersList(banks, R.id.spinnerBank2, "Przelew do banku");

		addListenerOnButtonSearch(banks, paymentTime);
		addListenerOnButtonReset();
	}

	public void addListenerOnButtonSearch(BankDatabase banks, Date paymentTime) {
		final Button button = (Button)findViewById(R.id.buttonFind);
		button.setOnClickListener(new ButtonFind(this, R.id.buttonFind, banks));
	}
	
	public void addListenerOnButtonReset() {
		final Button button = (Button)findViewById(R.id.buttonReset);
		button.setOnClickListener(new ButtonReset(this, R.id.buttonReset));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.activity_main, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.about_program:
	        	Intent myIntentAboutPtogram = new Intent(MainActivity.this, AboutProgram.class);
	            startActivity(myIntentAboutPtogram);
	            return true;
	        case R.id.bank_list:
	        	Intent myIntentBank = new Intent(MainActivity.this, BankList.class);
	            startActivity(myIntentBank);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	private void addAdView() {
		AdView ad = (AdView) findViewById(R.id.adView);
		ad.loadAd(new AdRequest());
	}
	
	private void setTimePickerProperties() {
		final TimePicker picker = (TimePicker)findViewById(R.id.insertTime);
		picker.setIs24HourView(true);
	}

	private void addItemsToSpinnersList(BankDatabase banks, int spinId, String initString) {
		List<String> list = new ArrayList<String>();
		list.add(initString);
		for(int i = 0; i < banks.size(); i++)
			list.add(banks.getBankName(i));
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		final Spinner spinn = (Spinner)findViewById(spinId);
		spinn.setAdapter(dataAdapter);
	}
}
