package com.example.listmostrichperson;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends ArrayAdapter<Person> {
    private Context context;
    private int layoutResourceId;

    public PersonAdapter(Context context, int layoutResourceId, Person[] data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
        }

        // Получите текущий объект Person
        Person person = getItem(position);
        if (person != null) {
            // Найдите элементы в макете
            ImageView flagImageView = convertView.findViewById(R.id.flagImageView);
            TextView nameTextView = convertView.findViewById(R.id.nameTextView);
            TextView moneyTextView = convertView.findViewById(R.id.moneyTextView);
            ImageButton openBrowserButton = convertView.findViewById(R.id.openBrowserButton);
            // Установите данные из объекта Person в элементы
            flagImageView.setImageResource(person.getFlagResource());
            nameTextView.setText(person.getName());
            moneyTextView.setText(person.getMoney());
            openBrowserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Откройте поисковую страницу в браузере
                    String searchQuery = person.getName(); // Используйте имя знаменитости в качестве запроса
                    Uri uri = Uri.parse("https://www.google.com/search?q=" + searchQuery);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);
                }
            });
        }

        return convertView;
    }
}
