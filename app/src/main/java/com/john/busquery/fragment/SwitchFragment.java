package com.john.busquery.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.john.busquery.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SwitchFragment extends Fragment {

    @InjectView(R.id.et_start)
    EditText etStart;
    @InjectView(R.id.et_end)
    EditText etEnd;
    @InjectView(R.id.btn_search)
    Button btnSearch;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_switch, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.btn_search)
    public void onClick() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
