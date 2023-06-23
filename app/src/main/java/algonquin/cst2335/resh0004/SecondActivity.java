package algonquin.cst2335.resh0004;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import algonquin.cst2335.resh0004.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    protected ActivitySecondBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        variableBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("Email");
        String savedPhone = preferences.getString("savedNumber", "");
        variableBinding.editTextPhone.setText(savedPhone);
        variableBinding.textView.setText("Welcome back: " + "" + emailAddress);
        variableBinding.button.setOnClickListener((v) -> {
            Intent call = new Intent(Intent.ACTION_DIAL);
            String phoneNumber = variableBinding.editTextPhone.getText().toString();
            call.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(call);
        });

        File file = new File(getFilesDir(), "Picture.png");
        if (file.exists()) {
            Bitmap theImage = BitmapFactory.decodeFile(file.getAbsolutePath());
            variableBinding.imageView.setImageBitmap(theImage);

        }

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Bitmap thumbnail = data.getParcelableExtra("data");
                        variableBinding.imageView.setImageBitmap(thumbnail);
                        FileOutputStream fOut = null;
                        try {
                            fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);
                            thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                            fOut.flush();
                            fOut.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                });

        variableBinding.button2.setOnClickListener(clk -> {
            cameraResult.launch(cameraIntent);
        });
    }
                            @Override
                            protected void onPause () {
                                super.onPause();
                                SharedPreferences pref = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("savedNumber", variableBinding.editTextPhone.getText().toString());
                                editor.apply();
                            }
                        }