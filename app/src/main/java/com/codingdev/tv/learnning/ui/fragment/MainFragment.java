package com.codingdev.tv.learnning.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.TitleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingdev.tv.learnning.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MainFragment extends BrowseSupportFragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUIElements();
        TitleView titleView;
    }


    private void setUIElements() {
        setTitle(getString(R.string.browse_title));
        setHeadersState(HEADERS_DISABLED);
    }
}