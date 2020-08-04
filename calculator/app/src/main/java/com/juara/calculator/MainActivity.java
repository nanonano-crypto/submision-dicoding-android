package com.juara.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText panjangg, lebarr, tinggii;
    private TextView hasil;
    private Button btnHitung;
    private static final String STATE_RESULT = "state_result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panjangg = findViewById(R.id.panjang);
        lebarr = findViewById(R.id.lebar);
        tinggii = findViewById(R.id.tinggi);
        hasil = findViewById(R.id.hasil);
        btnHitung = findViewById(R.id.btnHitung);
        btnHitung.setOnClickListener(this);

        //membuat hasil tidak hilang saat hp di buat portrait
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            hasil.setText(result);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHitung){
            //mengambil nilai value dari editText
            String inputPanjang = panjangg.getText().toString().trim();
            String inputLebar = lebarr.getText().toString().trim();
            String inputTinggi = tinggii.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputPanjang)){
                isEmptyFields = true;
                panjangg.setError("panjang harus di isi");
            }
            if (TextUtils.isEmpty(inputLebar)){
                isEmptyFields = true;
                lebarr.setError("lebar harus di isi");
            }
            if (TextUtils.isEmpty(inputTinggi)){
                isEmptyFields = true;
                tinggii.setError("tinggi harus di isi");
            }

            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);
            Double tinggi = toDouble(inputTinggi);

            if (panjang == null){
                isInvalidDouble = true;
                panjangg.setError("field tidak boleh kosong ");
            }
            if (lebar == null){
                isInvalidDouble = true;
                lebarr.setError("field tidak boleh kosong ");
            }
            if (tinggi == null) {
                isInvalidDouble = true;
                lebarr.setError("field tidak boleh kosong ");
            }
            if (!isEmptyFields && !isInvalidDouble){
                double volume = panjang * lebar * tinggi;
                hasil.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    //membuat hasil tetap ada saat di rubah ke mode portrait
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, hasil.getText().toString());

    }
}