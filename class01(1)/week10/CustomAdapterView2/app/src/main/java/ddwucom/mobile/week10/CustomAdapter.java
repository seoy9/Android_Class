package ddwucom.mobile.week10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<CustomData> customDataList;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int layout, ArrayList<CustomData> customDataList) {
        this.context = context;
        this.layout = layout;
        this.customDataList = customDataList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return customDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return customDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return customDataList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder holder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            holder = new ViewHolder();
            holder.tvNo = convertView.findViewById(R.id.tvNo);
            holder.tvDong = convertView.findViewById(R.id.tvDong);
            holder.tvSigu = convertView.findViewById(R.id.tvSigu);
            holder.tvHow = convertView.findViewById(R.id.tvHow);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvNo.setText(String.valueOf(customDataList.get(pos).get_id()));
        holder.tvDong.setText(customDataList.get(pos).getDong());
        holder.tvSigu.setText(customDataList.get(pos).getSigu());
        holder.tvHow.setText(customDataList.get(pos).getWeather());

        holder.tvNo.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, customDataList.get(pos).getSigu() + " " + customDataList.get(pos).getDong(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.tvDong.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, customDataList.get(pos).getDong(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.tvSigu.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, customDataList.get(pos).getSigu(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.tvHow.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "날씨는 " + customDataList.get(pos).getWeather(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView tvNo;
        TextView tvDong;
        TextView tvSigu;
        TextView tvHow;
    }
}
