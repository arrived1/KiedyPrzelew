package com.arrived1.kiedyprzelew;

import java.util.Vector;

public class Bank {
	private String BankName = "";
	private Vector<Date> TimeOut = new Vector<Date>();
	private Vector<Date> TimeIn = new Vector<Date>();
	private int maxTimeOutSizePerBank = 3;
	private int maxTimeInSizePerBank = 2;
	
	public Bank(String bankName) {
		String[] tmp = bankName.split(",");
		BankName = tmp[0];
		TimeOut = setVector(tmp[1]);
		TimeIn = setVector(tmp[2]);
	}

	public Date getNearestOutgoingTime(Date t)  {
		if(checkLessThanFirst(TimeOut, t))
			return TimeOut.elementAt(0);
		if(checkBeetwen(TimeOut, t, 0, 1))
			return TimeOut.elementAt(1);
		if(checkBeetwen(TimeOut, t, 1, 2))
			return TimeOut.elementAt(2);
		if(TimeOut.size() > maxTimeOutSizePerBank)
			if(checkBeetwen(TimeOut, t, 2, 3))
				return TimeOut.elementAt(3);
		if(checkGreaterThanLast(TimeOut, t))
			//TODO: dodac dnia nastepnego
			return TimeOut.elementAt(0);	
		return new Date();
	}
	
	public Date getNearestIncomingTime(Date t)  {
		if(checkLessThanFirst(TimeIn, t))
			return TimeIn.elementAt(0);
		if(checkBeetwen(TimeIn, t, 0, 1))
			return TimeIn.elementAt(1);
		if(TimeIn.size() > maxTimeInSizePerBank)
			if(checkBeetwen(TimeIn, t, 1, 2))
				return TimeIn.elementAt(2);
		if(checkGreaterThanLast(TimeIn, t))
			//TODO: dodac dnia nastepnego
			return TimeIn.elementAt(0);
		return new Date();
	}

	public String getName() {
		return BankName;
	}
	
	private Boolean checkLessThanFirst(Vector<Date> tab, Date t) {
		if(t.lessThan(tab.elementAt(0)))
			return true;
		return false;
	}
	
	private Boolean checkBeetwen(Vector<Date> tab, Date t, int from, int to) {
		if(t.greaterEqualThan(tab.elementAt(from)) && t.lessThan(tab.elementAt(to)))
			return true;
		return false;
	}
	
	private Boolean checkGreaterThanLast(Vector<Date> tab, Date t) {
		if(t.greaterEqualThan(tab.elementAt(tab.size() - 1)))
			return true;
		return false;
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
