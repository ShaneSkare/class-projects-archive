package edu.csumb.ybyun.ctof;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up a click listener for the Calculate button.
        Button caculateButton = findViewById(R.id.calulate_button);
    }

    calculateButton.setOnClickListener(new OnClickListener()
    public void onClick(View v) {
        EditText cinput;
        TextView result;

        if(v.getId() == R.id.calulate_button)
        {
            cinput = findViewById(R.id.cinput_edittext);
            String input = cinput.getText().toString();
            double cin = Double.parseDouble(input);
            double fout = cin * (9.0/5.0) + 32.0;
            result = findViewById(R.id.result_textview);
            result.setText(Double.toString(fout));
        )}
    }
}

