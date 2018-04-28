package com.riteshbhavsar.bhavsarreshimgathi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.riteshbhavsar.bhavsarreshimgathi.R;
import com.riteshbhavsar.bhavsarreshimgathi.model.Males;

import java.util.List;

/**
 * Created by Dishu on 4/20/2018.
 */

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerViewHolders> implements View.OnClickListener{

    private List<Males> task;
    protected Context mContext;
    public RecyclerAdapter(Context context, List<Males> task) {
        this.task = task;
        this.mContext = context;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_layout, parent, false);
        viewHolder = new RecyclerViewHolders(layoutView, task);
        layoutView.setOnClickListener(this);
        return viewHolder;
    }
    private onItemClickListener mItemClickListener;

    public void setOnItemClickListener(onItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClickListener(view, (Integer) view.getTag(), task.get((Integer) view.getTag()));
        }
    }

    public interface onItemClickListener {
        void onItemClickListener(View view, int position, Males myData);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.rl_view.setBackgroundResource(R.color.lst_bg_male);
        holder.txt_can_id.setTextColor(mContext.getResources().getColor(R.color.bpDarker_red));
        holder.txt_candidate_name.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
        holder.txt_candidate_dob.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
        holder.txt_candidate_dot.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
        holder.txt_can_edu.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
        holder.txt_can_occupa.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));
        holder.txt_can_sal.setTextColor(mContext.getResources().getColor(R.color.bpDark_gray));

        holder.txt_candidate_name.setText(task.get(position).getFullname());
//                   city.getFirstName() + " "
//                   + city.getMiddleName() + " "
//                   + city.getLastName());
        holder.txt_candidate_dob.setText("Dob: "+task.get(position).getDobStr());
        holder.txt_candidate_dot.setText("Dot: "+task.get(position).getDotStr());
        holder.txt_can_id.setText(task.get(position).getCandidateId());
//        getTxt_can_edu().setText("Education: "+city.getEducation());
        holder.txt_can_edu.setText("Education: "+task.get(position).getEducation());
        holder.txt_can_occupa.setText("Job: "+task.get(position).getOccupation());
//        getTxt_can_sal().setText("Salary: "+String.valueOf(city.getSalary()));
        holder.txt_can_sal.setText("Salary: "+String.valueOf(task.get(position).getSalary()));
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
                    .load(task.get(position).getProfileLogo())
                    .thumbnail(0.5f)
//                        .crossFade()
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.iv_candidate_profile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return this.task.size();
    }
}
