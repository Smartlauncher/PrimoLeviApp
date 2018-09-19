package main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import calebseeling2.click.R;

/**
 * Created by calebseeling on 19.08.18.
 */

public class shop extends AppCompatActivity {
    private ListView listview;
   // private int money = MainActivity.getMoney();
    private int clicker = MainActivity.getClicker();
    private Integer value;
    private Button silent;
    private  DatabaseReference WholeDatabase;
    private MediaPlayer bubble;
    private Button Red;
    private Button Green;
    private Button Blue;
    private Integer value1;
    private static String TAG = "MainActivity";
    private AdView mAdView;
    private ListAdapter adapter;
    private Button back;
    private TextView money_total;
    private String shop_item_1;
    private String shop_item_2;
    private String shop_item_3;
    private String shop_item_4;
    private String shop_item_5;
    private String shop_item_6;
    private String shop_item_7;
    private String shop_item_8;
    private String shop_item_9;
    private ArrayList<String> products ;
    private String shop_item_10;
    private String shop_item_11;
    private String shop_item_12;
    private String shop_item_13;
    private String shop_item_14;
    private String shop_item_15;


    private int shop_item_cost1;
    private int shop_item_cost2;
    private int shop_item_cost3;
    private int shop_item_cost4;
    private int shop_item_cost5;
    private int shop_item_cost6;
    private int shop_item_cost7;
    private int shop_item_cost8;
    private int shop_item_cost9;
    private int shop_item_cost10;
    private int shop_item_cost11;
    private int shop_item_cost12;
    private int shop_item_cost13;
    private int shop_item_cost14;
    private int shop_item_cost15;

    private boolean online = false;

    private int shop_item_click1;
    private int shop_item_click2;
    private int shop_item_click3;
    private int shop_item_click4;
    private int shop_item_click5;
    private int shop_item_click6;
    private int shop_item_click7;
    private int shop_item_click8;
    private int shop_item_click9;
    private int shop_item_click10;
    private int shop_item_click11;
    private int shop_item_click12;
    private int shop_item_click13;
    private int shop_item_click14;
    private int shop_item_click15;


    private FirebaseDatabase Whole_Database;
    private FirebaseDatabase database_for_money;
    private DatabaseReference myRef_for_money;
    private FirebaseDatabase database_for_clicks;
    private DatabaseReference myRef_for_clicks;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        listview = (ListView) findViewById(R.id.listview);
        money_total = (TextView) findViewById(R.id.money_total);
        String name = MainActivity.getName();
        back = (Button) findViewById(R.id.back);

        Red = (Button) findViewById(R.id.red2);
        Blue = (Button) findViewById(R.id.Blue);
        Green = (Button) findViewById(R.id.Green);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        final SharedPreferences green = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences background = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //Boolean data_green = sharedPreferences_green.getBoolean("Color_green" , false);
        //SharedPreferences.Editor editor_green = sharedPreferences_green.edit();
        //editor_green.putBoolean("Color_green" , true);
        //editor_green.apply();
        final SharedPreferences red = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //Boolean data_red = sharedPreferences_red.getBoolean("Color_red" , false);
        //SharedPreferences.Editor editor_red = sharedPreferences_red.edit();
        //editor_red.putBoolean("Color_green" , true);
        //editor_red.apply();
        final SharedPreferences blue = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //Boolean data_blue = sharedPreferences.getBoolean("Color_blue" , false);
        //SharedPreferences.Editor editor_blue = sharedPreferences.edit();
        //editor_blue.putBoolean("Color_green" , true);
        //editor_blue.apply();
        Whole_Database = FirebaseDatabase.getInstance();
        WholeDatabase = Whole_Database.getReference();



        WholeDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("shop_item_1").child("Name").exists()) {
                    shop_item_1 = dataSnapshot.child("shop_item_1").child("Name").getValue(String.class);
                    shop_item_2 = dataSnapshot.child("shop_item_2").child("Name").getValue(String.class);
                    shop_item_3 = dataSnapshot.child("shop_item_3").child("Name").getValue(String.class);
                    shop_item_4 = dataSnapshot.child("shop_item_4").child("Name").getValue(String.class);
                    shop_item_5 = dataSnapshot.child("shop_item_5").child("Name").getValue(String.class);
                    shop_item_6 = dataSnapshot.child("shop_item_6").child("Name").getValue(String.class);
                    shop_item_7 = dataSnapshot.child("shop_item_7").child("Name").getValue(String.class);
                    shop_item_8 = dataSnapshot.child("shop_item_8").child("Name").getValue(String.class);
                    shop_item_9 = dataSnapshot.child("shop_item_9").child("Name").getValue(String.class);
                    shop_item_10 = dataSnapshot.child("shop_item_10").child("Name").getValue(String.class);
                    shop_item_11 = dataSnapshot.child("shop_item_10").child("Name").getValue(String.class);
                    shop_item_12 = dataSnapshot.child("shop_item_10").child("Name").getValue(String.class);

                    //   shop_item_10 = dataSnapshot.child("Shop_item_11").child("Name").getValue(String.class);
                    //   shop_item_11 = dataSnapshot.child("Shop_item_12").child("Name").getValue(String.class);
                    //   shop_item_12 = dataSnapshot.child("Shop_item_13").child("Name").getValue(String.class);
                    //   shop_item_13 = dataSnapshot.child("Shop_item_14").child("Name").getValue(String.class);
                    //   shop_item_14 = dataSnapshot.child("Shop_item_15").child("Name").getValue(String.class);
                    //   shop_item_15 = dataSnapshot.child("Shop_item_16").child("Name").getValue(String.class);
//

                    shop_item_cost1 = dataSnapshot.child("shop_item_1").child("cost").getValue(Integer.class);
                    shop_item_cost2 = dataSnapshot.child("shop_item_2").child("cost").getValue(Integer.class);
                    shop_item_cost3 = dataSnapshot.child("shop_item_3").child("cost").getValue(Integer.class);
                    shop_item_cost4 = dataSnapshot.child("shop_item_4").child("cost").getValue(Integer.class);
                    shop_item_cost5 = dataSnapshot.child("shop_item_5").child("cost").getValue(Integer.class);
                    shop_item_cost6 = dataSnapshot.child("shop_item_6").child("cost").getValue(Integer.class);
                    shop_item_cost7 = dataSnapshot.child("shop_item_7").child("cost").getValue(Integer.class);
                    shop_item_cost8 = dataSnapshot.child("shop_item_8").child("cost").getValue(Integer.class);
                    shop_item_cost9 = dataSnapshot.child("shop_item_9").child("cost").getValue(Integer.class);
                    shop_item_cost10= dataSnapshot.child("shop_item_10").child("cost").getValue(Integer.class);
                    shop_item_cost11 = dataSnapshot.child("shop_item_10").child("cost").getValue(Integer.class);
                    shop_item_cost12 = dataSnapshot.child("shop_item_10").child("cost").getValue(Integer.class);
                    //  shop_item_cost10 = dataSnapshot.child("shop_item_10").child("Cost").getValue(Integer.class);
                    //  shop_item_cost11 = dataSnapshot.child("shop_item_11").child("Cost").getValue(Integer.class);
                    //  shop_item_cost12 = dataSnapshot.child("shop_item_12").child("Cost").getValue(Integer.class);
                    //  shop_item_cost13 = dataSnapshot.child("shop_item_13").child("Cost").getValue(Integer.class);
                    //  shop_item_cost14 = dataSnapshot.child("shop_item_14").child("Cost").getValue(Integer.class);
                    //  shop_item_cost15 = dataSnapshot.child("shop_item_15").child("Cost").getValue(Integer.class);

                    shop_item_click1 = dataSnapshot.child("shop_item_1").child("click").getValue(Integer.class);
                    shop_item_click2 = dataSnapshot.child("shop_item_2").child("click").getValue(Integer.class);
                    shop_item_click3 = dataSnapshot.child("shop_item_3").child("click").getValue(Integer.class);
                    shop_item_click4 = dataSnapshot.child("shop_item_4").child("click").getValue(Integer.class);
                    shop_item_click5 = dataSnapshot.child("shop_item_5").child("click").getValue(Integer.class);
                    shop_item_click6 = dataSnapshot.child("shop_item_6").child("click").getValue(Integer.class);


online = true;
                    Toast.makeText(shop.this, "Hallo", Toast.LENGTH_SHORT).show();
                    products = new ArrayList<>();
                    products.add("" + shop_item_1);
                    products.add("" + shop_item_2);
                    products.add("" + shop_item_3);
                    products.add("" + shop_item_4);
                    products.add("" + shop_item_5);
                    products.add("" + shop_item_6);
                    products.add("" + shop_item_7);
                    products.add("" + shop_item_8);
                    products.add("" + shop_item_9);
                    products.add("" + shop_item_10);
                    adapter = new ArrayAdapter<String>(shop.this, android.R.layout.simple_list_item_1, products);
                    listview.setAdapter(adapter);

                    ;

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                        @Override
                                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                            if (position == 0) {

                                                                if (value >= shop_item_cost1) {
                                                                    value = value - shop_item_cost1;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    myRef_for_clicks.child("Click").setValue(shop_item_click1);


                                                                }else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }


                                                            if (position == 1) {
                                                                if (value >= shop_item_cost2) {
                                                                    value = value - shop_item_cost2;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    myRef_for_clicks.child("Click").setValue(shop_item_click2);


                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                            if (position == 2) {
                                                                if (value >= shop_item_cost3) {
                                                                    value = value - shop_item_cost3;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    myRef_for_clicks.child("Click").setValue(shop_item_click3);


                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                            if (position == 3) {
                                                                if (value >= shop_item_cost4) {
                                                                    value = value - shop_item_cost4;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    myRef_for_clicks.child("Click").setValue(shop_item_click4);


                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }


                                                            if (position == 4) {
                                                                if (value >= shop_item_cost5) {
                                                                    value = value - shop_item_cost5;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    myRef_for_clicks.child("Click").setValue(shop_item_click5);


                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                            if (position == 5) {
                                                                if (value >= shop_item_cost6) {
                                                                    value = value - shop_item_cost6;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    myRef_for_clicks.child("Click").setValue(shop_item_click6);


                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();

                                                                }
                                                            }

                                                            if (position == 6) {
                                                                if (value >= shop_item_cost7) {
                                                                    value = value - shop_item_cost7;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                                                    Boolean data = sharedPreferences.getBoolean("Color_green" , false);
                                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                    editor.putBoolean("Color_green" , true);
                                                                    editor.apply();

                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }

                                                            if (position == 7) {
                                                                if (value >= shop_item_cost8) {
                                                                    value = value - shop_item_cost8;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                                                    Boolean data = sharedPreferences.getBoolean("Color_red" , false);
                                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                    editor.putBoolean("Color_red" , true);
                                                                    editor.apply();

                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                            if (position == 8) {
                                                                if (value >= shop_item_cost9) {
                                                                    value = value - shop_item_cost9;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                                                    Boolean data = sharedPreferences.getBoolean("Color_blue" , false);
                                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                    editor.putBoolean("Color_blue" , true);
                                                                    editor.apply();
                                                                } else {

                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                            if (position == 9) {
                                                                if (value >= 1000) {
                                                                    value = value - 10000;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    View inflater = LayoutInflater.from(shop.this).inflate(R.layout.main, parent, false);
                                                                    Button click = (Button)inflater.findViewById(R.id.Click_Starssts);
                                                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                                                    Boolean data = sharedPreferences.getBoolean("Sound" , false);
                                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                    editor.putBoolean("Sound" , true);
                                                                    editor.apply();

                                                                    //    int red = Color.parseColor("#FF0000");
//
//
                                                                    //    SharedPreferences prefs = getSharedPreferences("Background", Context.MODE_PRIVATE);
                                                                    //    SharedPreferences.Editor editor = prefs.edit();
                                                                    //    editor.putInt("Backgr ound", Color.GREEN);
                                                                    //    editor.commit();
                                                                    //    Toast.makeText(shop.this, "Farbe gekauft", Toast.LENGTH_SHORT).show();
                                                                    //    Log.d("Farbe:" , "ist" + prefs.getInt("Background" , Color.RED));







                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }


                                                            }

                                                            if (position == 10) {
                                                                if (value >= shop_item_cost11) {
                                                                    value = value - shop_item_cost11;
                                                                    myRef_for_money.child("Money").setValue(value);
                                                                    View inflater = LayoutInflater.from(shop.this).inflate(R.layout.main, parent, false);
                                                                    Button click = (Button)inflater.findViewById(R.id.Click_Starssts);
                                                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                                                    Boolean data = sharedPreferences.getBoolean("Sound" , false);
                                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                    editor.putBoolean("Sound" , true);
                                                                    editor.apply();

                                                                    //    int red = Color.parseColor("#FF0000");
//
//
                                                                    //    SharedPreferences prefs = getSharedPreferences("Background", Context.MODE_PRIVATE);
                                                                    //    SharedPreferences.Editor editor = prefs.edit();
                                                                    //    editor.putInt("Backgr ound", Color.GREEN);
                                                                    //    editor.commit();
                                                                    //    Toast.makeText(shop.this, "Farbe gekauft", Toast.LENGTH_SHORT).show();
                                                                    //    Log.d("Farbe:" , "ist" + prefs.getInt("Background" , Color.RED));







                                                                } else {
                                                                    Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                                }


                                                            }




                                                            //   if (position == 11) {
                                                            //       if (value >= shop_item_cost12) {
                                                            //           value = value - shop_item_cost12;
                                                            //           myRef_for_money.child("Money").setValue(value);
                                                            //           myRef_for_clicks.child("Click").setValue(55);
                                                            //       } else {
                                                            //           Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                            //       }
                                                            //   }
                                                            //   if (position == 12) {
                                                            //       if (value >= shop_item_cost13) {
                                                            //           value = value - shop_item_cost13;
                                                            //           myRef_for_money.child("Money").setValue(value);
                                                            //           myRef_for_clicks.child("Click").setValue(60);
                                                            //       } else {
                                                            //           Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                            //       }
                                                            //   }
                                                            //   if (position == 13) {
                                                            //       if (value >= shop_item_cost14) {
                                                            //           value = value - shop_item_cost14;
                                                            //           myRef_for_money.child("Money").setValue(value);
                                                            //           myRef_for_clicks.child("Click").setValue(60);
                                                            //       } else {
                                                            //           Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                            //       }
                                                            //   }
                                                            //   if (position == 14) {
                                                            //       if (value >= shop_item_cost15) {
                                                            //           value = value - shop_item_cost15;
                                                            //           myRef_for_money.child("Money").setValue(value);
                                                            //           myRef_for_clicks.child("Click").setValue(60);
                                                            //       } else {
                                                            //           Toast.makeText(shop.this, "Not enough Clicks", Toast.LENGTH_SHORT).show();
                                                            //       }

                                                            //   }


                                                        }
                                                    });



                } else {


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        bubble = MediaPlayer.create(getApplicationContext(), R.raw.dustyroom_cartoon_bubble_pop);
        //initializing database
        final RelativeLayout relative = (RelativeLayout) findViewById(R.id.shopl);
        database_for_money = FirebaseDatabase.getInstance();
        myRef_for_money = database_for_money.getReference(name);
        database_for_clicks = FirebaseDatabase.getInstance();
        myRef_for_clicks = database_for_money.getReference(name);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shop.this, MainActivity.class);
                startActivity(intent);
                bubble.start();

            }
        });
        myRef_for_money.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()) {
                    value = dataSnapshot.child("Money").getValue(Integer.class);
                    money_total.setText("" + value);
                    Log.d(TAG, "Value is: " + value);
                } else {
                    value = 0;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        Red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                boolean color = sharedPreferences.getBoolean("Color_red", false);
                if (color == true) {

                    SharedPreferences.Editor editor = background.edit();
                    editor.putString("Color", "#cc0953");
                    editor.apply();
                    Intent intent = new Intent(shop.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(shop.this, "Not brought!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                boolean color = sharedPreferences.getBoolean("Color_blue", false);
                if (color == true) {
                    SharedPreferences.Editor editor = background.edit();
                    editor.putString("Color", "#1e90ff");
                    editor.apply();
                    Intent intent = new Intent(shop.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(shop.this, "Not brought!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                boolean color = sharedPreferences.getBoolean("Color_green", true);
                if (color == true) {
                    SharedPreferences.Editor editor = background.edit();
                    editor.putString("Color", "#2f9d66");
                    editor.apply();
                    Intent intent = new Intent(shop.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(shop.this, "Not brought!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        money_total.setText("" + value);
        myRef_for_clicks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()) {
                    value1 = dataSnapshot.child("Click").getValue(Integer.class);

                    Log.d(TAG, "Value is: " + value);
                } else {
                    value1 = 0;
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        Log.d(TAG, "Value" + value);


// TODO: Add adView to your view hierarchy.


        //create the list adapter and set the adapter
    }
    public void setitem(){


    }}


