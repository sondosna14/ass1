package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.content.Intent;

import android.os.Bundle;
import android.widget.EditText;

import com.example.helloworld.Model.userinfo;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private EditText name;
    private EditText email;
    private EditText pass;
    private EditText conf;
    public static final String Name = "Name";
    public static final String Email = "Email";

    public static final String Password = "Password";
    public static final String ConfPass = "Confirm";
    String edtName, edtEmail, edtPass, edtConf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




    }
    public void btnRegisterOnClick(View v) {
        userinfo[] user = new userinfo[1];
        user[1]=new userinfo("username","email","password","conpassword");
        Gson gson = new Gson();
        String userString = gson.toJson(user);

        Intent intent = new Intent(RegisterActivity.this , HomeActivity.class);
        startActivity(intent);
        setUpViews();
        setUpSharedPrefs();
        loadPrefs();

    }

    public void btnRegister(View view){
        edtName = name.getText().toString();
        edtEmail = email.getText().toString();
        edtPass = pass.getText().toString();
        edtConf = conf.getText().toString();

        editor.putString(Name, edtName);
        editor.putString(Email,edtEmail);
        editor.putString(Password,edtPass);
        editor.putString(ConfPass,edtPass);
        editor.commit();




    }

    private void setUpViews(){
        name = findViewById(R.id.inputUsername);
        email = findViewById(R.id.inputEmail);
        pass = findViewById(R.id.inputPassword);
        conf = findViewById(R.id.inputConfirmPassword);
    }

    private void setUpSharedPrefs(){
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor= prefs.edit();
    }
    private void loadPrefs(){
        edtName = prefs.getString(Name,"");
        edtEmail = prefs.getString(Email,"");
        edtPass = prefs.getString(Password,"");
        edtConf = prefs.getString(ConfPass,"");


        name.setText(edtName);
        email.setText(edtEmail);
        pass.setText(edtPass);
        conf.setText(edtConf);
    }




}