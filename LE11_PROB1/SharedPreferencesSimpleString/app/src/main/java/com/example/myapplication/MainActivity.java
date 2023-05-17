package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(getApplication()).inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.eng:
            {Toast.makeText(this,"English",Toast.LENGTH_SHORT).show();
                textView.setText("English");
                sharedPreferences.edit().putString("title","English").apply();
                return true;}
            case R.id.hin:
            {Toast.makeText(this,"Hindi",Toast.LENGTH_SHORT).show();
                textView.setText("Hindi");
                sharedPreferences.edit().putString("title","Hindi").apply();
                return true;}
            case R.id.dev:
            {Toast.makeText(this,"Devnagari",Toast.LENGTH_SHORT).show();
                textView.setText("Devnagari");
                sharedPreferences.edit().putString("title","Devnagari").apply();
                return true;}
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.example.myapplication", 0);
        String pref = sharedPreferences.getString("title", "default");
        textView.setText(pref);
    }
}
