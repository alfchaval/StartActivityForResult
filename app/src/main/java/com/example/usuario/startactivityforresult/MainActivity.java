package com.example.usuario.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvMessageName, txvMessageSurname;
    private Button btnName, btnSurname;

    private final static int NAME = 0;
    private final static int SURNAME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvMessageName = findViewById(R.id.txvMessageName);
        txvMessageSurname = findViewById(R.id.txvMessageSurname);
        btnName = findViewById(R.id.btnName);
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivityForResult(intent, MainActivity.NAME);
            }
        });
        btnSurname = findViewById(R.id.btnSurname);
        btnSurname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivityForResult(intent, MainActivity.SURNAME);
            }
        });
    }

    /**
     * Se trata de un método callback que será llamado cuando SecondaryActivity finalice
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 1. Primero se comprueba el código de la petición
        String message;
        if((message = data.getStringExtra("message")) != null) {
            switch (requestCode) {
                case NAME:
                    if (resultCode == RESULT_OK) txvMessageName.setText(message);
                    break;
                case SURNAME:
                    if (resultCode == RESULT_OK) txvMessageSurname.setText(message);
                    break;
            }
        }
        // 2. Se comprueba el resultado de la operación

    }
}
