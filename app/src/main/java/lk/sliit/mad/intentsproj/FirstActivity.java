package lk.sliit.mad.intentsproj;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOk;
    EditText etNumber1, etNumber2;
    String number1,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etNumber1 = (EditText) findViewById(R.id.etNumber1);
        etNumber2 = (EditText) findViewById(R.id.etNumber2);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnOk:

                CharSequence message = "Sending message...";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(FirstActivity.this, message, duration);
//                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.show();

                Intent intent = new Intent(this, SecondActivity.class);
                number1 = etNumber1.getText().toString();
                number2 = etNumber2.getText().toString();

                intent.putExtra("Value1", number1);
                intent.putExtra("Value2", number2);
                startActivity(intent);
                finish();
                break;


        }
    }


    public void displayToast(View view) {
    }
}
