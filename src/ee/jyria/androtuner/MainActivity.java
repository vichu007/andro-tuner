package ee.jyria.androtuner;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import ee.jyria.androtuner.sound.SoundRecorder;

public class MainActivity extends Activity
{
	private static final String TAG = "MainActivity";
    private SoundRecorder recorder;
    private WheelView wheelView;
	/** Called when the activity is first created. */
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
    	super.onCreate( savedInstanceState );
        wheelView = new WheelView( this );
        setContentView( wheelView );
        recorder = new SoundRecorder();
        recorder.start();
        Log.i( TAG, "Main activity started" );
    }
}
