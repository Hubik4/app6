package com.example.app6;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button potwierdz;
    private EditText email;
    private EditText haslo;
    private EditText powtorz;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        potwierdz=findViewById(R.id.potwierdz);
        email=findViewById(R.id.email);
        haslo=findViewById(R.id.haslo);
        powtorz=findViewById(R.id.powtorz);
        info=findViewById(R.id.info);

        potwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_email=email.getText().toString().trim();
                String input_haslo=haslo.getText().toString().trim();
                String input_powtorz=powtorz.getText().toString().trim();

                if(input_email.isEmpty()){
                    info.setText("Podaj e-mail");
                    return;
                }
                if(input_haslo.isEmpty()){
                    info.setText("Podaj pole Haslo");
                    return;
                }
                if(input_powtorz.isEmpty()){
                    info.setText("Powtorz haslo");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(input_email).matches()){
                    info.setText("Email jest nie poprawny");
                    return;
                }
                if(!input_powtorz.equals(input_haslo)){
                    info.setText("Haslo musi byc identyczne");
                    return;
                }
                if(!input_email.isEmpty() && !input_haslo.isEmpty() && !input_powtorz.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(input_email).matches() && input_powtorz.equals(input_haslo)){
                    info.setText("witaj "+input_email);
                    return;
                }
            }
        });
    }
}