package cs4330.cs.utep.edu;

import android.util.Log;
import android.widget.*;
import android.view.*;
import android.content.*;

import org.w3c.dom.Text;

import java.util.*;

public class theArrayAdapter extends ArrayAdapter<Item> {
    private final Context context;
    protected ArrayList<Item> itemList;
    protected ArrayList<Item> filterList;
    Item temp = new Item("Stuff");
    public theArrayAdapter(Context context, ArrayList<Item> itemList) {
        super(context, -1, itemList);
        this.context = context;
        this.itemList = itemList;
        temp.url = "https://www.homedepot.com/p/Milwaukee-M18-18-Volt-Lithium-Ion-Cordless-Combo-Kit-10-Tool-with-2-Batteries-Charger-and-2-Tool-Bags-2695-10CX/304238212";
        itemList.add(temp);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_listview, parent, false);
        TextView name = (TextView) rowView.findViewById(R.id.label);
        TextView price = (TextView) rowView.findViewById(R.id.price);
        TextView priceChange = (TextView) rowView.findViewById(R.id.currentPrice);
        TextView percent = (TextView) rowView.findViewById(R.id.percent);

        name.setText(itemList.get(position).itemName);
        price.setText("$" + String.valueOf(itemList.get(position).initialPrice));
        priceChange.setText("$" + String.valueOf(itemList.get(position).currentPrice));
//        percent.setText(itemList.get(position).percent);

        return rowView;
    }
    protected void filter(String text){
        //Log.d("Andrew","List here " + itemList.size()); // debugging
        for (Item i : itemList){
            if(!i.itemName.contains(text)){
                itemList.remove(i);
            }
        }
        notifyDataSetChanged();
    }
}
