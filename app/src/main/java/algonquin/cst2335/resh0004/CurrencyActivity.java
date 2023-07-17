package algonquin.cst2335.resh0004;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import algonquin.cst2335.resh0004.databinding.ActivityCurrencyBinding;

public class CurrencyActivity extends AppCompatActivity {

    protected ActivityCurrencyBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variableBinding = ActivityCurrencyBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_currency);
        setContentView(variableBinding.getRoot());
    }
}