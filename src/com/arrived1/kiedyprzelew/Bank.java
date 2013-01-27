package com.arrived1.kiedyprzelew;

import java.text.ParseException;
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
		return t;
	}
	
	public Date getNearestOutgoingTime(Date t) throws ParseException {
		Date result = new Date(24, 60);
		
		for(int i = 0; i < TimeOut.size(); i++) {
			Date diff = new Date(TimeOut.elementAt(i).h - t.h, TimeOut.elementAt(i).h - t.m);

			if(t.lessThan(TimeOut.elementAt(0))) {
				if(diff.lessThan(result)) {
					result = diff;
				}
			}
			else if(t.greaterThan(TimeOut.elementAt(TimeOut.size() - 1))) {
				if(diff.greaterThan(result)) {
					result = diff;
				}
			}
			else 
				result = diff;	
		}
		return result;
	}
	
	public String getName() {
		return BankName;
	}
	
	private Vector<Date> setVector(String t) {
		Vector<Date> vec = new Vector<Date>();
		String[] times = t.split(" ");
		
		for(int i = 0; i < times.length; i++) {
			if(times[i].length() > 0) {
				Date time = new Date(times[i]);
				vec.addElement(time);
			}
		}
		return vec;
	}
}
