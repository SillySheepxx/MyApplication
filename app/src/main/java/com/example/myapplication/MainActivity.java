package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtSex,edtAge;
    TextView txtR;
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSex=(EditText)findViewById(R.id.edtSex);
        edtAge=(EditText)findViewById(R.id.edtAge);
        txtR=(TextView)findViewById(R.id.txtR);
        btnOK=(Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strSex=edtSex.getText().toString();
            int iAge=Integer.parseInt(edtAge.getText().toString());
            String strSug=getString(R.string.suggestion);

            if(strSex.equals(getString(R.string.sex_male)))
            {
                if(iAge<28)
                {
                    strSug+=getString(R.string.sug_not_hurry);
                    Log.d("MarriSug","man not hurry!");
                }
                else if(iAge>33)
                {
                    strSug+=getString(R.string.sug_get_married);
                    Log.d("MarriSug","man get married!");
                }
                else
                {
                    strSug+=getString(R.string.sug_find_couple);
                    Log.d("MarriSug","man find couple!");
                }
            }
            else
            {
                if(iAge<25)
                {
                    strSug+=getString(R.string.sug_not_hurry);
                    Log.d("MarriSug","woman not hurry!");
                }
                else if(iAge>30)
                {
                    strSug+=getString(R.string.sug_get_married);
                    Log.d("MarriSug","woman get married!");
                }
                else
                {
                    strSug+=getString(R.string.sug_find_couple);
                    Log.d("MarriSug","woman find couple!");
                }
            }
            txtR.setText(strSug);
        }
    };
}