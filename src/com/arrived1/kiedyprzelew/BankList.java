package com.arrived1.kiedyprzelew;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BankList extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.bank_list);
		 
		 BankDatabase banks = new BankDatabase(this);
		 List<String> list = new ArrayList<String>();
		 for(int i = 0; i < banks.size(); i++)
			 list.add(banks.getBankName(i));
		 
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
		 ListView listView = (ListView)findViewById(R.id.listView);
		 listView.setAdapter(adapter); 
	}
}
