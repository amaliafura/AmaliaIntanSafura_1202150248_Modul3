package com.example.android.amaliaintansafura_1202150248_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MineralAdapter extends RecyclerView.Adapter<MineralAdapter.ViewHolder> {

    private ArrayList<Mineral> mMineralData;
    private Context mContext;
    //private GradientDrawable mGradient;


    /**
     * Constructor that passes in the sports data and the context
     *
     * @param sportsData ArrayList containing the sports data
     * @param context    Context of the application
     */
   MineralAdapter(Context context, ArrayList<Mineral> sportsData) {
        this.mMineralData = sportsData;
        this.mContext = context;

       Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.ades);
/*
       }*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MineralAdapter.ViewHolder holder, int position) {
        Mineral currentMineral = mMineralData.get(position);
        //Populate the textviews with data
        holder.bindTo(currentMineral);
        Glide.with(mContext).load(currentMineral.getImageResource()).into(holder.mMineralImage);

    }

    @Override
    public int getItemCount() {
        return mMineralData.size();
    }

    /**
     * ViewHolder class that represents each row of data in the RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mMineralImage;
        private Mineral mCurrentMineral;
        private GradientDrawable mGradientDrawable;
        private String txtTitle;
        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file
         */
        ViewHolder(Context context, View itemView) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView) itemView.findViewById(R.id.title);
            mInfoText = (TextView) itemView.findViewById(R.id.subTitle);
            mMineralImage = (ImageView) itemView.findViewById(R.id.mineralImage);

            itemView.setOnClickListener(this);
        }

        void bindTo(Mineral currentMineral) {
            //Populate the textviews with data
            mTitleText.setText(currentMineral.getTitle());
            mInfoText.setText(currentMineral.getInfo());
            txtTitle = mTitleText.getText().toString();
            mCurrentMineral = currentMineral;

            Glide.with(mContext).load(currentMineral.
                    getImageResource()).placeholder(mGradientDrawable).into(mMineralImage);

        }
        @Override
        public void onClick(View view) {
            Intent a = Mineral.starter(mContext, mCurrentMineral.getTitle(), mCurrentMineral.getImageResource());
            a.putExtra("title", txtTitle);
            mContext.startActivity(a);
        }
    }
}
