package com.example.weather.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weather.R;
import com.example.weather.SingletonPattern.Singleton;
import com.squareup.picasso.Picasso;

public class TomorrowFragment extends Fragment {

    ImageView mNextIcon1, mNextIcon2;

    TextView mMaxTemp1, mMaxTemp2;
    TextView mMinTemp1, mMinTemp2;
    TextView mNextText1, mNextText2;
    TextView mNextDate1, mNextDate2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_tomorrow,container,false);

        mNextIcon1 = view.findViewById(R.id.nextIcon1);
        mMaxTemp1 = view.findViewById(R.id.maxTemp1);
        mMinTemp1 = view.findViewById(R.id.minTemp1);
        mNextText1 = view.findViewById(R.id.nextText1);
        mNextDate1 = view.findViewById(R.id.nextDate1);

        mNextIcon2 = view.findViewById(R.id.nextIcon2);
        mMaxTemp2 = view.findViewById(R.id.maxTemp2);
        mMinTemp2 = view.findViewById(R.id.minTemp2);
        mNextText2 = view.findViewById(R.id.nextText2);
        mNextDate2 = view.findViewById(R.id.nextDate2);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Singleton singleton = Singleton.getInstance();

        //mTCountry.setText(singleton.getDate());

        Picasso.get()
                .load("http:" + singleton.getNextIcon1())
                .into(mNextIcon1);
        mMaxTemp1.setText(singleton.getMaxTemp1());
        mMinTemp1.setText(singleton.getMinTemp1());
        mNextText1.setText(singleton.getNextText1());
        mNextDate1.setText(singleton.getNextDate1());

        Picasso.get()
                .load("http:" + singleton.getNextIcon2())
                .into(mNextIcon2);
        mMaxTemp2.setText(singleton.getMaxTemp2());
        mMinTemp2.setText(singleton.getMinTemp2());
        mNextText2.setText(singleton.getNextText2());
        mNextDate2.setText(singleton.getNextDate2());
    }
}
