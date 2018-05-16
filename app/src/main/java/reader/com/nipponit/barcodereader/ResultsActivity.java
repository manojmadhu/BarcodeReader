package reader.com.nipponit.barcodereader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView barcodeResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        barcodeResult = (TextView)findViewById(R.id.lblresult);
    }

    public void scanBarcode(View view){
        Intent intent = new Intent(ResultsActivity.this,MainActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            if(resultCode == 0){
                if(data!=null){
                    String barcode = data.getStringExtra("barcode");
                    barcodeResult.setText(barcode);
                }
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
