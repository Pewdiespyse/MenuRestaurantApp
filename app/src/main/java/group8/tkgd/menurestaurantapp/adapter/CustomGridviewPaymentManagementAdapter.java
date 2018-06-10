package group8.tkgd.menurestaurantapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
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

public class CustomGridviewPaymentManagementAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Dish> dishes;

    public CustomGridviewPaymentManagementAdapter(Context context, int layout, List<Dish> dishes) {
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
            CustomGridviewPaymentManagementAdapter.ViewHolder holder = new CustomGridviewPaymentManagementAdapter.ViewHolder();
            holder.image = viewrow.findViewById(R.id.imageDishPayment);
            holder.name = viewrow.findViewById(R.id.titleDishPayment);
            holder.price = viewrow.findViewById(R.id.titlePricePayment);
            holder.rate = viewrow.findViewById(R.id.titleRatePayment);
            holder.countOfDish = viewrow.findViewById(R.id.titleCountOfDishDetailPayment);
            holder.count = (int)(Math.random()*10) % 3 + 1;
            viewrow.setTag(holder);
        }

        final CustomGridviewPaymentManagementAdapter.ViewHolder holder = (CustomGridviewPaymentManagementAdapter.ViewHolder) viewrow.getTag();
        holder.image.setImageResource(dishes.get(position).getImage());
        holder.name.setText(dishes.get(position).getName());
        holder.price.setText("" + dishes.get(position).getPrice() + "$");
        holder.rate.setText("" + dishes.get(position).getRate());
        holder.countOfDish.setText("" + holder.count);
        return viewrow;
    }

    private class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        TextView rate;
        TextView countOfDish;
        int count;
    }
}
