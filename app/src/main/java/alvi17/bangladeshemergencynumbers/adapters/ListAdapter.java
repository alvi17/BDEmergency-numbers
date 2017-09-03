package alvi17.bangladeshemergencynumbers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import alvi17.bangladeshemergencynumbers.R;

/**
 * Created by User on 8/31/2017.
 */

public class ListAdapter extends BaseAdapter{

    Context context;
    String[] items;
    public ListAdapter(Context context,String[] items){

        this.context=context;
        this.items=items;

    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rootView  = inflater.inflate(R.layout.list_item, null);

        TextView textView=(TextView)rootView.findViewById(R.id.expandedListItem);
        textView.setText(items[i]);

        return rootView;

    }
}
