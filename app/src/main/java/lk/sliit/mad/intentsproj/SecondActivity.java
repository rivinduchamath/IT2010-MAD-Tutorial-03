package lk.sliit.mad.intentsproj;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText tvNumber1;
    EditText tvNumber2;
    String number1;
    String number2;


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
    }
}
