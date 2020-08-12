package lk.sliit.mad.intentsproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOk, btnCustomToast;
    EditText etNumber1, etNumber2;
    String number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etNumber1 = findViewById(R.id.etNumber1);   //Edit Text For Number1
        etNumber2 = findViewById(R.id.etNumber2);   //Edit Text For Number2
        btnOk = findViewById(R.id.btnOk);           //Button Ok
        btnCustomToast = findViewById(R.id.btnCustomToast);   // Button Custom Toast
        btnOk.setOnClickListener(this);
        btnCustomToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {          //On click Method to when click Buttons

        switch (view.getId()) {               //switch for 2 buttons

            case R.id.btnOk:                                         //Button Ok
                CharSequence message = "Sending message...";         // Toast
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(FirstActivity.this, message, duration);
                toast.setGravity(Gravity.TOP | Gravity.BOTTOM, 0, 0);
                toast.show();

                Intent intent = new Intent(this, SecondActivity.class);
                number1 = etNumber1.getText().toString();            //Get Values
                number2 = etNumber2.getText().toString();

                intent.putExtra("Value1", number1);
                intent.putExtra("Value2", number2);
                startActivity(intent);
                finish();
                break;

            case R.id.btnCustomToast:                                                //Button Custom Toast
                startActivity(new Intent(this, MainActivity.class));  // Main Activity
                break;

        }//End Switch
    }//End OnClick
}//End Class
