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

import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.model.Dish;

public class CustomGridviewOrderManagementAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Dish> dishes;

    public CustomGridviewOrderManagementAdapter(Context context, int layout, List<Dish> dishes) {
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
            holder.btnAdd = viewrow.findViewById(R.id.btnAddOrder);
            holder.btnSub = viewrow.findViewById(R.id.btnSubOrder);
            holder.countOfDish = viewrow.findViewById(R.id.titleCountOfDishDetail);
            holder.count = (int)Math.random() % 3 + 1;
            viewrow.setTag(holder);
        }

        final ViewHolder holder = (ViewHolder) viewrow.getTag();
        holder.image.setImageResource(dishes.get(position).getImage());
        holder.name.setText(dishes.get(position).getName());
        holder.price.setText("" + dishes.get(position).getPrice() + "$");
        holder.countOfDish.setText("" + holder.count);
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.count++;
                holder.countOfDish.setText("" + holder.count);
            }
        });
        holder.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.count--;
                if (holder.count < 0)
                    holder.count = 0;
                holder.countOfDish.setText("" + holder.count);
            }
        });
        return viewrow;
    }

    private class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        TextView countOfDish;
        Button btnAdd;
        Button btnSub;
        int count;
    }

}
