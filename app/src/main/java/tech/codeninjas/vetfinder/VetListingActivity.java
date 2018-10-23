package tech.codeninjas.vetfinder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VetListingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FirebaseRecyclerAdapter adapter;
    private String[] names={"Dr. Jeff Mike","Dr. Ade Stevens","Dr. Micheal Obi","Dr. Ali Bawa","Dr. Adams Sowore","Dr. Frank Jacob","Dr. Musa Kasim"};
    private String[] addresses={"Kaduna","Akure","Awka","Makurdi","Ikeja","Abuja","Minna"};
    private String[] languages={"English,Hausa","English,Yoruba","English,Igbo","English,Tivii","English,Yoruba,Idoma","English,Yoruba,Edo","Hausa"};
    private String[] phonenum={"08163471885","08163471885","08163471885","08163471885","08163471885","08163471885","08163471885"};
    private String[] emails={"drjeff@gmail.com","adestevens@gmail","drmicheabi@gmail","dalibawa@gmail","dradams@gmail","frankjacob@gmail","musakasim@gmail"};
    private String[] rating={"3.5","2.5","3.5","4","3","4.5","3.5"};
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_listing);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Doctors");
        recyclerView = findViewById(R.id.list);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("doctors").push();
        createData();
        fetch();
    }

    private void createData() {
        for(int i=0;i<names.length;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", databaseReference.getKey());
            map.put("name", names[i]);
            map.put("address", addresses[i]);
            map.put("languages", languages[i]);
            map.put("phonenum", phonenum[i]);
            map.put("email", emails[i]);
            map.put("rating", rating[i]);
            databaseReference.setValue(map);
        }
    }

    private void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference().child("doctors");

        FirebaseRecyclerOptions<Vet> options =
                new FirebaseRecyclerOptions.Builder<Vet>()
                        .setQuery(query, new SnapshotParser<Vet>() {
                            @NonNull
                            @Override
                            public Vet parseSnapshot(@NonNull DataSnapshot snapshot) {
                                return new Vet(snapshot.child("id").getValue().toString(),
                                        snapshot.child("name").getValue().toString(),
                                        snapshot.child("languages").getValue().toString(),
                                        snapshot.child("address").getValue().toString(),
                                        snapshot.child("phonenum").getValue().toString(),
                                        snapshot.child("email").getValue().toString(),
                                        snapshot.child("rating").getValue().toString());
                            }
                        })
                        .build();

        adapter = new FirebaseRecyclerAdapter<Vet, ViewHolder>(options) {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.vet_listing_item, parent, false);

                return new ViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(ViewHolder holder, final int position, Vet vet) {
                holder.setName(vet.getmName());
                holder.setAddress(vet.getmAddress());
               // holder.setRatingBar(vet.getmRating());
                holder.setTxtLanguages(vet.getmLanguages());

                holder.root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(VetListingActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        };
        recyclerView.setAdapter(adapter);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout root;
        public TextView txtName;
        public TextView txtAddress;
        public TextView txtLanguages;
        public ImageView vetProfilePic;
        public ImageView isVirtual;
        public RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.list_root);
            txtName = itemView.findViewById(R.id.vet_list_name_item);
            txtAddress = itemView.findViewById(R.id.vet_list_location_item);
            txtLanguages = itemView.findViewById(R.id.languages);
            vetProfilePic = itemView.findViewById(R.id.vet_list_image_item);
            isVirtual = itemView.findViewById(R.id.vet_list_isvirtual_item);
            ratingBar = itemView.findViewById(R.id.vet_list_rating_bar_item);
        }

        public void setName(String string) {
            txtName.setText(string);
        }

        public void setAddress(String string) {
            txtAddress.setText(string);
        }

        public void setIsVirtual(Boolean state) {
            if (state) {
                this.isVirtual.setVisibility(View.VISIBLE);
            } else {
                this.isVirtual.setVisibility(View.INVISIBLE);
            }
        }

        public void setTxtLanguages(String languages) {
            this.txtLanguages.setText(languages);
        }

        public void setRatingBar(int rating) {
            this.ratingBar.setRating(rating);
        }

        public void setVetProfilePic(int image) {
            this.vetProfilePic.setImageResource(image);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
