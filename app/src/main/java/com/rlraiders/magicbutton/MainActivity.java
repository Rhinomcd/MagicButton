package com.rlraiders.magicbutton;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import info.hoang8f.widget.FButton;


public class MainActivity extends ActionBarActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button);
        if(button!=null) {
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    int randomCondition = new Random().nextInt(50);
                    if (randomCondition < 10){
                        TextView mainText = (TextView) findViewById(R.id.textView);
                        mainText.setText("Case1");
                    }
                    else if(randomCondition < 20){
                        TextView mainText = (TextView) findViewById(R.id.textView);
                        mainText.setText("Case2");
                    }
                    else if (randomCondition < 30){
                        FButton magicButton = (FButton) findViewById(R.id.button);
                        magicButton.setButtonColor(getResources().getColor(R.color.fbutton_color_orange));
                    }
                    else{
                        FButton magicButton = (FButton) findViewById(R.id.button);
                        magicButton.setButtonColor(getResources().getColor(R.color.fbutton_color_turquoise));
                    }
                }
            });
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // int id = item.getItemId();

        switch (item.getItemId()) {
            case 0:
                startActivity(new Intent(this, ShowSettingsActivity.class));
                return true;
        }
        return false;
    }
}
