package mobile.database.dbtest02;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {
    LayoutInflater inflater;
    int layout;

    public MyCursorAdapter(Context context, int layout, Cursor c) {
        super(context, c, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();

        if (holder.tvContactName == null) {
            holder.tvContactName = view.findViewById(R.id.tvContactName);
            holder.tvContactPhone = view.findViewById(R.id.tvContactPhone);
        }

        holder.tvContactName.setText(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_NAME)));
        holder.tvContactPhone.setText(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_PHONE)));

//        TextView tvContactName = view.findViewById(R.id.tvContactName);
//        TextView tvContactPhone = view.findViewById(R.id.tvContactPhone);

//        tvContactName.setText(cursor.getString(1));
//        tvContactPhone.setText(cursor.getString(2));
//        tvContactName.setText(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_NAME)));
//        tvContactPhone.setText(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_PHONE)));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//        View listItemLayout = inflater.inflate(layout, parent, false);
//        return listItemLayout;
//        return inflater.inflate(layout, parent, false);
        View view = inflater.inflate(layout, parent, false);
        ViewHolder holder = new ViewHolder();
        view.setTag(holder);    // holder 생성 후 보관만
        return view;
    }

    static class ViewHolder {

        public ViewHolder() {
            tvContactName = null;
            tvContactPhone = null;
        }

        TextView tvContactName;
        TextView tvContactPhone;
    }
}
