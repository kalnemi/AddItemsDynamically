package com.example.additemsdynamically;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ListActivity 
{
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		Button btn = (Button) findViewById( R.id.btnAdd );
		adapter = new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1, list );
		
		btn.setOnClickListener( new OnClickListener()
		{
			@Override
			public void onClick ( View view )
			{
				EditText edit = (EditText) findViewById( R.id.txtItem );
				list.add( edit.getText().toString());
				edit.setText( "" );
				adapter.notifyDataSetChanged();
			}
		});
		
		setListAdapter(adapter);
	}
}