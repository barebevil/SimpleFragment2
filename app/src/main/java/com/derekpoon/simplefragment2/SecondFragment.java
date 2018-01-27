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
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private final String FRAG2_TAG = "Second Fragment";
    private EditText mEditText;
    private String mMessage;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("frag2_key", mMessage);
    }

    //when a fragment is connected to an activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(FRAG2_TAG, "onAttach() called");
    }

    //the system calls this when creating the fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(FRAG2_TAG, "onCreate() called");
    }

    //to inflate a view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(FRAG2_TAG, "onCreatView() called");

        //Inflates the fragment layout
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        return view;
    }

    //is called after onCreateView()
    //any view setup should occur here, e.g. attaching listeners
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(FRAG2_TAG, "onViewCreated() called");

        mEditText = view.findViewById(R.id.frag2_edit_text);
        if (savedInstanceState != null) {
            Toast.makeText(getActivity(), "saveState = FOUND", Toast.LENGTH_SHORT).show();
            mMessage = savedInstanceState.getString("frag2_key");
            mEditText.setText(mMessage);
        }
    }

    //when the fragment is ready to be displayed on screen
    @Override
    public void onStart() {
        super.onStart();
        Log.d(FRAG2_TAG, "onStart() called");
    }

    //the fragment is not visible
    @Override
    public void onStop() {
        super.onStop();
        Log.d(FRAG2_TAG, "onStop() called");
    }

    //the fragment is running in the activity
    @Override
    public void onResume() {
        super.onResume();
        Log.d(FRAG2_TAG, "onResume() called");
    }

    //when another activity in the foreground has focus, but the activity hosting this fragment is still visible
    @Override
    public void onPause() {
        super.onPause();
        Log.d(FRAG2_TAG, "onPause() called");
    }
}
