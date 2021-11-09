package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class HomeActivity extends AppCompatActivity {
    private final String exePeriod[] = {"1 hour a day", "1 hour a week", "1 hour a month"};
    private EditText edtGoal;
    private EditText edtHeight;
    private EditText edtWidth;
    private EditText edtFat;
    private RadioGroup rdg;
    private RadioButton  rbMale;
    private RadioButton  rbFemale;
    private RadioGroup rgd2;
    private RadioButton  age1;
    private RadioButton  age2;
    private RadioButton  age3;
    private Spinner spinner;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public static final String Goal = "Goal";
    public static final String Height = "Height";
    public static final String Width = "Width";
    public static final String Fat = "Fat";
    public static final String Gender = "Gender";
    public static final String Age = "Age";
    public static final String Exercise = "Exercise";
    String GoalStr, HeightStr,WidthStr,FatStr,GenderStr,AgeStr,ExerciseStr;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edtGoal = findViewById(R.id.edtGoal);
        edtHeight = findViewById(R.id.edtHeight);
        edtWidth = findViewById(R.id.edtWidth);
        edtFat = findViewById(R.id.edtFat);
        rdg = findViewById(R.id.rdg);
        rbMale = findViewById(R.id.btnMail);
        rbFemale = findViewById(R.id.btnFemale);
        rgd2 = findViewById(R.id.rdg2);
        age1 = findViewById(R.id.age1);
        age2 = findViewById(R.id.age2);
        age3 = findViewById(R.id.age3);
        spinner = findViewById(R.id.spinner);
        prefs = getSharedPreferences("prefs", 0);
        int genSp = prefs.getInt("genderSp", 3);
        int ageSp = prefs.getInt("ageSp",3);
        editor = prefs.edit();

        if(genSp == 1){
            rbMale.setChecked(true);
        }else if(genSp == 0){
            rbFemale.setChecked(true);
        }

        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.btnMail){
                    editor.putInt("genderSP",1);
                }else if (checkedId == R.id.btnFemale){
                    editor.putInt("genderSP",0);
                }
                editor.commit();
            }
        });

        if(ageSp == 1){
            age1.setChecked(true);
        }else if(genSp == 0){
            age2.setChecked(true);
        }else if(ageSp == 2){
            age3.setChecked(true);
        }
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.age1){
                    editor.putInt("ageSp",1);
                }else if (checkedId == R.id.age2){
                    editor.putInt("ageSp",0);
                }else if (checkedId == R.id.age3) {
                    editor.putInt("ageSp", 2);
                }
                editor.commit();
            }
        });




        ArrayAdapter<String> adapter = new ArrayAdapter<>(HomeActivity.this, android.R.layout.simple_spinner_dropdown_item, exePeriod);
        spinner.setAdapter(adapter);
        setUpSharedPrefs();
        loadPrefs();
    }

    private void btnNextOnClick(View view){
        GoalStr = edtGoal.getText().toString();
        HeightStr = edtHeight.getText().toString();
        WidthStr = edtWidth.getText().toString();
        FatStr = edtFat.getText().toString();
        ExerciseStr = spinner.getSelectedItem().toString();



        editor.putString(Goal,GenderStr);
        editor.putString(Height,HeightStr);
        editor.putString(Width,WidthStr);
        editor.putString(Fat,FatStr);
        editor.putString(Exercise,ExerciseStr);
        editor.commit();
        setUpSharedPrefs();
        loadPrefs();
        Intent intent = new Intent(HomeActivity.this , workActivity.class);
        startActivity(intent);


    }


    private void setUpSharedPrefs(){
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor= prefs.edit();
    }

    private void loadPrefs(){
        GoalStr = prefs.getString(Goal,"");
        HeightStr = prefs.getString(Height,"");
        WidthStr = prefs.getString(Width,"");
        FatStr = prefs.getString(Fat,"");
        GenderStr = prefs.getString(Gender,"");
        AgeStr = prefs.getString(Age,"");
        ExerciseStr = prefs.getString(Exercise,"");


        edtGoal.setText(GoalStr);
        edtHeight.setText(HeightStr);
        edtWidth.setText(WidthStr);
        edtFat.setText(FatStr);
//        Gender
//        Age
        spinner.setSelected(Boolean.parseBoolean(ExerciseStr));


    }



}