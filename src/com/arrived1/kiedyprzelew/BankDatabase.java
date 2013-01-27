package com.arrived1.kiedyprzelew;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import android.app.Activity;
import android.widget.Toast;


public class BankDatabase {
	private Vector<Bank> banks = new Vector<Bank>();
	private Activity actv;
	
	public BankDatabase(Activity activity) {
		this.actv = activity;
		try {
			ReadFromFile();
		} 
		catch (IOException e) {
			Toast.makeText(actv.getApplicationContext(), "Problems: " + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	
	private void ReadFromFile() throws IOException {
		String str = "";
		
		InputStream is = actv.getResources().openRawResource(R.drawable.banks);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		if (is != null) {							
			while ((str = reader.readLine()) != null) {	
				Bank bank = new Bank(str);
				banks.addElement(bank);
//				System.out.println("DUPA, " + " Bank name: " + bank.getName());
			}				
		}		
		is.close();		
	}
	
	public int size() {
		return banks.size();
	}
	
	public String getBankName(int i) {
		if(i < size())
			return banks.elementAt(i).getName();
		return "Error";
	}
}
