package com.riteshbhavsar.bhavsarreshimgathi.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.riteshbhavsar.bhavsarreshimgathi.R;
import com.riteshbhavsar.bhavsarreshimgathi.model.Males;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Dishu on 4/20/2018.
 */

public class RecyclerViewHolders  extends RecyclerView.ViewHolder{
    private static final String TAG = RecyclerViewHolders.class.getSimpleName();
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

    private List<Males> taskObject;

    public RecyclerViewHolders(final View itemView, final List<Males> taskObject) {
        super(itemView);
        this.taskObject = taskObject;
        txt_candidate_name = itemView.findViewById(R.id.txt_candidate_name);
                txt_candidate_dob = itemView.findViewById(R.id.txt_candidate_dob);
        txt_candidate_dot = itemView.findViewById(R.id.txt_candidate_dot);
                txt_can_id = itemView.findViewById(R.id.txt_can_id);
        txt_can_edu = itemView.findViewById(R.id.txt_can_edu);
                txt_can_occupa = itemView.findViewById(R.id.txt_can_occupa);
        txt_can_sal = itemView.findViewById(R.id.txt_can_sal);
                rl_view = itemView.findViewById(R.id.rl_view);
        iv_candidate_profile = itemView.findViewById(R.id.iv_candidate_profile);
//        itemView.setOnClickListener(this);
    }


}