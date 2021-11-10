package com.codingdev.tv.learnning.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardRow {

    /*type: default is list cards*/
    public static final int TYPE_DEFAULT = 0;
    /**/
    public static final int TYPE_SECTION_HEADER = 1;
    /*type: divider.*/
    public static final int TYPE_DIVIDER =2;

    @SerializedName("type") private int mType = TYPE_DEFAULT;
    // Used to determine whether the row shall use shadows when displaying its cards or not.
    @SerializedName("shadow") private boolean mShadow = true;
    @SerializedName("title") private String mTitle;
    @SerializedName("cards") private List<Card> mCards;

    public int getType() {
        return mType;
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean useShadow() {
        return mShadow;
    }

    public List<Card> getCards() {
        return mCards;
    }
}
