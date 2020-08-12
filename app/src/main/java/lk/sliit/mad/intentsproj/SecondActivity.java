package lk.sliit.mad.intentsproj;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tvNumber1, tvNumber2;
    TextView tvCalculations;
    private String number1, number2;
    Button btnAdd, btnMinus, btnMultiply, btnDivide;
    double val1, val2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvNumber1 = findViewById(R.id.etSecNumber1);
        number1 = getIntent().getExtras().getString("Value1");  // get number1
        tvNumber1.setText(number1);                                  // Set value to number1 Text View

        tvNumber2 = findViewById(R.id.etSecNumber2);
        number2 = getIntent().getExtras().getString("Value2");  // get number2
        tvNumber2.setText(number2);                                  // Set value to number2 Text View

        btnAdd = findViewById(R.id.btnAddition);
        btnAdd.setOnClickListener(this);
        btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
        btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);
        btnMultiply = findViewById(R.id.btnMultiplication);
        btnMultiply.setOnClickListener(this);

    }//End onCreate()


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        tvCalculations = findViewById(R.id.tvCalculations);  // Text View to show Calculation

        tvNumber1 = findViewById(R.id.etSecNumber1);
        number1 = tvNumber1.getText().toString();            //Again Get value from Edit text field 1 (if Someone change Text Field)

        tvNumber2 = findViewById(R.id.etSecNumber2);
        number2 = tvNumber2.getText().toString();             //Again Get value from Edit text field 2

        if (number2.equals("") || number1.equals("")) {       //check fields are empty
            number1 = String.valueOf(0);
            number2 = String.valueOf(0);
        }

        val1 = Double.parseDouble(number1);                    //Cast String to Double
        val2 = Double.parseDouble(number2);

        switch (view.getId()) {                                //Switch for buttons
            case R.id.btnAddition:
                tvCalculations.setText(number1 + " + " + number2 + " = " + (val1 + val2));
                break;
            case R.id.btnMinus:
                tvCalculations.setText(number1 + " - " + number2 + " = " + (val1 - val2));
                break;
            case R.id.btnMultiplication:
                tvCalculations.setText(number1 + " * " + number2 + " = " + (val1 * val2));
                break;
            case R.id.btnDivide:
                try {                                                    //Handle Exception if someone is try to divide by 0
                    tvCalculations.setText(number1 + " / " + number2 + " = " + (val1 / val2));
                    break;
                } catch (ArithmeticException e) {
                    tvCalculations.setText("Cannot divide by zero");
                }
        }//End Switch
    }//end onClick()
}//End Class
