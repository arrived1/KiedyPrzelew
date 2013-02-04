package com.arrived1.kiedyprzelew;

import java.util.Vector;

import android.R.bool;

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

	
	private Boolean checkLessThanFirst(Date t) {
		if(t.lessThan(TimeOut.elementAt(0)))
			return true;
		return false;
	}
	
	private Boolean checkBeetwen(Date t, int from, int to) {
		if(t.greaterEqualThan(TimeOut.elementAt(from)) && t.lessThan(TimeOut.elementAt(to)))
			return true;
		return false;
	}
	
	private Boolean checkGreaterThanLast(Date t) {
		if(t.greaterEqualThan(TimeOut.elementAt(TimeOut.size() - 1)))
			return true;
		return false;
	}

	public Date getNearestOutgoingTime(Date t)  {
		if(checkLessThanFirst(t))
			return TimeOut.elementAt(0);
		if(checkBeetwen(t, 0, 1))
			return TimeOut.elementAt(1);
		if(checkBeetwen(t, 1, 2))
			return TimeOut.elementAt(2);
		if(TimeOut.size() > 3)
			if(checkBeetwen(t, 2, 3))
				return TimeOut.elementAt(3);
		if(checkGreaterThanLast(t))
			return TimeOut.elementAt(0);	
		return new Date();
	}
	
	
	
	public Date getNearestIncomingTime(Date t)  {
		Date result = new Date();
		
		for(int i = 0; i < TimeIn.size(); i++) {
			Date diff = new Date(TimeIn.elementAt(i).h - t.h, TimeIn.elementAt(i).h - t.m);

			if(t.lessThan(TimeIn.elementAt(0))) {
				if(diff.lessThan(result)) {
					result = diff;
				}
			}
			else if(t.greaterThan(TimeIn.elementAt(TimeIn.size() - 1))) {
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
