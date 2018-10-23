package tech.codeninjas.vetfinder;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.ldoublem.loadingviewlib.view.LVCircularSmile;

import java.util.ArrayList;
import java.util.Objects;

import moe.feng.common.stepperview.VerticalStepperItemView;

public class QADiagnoseActivity extends AppCompatActivity {
    private VerticalStepperItemView mSteppers[] = new VerticalStepperItemView[4];
    private Button mNextBtn1, mNextBtn2, mPrevBtn2, mNextBtn3, mPrevBtn3,mPrevBtn4,qaDiagnoseBtn;
    private CheckBox cbSymptoms,cbSymptoms1,cbSymptoms2,cbSymptoms3,cbSymptoms4,cbSymptoms5,cbSymptoms6,cbSymptoms7,cbSymptoms8;
    private ManualML manualML;
    private ArrayList<String> symptoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa_diagnose);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Q/A Diagnosis");
        cbSymptoms=findViewById(R.id.check_sym1);
        cbSymptoms1=findViewById(R.id.check_sym2);
        cbSymptoms2=findViewById(R.id.check_sym3);
        cbSymptoms3=findViewById(R.id.check_sym4);
        cbSymptoms4=findViewById(R.id.check_sym5);
        cbSymptoms5=findViewById(R.id.check_sym6);
        cbSymptoms6=findViewById(R.id.check_sym7);
        cbSymptoms7=findViewById(R.id.check_sym8);
        cbSymptoms8=findViewById(R.id.check_sym9);
       CheckBox[] symptomsCheckArray={cbSymptoms,cbSymptoms1,cbSymptoms2,cbSymptoms3,cbSymptoms4,cbSymptoms5,cbSymptoms6,cbSymptoms7,cbSymptoms8};
        for(CheckBox box:symptomsCheckArray){
           if(box.isChecked()){
               symptoms.add(box.getText().toString());
           }
        }
        qaDiagnoseBtn=findViewById(R.id.qa_diagnose_btn);
        manualML=new ManualML(this);
        mSteppers[0] = findViewById(R.id.step_view_1);
        mSteppers[1] = findViewById(R.id.step_view_2);
        mSteppers[2] = findViewById(R.id.step_view_3);
        mSteppers[3] = findViewById(R.id.step_view_4);
        VerticalStepperItemView.bindSteppers(mSteppers);

        mNextBtn1 = findViewById(R.id.step_1_nextBtn);
        mNextBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[0].nextStep();
            }
        });


        mPrevBtn2 = findViewById(R.id.step_2_prevBtn);
        mPrevBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[1].prevStep();
            }
        });

        mNextBtn2 = findViewById(R.id.step_2_nextBtn);
        mNextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[1].nextStep();
            }
        });

        mPrevBtn3 = findViewById(R.id.step_3_prevBtn);
        mPrevBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[2].prevStep();
            }
        });

        mNextBtn3 = findViewById(R.id.step_3_nextBtn);
        mNextBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[2].nextStep();
            }
        });
        mPrevBtn4 = findViewById(R.id.step_4_prevBtn);
        mPrevBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[3].prevStep();
            }
        });

        qaDiagnoseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(symptoms.toString(),"QA_DIAGNOSE_DISEASE");
                showLoadDialog(10000);
//                if(manualML.diagnose(symptoms).size()>0) {
//                    Log.d(manualML.diagnose(symptoms).get(0).getmName(),"QA_DIAGNOSE_DISEASE");
//                }
            }
        });
    }
    public void showLoadDialog(int time){
        final AlertDialog.Builder builder = new AlertDialog.Builder(QADiagnoseActivity.this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view=inflater.inflate(R.layout.loading_dialog, null);
        LVCircularSmile loadView=view.findViewById(R.id.diagnose_load_icon);
        loadView.startAnim();
        builder.setView(view);
        final AlertDialog dialog=builder.create();
        dialog.show();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                startActivity(new Intent(QADiagnoseActivity.this,DiagnosesResultActivity.class));
            }
        }, time);
    }
}

