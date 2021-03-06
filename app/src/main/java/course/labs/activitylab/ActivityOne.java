package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.content.SharedPreferences;


public class ActivityOne extends Activity {

		// string for logcat documentation
	private final static String TAG = "Lab-ActivityOne";
    private int createCount, startCount, resumeCount, pauseCount,
            stopCount, restartCount, destroyCount;
    private TextView onCreateTxt, onStartTxt, onResumeTxt,
            onPauseTxt, onStopTxt, onRestartTxt, onDestroyTxt;
    private SharedPreferences prefs;
	// lifecycle counts
	//TODO: Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
	//TODO:  increment the variables' values when their corresponding lifecycle methods get called.
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		viewInitialization();
        loadCounterFromDisk();

		//Log cat print out
		Log.i(TAG, "onCreate called");
		//String test = getResources().getString(R.string.onCreate);
		//TODO: update the appropriate count variable & update the view
		createCount++;
        updateCounterUI();
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
        startCount++;
        updateCounterUI();
        //TODO:  update the appropriate count variable & update the view
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.i(TAG, "onResume called");
        resumeCount++;
        updateCounterUI();
	}

	@Override
	protected void onPause() {
		super.onPause();

		Log.i(TAG, "onPause called");
		onPauseTxt.setText(getResources().getString(R.string.onPause) + ++pauseCount);

	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.i(TAG, "onStop called");
		onStopTxt.setText(getResources().getString(R.string.onStop) + ++stopCount);
        saveCounterToDisk();
	}

	@Override
	protected void onRestart(){
		super.onRestart();

		Log.i(TAG, "onRestart called");
		onRestartTxt.setText(getResources().getString(R.string.onRestart) + ++restartCount);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.i(TAG, "onDestroy called");
		onDestroyTxt.setText(getResources().getString(R.string.onDestroy) + ++destroyCount);
	}


	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState){
		//TODO:  save state information with a collection
		// of key-value pairs & save all  count variables

		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt("create", createCount);
		savedInstanceState.putInt("start", startCount);
		savedInstanceState.putInt("resume", resumeCount);
		savedInstanceState.putInt("pause", pauseCount);
		savedInstanceState.putInt("stop", stopCount);
		savedInstanceState.putInt("restart", restartCount);
		savedInstanceState.putInt("destroy", destroyCount);

	}

	@Override
	protected void onRestoreInstanceState(Bundle inState) {
		super.onRestoreInstanceState(inState);

		createCount = inState.getInt("create");
		startCount = inState.getInt("start");
		resumeCount = inState.getInt("resume");
		pauseCount = inState.getInt("pause");
		stopCount = inState.getInt("stop");
		restartCount = inState.getInt("restart");
		destroyCount = inState.getInt("destroy");
	}


    public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}

    public void updateCounterUI() {
        onCreateTxt.setText(getResources().getString(R.string.onCreate) + createCount);
        onStartTxt.setText(getResources().getString(R.string.onStart) + startCount);
        onResumeTxt.setText(getResources().getString(R.string.onResume) + resumeCount);
        onPauseTxt.setText(getResources().getString(R.string.onPause) + pauseCount);
        onStopTxt.setText(getResources().getString(R.string.onStop) + stopCount);
        onRestartTxt.setText(getResources().getString(R.string.onRestart) + restartCount);
        onDestroyTxt.setText(getResources().getString(R.string.onDestroy) + destroyCount);
    }

    public void saveCounterToDisk() {
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(getString(R.string.onCreate), createCount);
        editor.putInt(getString(R.string.onStart), startCount);
        editor.putInt(getString(R.string.onResume), resumeCount);
        editor.putInt(getString(R.string.onPause), pauseCount);
        editor.putInt(getString(R.string.onStop), stopCount);
        editor.putInt(getString(R.string.onRestart), restartCount);
        editor.putInt(getString(R.string.onDestroy), destroyCount);

        editor.commit();

    }


    public void loadCounterFromDisk() {
        createCount = prefs.getInt(getString(R.string.onCreate), 0);
        startCount = prefs.getInt(getString(R.string.onStart), 0);
        resumeCount = prefs.getInt(getString(R.string.onResume), 0);
        pauseCount = prefs.getInt(getString(R.string.onPause), 0);
        stopCount = prefs.getInt(getString(R.string.onStop), 0);
        restartCount = prefs.getInt(getString(R.string.onRestart), 0);
        destroyCount = prefs.getInt(getString(R.string.onDestroy), 0);


    }

    private void viewInitialization(){
        onCreateTxt = (TextView) findViewById(R.id.create);
        onStartTxt = (TextView) findViewById(R.id.start);
        onResumeTxt = (TextView) findViewById(R.id.resume);
        onPauseTxt = (TextView) findViewById(R.id.pause);
        onStopTxt = (TextView) findViewById(R.id.stop);
        onRestartTxt = (TextView) findViewById(R.id.restart);
        onDestroyTxt = (TextView) findViewById(R.id.destroy);

        // no editor needed we're reading values
        prefs = getPreferences(MODE_PRIVATE);

    }
}
