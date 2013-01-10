package com.adr;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final MainActivity activity = this;
		Button startButton = (Button)findViewById(R.id.startButton);
		final Intent adrIntent = new Intent(activity, Adr.class);
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startService(adrIntent);
				
			}
		});
		
		Button stopButton = (Button)findViewById(R.id.stopButton);
		stopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stopService(adrIntent);
				
			}
		});
//		startService(new Intent(this, Adr.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startButton:
            	startService(new Intent(this, Adr.class));
                break;

            case R.id.stopButton:
                stopService(new Intent(this, Adr.class));
                break;
        }
        finish();
    }

}
