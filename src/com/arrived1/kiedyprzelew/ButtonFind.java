package com.arrived1.kiedyprzelew;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ButtonFind extends MyButton {
	private BankDatabase banks;

	public ButtonFind(Activity activity_, int activityId_, BankDatabase banks_) {
		super(activity_, activityId_);		
		this.banks = banks_;
	}
	
	public void onClick(View arg0) {
		final TimePicker picker = (TimePicker)actv.findViewById(R.id.insertTime);
		Date paymentTime = new Date(picker.getCurrentHour(), picker.getCurrentMinute());

		Spinner spinn1 = (Spinner)actv.findViewById(R.id.spinnerBank1);
		Spinner spinn2 = (Spinner)actv.findViewById(R.id.spinnerBank2);
		
		if(spinn1.getSelectedItemPosition() == 0 || spinn2.getSelectedItemPosition() == 0) {
			Toast toast= Toast.makeText(actv.getApplicationContext(), "Wybierz bank!", Toast.LENGTH_SHORT);  
					toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
					toast.show();
		}
		else if(spinn1.getSelectedItemPosition() == spinn2.getSelectedItemPosition()) {
			TextView pokazCzas = (TextView)actv.findViewById(R.id.deliveryTime);
			pokazCzas.setTextSize(21.f);
			pokazCzas.setText("Przelew natychmiastowy");
		}
		else {
			String zBankuNazwa = spinn1.getSelectedItem().toString();
			String doBankuNazwa = spinn2.getSelectedItem().toString();
			
			Bank zBanku = banks.findBank(zBankuNazwa);
			Bank doBanku = banks.findBank(doBankuNazwa);
	
			Date zBankuWychodzacy = zBanku.getNearestOutgoingTime(paymentTime);
			Date doBankuPrzychodzacy = doBanku.getNearestIncomingTime(zBankuWychodzacy);
	
			TextView pokazCzas = (TextView)actv.findViewById(R.id.deliveryTime);
			pokazCzas.setTextSize(36.f);
			pokazCzas.setText(doBankuPrzychodzacy.toString());
	
			TextView nastepnegoDnia = (TextView)actv.findViewById(R.id.nextDay);
			nastepnegoDnia.setText("");
			if(zBankuWychodzacy.isNextDay()) {
				nastepnegoDnia.setText("Następnego dnia");
			}
		}
	}

}
