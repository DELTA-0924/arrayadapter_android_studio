package com.example.listmostrichperson;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // набор данных, которые свяжем со списком

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Person[] celebrities = new Person[15];
// Продолжайте добавлять элементы для остальных знаменитостей
        Field[] drawablesFields = R.drawable.class.getFields();
        List<Integer> drawableResources = new ArrayList<>();

        for (Field field : drawablesFields) {
            try {
                int resId = field.getInt(null);
                drawableResources.add(resId);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String[] celebritiesname = getResources().getStringArray(R.array.celebrities);
        String[] celebrityfinanse=getResources().getStringArray(R.array.celebrity_finances);
        for(int i=0;i<15;i++){
            celebrities[i] = new Person(celebritiesname[i], celebrityfinanse[i], drawableResources.get(i));
        }
        // получаем элемент ListView
        ListView countriesList = findViewById(R.id.celebrityListView);
        // создаем адаптер
        PersonAdapter adapter = new PersonAdapter(this, R.layout.list_item_layout, celebrities);

        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
    }
}