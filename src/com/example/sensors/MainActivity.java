package com.example.sensors;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	
	private ListView listView;
	private SensorManager smanage;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView)findViewById(R.id.listView1);
		smanage =  (SensorManager)getSystemService(SENSOR_SERVICE);
		List<Sensor> list = smanage.getSensorList(Sensor.TYPE_ALL);
		List<String> list_name = new ArrayList<String>();
		for(Sensor sensor:list){
			list_name.add(sensor.getName());			
		}
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_name);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		
		
		
	}
	
	
	
	
/**************************************************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
