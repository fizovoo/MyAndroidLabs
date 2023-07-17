package algonquin.cst2335.resh0004;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import algonquin.cst2335.resh0004.databinding.ActivityAviationBinding;

public class AviationActivity extends AppCompatActivity {

    protected ActivityAviationBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variableBinding = ActivityAviationBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_aviation);
        setContentView(variableBinding.getRoot());
    }
}
