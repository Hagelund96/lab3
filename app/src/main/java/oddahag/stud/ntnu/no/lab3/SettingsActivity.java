package oddahag.stud.ntnu.no.lab3;

import android.app.Activity;
import android.se.omapi.SEService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.net.Inet4Address;
import java.nio.channels.InterruptedByTimeoutException;

import static java.sql.Types.NULL;

public class SettingsActivity extends AppCompatActivity {

    public static final String SENSITIVITY = "selected_sense";
    private String sendValue = "5";
    private static final String S1 = "5";
    private static final String S2 = "10";
    private static final String S3 = "15";
    private static final String S4 = "20";
    private Button backButton;
    private SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initiate seek bar with a listener
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // What to do with the different options on the seek bar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int temp = seekBar.getProgress();

                switch (temp){
                    case 0:
                        sendValue = S1;
                        break;
                    case 1:
                        sendValue = S2;
                        break;
                    case 2:
                        sendValue = S3;
                        break;
                    case 3:
                        sendValue = S4;
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // usen't
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // usen't
            }
        });

        // Initiates button to go back to MainActivity
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    // Function to go back to MainActivity and pass with the chosen sensitivity for the accelerometer
    public void goBack(){
        Intent i = new Intent(SettingsActivity.this, MainActivity.class);
        Bundle b = new Bundle();

        b.putString(SENSITIVITY, sendValue);
        i.putExtras(b);


        setResult(Activity.RESULT_OK, i);
        finish();
    }

}
