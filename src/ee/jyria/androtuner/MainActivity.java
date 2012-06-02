package ee.jyria.androtuner;

import ee.jyria.androtuner.sound.SoundRecorder;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{
    private SoundRecorder recorder;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recorder = new SoundRecorder();
        recorder.start();
    }
}
