package com.example.niyamat.photoviewer;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Niyamat on 1/17/2016.
 */
public class StaggeredGridLayoutAdapter extends CustomRecyclerViewAdapter {

    private Context mContext;
    private ArrayList<String> mImages;
    private int mScreenWidth;

    public StaggeredGridLayoutAdapter(Context context, ArrayList<String> images) {
        mContext = context;
        mImages = images;

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mScreenWidth = size.x;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.demo_images, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"Ya it's working",Toast.LENGTH_LONG).show();
            }
        });
        Holder myHolder = (Holder) holder;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mImages.get(position), opts);
        opts.inJustDecodeBounds = false;
        int height;
        if (position == 1 || position == (mImages.size() - 1)) {
            height = 150;
        } else {
            height = 300;
        }
        Picasso.with(mContext)
                .load(mImages.get(position))
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resize(mScreenWidth / 2, height)
                .centerCrop()
                .into(myHolder.mImageView);
    }


    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class Holder extends CustomRecycleViewHolder {
        public ImageView mImageView;
        public Holder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.ivItemGridImage);
        }
    }


}
