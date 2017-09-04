package com.example.peter.expandablelistviewtutorial;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseExpandableListAdapter {

    private int groupNum = 3;
    String groupTexts[] = new String[groupNum];
    //グループアイテムに表示するテキスト

    int childNum = 5;
    String childTexts[][] = new String[groupNum][];
    //子アイテムに表示するテキスト
    Bitmap childImages[][] = new Bitmap[groupNum][];
    //子アイテムに表示するテキスト

    private LayoutInflater inflater;
    private CustomExpandableActivity activity;


    CustomAdapter(CustomExpandableActivity activity) {
        this.activity = activity;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getGroupCount() {
        return groupNum;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    /** グループのテキストを取得 */
    @Override
    public Object getGroup(int groupPosition) {
        return groupTexts[groupPosition];
    }

    /**
     * 子アイテムのテキストを取得
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childTexts[groupPosition][childPosition];
    }

    /**子アイテムの画像を取得*/
    public Bitmap getChildImage(int groupPosition, int childPosition)
    {
        return childImages[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.expandable_list_group_item, null);
        }

        final TextView groupText = convertView.findViewById(R.id.expand_list_group_text);
        groupText.setText((CharSequence) getGroup(groupPosition));

        return convertView;
    }

    /** 子アイテムの取得 */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.expandable_list_child_item, null);
        }
        final ImageView imageView = convertView.findViewById(R.id.expand_list_child_image_view);
        final TextView textView = convertView.findViewById(R.id.expand_list_child_text);

        imageView.setImageBitmap(getChildImage(groupPosition,childPosition));
        textView.setText((CharSequence) getChild(groupPosition, childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
