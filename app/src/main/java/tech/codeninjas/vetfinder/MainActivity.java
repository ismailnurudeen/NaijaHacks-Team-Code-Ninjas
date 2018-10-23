package tech.codeninjas.vetfinder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private CardView diagnoseCard,pendingTreatmentCard,doctorsCard,virtualDoctorsCard,settingsCard,helpCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diagnoseCard=findViewById(R.id.diagnosecardId);
        pendingTreatmentCard=findViewById(R.id.pending_treatment_card_id);
        doctorsCard=findViewById(R.id.doctors_card_id);
        virtualDoctorsCard=findViewById(R.id.virtual_doctor_card_id);
        settingsCard=findViewById(R.id.settings_card_id);
        helpCard=findViewById(R.id.help_card_id);
    }
    public void onHomeCardClicked(View v){
        switch (v.getId()){
            case R.id.diagnosecardId:
                gotoAvtivity(DiagnoseActivity.class);
                break;
            case R.id.pending_treatment_card_id:
                gotoAvtivity(PendingTreatmentActivity.class);
                break;
            case R.id.doctors_card_id:
                gotoAvtivity(VetListingActivity.class);
                break;
            case R.id.virtual_doctor_card_id:
                gotoAvtivity(VetProfileActivity.class);
                break;
            case R.id.settings_card_id:
               // gotoAvtivity(SettingsActivity.class);
                gotoAvtivity(SettingsActivity.class);
                break;
            case R.id.help_card_id:
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("email"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL,"ibrightstar247@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"What you need help with?");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"Choose email app"));
                break;
        }
    }
    private void gotoAvtivity(Class activity){
        Intent in=new Intent(MainActivity.this,activity);
        startActivity(in);
    }
}
