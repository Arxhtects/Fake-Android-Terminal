import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView.*;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;

public class MainActivity extends AppCompatActivity {
    //Colors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_terminal);

        //setting the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        EditText editText = (EditText) findViewById(R.id.text_input);
        editText.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    EditText editText = (EditText) findViewById(R.id.text_input);
                    TextView newText = (TextView) findViewById(R.id.console_view);
                    String string = editText.getText().toString();
                    //strings
                    String input_print = "\n"+"> "+string+"\n"; //> new line then input text
                    String problems = "No Command Found"; //No Command Found
                    String help = "I Cant Help You. I Do Nothing";

                    //commands checks
                    newText.append(input_print);
                    if (string.contains("clear")) {
                        newText.setText(null);
                    } else if (string.contains("help")) {
                        newText.append(help);
                    } else {
                        newText.append(problems);
                    }
                    editText.setText("");
                    handled = true;
                }
                return handled;
            }
        });
            }

    }
