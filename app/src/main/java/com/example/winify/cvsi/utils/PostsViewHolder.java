package com.example.winify.cvsi.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.activities.ItemPreviewActivity;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.dto.ListDto;
import com.squareup.picasso.Picasso;

/**
 * Created by diana on 8/10/16.
 */
public class PostsViewHolder extends RecyclerView.ViewHolder{
    public final CardView cardView;
    public final TextView mTitleTextView;
    public final TextView mDateCreated;
    public final TextView mPrice;
    public final TextView mDescriptionTextView;
    public final ImageView mImageView;

    public PostsViewHolder(View v) {
        super(v);
        cardView = (CardView) v.findViewById(R.id.card_view);
        mTitleTextView = (TextView) v.findViewById(R.id.title_tv);
        mDescriptionTextView = (TextView) v.findViewById(R.id.description_tv);
        mImageView = (ImageView) v.findViewById(R.id.image_view);

        mDateCreated = (TextView) v.findViewById(R.id.date_text_view);
        mPrice = (TextView) v.findViewById(R.id.price_text_view);
    }

    public void bind(AbstractProductTemplate temp, Context context) {
        mTitleTextView.setText(temp.getTitle());
        mDateCreated.setText(temp.getCreatedDate().toString());
        mPrice.setText(String.valueOf(temp.getPrice()));
//        Picasso.with(context).load("http://192.168.3.191:8080/cvsi-server/1/image/default").into(mImageView);
//        Picasso.with(context).load("http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg").into(mImageView);

        ProductController productController = new ProductController(context, new SessionManager(context).getToken());
        productController.getProductDefaultImage("1");
        productController.getImage(context, new SessionManager(context).getToken(),"http://192.168.3.191:8080/cvsi-server/1/image/default",mImageView);
//        Glide.with(getActivity()).load("http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg").into(imageView);
    }
}