package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Book> bookList;
    private LayoutInflater layoutInflater;

    public BookAdapter(Context context, int layout, ArrayList<Book> bookList) {
        this.context = context;
        this.layout = layout;
        this.bookList = bookList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bookList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvAuthor = convertView.findViewById(R.id.tv_author);
        TextView tvPublisher = convertView.findViewById(R.id.tv_publisher);

        imageView.setImageResource(R.mipmap.book);
        tvTitle.setText(String.valueOf(bookList.get(pos).getTitle()));
        tvAuthor.setText(String.valueOf(bookList.get(pos).getAuthor()));
        tvPublisher.setText(String.valueOf(bookList.get(pos).getPublisher()));

        return convertView;
    }
}
