package tech.codeninjas.vetfinder;

import android.content.Context;

import java.util.ArrayList;

public class ManualML {
    private final String[] mFmdSymptoms;
    private final String[] mBtSymptoms;
    private final String[] mBlSymptoms;
    private final String[] mRvfSymptoms;
    private final Context mContext;
    private int mFmdCount=0;
    private int mBtCount=0;
    private int mBlCount=0;
    private int mRvfCount=0;
    private ArrayList<Diseases> diseases;
    ManualML(Context ctx){
        mContext=ctx;
        Diseases dis=new Diseases(ctx);
        mFmdSymptoms=dis.getFoodAndMouthSymptoms();
        mBtSymptoms=dis.getBlueTongueSymptoms();
        mBlSymptoms=dis.getBlackLegSymptoms();
        mRvfSymptoms=dis.getRiftValleyFeverSymptoms();
    }
    public ArrayList<Diseases> diagnose(ArrayList<String> symptoms){
        for(int i=0;i<symptoms.size();i++){
            if(symptoms.get(i).equalsIgnoreCase(mFmdSymptoms[i])){
                mFmdCount++;
            };
            if(symptoms.get(i).equalsIgnoreCase(mBlSymptoms[i])){
                mFmdCount++;
            };
            if(symptoms.get(i).equalsIgnoreCase(mRvfSymptoms[i])){
                mRvfCount++;
            };
        }
        if(mFmdCount>=3){
            diseases.add(new Diseases(mContext,
                    mContext.getResources().getString(R.string.food_mouth_disease),
                    "file:///android_asset/foot_and_mouth_disease.html"));
        }
        if(mBtCount>=3){
            diseases.add(new Diseases(mContext,
                    mContext.getResources().getString(R.string.blue_tongue_disease),
                    "file:///android_asset/blue_tongue.html"));
        }
        if(mBlCount>=3){
            diseases.add(new Diseases(mContext,
                    mContext.getResources().getString(R.string.black_leg_disease),
                    "file:///android_asset/blackleg_disease.html"));
        }
        if(mRvfCount>=3){
            diseases.add(new Diseases(mContext,
                    mContext.getResources().getString(R.string.rift_valley_disease),
                    "file:///android_asset/rift_vally_fever.html"));
        }
        return  diseases;
    }
}
