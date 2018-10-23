package tech.codeninjas.vetfinder;

import android.content.Context;
import android.content.res.Resources;

public class Diseases {
    private String mDescPath;
    private String mName;
    private Resources res;
    private Context mContext;
    Diseases(Context ctx,String name,String htmlPath){
        mContext=ctx;
        res= mContext.getResources();
        mName = name;
        mDescPath=htmlPath;
    }
    Diseases(Context ctx){
        mContext=ctx;
        res= mContext.getResources();
    }
    public String[] getFoodAndMouthSymptoms(){
        String[] symptoms={res.getString(R.string.fever),
                res.getString(R.string.bilsters_in_the_mouth_and_feet),
                res.getString(R.string.weight_loss),
                res.getString(R.string.loss_of_appetite),
                res.getString(R.string.drop_in_milk_production),
                res.getString(R.string.lameness)
        };
        return symptoms;
    }
    public  String[] getRiftValleyFeverSymptoms(){
        String[] symptoms={res.getString(R.string.fever),
                res.getString(R.string.weakness),
                res.getString(R.string.abortion),
                res.getString(R.string.loss_of_appetite),
        };
        return symptoms;
    }
    public  String[] getBlackLegSymptoms(){
        String[] symptoms={res.getString(R.string.fever),
                res.getString(R.string.rapid_breathing),
                res.getString(R.string.weight_loss),
                res.getString(R.string.loss_of_appetite),
                res.getString(R.string.lameness),
        };
        return symptoms;
    }
    public  String[] getBlueTongueSymptoms(){
        String[] symptoms={res.getString(R.string.fever),
                res.getString(R.string.lameness)
        };
        return symptoms;
    }

    public String getmDescPath() {
        return mDescPath;
    }

    public String getmName() {
        return mName;
    }
}
