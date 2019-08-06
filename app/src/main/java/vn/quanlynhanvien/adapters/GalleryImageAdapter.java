package vn.quanlynhanvien.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import vn.quanlynhanvien.R;
import vn.quanlynhanvien.models.ImageItem;

public class GalleryImageAdapter extends ArrayAdapter {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public GalleryImageAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, null);
            holder = new ViewHolder();
            holder.imageTitle = row.findViewById(R.id.textViewTitle);
            holder.imageView= row.findViewById(R.id.imageView);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }

        ImageItem item = (ImageItem) data.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.imageView.setImageBitmap(item.getImage());
        return row;
    }

    static class ViewHolder{
        TextView imageTitle;
        ImageView imageView;
    }
}
