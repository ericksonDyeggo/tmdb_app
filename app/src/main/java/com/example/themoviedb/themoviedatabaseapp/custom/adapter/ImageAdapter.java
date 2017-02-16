package com.example.themoviedb.themoviedatabaseapp.custom.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.themoviedb.themoviedatabaseapp.R;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickson on 14/02/17.
 */

@EBean
public class ImageAdapter extends BaseAdapter {

    @RootContext
    Context mContext;

    List<String> mImages;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

//        Check if there's a view
        if (convertView == null) {
//            if not, create one
            imageView = new ImageView(mContext);
        } else {
//            use de recycled one
            imageView = (ImageView) convertView;
        }

//        Load images using Picasso
        Picasso.with(mContext)
                .load(mImages.get(position))
                .placeholder(R.mipmap.timthumb)
                .error(R.mipmap.timthumb)
                .noFade()
                .resize(153, 227)
                .centerCrop()
                .into(imageView);

        return imageView;
    }

    public void addImage(String image) {
        if (mImages == null)
            mImages = new ArrayList<>();

        mImages.add(image);
    }

    public void addImage(List<String> images) {
        if (mImages == null)
            mImages = images;
        else
            mImages.addAll(images);
    }
}
