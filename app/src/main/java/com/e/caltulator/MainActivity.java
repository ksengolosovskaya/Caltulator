package com.e.caltulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    final int M_reset = 1;
    final int M_exit = 2;

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    TextView tV;
    EditText Ed1;
    EditText Ed2;
    String str = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        Ed1 = findViewById(R.id.Ed1);
        Ed2 = findViewById(R.id.Ed2);

        tV = findViewById(R.id.tV);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float num3 = 0;

        if(TextUtils.isEmpty(Ed1.getText().toString())||TextUtils.isEmpty(Ed2.getText().toString())){
            return;
        }
        num1= Float.parseFloat(Ed1.getText().toString());
        num2 = Float.parseFloat(Ed2.getText().toString());

        switch(v.getId()){
            case R.id.b1:
                str = "+";
                num3 = num1 + num2;
                break;
            case R.id.b2:
                str = "-";
                num3 = num1 - num2;
                break;
            case R.id.b3:
                str = "*";
                num3 = num1 * num2;
                break;
            case R.id.b4:
                str = "/";
                num3 = num1/num2;
                break;

        }
        tV.setText(num1 + "" + str + "" + num2 + "" + "=" +""+ num3 );



    }

    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(1,1,1,"reset");
        menu.add(1,2,2,"exit");
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected (MenuItem Item){
        switch(Item.getItemId()){
            case M_reset:
                Ed1.setText(" ");
                Ed2.setText(" ");
                tV.setText(" ");
                break;
            case M_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(Item);
    }


}
