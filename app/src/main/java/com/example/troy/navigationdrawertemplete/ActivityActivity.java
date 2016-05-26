package com.example.troy.navigationdrawertemplete;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by troy on 16/5/26.
 */
public class ActivityActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnScan;
    private TextView txtFormat, txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        btnScan = (Button) findViewById(R.id.btnScan);
        btnScan.setOnClickListener(this);

        txtFormat = (EditText) findViewById(R.id.txtFormat);
        txtContent = (EditText) findViewById(R.id.txtContent);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnScan){
//            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
//            scanIntegrator.initiateScan();
            IntentIntegrator integrator = new IntentIntegrator(this);
//            integrator.setDesiredBarcodeFormats(CustomIntegrator.PDF_417);
            integrator.setPrompt("Scan a barcode");
            integrator.setCameraId(0);  // Use a specific camera of the device
            integrator.setOrientationLocked(true);
            integrator.setBeepEnabled(true);
            integrator.setCaptureActivity(CaptureActivityPortrait.class);
            integrator.initiateScan();
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();

            txtFormat.setText(scanFormat);
            txtContent.setText(scanContent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}
