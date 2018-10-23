package tech.codeninjas.vetfinder;

/**
 * Created by ankit on 22/1/18.
 */

public class Vet {
    private String mEmail;
    private String mLanguages;
    private String mPhoneNum;
    private String mId, mName, mAddress,mRating;

    public Vet() {

    }

    public Vet(String mId, String mName, String mAddress,String languages,String phoneNum,String email,String rating) {
        this.mId = mId;
        this.mName = mName;
        this.mAddress = mAddress;
        mLanguages=languages;
        mPhoneNum=phoneNum;
        mEmail=email;
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

    public String getmEmail() {
        return mEmail;
    }

    public String getmLanguages() {
        return mLanguages;
    }

    public String getmPhoneNum() {
        return mPhoneNum;
    }

    public int getmRating() {
        return Integer.parseInt(mRating);
    }
    public void setmRating(int mRating) {
        this.mRating =String.valueOf(mRating);
    }
}
