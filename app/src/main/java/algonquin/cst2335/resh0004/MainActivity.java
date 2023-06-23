package algonquin.cst2335.resh0004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import algonquin.cst2335.resh0004.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        Log.w(TAG, "In onCreate() - Loading Widgets");
        setContentView(binding.getRoot());
        binding.loginButton.setOnClickListener(clk ->
        {
            Log.e(TAG, "You Clicked the button");
            Intent nextPage = new Intent(this, SecondActivity.class);

            String input = binding.editText.getText().toString();
            String password = binding.editText2.getText().toString();

            nextPage.putExtra("Email", input);
            nextPage.putExtra("PASSWORD", password);

            startActivity(nextPage);
        });
    }
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



}