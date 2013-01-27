package com.arrived1.kiedyprzelew;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BankDatabase banks = new BankDatabase(this);
		
		addListenerOnButtonSearch();
		addListenerOnButtonReset();
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
