package com.game.sh.memesdealer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost.TabSpec tabSpec;
    protected static final String LOG_TAG = "my_tag";
    ImageButton creater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // если хотим, чтобы приложение постоянно имело портретную ориентацию
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // если хотим, чтобы приложение было полноэкранным
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // и без заголовка
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        // инициализация
        tabHost.setup();

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Лента");
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Информация");
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);


        // вторая вкладка по умолчанию активна
        tabHost.setCurrentTabByTag("tag1");

        // логгируем переключение вкладок
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Log.d(LOG_TAG, "tabId = " + tabId);

            }
        });

        creater = (ImageButton)findViewById(R.id.BCreator);
        creater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Creater.class);
                startActivity(intent);
            }
        });

    }
}
