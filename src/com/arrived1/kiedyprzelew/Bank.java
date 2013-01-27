package com.arrived1.kiedyprzelew;

import java.text.ParseException;
import java.util.Vector;

public class Bank {
	
	class Date {
		public int h;
		public int m;
		
		public Date() {
			this.h = 0;
			this.m = 0;
		}
		
		public Date(int h, int m) {
			this.h = h;
			this.m = m;
		}
		
		public Date(String t) {
			String[] hourAndMin = t.split(":");
			this.h = Integer.parseInt(hourAndMin[0]);
			this.m = Integer.parseInt(hourAndMin[1]);
		}
	}

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
	
	//TODO: implement me	
	public Date getNearestOutgoingTime(Date t) throws ParseException {
		Date result = new Date();
		
		for(int i = 0; i < TimeOut.size(); i++) {
			Date diff = new Date(TimeOut.elementAt(i).h - t.h, TimeOut.elementAt(i).h - t.m);

			//TODO: Co gdy sa rowne
			if((diff.h > result.h) && (diff.h == result.h && diff.m > result.m)) {
				result = diff;
			}
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
