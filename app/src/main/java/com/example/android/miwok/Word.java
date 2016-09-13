package com.example.android.miwok;


import android.graphics.drawable.Drawable;
import android.media.Image;

public class Word {

    //default translation for the word
    private String mDefaultTranslation;

    //miwok translation for the word
    private String mMiwokTranslation;

    //get the image resource id for the correct image
    private int mImageResourceId = NO_IMAGE_PROVIDED; //By default we will set it to NO image

    //set to -1 because VISIBLE, INVISIBLE and GONE use variables other then -1
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mSongResourceId;

    /**
     * Create a word constructor
     *
     * @param defaultTranslation is the word in default language
     * @param miwokTranslation   Is the word  in miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation) {

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     *
     * @param defaultTranslation is the word in default language
     * @param miwokTranslation is the word in miwok translation
     * @param imageResourceId is the image reasource id for the image associated with the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;

    }

    /**
     *
     * @param defaultTranslation is the word in default language
     * @param miwokTranslation is the word in miwok translation
     * @param imageResourceId is the image reasource id for the image associated with the word
     * @param songResourceId is the song resource id for the image associated with the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int songResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSongResourceId = songResourceId;
    }

    //Get the default translation for the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //Get the miwok translation for the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //gets the resource id of the image
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /*
     * Returns whether or not there is an image for this word
     * If mImageResourceId is not equal to -1 then it must have an image
     * associated with it and will return true
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    //gets the resource id for the song
    public int getSongResourceId(){
        return mSongResourceId;
    }

}
