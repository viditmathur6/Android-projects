package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExpendableListviewAdapter extends BaseExpandableListAdapter {
   List<String> category;
   Map<String, List<String>> names;
   Context context;

   public MyExpendableListviewAdapter(Context context, List<String> category, Map<String, List<String>> names){
       this.category = category;
       this.names = names;
       this.context = context;

   }

    @Override
    public int getGroupCount() {
        return category.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return names.get(category.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return category.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return names.get(category.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
       String headertittle = (String) getGroup(i);
       if(view == null){
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = inflater.inflate(R.layout.parent_list,null);
       }
        TextView txtparent = view.findViewById(R.id.parent_list);
       txtparent.setText(headertittle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
       String childtext = (String) getChild(i,i1);
       if(view == null){
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = inflater.inflate(R.layout.child_list,null);

       }
       TextView textchild = view.findViewById(R.id.child_list);
       textchild.setText(childtext);
       return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
