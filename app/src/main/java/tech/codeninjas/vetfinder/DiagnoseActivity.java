package tech.codeninjas.vetfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class DiagnoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Choose Diagnose Type");

    }

    public void diagnoseTypeClicked(View v) {
        switch (v.getId()){
            case R.id.qa_diagnose_btn:
                startActivity(new Intent(DiagnoseActivity.this,QADiagnoseActivity.class));
                break;
            case R.id.photo_detection_btn:
                startActivity(new Intent(DiagnoseActivity.this,PhotoDiagnoseActivity.class));
                break;
        }
    }
}
