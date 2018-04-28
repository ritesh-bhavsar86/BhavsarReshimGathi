package com.riteshbhavsar.bhavsarreshimgathi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.riteshbhavsar.bhavsarreshimgathi.model.Candidate;

/**
 * Created by Dishu on 3/11/2018.
 */
//https://www.android-examples.com/show-firebase-database-data-into-recyclerview/

public class MyFireBaseAdapter extends FirebaseRecyclerAdapter<Candidate, CandidateViewHolder> {
    private Context context;

    /**
     * Initialize a {@link RecyclerView .Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MyFireBaseAdapter(@NonNull FirebaseRecyclerOptions<Candidate> options) {
        super(options);
    }
//    public MyFireBaseAdapter(Class<Candidate> modelClass, int modelLayout,
//                             Class<CandidateViewHolder> viewHolderClass, DatabaseReference ref
//            , Context context) {
//        super(modelClass, modelLayout, viewHolderClass, ref);
//        this.context = context;
//    }

    @Override
    protected void onBindViewHolder(@NonNull CandidateViewHolder holder, int position, @NonNull Candidate model) {

    }

    @Override
    public CandidateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }


}
