package algonquin.cst2335.resh0004;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Override
    protected void onStop() {
        Log.w(TAG, "The application is no longer visible.");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.w( TAG, "The application no longer responds to user input" );
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.w(TAG,"The application is now responding to user input" );
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.w( TAG, "The application is now visible on screen." );
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.w( TAG,"Any memory used by the application is freed.");
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}