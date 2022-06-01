package ddwucom.mobile.report01;

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

        if (holder.tvContactTitle == null) {
            holder.tvContactTitle = view.findViewById(R.id.tvContactTitle);
            holder.tvContactDate = view.findViewById(R.id.tvContactDate);
            holder.tvContactReview = view.findViewById(R.id.tvContactReview);
        }

        holder.tvContactTitle.setText(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_TITLE)));
        holder.tvContactDate.setText(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_DATE)));
        holder.tvContactReview.setText(cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_REVIEW)));

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = inflater.inflate(layout, parent, false);
        ViewHolder holder = new ViewHolder();
        view.setTag(holder);    // holder 생성 후 보관만
        return view;
    }

    static class ViewHolder {

        public ViewHolder() {
            tvContactTitle = null;
            tvContactDate = null;
            tvContactReview = null;
        }

        TextView tvContactTitle;
        TextView tvContactDate;
        TextView tvContactReview;
    }
}
