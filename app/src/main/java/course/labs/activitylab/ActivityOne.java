package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";
    private int createCount, startCount, resumeCount, pauseCount,
            stopCount, restartCount, destroyCount;
    private TextView onCreateTxt, onStartTxt, onResumeTxt,
            onPauseTxt, onStopTxt, onRestartTxt, onDestroyTxt;

		// lifecycle counts
		//TODO: Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		//TODO:  increment the variables' values when their corresponding lifecycle methods get called.
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);
            viewInitialization();

			//Log cat print out
			Log.i(TAG, "onCreate called");
			
			//TODO: update the appropriate count variable & update the view
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			
			//Log cat print out
			Log.i(TAG, "onStart called");
			
			//TODO:  update the appropriate count variable & update the view
		}

	    // TODO: implement 5 missing lifecycle callback methods

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			//TODO:  save state information with a collection of key-value pairs & save all  count variables
		}


    public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}


    private void viewInitialization(){
        onCreateTxt = (TextView) findViewById(R.id.create);
        onStartTxt = (TextView) findViewById(R.id.start);
        onResumeTxt = (TextView) findViewById(R.id.resume);
        onPauseTxt = (TextView) findViewById(R.id.pause);
        onStopTxt = (TextView) findViewById(R.id.stop);
        onRestartTxt = (TextView) findViewById(R.id.restart);
        onDestroyTxt = (TextView) findViewById(R.id.destroy);
    }
}
