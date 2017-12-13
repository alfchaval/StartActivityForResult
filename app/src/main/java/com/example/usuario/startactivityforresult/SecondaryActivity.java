package com.example.usuario.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by usuario on 12/11/17.
 */

public class SecondaryActivity extends AppCompatActivity {

    private EditText edtMessage;
    private Button btnSend, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Comprobar que el mensaje no esté vacío
                String message = edtMessage.getText().toString().trim();
                if(!message.isEmpty()) {
                    // 2. Se añade el mensaje al Intent
                    Intent intent = new Intent();
                    intent.putExtra("message", message);
                    finish();
                    // 3. Indicar que el resultado ha sido correcto
                    setResult(Activity.RESULT_OK);
                    finish();
                }
            }
        });
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
