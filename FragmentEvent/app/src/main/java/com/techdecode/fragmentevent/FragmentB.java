package com.techdecode.fragmentevent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class FragmentB extends Fragment {

    TextView textViewB;
    EditText editTextB;
    Button buttonB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        textViewB = view.findViewById(R.id.TextViewFragmentB);
        editTextB = view.findViewById(R.id.EditTextFragmentB);
        buttonB = view.findViewById(R.id.buttonB);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), editTextB.getText().toString(), Toast.LENGTH_SHORT).show();
                TextView textViewA = Objects.requireNonNull(getActivity()).findViewById(R.id.TextViewFragmentA);
                textViewA.setText(editTextB.getText().toString());
            }
        });

        return view;
    }
}
