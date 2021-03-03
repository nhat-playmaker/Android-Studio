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

    private class ViewHolder {
        ImageView imageViewFruit;
        TextView textViewName, textViewDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Đối tượng ViewHolder được dùng để giữ trạng thái cũ của view,
        // Để khi scroll screen, view không phải tạo lại mà chỉ lấy lại view đã được giữ trước đó
        ViewHolder holder;

        if (convertView == null) {
            // Đối tượng truyền context (MainActivity)
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Truyền vào inflater đã inflate layout truyền vào
            convertView = inflater.inflate(layout, null);

            holder = new ViewHolder();
            // Ánh xạ sang convertView
            holder.textViewName = (TextView) convertView.findViewById(R.id.textViewFruitName);
            holder.textViewDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
            holder.imageViewFruit = (ImageView) convertView.findViewById(R.id.imageViewFruit);

            // Tuyền phần ánh xạ vào convertView
            convertView.setTag(holder);
        }
        else {
            // Nếu đã có thì lấy lại giá trị Tag
            holder = (ViewHolder) convertView.getTag();
        }

        // Gán giá trị
        Fruit fruit = fruitList.get(position);
        holder.textViewName.setText(fruit.getName());
        holder.textViewDescription.setText(fruit.getDescription());
        holder.imageViewFruit.setImageResource(fruit.getImageCode());

        return convertView;
    }
}
