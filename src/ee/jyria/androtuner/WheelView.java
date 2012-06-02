package ee.jyria.androtuner;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;


public class WheelView extends View
{
	private static final String TAG = "WheelView";
	private Bitmap wheelBitmap;
	private Matrix matrix;
	private int angle = 0;
	
	public WheelView( Context context ) 
	{
		super( context );
		wheelBitmap = BitmapFactory.decodeResource( getResources(), R.drawable.wheel3 );
		matrix = new Matrix();
		Log.i( TAG, "Wheel view initialized." );
		Log.i( TAG, "Loaded bitmap: " + getResources().getResourceEntryName( R.drawable.wheel3 ) ); 
	}

	@Override
	protected void onDraw( Canvas canvas ) {
		super.onDraw(canvas);
		// Added some rotation, just for animation.
		// Will be removed, when actual implemetation is created.
		angle ++;
		canvas.drawColor( Color.GRAY );
		matrix.setScale( 5, 5 );
		matrix.setRotate( angle, 100, 100 );
		canvas.drawBitmap( wheelBitmap, matrix, null );
		invalidate();
	}
	
	
}
