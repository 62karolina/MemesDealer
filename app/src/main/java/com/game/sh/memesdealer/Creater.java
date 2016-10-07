package com.game.sh.memesdealer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Creater extends AppCompatActivity {

    ImageButton popMenu;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creater);


        popMenu = (ImageButton)findViewById(R.id.subMenu);
        textView = (TextView) findViewById(R.id.textView);

        popMenu.setOnClickListener(viewClickListener);

    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu); // Для Android 4.0

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(),
                                "Вы выбрали PopupMenu 1",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(),
                                "Вы выбрали PopupMenu 2",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(),
                                "Вы выбрали PopupMenu 3",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "onDismiss",
                        Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }


}
