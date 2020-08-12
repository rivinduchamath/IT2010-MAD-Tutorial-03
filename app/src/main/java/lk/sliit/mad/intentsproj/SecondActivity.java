package lk.sliit.mad.intentsproj;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    EditText tvNumber1;
    EditText tvNumber2;
    TextView tvCalculations;
    String number1;
    String number2;
    Button btnAdd, btnMinus, btnMultiply, btnDivide;
    int val1,val2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvNumber1 = findViewById(R.id.etSecNumber1);
        number1 = getIntent().getExtras().getString("Value1");
        tvNumber1.setText(number1);

        tvNumber2 = findViewById(R.id.etSecNumber2);
        number2 = getIntent().getExtras().getString("Value2");
        tvNumber2.setText(number2);

        btnAdd = findViewById(R.id.btnAddition);
        btnAdd.setOnClickListener(this);
        btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
        btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);
        btnMultiply = findViewById(R.id.btnMultiplication);
        btnMultiply.setOnClickListener(this);

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        tvCalculations = findViewById(R.id.tvCalculations);

        tvNumber1 = findViewById(R.id.etSecNumber1);
        number1 =tvNumber1.getText().toString();

        tvNumber2 = findViewById(R.id.etSecNumber2);
        number2 = tvNumber2.getText().toString();

        val1 = Integer.parseInt(number1);
        val2 = Integer.parseInt(number2);
        switch (view.getId()) {

            case R.id.btnAddition:
                tvCalculations.setText(number1 + " + " + number2+ " = " +(val1+val2));
                break;
            case R.id.btnMinus:
                tvCalculations.setText(number1 + " - " + number2+ " = " +(val1-val2));
                break;
            case R.id.btnMultiplication:
                tvCalculations.setText(number1 + " * " + number2+ " = " +(val1*val2));
                break;
            case R.id.btnDivide:
                tvCalculations.setText(number1 + " / " + number2+ " = " +(val1/val2));
                break;
        }
    }
}
