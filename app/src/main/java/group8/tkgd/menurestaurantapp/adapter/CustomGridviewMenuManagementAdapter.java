package group8.tkgd.menurestaurantapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import group8.tkgd.menurestaurantapp.activity.DishDetailActivity;
import group8.tkgd.menurestaurantapp.activity.MenuEditDetailActivity;
import group8.tkgd.menurestaurantapp.activity.MenuManagementActivity;
import group8.tkgd.menurestaurantapp.model.Dish;
import group8.tkgd.menurestaurantapp.R;

public class CustomGridviewMenuManagementAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Dish> dishes;

    public CustomGridviewMenuManagementAdapter(Context context, int layout, List<Dish> dishes) {
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View viewrow = convertView;
        if (viewrow == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewrow = inflater.inflate(layout, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.image = viewrow.findViewById(R.id.imageDish);
            holder.name = viewrow.findViewById(R.id.titleDish);
            holder.price = viewrow.findViewById(R.id.titlePrice);
            holder.btnEdit = viewrow.findViewById(R.id.btnEditMenu);
            holder.btnDelete = viewrow.findViewById(R.id.btnDeleteMenu);

            viewrow.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) viewrow.getTag();
        holder.image.setImageResource(dishes.get(position).getImage());
        holder.name.setText(dishes.get(position).getName());
        holder.price.setText("" + dishes.get(position).getPrice() + "$");
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dishes.get(position).getDescription(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MenuEditDetailActivity.class);
                intent.putExtra("image", "" + dishes.get(position).getImage());
                intent.putExtra("name", "" + dishes.get(position).getName());
                intent.putExtra("price", "" + dishes.get(position).getPrice());
                intent.putExtra("description", "" + dishes.get(position).getDescription());
                context.startActivity(intent);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Delete " + dishes.get(position).getName(),  Toast.LENGTH_SHORT).show();
                dishes.remove(position);
                notifyDataSetChanged();
            }
        });
        return viewrow;
    }

    private class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        Button btnEdit;
        Button btnDelete;
    }
}
