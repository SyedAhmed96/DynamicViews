package com.example.ahmed.dynamicviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutTest;

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String count = null;
                int c = 0;
                
                try
                {
                    //nextInt will throw InputMismatchException
                    //if the next token does not match the Integer
                    //regular expression, or is out of range

                     count = editText.getText().toString();
                     c = Integer.parseInt(count);

                }
                catch(NumberFormatException exception)
                {
                    //Print "This is not an integer"
                    //when user put other than integer
                    Toast.makeText(MainActivity.this, "Not an Integer Please Try Again!!",
                            Toast.LENGTH_LONG).show();
                   }


               
                for(int i=0; i<c; i++){
                    DynamicTextView(i);
                }
            }
        });

    }


    void DynamicTextView(int i){
        layoutTest = (LinearLayout) findViewById(R.id.layoutTest);
        TextView textView = new TextView(MainActivity.this);
        textView.setText("Dynamic textView "+i);
        layoutTest.addView(textView);
    }

}
