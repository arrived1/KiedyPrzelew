package com.arrived1.kiedyprzelew;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Date paymentTime;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BankDatabase banks = new BankDatabase(this);
		
		setTimePickerProperties();
		
		addItemsToSpinnersList(banks, R.id.spinnerBank1, "Wybierz bank");
		addItemsToSpinnersList(banks, R.id.spinnerBank2, "Wybierz bank");

		addListenerOnButtonSearch(banks, paymentTime);
		addListenerOnButtonReset();
	}

	public void addListenerOnButtonSearch(BankDatabase banks, Date paymentTime) {
//		System.out.println("DUPA, Ktos wcisnal przycisk szukaj");
		final Button button = (Button)findViewById(R.id.buttonFind);
		
//		System.out.println("DUPA, Buduje obiekt ButtonFind, zaraz bede wolal konstruktor");
		button.setOnClickListener(new ButtonFind(this, R.id.buttonFind, banks, paymentTime));
	}
	
	public void addListenerOnButtonReset() {
		final Button button = (Button)findViewById(R.id.buttonReset);
		button.setOnClickListener(new ButtonReset(this, R.id.buttonReset));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
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
