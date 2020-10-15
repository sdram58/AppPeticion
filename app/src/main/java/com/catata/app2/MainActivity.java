package com.catata.app2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int  RESPUESTA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view) {
        Intent sendIntent = new Intent();

        //sendIntent.setPackage("com.catata.app1");


        sendIntent.setAction(Intent.ACTION_SEND);

        sendIntent.putExtra(Intent.EXTRA_TEXT, "start");

        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);

        startActivityForResult(shareIntent, RESPUESTA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESPUESTA && resultCode == RESULT_OK){
            String texto = data.getExtras().getString("RESULTADO");
            ((TextView)findViewById(R.id.tvTexto)).setText(texto);
        }

    }
}