package com.example.troy.navigationdrawertemplete;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by troy on 16/5/26.
 */
public class FragmentCamera extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                TextView textView = (TextView) getActivity().findViewById(R.id.fragment1_text);
                //                Toast.makeText(getActivity(), textView.getText(), Toast.LENGTH_LONG).show();

                FragmentHome  fragmentHome =  new FragmentHome() ;
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container, fragmentHome).commit();

            }
        });
    }


}
