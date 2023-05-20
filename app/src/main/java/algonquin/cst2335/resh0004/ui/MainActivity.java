package algonquin.cst2335.resh0004.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.resh0004.data.MainViewModel;
import algonquin.cst2335.resh0004.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(MainViewModel.class);
        super.onCreate(savedInstanceState);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());// loads xml on screen


        variableBinding.button.setOnClickListener(click ->
        {
            model.editString.postValue(variableBinding.myEdit.getText().toString());
        });

        model.editString.observe(this, s -> {


            variableBinding.myText.setText("Your edit text has "+ s);


        });

    }

    }



