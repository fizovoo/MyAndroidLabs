package algonquin.cst2335.resh0004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This page validates a password to check if it has an upper case character,
 * lower case character, number or a special character
 * @author Fayz Reshid
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This variable checks if an upper case letter exists in the password or not
     */
    private boolean foundUpperCase = false;
    /**
     * This variable checks if a lower case letter exists in the password or not
     */
    private boolean foundLowerCase = false;
    /**
     * This variable checks if a number exists in the password or not
     */
    private boolean foundNumber = false;
    /**
     * This variable checks if a special character was found in the password or not
     */
    private boolean foundSpecial = false;
    /**
     * The context object used for displaying Toast messages
     */
    private Context context = this;
    /**
     * This holds the text at the centre of the screen
     */
     private TextView tv = findViewById(R.id.textView);
    /**
     * This holds the password that is to be typed
     */
    private EditText et = findViewById(R.id.editText);
    /**
     * This holds the login button that is to be clicked
     */
    private Button btn = findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            boolean passwordComplexityMet = checkPasswordComplexity(password);
            if (passwordComplexityMet) {
                tv.setText("Your password meets the requirements");
            } else {
                tv.setText("You shall not pass!");
            }

        });
    }

    /**
     * This function validates the password to see if it has an Upper case letter, lower case letter,
     * number and a special character.
     *
     * @param pw The String object that we are checking
     * @return Returns true if the password is complex enough and false otherwise.
     */
    boolean checkPasswordComplexity(String pw) {
        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(context, "Upper case character missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(context, "Lower case character missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(context, "Number missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(context, "Special character missing", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    /** This function checks if the special character is one of the following #$%^&*!@? and if not
         * will return false.
         *
         * @param c the char object that we are checking
         * @return will return true if c is one of: #$%^&*!@? otherwise false
         */
        boolean isSpecialCharacter(char c)
        {
            switch (c) {
                case '#':
                case '$':
                case '%':
                case '^':
                case '&':
                case '!':
                case '@':
                case '?':
                case '*':
                    return true;
                default:
                    return false;
            }
        }


}
