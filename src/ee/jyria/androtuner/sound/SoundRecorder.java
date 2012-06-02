package ee.jyria.androtuner.sound;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioSource;
import android.util.Log;

public class SoundRecorder extends Thread {
	
	private static final String TAG = "SoundRecorder";
	private static final int SAMPLE_RATE = 8000;
	private static final int BLOCK_SIZE = 256;
	private int bufferSize;
	private AudioRecord audioRecord;
	
	public void run()
	{
		Log.i(TAG, "Sound recording started");
		short[] buffer = new short[ BLOCK_SIZE ];
		
		try 
		{
			bufferSize = AudioRecord.getMinBufferSize( SAMPLE_RATE, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT );
			audioRecord = new AudioRecord( 				AudioSource.MIC, 
														SAMPLE_RATE, 
														AudioFormat.CHANNEL_IN_MONO, 
														AudioFormat.ENCODING_PCM_16BIT, 
														bufferSize);
			audioRecord.startRecording();
			
			while( !isInterrupted() )
			{
				int results = audioRecord.read( buffer, 0, BLOCK_SIZE );
				
				if( results == AudioRecord.ERROR || 
					results == AudioRecord.ERROR_BAD_VALUE || 
					results == AudioRecord.ERROR_INVALID_OPERATION )
				{
					Log.e( TAG, "Audio read results error " + results );
				}
			}
			audioRecord.stop();
			audioRecord.release();
			Log.i( TAG, "Audio resources released" );
		} 
		catch (Exception e) 
		{
			Log.e(TAG, "Cant read data, releasing mic resources: " + e );
			audioRecord.stop();
			audioRecord.release();
		}
	}
}
