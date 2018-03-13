package com.daetsoooe.naaq.tips;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daetsoooe.naaq.R;
import com.daetsoooe.naaq.test.TutorialActivity;


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

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return super.getViewModelStore();
    }

    public ScreenSlidePageFragment() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
    }

    @Override
    public void setInitialSavedState(@Nullable SavedState state) {
        super.setInitialSavedState(state);
    }

    @Override
    public void setTargetFragment(@Nullable Fragment fragment, int requestCode) {
        super.setTargetFragment(fragment, requestCode);
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setRetainInstance(boolean retain) {
        super.setRetainInstance(retain);
    }

    @Override
    public void setHasOptionsMenu(boolean hasMenu) {
        super.setHasOptionsMenu(hasMenu);
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    public class fsfsdfasdf {

        private String a323232;
        private String a323322;
        private String a323;
        private String a3232;
        private String a322;
        private String a35;
        private String a15;
        private String a215;
        private String a5;
        private String a4;
        private String a3;
        private String a2;
        private String a32;

        public String getA323232() {
            return a323232;
        }

        public String getA323322() {
            return a323322;
        }

        public String getA323() {
            return a323;
        }

        public String getA3232() {
            return a3232;
        }

        public String getA322() {
            return a322;
        }

        public String getA35() {
            return a35;
        }

        public String getA15() {
            return a15;
        }

        public String getA215() {
            return a215;
        }

        public String getA5() {
            return a5;
        }

        public String getA4() {
            return a4;
        }

        public String getA3() {
            return a3;
        }

        public String getA2() {
            return a2;
        }

        public String getA32() {
            return a32;
        }

        public void setA323232(String a323232) {
            this.a323232 = a323232;
        }

        public void setA323322(String a323322) {
            this.a323322 = a323322;
        }

        public void setA323(String a323) {
            this.a323 = a323;
        }

        public void setA3232(String a3232) {
            this.a3232 = a3232;
        }

        public void setA322(String a322) {
            this.a322 = a322;
        }

        public void setA35(String a35) {
            this.a35 = a35;
        }

        public void setA15(String a15) {
            this.a15 = a15;
        }

        public void setA215(String a215) {
            this.a215 = a215;
        }

        public void setA5(String a5) {
            this.a5 = a5;
        }

        public void setA4(String a4) {
            this.a4 = a4;
        }

        public void setA3(String a3) {
            this.a3 = a3;
        }

        public void setA2(String a2) {
            this.a2 = a2;
        }

        public void setA32(String a32) {
            this.a32 = a32;
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
