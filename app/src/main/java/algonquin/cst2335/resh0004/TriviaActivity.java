package algonquin.cst2335.resh0004;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import algonquin.cst2335.resh0004.databinding.ActivityCurrencyBinding;
import algonquin.cst2335.resh0004.databinding.ActivityTriviaBinding;

public class TriviaActivity extends AppCompatActivity {

    protected ActivityTriviaBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variableBinding = ActivityTriviaBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
    }
}