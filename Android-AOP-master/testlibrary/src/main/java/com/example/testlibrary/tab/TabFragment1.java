package com.example.testlibrary.tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testlibrary.R;
import com.example.testlibrary.basefragment;

/**
 * Created by chengxi on 17/4/26.
 */
public class TabFragment1 extends basefragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       return inflater.inflate(R.layout.fragment_tab_1, null);

    }
}
