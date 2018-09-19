package main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import calebseeling2.click.R;

/**
 * Created by calebseeling on 19.08.18.
 */

public class Highscore extends AppCompatActivity {
    private TextView Highscore_score;
    private int large_number;
    private int value;
    private InterstitialAd mInterstitialAd;
    public static String TAG = "Highscore";
    private static TextView yourscore;
    private ListView high_view;
    private int Highscore1;
    private int Highscore2;
    private int Highscore3;
    private int Highscore4;
    private int Highscore5;
    private int Highscore6;
    private int Highscore7;
    private int Highscore8;
    private int Highscore9;
    private Button back2;
    private int Highscore10;
    private String Highscore1_s;
    private String Highscore2_s;
    private String Highscore3_s;
    private MediaPlayer bubble;
    private String Highscore4_s;
    private String Highscore5_s;
    private String Highscore6_s;
    private String Highscore7_s;
    private ArrayList<String> products = new ArrayList<>();
    private String Highscore8_s;
    private String Highscore9_s;
    private String Highscore10_s;
    private String score;
//    private  int text_for_your_score = MainActivity.getKey() ;
    private TextView name_high;
    private String value_name;
    private SharedPreferences sharedpreference;
    private AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        yourscore = (TextView) findViewById(R.id.yourscore);
        high_view = (ListView) findViewById(R.id.high_view);
        back2 = (Button) findViewById(R.id.back2);
        bubble = MediaPlayer.create(getApplicationContext(), R.raw.dustyroom_cartoon_bubble_pop);
        mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //   yourscore.setText(" "+text_for_your_score);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        FirebaseDatabase database_for_name = FirebaseDatabase.getInstance();
        DatabaseReference myRef_for_name = database.getReference(MainActivity.getName());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if(dataSnapshot.child("Highscore1").child("Score").exists()&&
                  dataSnapshot.child( "Highscore2").child("Score").exists()&&
                  dataSnapshot.child( "Highscore3").child("Score").exists()&&
                   dataSnapshot.child("Highscore4").child("Score").exists()&&
                   dataSnapshot.child("Highscore5").child("Score").exists()&&
                   dataSnapshot.child("Highscore6").child("Score").exists()&&
                   dataSnapshot.child("Highscore7").child("Score").exists()&&
                dataSnapshot.child("Highscore7").child("Score").exists()&&
                dataSnapshot.child("Highscore7").child("Score").exists()&&
                dataSnapshot.child("Highscore7").child("Score").exists()&&

                   dataSnapshot.child("Highscore1").child("Name").exists()&&
                   dataSnapshot.child("Highscore2").child("Name").exists()&&
                   dataSnapshot.child("Highscore3").child("Name").exists()&&
                   dataSnapshot.child("Highscore4").child("Name").exists()&&
                   dataSnapshot.child("Highscore5").child("Name").exists()&&
                   dataSnapshot.child("Highscore6").child("Name").exists()&&
                   dataSnapshot.child("Highscore7").child("Name").exists()&&
                   dataSnapshot.child("Highscore8").child("Name").exists()&&
                   dataSnapshot.child("Highscore9").child("Name").exists()&&
                dataSnapshot.child("Highscore10").child("Name").exists()
                        ){





                    Highscore1 =  dataSnapshot.child("Highscore1").child("Score").getValue(Integer.class);
                    Highscore2 =  dataSnapshot.child("Highscore2").child("Score").getValue(Integer.class);
                    Highscore3 =  dataSnapshot.child("Highscore3").child("Score").getValue(Integer.class);
                    Highscore4 =  dataSnapshot.child("Highscore4").child("Score").getValue(Integer.class);
                    Highscore5 =  dataSnapshot.child("Highscore5").child("Score").getValue(Integer.class);
                    Highscore6 =  dataSnapshot.child("Highscore6").child("Score").getValue(Integer.class);
                    Highscore7 =  dataSnapshot.child("Highscore7").child("Score").getValue(Integer.class);
                    Highscore8 =  dataSnapshot.child("Highscore8").child("Score").getValue(Integer.class);
                    Highscore9 =  dataSnapshot.child("Highscore9").child("Score").getValue(Integer.class);
                    Highscore10 =  dataSnapshot.child("Highscore10").child("Score").getValue(Integer.class);

                    Highscore1_s  = dataSnapshot.child("Highscore1").child("Name").getValue(String.class);
                    Highscore2_s =  dataSnapshot.child("Highscore2").child("Name").getValue(String.class);
                    Highscore3_s =  dataSnapshot.child("Highscore3").child("Name").getValue(String.class);
                    Highscore4_s  = dataSnapshot.child("Highscore4").child("Name").getValue(String.class);
                    Highscore5_s =  dataSnapshot.child("Highscore5").child("Name").getValue(String.class);
                    Highscore6_s =  dataSnapshot.child("Highscore6").child("Name").getValue(String.class);
                    Highscore7_s =  dataSnapshot.child("Highscore7").child("Name").getValue(String.class);
                    Highscore8_s  = dataSnapshot.child("Highscore8").child("Name").getValue(String.class);
                    Highscore9_s =  dataSnapshot.child("Highscore9").child("Name").getValue(String.class);
                    Highscore10_s = dataSnapshot.child("Highscore10").child("Name").getValue(String.class);



                    products.add("1. " +  Highscore1_s + " : " + Highscore1);
                    products.add( "2. " + Highscore2_s + " : " + Highscore2);
                    products.add( "3. " + Highscore3_s + " : " + Highscore3);
                    products.add( "4. " + Highscore4_s + " : " + Highscore4);
                    products.add( "5. " + Highscore5_s + " : " + Highscore5);
                    products.add( "6. " + Highscore6_s + " : " + Highscore6);
                    products.add( "7. " + Highscore7_s + " : " + Highscore7);
                    products.add( "8. " + Highscore8_s + " : " + Highscore8);
                    products.add( "9. " + Highscore9_s + " : " + Highscore9);
                    products.add( "10. " + Highscore10_s + " : " + Highscore10);



                }
                else{


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

back2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Highscore.this,MainActivity.class);
        startActivity(intent);
        bubble.start();
    }
});


        yourscore.setText("" + MainActivity.getScore());





        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        high_view.setAdapter(adapter);
      }}