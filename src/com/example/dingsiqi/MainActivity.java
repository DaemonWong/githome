package com.example.dingsiqi;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class MainActivity extends ActionBarActivity {

	private Chronometer clock ;
	private Button start ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.clock = (Chronometer)findViewById(R.id.clock) ;
		this.start = (Button)findViewById(R.id.start) ;
		
		this.start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clock.setBase(SystemClock.elapsedRealtime());
				clock.start();
				start.setEnabled(false);
			}
		});
		
		this.clock.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer chronometer) {
				// TODO Auto-generated method stub
				if(SystemClock.elapsedRealtime() - clock.getBase() > 20*1000) {
					clock.stop();
					start.setEnabled(true);
				}
			}
		});
	}

}
