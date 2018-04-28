package com.riteshbhavsar.bhavsarreshimgathi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CursorAnchorInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.riteshbhavsar.bhavsarreshimgathi.adapter.CandidateViewHolder;
import com.riteshbhavsar.bhavsarreshimgathi.adapter.CustomRecyclerAdapter;
import com.riteshbhavsar.bhavsarreshimgathi.adapter.RecyclerAdapter;
import com.riteshbhavsar.bhavsarreshimgathi.model.Candidate;
import com.riteshbhavsar.bhavsarreshimgathi.model.Males;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoardActivity extends AppCompatActivity {

    @BindView(R.id.mainText)
    TextView text;
//    List<Candidate> cities;
    List<Males> cities;
    @BindView(R.id.rcv_list)
    RecyclerView rcv_list;

    //    private CustomAdapter mAdapter;
    private CustomRecyclerAdapter mAdapter;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private DatabaseReference mRestaurantReference;
    RecyclerAdapter adapter;
    private ValueEventListener mMalesRefListener;
    private ValueEventListener mFemalesRefListener;
    private ValueEventListener mAllRefListener;

    static final int ALL_CAN = 1;
    static final int MALE_CAN = 2;
    static final int FEMALE_CAN = 3;
    int which_candiate = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardActivity.this, AddCandiateActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.nothing);

            }
        });
        cities = new ArrayList<Males>();
        mRestaurantReference = FirebaseDatabase.getInstance().getReference("candidates/males");
        setUpFirebaseAdapter();

    }
    private void setUpFirebaseAdapter() {
//        Query query = mRestaurantReference.limitToLast(8);
////        Query query = FirebaseDatabase.getInstance().getReference().child("candidates").child("males").limitToLast(50);
//        FirebaseRecyclerOptions<Males> options =
//                new FirebaseRecyclerOptions.Builder<Males>()
//                        .setLifecycleOwner(this)
//                        .setQuery(query, Males.class)
//                        .build();
//        mFirebaseAdapter = new FirebaseRecyclerAdapter<Males, MalesViewHolder>(options) {
//
//            @Override
//            public MalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////                return null;
//                return new MalesViewHolder(LayoutInflater.from(DashBoardActivity.this)
//                        .inflate(R.layout.list_row_layout, parent, false));
//            }
//
//            @Override
//            protected void onBindViewHolder(@NonNull MalesViewHolder holder, int position, @NonNull Males model) {
//                holder.bindRestaurant(model);
//            }
//
//            @Override
//            public void onDataChanged() {
//                super.onDataChanged();
//                mFirebaseAdapter.notifyDataSetChanged();
//                // If there are no chat messages, show a view that invites the user to add a message.
//                text.setVisibility(getItemCount() == 0 ? View.VISIBLE : View.GONE);
//            }
//
//        };
//        mRestaurantReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                getAllTask(dataSnapshot);
//            }
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                getAllTask(dataSnapshot);
//            }
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
////                taskDeletion(dataSnapshot);
//            }
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });

//        mFirebaseAdapter.startListening();
        rcv_list.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_list.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter(DashBoardActivity.this, cities);
        rcv_list.setAdapter(adapter);
//        rcv_list.setAdapter(mFirebaseAdapter);
        adapter.setOnItemClickListener(new RecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position, Males myData) {
                Intent intent = new Intent(DashBoardActivity.this, ProfileViewActivity.class);
                intent.putExtra("data", myData);
                startActivity(intent);
            }
        });

    }
    private void getAllTask(DataSnapshot dataSnapshot){
        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            if(which_candiate == ALL_CAN){
                String key= singleSnapshot.getKey();
                String value=singleSnapshot.getValue().toString();
                String str = value;
                GenericTypeIndicator<Map<String, Males>> genericTypeIndicator = new GenericTypeIndicator<Map<String, Males>>() {};
                Map<String, Males> hashMap = singleSnapshot.getValue(genericTypeIndicator);

                for (Map.Entry<String,Males> entry : hashMap.entrySet()) {
                    Males educations = entry.getValue();
                    String str1 = educations.toString();
                    cities.add(educations);
                }
            }else if(which_candiate == MALE_CAN){
                Males taskTitle = singleSnapshot.getValue(Males.class);
                cities.add(taskTitle);
            }else {
                Males taskTitle = singleSnapshot.getValue(Males.class);
                cities.add(taskTitle);
            }

        }
        adapter.notifyDataSetChanged();
    }

//     when an item of the list is clicked
//    @Override
//    protected void onListItemClick(ListView list, View view, int position, long id) {
//        super.onListItemClick(list, view, position, id);
////        String selectedItem = (String) getListView().getItemAtPosition(position);
//        String selectedItem = ((Candidate)getListAdapter().getItem(position)).getFullname();
//        int cid = ((Candidate)getListAdapter().getItem(position)).getId();
//
//        //exception
////        int i = 100/0;
//        text.setText("You clicked " + cid + " name "+ selectedItem + " at position " + position);
//
////        Candidate cdata = realmInstance.where(Candidate.class).equalTo("id", cid).findFirst();
////        Toast.makeText(this, "Done" + cdata.getFirstName()+" "+ cdata.getContactNo(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(DashBoardActivity.this, ProfileActivity.class);
//        intent.putExtra("id", cid);
//        startActivity(intent);
//    }

//    public RealmResults<Candidate> readFromDB() {
//        RealmResults<Candidate> results = realmInstance.where(Candidate.class).findAll();
//        return results;
//    }

    @Override
    protected void onResume() {
        super.onResume();
        // Load from file "cities.json" first time
        try {
            if (mAdapter == null) {
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static class MalesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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


        public MalesViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mView = itemView;
            mContext = itemView.getContext();
            txt_candidate_name = itemView.findViewById(R.id.txt_candidate_name);
            itemView.setOnClickListener(this);
        }

        public void bindRestaurant(Males city) {
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
            final ArrayList<Males> restaurants = new ArrayList<>();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("candidates/males");
            ref.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        restaurants.add(snapshot.getValue(Males.class));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.all:
                try {
                    mRestaurantReference.removeEventListener(mMalesRefListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    mRestaurantReference.removeEventListener(mFemalesRefListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                which_candiate = ALL_CAN;
                mRestaurantReference = FirebaseDatabase.getInstance().getReference("candidates");
                mAllRefListener = mRestaurantReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        cities.clear();
                        getAllTask(snapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getMessage());
                    }
                });
                return true;
            case R.id.males:
//                showHelp();
                try {
                    mRestaurantReference.removeEventListener(mFemalesRefListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    mRestaurantReference.removeEventListener(mAllRefListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                which_candiate = MALE_CAN;
                mRestaurantReference = FirebaseDatabase.getInstance().getReference("candidates/males");
                mMalesRefListener = mRestaurantReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        cities.clear();
                        getAllTask(snapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getMessage());
                    }
                });
                return true;
            case R.id.females:
//                showHelp();
                try {
                    mRestaurantReference.removeEventListener(mMalesRefListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    mRestaurantReference.removeEventListener(mAllRefListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                which_candiate = FEMALE_CAN;
                mRestaurantReference = FirebaseDatabase.getInstance().getReference("candidates/females");
                mFemalesRefListener = mRestaurantReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        cities.clear();
                        getAllTask(snapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getMessage());
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
