package com.example.centuratechnology.baheekhata;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Centura Technology on 6/10/2017.
 */

public class ExpandList extends BaseExpandableListAdapter {
    //this is for ExpandableListView
    private Context context;
    private List<String> headerList;
    private HashMap<String, List<String>> childList;

    ExpandList(Context context, List<String> headerList, HashMap<String, List<String>> childList) {
        this.context = context;
        this.headerList = headerList;
        this.childList = childList;
    }

    //This is implement to parent part
    @Override
    public Object getGroup(int groupPosition) {
        return this.headerList.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final String headerText = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflat = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflat.inflate(R.layout.parent_list, null);
        }

        TextView txtParent = (TextView) convertView.findViewById(R.id.parentList);
        txtParent.setText(headerText);
        txtParent.setTypeface(null, Typeface.BOLD);
        return convertView;
    }

    @Override
    public int getGroupCount() {
        return this.headerList.size();
    }

    //This is implement to child part

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.childList.get(this.headerList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infla = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infla.inflate(R.layout.child_list, null);
        }
        TextView txtChild = (TextView) convertView.findViewById(R.id.childList);
        txtChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.childList.get(this.headerList.get(groupPosition)).size();
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
