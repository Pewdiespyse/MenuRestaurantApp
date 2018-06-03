package group8.tkgd.menurestaurantapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.model.Table;

public class CustomGridviewTableManagementAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Table> tables;

    public CustomGridviewTableManagementAdapter(Context context, int layout, List<Table> tables) {
        this.context = context;
        this.layout = layout;
        this.tables = tables;
    }

    @Override
    public int getCount() {
        return tables.size();
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
            holder.number = viewrow.findViewById(R.id.titleNumberTable);
            holder.status = viewrow.findViewById(R.id.titleStatusTable);
            holder.cardView = viewrow.findViewById(R.id.cardViewTable);
            if (tables.get(position).getStatus() == "Serving") {
                holder.cardView.setCardBackgroundColor(Color.rgb(255,92,0));
            }
            else if (tables.get(position).getStatus() == "Available") {
                holder.cardView.setBackgroundColor(Color.rgb(21,171,0));
            }
            viewrow.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) viewrow.getTag();
        holder.number.setText("" + tables.get(position).getNumber());
        holder.status.setText("" + tables.get(position).getStatus());

        return viewrow;
    }

    private class ViewHolder {
        TextView number;
        TextView status;
        CardView cardView;
    }
}
