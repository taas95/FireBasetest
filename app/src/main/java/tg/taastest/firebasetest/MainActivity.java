package tg.taastest.firebasetest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editname) EditText name;
    @BindView(R.id.spinner)    Spinner spinner;
    @BindView(R.id.btn) Button btn;
    @BindView(R.id.listv) ListView listv;
    DatabaseReference db;
    List<Artist> artistList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        db= FirebaseDatabase.getInstance().getReference("aritst");
    }

    @Override
    protected void onStart() {
        super.onStart();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //artistList.clear();
                for (DataSnapshot artistsnp:dataSnapshot.getChildren())
                {
                    Artist artist = artistsnp.getValue(Artist.class);
                    artistList.add(artist);
                }
                ArtistList adapter = new ArtistList(MainActivity.this,artistList);
                listv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.btn)
        public void AddArtist()
    {
        String art_name = name.getText().toString().trim();
        String genre = spinner.getSelectedItem().toString();
        if (!TextUtils.isEmpty(art_name))
        {
               String id= db.push().getKey();
               Artist artist= new Artist(id,art_name,genre);
               db.child(id).setValue(artist);
               Toast.makeText(this,"Successfull",Toast.LENGTH_SHORT).show();
               name.setText("");
        }
        else {
            Toast.makeText(this,"Please fill the name",Toast.LENGTH_SHORT).show();
        }

    }
}
