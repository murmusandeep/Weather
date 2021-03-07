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

public class TomorrowFragment extends Fragment {

    TextView mTCountry, mTTimeZone, mTLocalTime;

    TextView mTTemperature, mTWindSpeed, mTWindDirection, mTHumidity, mTCloud, mTFeelslike;

    TextView mTText;
    ImageView mTIcon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        return inflater.inflate(R.layout.fragment_tomorrow,container,false);

        //mTCountry = view.findViewById(R.id.tCountry);
//        mTTimeZone = view.findViewById(R.id.tTimeZone);
//        mTLocalTime = view.findViewById(R.id.tLocalTime);
//
//        mTTemperature = view.findViewById(R.id.tTemperature);
//        mTWindSpeed = view.findViewById(R.id.tWindSpeed);
//        mTWindDirection = view.findViewById(R.id.tWindDirection);
//        mTHumidity = view.findViewById(R.id.tHumidity);
//        mTCloud = view.findViewById(R.id.tCloud);
//        mTFeelslike = view.findViewById(R.id.tFeelsLike);
//
//        mTText = view.findViewById(R.id.tText);
//        mTIcon = view.findViewById(R.id.tIcon);

        //return view;
    }
}
