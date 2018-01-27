package com.derekpoon.simplefragment2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by derekpoon on 11/01/2018.
 */

public class FirstFragment extends Fragment {

    private final String FRAG1_TAG = "First Fragment";
    private EditText mEditText;
    private String mMessage;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("frag1_key", mMessage);
    }

    //when a fragment is connected to an activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(FRAG1_TAG, "onAttach() called");
    }

    //the system calls this when creating the fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(FRAG1_TAG, "onCreate() called");
    }

    //to inflate a view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(FRAG1_TAG, "onCreatView() called");

        //Inflates the fragment layout
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }

    //is called after onCreateView()
    //any view setup should occur here, e.g. attaching listeners
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(FRAG1_TAG, "onViewCreated() called");

        mEditText = view.findViewById(R.id.frag1_edit_text);
        if (savedInstanceState != null) {
            Toast.makeText(getActivity(), "saveState = FOUND", Toast.LENGTH_SHORT).show();
            mMessage = savedInstanceState.getString("frag1_key");
            mEditText.setText(mMessage);
        }
    }

    //when the fragment is ready to be displayed on screen
    @Override
    public void onStart() {
        super.onStart();
        Log.d(FRAG1_TAG, "onStart() called");
    }

    //the fragment is not visible
    @Override
    public void onStop() {
        super.onStop();
        Log.d(FRAG1_TAG, "onStop() called");
    }

    //the fragment is running in the activity
    @Override
    public void onResume() {
        super.onResume();
        Log.d(FRAG1_TAG, "onResume() called");
    }

    //when another activity in the foreground has focus, but the activity hosting this fragment is still visible
    @Override
    public void onPause() {
        super.onPause();
        Log.d(FRAG1_TAG, "onPause() called");
    }
}
