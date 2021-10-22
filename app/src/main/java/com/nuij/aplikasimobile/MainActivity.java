package com.nuij.aplikasimobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText TextNama;
    TextView Hasil;

    private String[] Item = {"Laki-laki", "Perempuan", "?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextNama = (EditText) findViewById(R.id.TxtNama);
        Hasil = (TextView) findViewById(R.id.Lbl_Nama);
        final Spinner List = findViewById(R.id.listItem);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,Item);
        List.setAdapter(adapter);

        List.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Jenis Kelamin "+adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {
                Toast.makeText(getApplicationContext(),"Tidak Ada Item Yang Dipilih", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void TampilNama(View v) {
        Hasil.setText("Nama Anda : " + TextNama.getText());
    }
}