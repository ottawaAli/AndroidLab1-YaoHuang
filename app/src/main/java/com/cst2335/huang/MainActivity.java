package com.cst2335.huang;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_linear);
        setContentView(R.layout.activity_main_grid);
        //setContentView(R.layout.activity_main_relative);


        Button clickButton = findViewById(R.id.btn);
        clickButton.setOnClickListener(view -> {
            String toastMessage = getResources().getString(R.string.toast_message);
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
        });

        Switch mySwitch = findViewById(R.id.switchOnOff);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                String snackbarMsg = isChecked ? getResources().getString(R.string.switch_on) : getResources().getString(R.string.switch_off);

                String undoText = getResources().getString(R.string.undo);
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), snackbarMsg, Snackbar.LENGTH_LONG);
                snackbar.setAction(undoText, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mySwitch.setChecked(!isChecked);
                    }
                });
                snackbar.show();
            }
        });


        //Assign the ImageButton with the ID imageButton from the layout to the variable named flagButton
        ImageButton flagButton = findViewById(R.id.imageButton);
        //Display the image with the name "flag" from the resources
        flagButton.setImageResource(R.drawable.flag);

    }
}
