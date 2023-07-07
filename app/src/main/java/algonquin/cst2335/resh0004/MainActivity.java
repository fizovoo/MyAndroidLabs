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
    private Context context = this;
    /**
     * This holds the text at the centre of the screen
     */
     private  TextView tv = null;
    /**
     * This holds the password that is to be typed
     */
    private  EditText et = null;
    /**
     * This holds the login button that is to be clicked
     */
     private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tv = findViewById(R.id.textView);
         et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            checkPasswordComplexity(password);

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
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

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
            tv.setText("You shall not pass");
            Toast.makeText(context, "Upper case character missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            tv.setText("You shall not pass");
            Toast.makeText(context, "Lower case character missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            tv.setText("You shall not pass");
            Toast.makeText(context, "Number missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            tv.setText("You shall not pass");
            Toast.makeText(context, "Special character missing", Toast.LENGTH_SHORT).show();
            return false;
        } else
            tv.setText("Your password meets the requirements");
        return true;
    }

    /** This function checks if the special character in the password and if not will return false.
         *
         * @param c the char object that we are checking
         * @return will return true if c is a special character otherwise false
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
