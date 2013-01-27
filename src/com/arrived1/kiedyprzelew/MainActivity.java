package com.arrived1.kiedyprzelew;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BankDatabase banks = new BankDatabase(this);
		addItemsToSpinnersList(banks, R.id.spinnerBank1, "Przelew z banku");
		addItemsToSpinnersList(banks, R.id.spinnerBank2, "Przelew do banku");
		
		addListenerOnButtonSearch();
		addListenerOnButtonReset();
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

	public void addListenerOnButtonSearch() {
		final Button button = (Button)findViewById(R.id.buttonFind);
		button.setOnClickListener(new ButtonFind(this, R.id.buttonFind));
	}
	
	public void addListenerOnButtonReset() {
		final Button button = (Button)findViewById(R.id.buttonReset);
		button.setOnClickListener(new ButtonReset(this, R.id.buttonReset));
	}
	
	public void showTimePickerDialog(View v) {
	    DialogFragment newFragment = new TimePickerFragment();
	    newFragment.show(getFragmentManager(), "timePicker");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
