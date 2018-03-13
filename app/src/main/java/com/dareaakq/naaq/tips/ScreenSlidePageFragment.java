package com.dareaakq.naaq.tips;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dareaakq.naaq.R;
import com.dareaakq.naaq.TutorialActivity;


public class ScreenSlidePageFragment extends Fragment {

    public static final String ARG_PAGE = "page";
    public static final String MODE = "mode";
    private int pageNumber = 0;
    private String mode;
    private TextView tv_title;
    private TextView tv_text;
    private View line;


    public static ScreenSlidePageFragment create(int pageNumber, String mode) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putString(MODE, mode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mode = getArguments().getString(MODE);
            pageNumber = getArguments().getInt(ARG_PAGE);
        }
        line = view.findViewById(R.id.line);
        tv_text = view.findViewById(R.id.tv_text);
        tv_title = view.findViewById(R.id.tv_title);

        if (mode.equals(TutorialActivity.BOY_SCREEN)) {
            boyMode(pageNumber);
        } else {
            girlMode(pageNumber);
        }

    }

    private void girlMode(int pageNumber) {
        line.setBackgroundColor(getResources().getColor(R.color.colorGirl));
        tv_text.setText(getGirlText(pageNumber));
        tv_title.setText(getGirlTextTitle(pageNumber));
    }

    private void boyMode(int pageNumber) {
        line.setBackgroundColor(getResources().getColor(R.color.colorMen));
        tv_text.setText(getMenText(pageNumber));
        tv_title.setText(getMenTextTitle(pageNumber));
    }

    private int getMenTextTitle(int pageNumber) {
        switch (pageNumber) {
            case 0 : return R.string.hint_title_men1;
            case 1 : return R.string.hint_title_men2;
            case 2 : return R.string.hint_title_men3;
            case 3 : return R.string.hint_title_men4;
            case 4 : return R.string.hint_title_men5;
            case 5 : return R.string.hint_title_men6;
            default: return R.string.hint_title_men1;
        }
    }

    private int getMenText(int pageNumber) {
        switch (pageNumber) {
            case 0 : return R.string.hint_text_men1;
            case 1 : return R.string.hint_text_men2;
            case 2 : return R.string.hint_text_men3;
            case 3 : return R.string.hint_text_men4;
            case 4 : return R.string.hint_text_men5;
            case 5 : return R.string.hint_text_men6;
            default: return R.string.hint_text_men1;
        }
    }

    private int getGirlText(int pageNumber){
        switch (pageNumber) {
            case 0 : return R.string.hint_text_girl1;
            case 1 : return R.string.hint_text_girl2;
            case 2 : return R.string.hint_text_girl3;
            case 3 : return R.string.hint_text_girl4;
            case 4 : return R.string.hint_text_girl5;
            case 5 : return R.string.hint_text_girl6;
            default: return R.string.hint_text_girl1;
        }
    }
    private int getGirlTextTitle(int pageNumber){
        switch (pageNumber) {
            case 0 : return R.string.hint_title_girl1;
            case 1 : return R.string.hint_title_girl2;
            case 2 : return R.string.hint_title_girl3;
            case 3 : return R.string.hint_title_girl4;
            case 4 : return R.string.hint_title_girl5;
            case 5 : return R.string.hint_title_girl6;
            default: return R.string.hint_title_girl1;
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.item_human, container, false);
    }


}
