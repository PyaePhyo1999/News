package xyz.arkarhein.news.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.news.R;

/**
 * Created by Acer on 1/20/2018.
 */

public class LoginFragment extends android.support.v4.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragrament_login,container,false);
        ButterKnife.bind(this,view);
        return view;
    }
}
