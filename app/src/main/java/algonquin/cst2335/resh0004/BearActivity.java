package algonquin.cst2335.resh0004;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import algonquin.cst2335.resh0004.databinding.ActivityBearBinding;


public class BearActivity extends AppCompatActivity {
    protected ActivityBearBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variableBinding = ActivityBearBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
    }
}