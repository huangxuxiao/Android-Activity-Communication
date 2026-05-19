package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button buttonIntent, buttonImplicitIntent;
    private Intent intentToSecond, implicitIntentToSecond;
    private EditText editTextStuId, editTextStuName, editTextStuMajor, editTextStuClass;
    private RadioGroup radioGroupGender;
    private Spinner spinnerSchool;
    private RadioButton radioButtonMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonMale = (RadioButton)findViewById(R.id.male);
        radioButtonMale.setChecked(true);

        editTextStuId = (EditText)findViewById(R.id.stuId);
        editTextStuName = (EditText)findViewById(R.id.stuName);
        radioGroupGender = (RadioGroup)findViewById(R.id.gender);
        spinnerSchool = (Spinner)findViewById(R.id.school);
        editTextStuMajor = (EditText)findViewById(R.id.stuMajor);
        editTextStuClass = (EditText)findViewById(R.id.stuClass);
        buttonIntent = (Button)findViewById(R.id.intentStart);
        buttonImplicitIntent = (Button)findViewById(R.id.implicitIntentStart);

        intentToSecond = new Intent(this, SecondActivity.class);
        implicitIntentToSecond = new Intent("com.example.myapplication.SECOND_ACTION");

        buttonIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intentToSecond.putExtra("stuId", editTextStuId.getText().toString());
                intentToSecond.putExtra("stuName", editTextStuName.getText().toString());

                for(int i=0;i<radioGroupGender.getChildCount();i++){
                    RadioButton r=(RadioButton)radioGroupGender.getChildAt(i);
                    if(r.isChecked()){
                        intentToSecond.putExtra("stuGender", r.getText());
                        break;
                    }
                }

                intentToSecond.putExtra("stuSchool", spinnerSchool.getSelectedItem().toString());
                intentToSecond.putExtra("stuMajor", editTextStuMajor.getText().toString());
                intentToSecond.putExtra("stuClass", editTextStuClass.getText().toString());
                startActivity(intentToSecond);
            }
        });

        buttonImplicitIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                implicitIntentToSecond.putExtra("stuId", editTextStuId.getText().toString());
                implicitIntentToSecond.putExtra("stuName", editTextStuName.getText().toString());

                for(int i=0;i<radioGroupGender.getChildCount();i++){
                    RadioButton r=(RadioButton)radioGroupGender.getChildAt(i);
                    if(r.isChecked()){
                        implicitIntentToSecond.putExtra("stuGender", r.getText());
                        break;
                    }
                }

                implicitIntentToSecond.putExtra("stuSchool", spinnerSchool.getSelectedItem().toString());
                implicitIntentToSecond.putExtra("stuMajor", editTextStuMajor.getText().toString());
                implicitIntentToSecond.putExtra("stuClass", editTextStuClass.getText().toString());

                startActivity(implicitIntentToSecond);
            }
        });
    }
}