package com.arrived1.kiedyprzelew;

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

	public Date getNearestOutgoingTime(Date t)  {
		Date result = new Date();
		
		System.out.println("DUPA, Dostalem date: " + t.toString());
		
		for(int i = 0; i < TimeOut.size(); i++) {
			System.out.println("DUPA, <<<<<<<<< " + i + " >>>>>>>>>>>>>>");
			Date diff = new Date(TimeOut.elementAt(i).h - t.h, TimeOut.elementAt(i).m - t.m);
			diff.abs();
			System.out.println("DUPA, diff date: " + diff.toString());
			
			if(t.lessThan(TimeOut.elementAt(0))) {
				System.out.println("DUPA, otrzymana data mniejssza niz diff");
				if(diff.lessThan(result)) {
					System.out.println("DUPA, otrzymana data mniejssza niz result");
					result = diff;
				}
			}
			else if(t.greaterThan(TimeOut.elementAt(TimeOut.size() - 1))) {
				System.out.println("DUPA, otrzymana data wieksza niz diff");
				if(diff.greaterThan(result)) {
					System.out.println("DUPA, otrzymana data wieksza niz result");
					result = diff;
				}
			}
			else 
				System.out.println("DUPA, result == diff");
				result = diff;	
		}
		System.out.println("DUPA, na koniec zwracam: " + result.toString());
		return result;
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
