package com.techdecode.listviewadvance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, List<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        // Trả về số phần tử của List
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Đối tượng truyền context (MainActivity)
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Truyền vào inflater đã inflate layout truyền vào
        convertView = inflater.inflate(layout, null);

        // Ánh xạ sang convertView
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewFruitName);
        TextView textViewDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
        ImageView imageViewFruit = (ImageView) convertView.findViewById(R.id.imageViewFruit);

        // Gán giá trị
        Fruit fruit = fruitList.get(position);
        textViewName.setText(fruit.getName());
        textViewDescription.setText(fruit.getDescription());
        imageViewFruit.setImageResource(fruit.getImageCode());

        return convertView;
    }
}
