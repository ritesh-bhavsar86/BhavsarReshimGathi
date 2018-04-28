package com.riteshbhavsar.bhavsarreshimgathi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.riteshbhavsar.bhavsarreshimgathi.R;
import com.riteshbhavsar.bhavsarreshimgathi.model.Candidate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dishu on 3/11/2018.
 */

public class CandidateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;


    @BindView(R.id.txt_candidate_name)
    public        TextView txt_candidate_name;
    @BindView(R.id.txt_candidate_dob)
    public        TextView txt_candidate_dob;
    @BindView(R.id.txt_candidate_dot)
    public TextView txt_candidate_dot;
    @BindView(R.id.txt_can_id)
    public TextView txt_can_id;
    @BindView(R.id.txt_can_edu)
    public TextView txt_can_edu;
    @BindView(R.id.txt_can_occupa)
    public TextView txt_can_occupa;
    @BindView(R.id.txt_can_sal)
    public TextView txt_can_sal;

    @BindView(R.id.rl_view)
    RelativeLayout rl_view;
    @BindView(R.id.iv_candidate_profile)
    ImageView iv_candidate_profile;


    public CandidateViewHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
        mView = itemView;
        mContext = itemView.getContext();
        txt_candidate_name = itemView.findViewById(R.id.txt_candidate_name);
        itemView.setOnClickListener(this);
    }

    public void bindRestaurant(Candidate city) {
//        ImageView restaurantImageView = (ImageView) mView.findViewById(R.id.restaurantImageView);
//        TextView nameTextView = (TextView) mView.findViewById(R.id.restaurantNameTextView);
//        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
//        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

//        Picasso.with(mContext)
//                .load(restaurant.getImageUrl())
//                .resize(MAX_WIDTH, MAX_HEIGHT)
//                .centerCrop()
//                .into(restaurantImageView);

//        nameTextView.setText(restaurant.getName());
//        categoryTextView.setText(restaurant.getCategories().get(0));
//        ratingTextView.setText("Rating: " + restaurant.getRating() + "/5");
        if (city != null) {

            if(city.getGender().equalsIgnoreCase("M")){
                rl_view.setBackgroundResource(R.color.lst_bg_male);
                txt_can_id.setTextColor(mContext.getResources().getColor(R.color.bpDarker_red));
                txt_candidate_name.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_candidate_dob.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_candidate_dot.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_edu.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_occupa.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_sal.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
            }else if(city.getGender().equalsIgnoreCase("F")){
                rl_view.setBackgroundResource(R.color.lst_bg_female);
                txt_can_id.setTextColor(mContext.getResources().getColor(R.color.bpDarker_blue));
                txt_candidate_name.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_candidate_dob.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_candidate_dot.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_edu.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_occupa.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_sal.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
            }else{
                rl_view.setBackgroundResource(R.color.bpDarker_red);
                txt_can_id.setTextColor(mContext.getResources().getColor(R.color.bpWhite));
                txt_candidate_name.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_candidate_dob.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_candidate_dot.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_edu.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_occupa.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
                txt_can_sal.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
            }
            txt_candidate_name.setText(city.getFullname());
//                   city.getFirstName() + " "
//                   + city.getMiddleName() + " "
//                   + city.getLastName());
            txt_candidate_dob.setText("Dob: "+city.getDobStr());
            txt_candidate_dot.setText("Dot: "+city.getDotStr());
            txt_can_id.setText(city.getCandidateId());
            getTxt_can_edu().setText("Education: "+city.getEducation());
            txt_can_occupa.setText("Job: "+city.getOccupation());
            getTxt_can_sal().setText("Salary: "+String.valueOf(city.getSalary()));
            try {
//                Bitmap bmp = BitmapFactory.decodeByteArray(city.getProfileLogoByte(), 0, city.getProfileLogoByte().length);
//                ((ImageView) currentView.findViewById(R.id.iv_candidate_profile)).setImageBitmap(bmp);
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.mipmap.ic_launcher_round);
                requestOptions.error(R.mipmap.ic_launcher_round);
                requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
                requestOptions.circleCrop();

                Glide.with(mContext)
                        .setDefaultRequestOptions(requestOptions)
                        .load(city.getProfileLogo())
                        .thumbnail(0.5f)
//                        .crossFade()
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(iv_candidate_profile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Candidate> restaurants = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("candidates/males");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    restaurants.add(snapshot.getValue(Candidate.class));
                }

                int itemPosition = getLayoutPosition();

//                Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("restaurants", Parcels.wrap(restaurants));
//
//                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public RelativeLayout getRl_view() {
        return rl_view;
    }

    public void setRl_view(RelativeLayout rl_view) {
        this.rl_view = rl_view;
    }

    public ImageView getIv_candidate_profile() {
        return iv_candidate_profile;
    }

    public void setIv_candidate_profile(ImageView iv_candidate_profile) {
        this.iv_candidate_profile = iv_candidate_profile;
    }

    public TextView getTxt_candidate_name() {
        return txt_candidate_name;
    }

    public void setTxt_candidate_name(TextView txt_candidate_name) {
        this.txt_candidate_name = txt_candidate_name;
    }

    public TextView getTxt_candidate_dob() {
        return txt_candidate_dob;
    }

    public void setTxt_candidate_dob(TextView txt_candidate_dob) {
        this.txt_candidate_dob = txt_candidate_dob;
    }

    public TextView getTxt_candidate_dot() {
        return txt_candidate_dot;
    }

    public void setTxt_candidate_dot(TextView txt_candidate_dot) {
        this.txt_candidate_dot = txt_candidate_dot;
    }

    public TextView getTxt_can_id() {
        return txt_can_id;
    }

    public void setTxt_can_id(TextView txt_can_id) {
        this.txt_can_id = txt_can_id;
    }

    public TextView getTxt_can_edu() {
        return txt_can_edu;
    }

    public void setTxt_can_edu(TextView txt_can_edu) {
        this.txt_can_edu = txt_can_edu;
    }

    public TextView getTxt_can_occupa() {
        return txt_can_occupa;
    }

    public void setTxt_can_occupa(TextView txt_can_occupa) {
        this.txt_can_occupa = txt_can_occupa;
    }

    public TextView getTxt_can_sal() {
        return txt_can_sal;
    }

    public void setTxt_can_sal(TextView txt_can_sal) {
        this.txt_can_sal = txt_can_sal;
    }

}
