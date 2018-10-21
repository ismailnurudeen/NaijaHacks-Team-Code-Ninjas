package tech.codeninjas.vetfinder;

/**
 * Created by ankit on 22/1/18.
 */

public class Vet {
    private String mId, mName, mAddress,mRating;

    public Vet() {

    }

    public Vet(String mId, String mName, String mAddress,String phoneNum,String email,String rating) {
        this.mId = mId;
        this.mName = mName;
        this.mAddress = mAddress;
        mRating=rating;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public int getmRating() {
        return Integer.parseInt(mRating);
    }

    public void setmRating(int mRating) {
        this.mRating = String.valueOf(mRating);
    }
}
