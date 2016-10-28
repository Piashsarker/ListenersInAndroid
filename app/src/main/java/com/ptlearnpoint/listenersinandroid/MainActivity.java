package com.ptlearnpoint.listenersinandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText toToastText ;
    private Button clearButton , toastButton;

    private ButtonOnClickListener buttonOnClickListener;
    private ButtonHintOnLongClick buttonHintListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toToastText = (EditText) findViewById(R.id.editText);

        toToastText.setOnClickListener(new TextOnClickListener());
        clearButton = (Button) findViewById(R.id.btnClear);
        toastButton = (Button) findViewById(R.id.btnToast);
    }

    private class TextOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            buttonOnClickListener = new ButtonOnClickListener();
            buttonHintListener = new ButtonHintOnLongClick();

            clearButton.setOnClickListener(buttonOnClickListener);
            toastButton.setOnClickListener(buttonOnClickListener);

            clearButton.setOnLongClickListener(buttonHintListener);
            toastButton.setOnLongClickListener(buttonHintListener);


        }
    }

    private class ButtonOnClickListener implements  View.OnClickListener{
        @Override
        public void onClick(View v) {

            if(v.getId() ==R.id.btnClear){
                toToastText.setText("");
            }
            if(v.getId() == R.id.btnToast){
                Toast.makeText(v.getContext(), toToastText.getText(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class ButtonHintOnLongClick implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {
            String hint = null ;
            Context context = v.getContext();

            if (v.getId()==R.id.btnClear){
                hint = "This Button Will Clear The Text Of Above Text Field ";
            }
            else if(v.getId() ==R.id.btnToast){
                hint = "This Button Will Toast The Message From Above Text Field";
            }
            Toast.makeText(context, hint, Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
