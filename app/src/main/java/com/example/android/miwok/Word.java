package com.example.android.miwok;


public class Word {

    //default translation for the word
    private String mDefaultTranslation;

    //miwok translation for the word
    private String mMiwokTranslation;

    /**
     *
     * @param defaultTranslation is the word in default language
     * @param miwokTranslation Is the word  in miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    //Get the default translation for the word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    //Get the miwok translation for the word
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

}
