package com.vegan.eiko.vegantravel;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by eiko on 10/8/2015.
 */
public class VegTravel_ExpandlistAdapter extends BaseExpandableListAdapter {
    private Context VegTravel_expand_Context;
    private List<String> VegTravel_expand_ListDataHeader;
    private HashMap<String, List<String>> VegTravel_expand_ListDataChild;
    ExpandableListView VegTravel_expandList;

    public VegTravel_ExpandlistAdapter(Context VegTravel_context,
                                       List<String> VegTravel_listDataHeader,
                                       HashMap<String, List<String>> VegTravel_listDataChild,
                                       ExpandableListView VegTravel_expandList){
        this.VegTravel_expand_Context = VegTravel_context;
        this.VegTravel_expand_ListDataHeader = VegTravel_listDataHeader;
        this.VegTravel_expand_ListDataChild = VegTravel_listDataChild;
        this.VegTravel_expandList = VegTravel_expandList;
    }
    @Override
    public int getGroupCount() {
        return this.VegTravel_expand_ListDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.VegTravel_expand_ListDataChild.get(this.VegTravel_expand_ListDataHeader
                .get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.VegTravel_expand_ListDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.VegTravel_expand_ListDataChild.get(this.VegTravel_expand_ListDataHeader
                .get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headertitle = (String)getGroup(groupPosition);
        if (convertView==null){
            LayoutInflater inf = (LayoutInflater)this.VegTravel_expand_Context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.listgroup, null);
            }
        TextView tvHeader = (TextView)convertView.findViewById(
                R.id.listgroup);
        tvHeader.setTypeface(null, Typeface.BOLD);
        tvHeader.setText(headertitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView,
                             ViewGroup parent) {
        final String childtext = (String)getChild(groupPosition,
                childPosition);
        if (convertView==null) {
            LayoutInflater inf = (LayoutInflater) this.VegTravel_expand_Context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.listitem, null);
            }
            TextView textlistchild = (TextView)convertView.findViewById(R.id.listitemchild);
            textlistchild.setText(childtext);
            return  convertView;
        }
    @Override
    public boolean hasStableIds(){
        return false;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
}
