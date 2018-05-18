package group8.tkgd.menurestaurantapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import group8.tkgd.menurestaurantapp.model.Dish;
import group8.tkgd.menurestaurantapp.R;

public class CustomGridviewMainMenuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Dish> dishes;

    public CustomGridviewMainMenuAdapter(Context context, int layout, List<Dish> dishes) {
        this.context = context;
        this.layout = layout;
        this.dishes = dishes;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewrow = convertView;
        if (viewrow == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewrow = inflater.inflate(layout, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.image = viewrow.findViewById(R.id.imageDish);
            holder.name = viewrow.findViewById(R.id.titleDish);
            holder.price = viewrow.findViewById(R.id.titlePrice);

            viewrow.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) viewrow.getTag();
        holder.image.setImageResource(dishes.get(position).getImage());
        holder.name.setText(dishes.get(position).getName());
        holder.price.setText("" + dishes.get(position).getPrice() + "$");
        return viewrow;
    }

    private class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
    }

}
