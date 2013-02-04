package com.arrived1.kiedyprzelew;

import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

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
		String zBankuNazwa = spinn1.getSelectedItem().toString();
		Bank zBanku = banks.findBank(zBankuNazwa);
		
		Spinner spinn2 = (Spinner)actv.findViewById(R.id.spinnerBank2);
		String doBankuNazwa = spinn2.getSelectedItem().toString();
		Bank doBanku = banks.findBank(doBankuNazwa);

		Date zBankuWychodzacy = zBanku.getNearestOutgoingTime(paymentTime);
		Date doBankuPrzychodzacy = doBanku.getNearestIncomingTime(zBankuWychodzacy);

		TextView pokazCzas = (TextView)actv.findViewById(R.id.deliveryTime);
		pokazCzas.setText(doBankuPrzychodzacy.toString());
	}

}
