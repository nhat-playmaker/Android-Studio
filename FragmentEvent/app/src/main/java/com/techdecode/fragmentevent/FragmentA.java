package com.techdecode.fragmentevent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class FragmentA extends Fragment {

    TextView textViewA;
    EditText editTextA;
    Button buttonA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        textViewA = view.findViewById(R.id.TextViewFragmentA);
        editTextA = view.findViewById(R.id.EditTextFragmentA);
        buttonA = view.findViewById(R.id.buttonA);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), editTextA.getText().toString(), Toast.LENGTH_SHORT).show();

                // getActivity() -> Lấy activity hiện tại đang chứa fragment đó
                TextView textViewMain = Objects.requireNonNull(getActivity()).findViewById(R.id.TextViewMain);
                textViewMain.setText(editTextA.getText().toString());
            }
        });

        return view;
    }

    public void ganNoiDung(String content) {
        textViewA.setText(content);
    }
}
