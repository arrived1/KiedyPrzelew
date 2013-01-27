package com.arrived1.kiedyprzelew;

import java.text.ParseException;

import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
//import android.widget.Toast;

public class ButtonFind extends MyButton {
	private BankDatabase banks;
	private Date paymentTime;

	public ButtonFind(Activity activity_, int activityId_, BankDatabase banks_, Date paymentTime_) {
		super(activity_, activityId_);
		System.out.println("DUPA, Konstruktor w klasie ButtonFind");
		
		this.banks = banks_;
		System.out.println("DUPA, Konstruktor w klasie ButtonFind, banki gotowe");
		
		//TODO: za wczesnie dostaje czas przelewu
		this.paymentTime = paymentTime_;
		System.out.println("DUPA, Otrzymalem czas przelewu: " + paymentTime.toString());
	}
	
	public void onClick(View arg0) {
		
		Spinner spinn1 = (Spinner)actv.findViewById(R.id.spinnerBank1);
		String zBankuNazwa = spinn1.getSelectedItem().toString();
		Bank zBanku = banks.findBank(zBankuNazwa);
		System.out.println("DUPA, Pobieram dane z pierwszego Spinboxa, nazwaBanku: " + zBankuNazwa);
		
		Spinner spinn2 = (Spinner)actv.findViewById(R.id.spinnerBank1);
		String doBankuNazwa = spinn2.getSelectedItem().toString();
		Bank doBanku = banks.findBank(doBankuNazwa);
		System.out.println("DUPA, Pobieram dane z drugiego Spinboxa, nazwaBanku: " + doBankuNazwa);
		
		try {
			Date zBankuWychodzacy = zBanku.getNearestOutgoingTime(paymentTime);
			System.out.println("DUPA, Czas wychodzacej kasy: " + zBankuWychodzacy.toString());
			
			Date doBankuPrzychodzacy = doBanku.getNearestIncomingTime(zBankuWychodzacy);
			System.out.println("DUPA, Czas otrzymanje kasy: " + doBankuPrzychodzacy.toString());
			
			TextView pokazCzas = (TextView)actv.findViewById(R.id.deliveryTime);
			pokazCzas.setText(doBankuPrzychodzacy.toString());
		} 
		catch (ParseException e) {
			System.out.println("DUPA, WYJATEK!!!!!: ");
			e.printStackTrace();
		}		
		
		
//		Toast.makeText(actv.getApplicationContext(), "Dziala, button Szukaj!", Toast.LENGTH_SHORT).show(); 
	}

}
