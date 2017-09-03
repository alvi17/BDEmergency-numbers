package alvi17.bangladeshemergencynumbers.adapters;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import alvi17.bangladeshemergencynumbers.R;
import alvi17.bangladeshemergencynumbers.Util;

/**
 * Created by User on 8/31/2017.
 */

public class ExpandaleListAdapter extends BaseExpandableListAdapter {


    private Context _context;
    private String[]_listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, String[]> _listDataChild;

    public ExpandaleListAdapter(Context context, String[] listDataHeader,
                                HashMap<String, String[]> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public String[] getChild(int groupPosition, int childPosititon) {

        return this._listDataChild.get(this._listDataHeader[groupPosition]);

    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
        final String[] child_list=getChild(groupPosition,childPosition);

        TextView textView=(TextView)convertView.findViewById(R.id.expandedListItem);
        textView.setText(child_list[childPosition]);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(_context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                    Util.call(_context, child_list[childPosition].substring(child_list[childPosition].indexOf("\n")));
                }else{
                    Toast.makeText(_context,"আপনি কল পারমিশন অনুমোদন করেননি।",Toast.LENGTH_LONG).show();
                }
            }
        });

//        ListView listView=(ListView)convertView.findViewById(R.id.exp_list_child);
//
//        Log.e("ExpListAdapter","child[]:"+child_list.length);
//        for(int i=0;i<child_list.length;i++){
//            Log.e("ExpListAdpater","child: "+child_list[i]);
//
//        }
//        ListAdapter listAdapter=new ListAdapter(_context,child_list);
//        listView.setAdapter(listAdapter);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(_listDataHeader[groupPosition]).length;

    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader[groupPosition];
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.length;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.listTitle);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
