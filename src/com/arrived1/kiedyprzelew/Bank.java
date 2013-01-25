package com.arrived1.kiedyprzelew;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Bank {
	private String BankName = "";
	private Vector<Date> TimeOut = new Vector<Date>();
	private Vector<Date> TimeIn = new Vector<Date>();
	
	public Bank(String bankName) {
		String[] tmp = bankName.split(",");
		BankName = tmp[0];
		TimeOut = setVector(tmp[1]);
		TimeIn = setVector(tmp[2]);
	}
	
	//TODO: implement me
	public Date getNearestIncomingTime(Date t) {
		return new Date();
	}
	
	//TODO: implement me	
	public Date getNearestOutgoingTime(Date t) {
		return new Date();
	}
	
	public String getName() {
		return BankName;
	}
	
	private Vector<Date> setVector(String t) {
		Vector<Date> vec = new Vector<Date>();
		String[] times = t.split(" ");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		
		try {
			//TODO: it wont works with 2, 3, 4?
			for(int i = 0; i < 4; i++) {
				Date time = timeFormat.parse(times[i]);
				vec.addElement(time);
			}
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vec;
	}
}
