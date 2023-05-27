package algonquin.cst2335.resh0004.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

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

        model.selectButtons.observe(this, selected -> {
            variableBinding.checkBox.setChecked(selected);
            variableBinding.switchButton.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);

            String message = "The value is now: " + selected;
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        });

        variableBinding.checkBox.setOnCheckedChangeListener((button, isChecked) -> {
           model.selectButtons.postValue(isChecked);
        });

        variableBinding.switchButton.setOnCheckedChangeListener((button, isChecked) -> {
            model.selectButtons.postValue(isChecked);
        });

        variableBinding.radioButton.setOnCheckedChangeListener((button, isChecked) -> {
            model.selectButtons.postValue(isChecked);
        });

        // Initialize the ImageView using ViewBinding
        ImageView myImageView = variableBinding.imageView;
        ImageButton myImageButton = variableBinding.imageButton;
// Set an OnClickListener for the ImageButton

       myImageButton.setOnClickListener(v -> {
                int width = myImageView.getWidth();
                int height = myImageView.getHeight();

           String message = "The width = " + width + " and height = " + height;
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });

    }

    }







