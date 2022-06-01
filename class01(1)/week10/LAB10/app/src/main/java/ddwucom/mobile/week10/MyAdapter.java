package ddwucom.mobile.week10;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    static final String TAG = "MyAdapter";
    int count;
    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        count = 0;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        ViewHolder holder;

        Log.d(TAG, "getView()!");

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);
            Log.d(TAG, "count: " + ++count);

            holder = new ViewHolder();
            holder.tvNo = convertView.findViewById(R.id.tvNo);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvPhone = convertView.findViewById(R.id.tvPhone);
            holder.button = convertView.findViewById(R.id.button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        TextView tvNo = convertView.findViewById(R.id.tvNo);
//        TextView tvName = convertView.findViewById(R.id.tvName);
//        TextView tvPhone = convertView.findViewById(R.id.tvPhone);
//        Button button = convertView.findViewById(R.id.button);
//        button.setFocusable(false);

//        tvNo.setText(String.valueOf(myDataList.get(pos).get_id()));
//        tvName.setText(myDataList.get(pos).getName());
//        tvPhone.setText(myDataList.get(pos).getPhone());
//        button.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, myDataList.get(pos).getPhone() + "선택", Toast.LENGTH_SHORT).show();
//            }
//        });

        holder.tvNo.setText(String.valueOf(myDataList.get(pos).get_id()));
        holder.tvName.setText(myDataList.get(pos).getName());
        holder.tvPhone.setText(myDataList.get(pos).getPhone());
        holder.button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(pos).getPhone() + "선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        Button button;
    }
}
