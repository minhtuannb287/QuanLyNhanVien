package vn.quanlynhanvien.fragements;


import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.quanlynhanvien.R;
import vn.quanlynhanvien.adapters.GalleryImageAdapter;
import vn.quanlynhanvien.models.ImageItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaleryFragment extends Fragment {

    private GridView gridView;
    private GalleryImageAdapter galleryImageAdapter;

    public GaleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galery, container, false);
        gridView = view.findViewById(R.id.gridView);
        galleryImageAdapter = new GalleryImageAdapter(getActivity(), R.layout.grid_item_layout, getData());

        gridView.setAdapter(galleryImageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageItem item = (ImageItem) adapterView.getItemAtPosition(i);

                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_LONG).show();

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for(int i = 0; i <imgs.length(); i++){
            Bitmap bitmap= BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#"+i));
        }
        return imageItems;


    }

}
