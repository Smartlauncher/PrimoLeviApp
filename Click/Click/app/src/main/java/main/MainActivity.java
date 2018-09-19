package main;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.RecoverySystem;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import calebseeling2.click.R;


public class MainActivity extends AppCompatActivity {
    private Button click_start;
   private double money_plus_value = 0;
    private TextView number_final;

    private static int clicker = 2;
  //  private int clicker_custom = shop.getClicker();
    private TextView yourscore;
    private int money_1 = 0;
    private TextView hello;
    private ImageView txtclose;
    private int value;
    private int value_for_score;
    private Button btnFollow;
    private int randomString;
    private MediaPlayer coinsound;
    private MediaPlayer mp;
    private MediaPlayer bubble;
    private int value_money;
    private static String TAG = "MainActivity";
    private FirebaseDatabase database;
    private FirebaseDatabase database_for_score;
    private FirebaseDatabase Whole_Database;
    private  SharedPreferences.Editor editor;
    private ImageView shop;
    private ImageView Highlist;
    private static String nameer_s;
    private static int nameer;
    private TextView money;
    private int Key;
    private boolean clicked = false;
    private Random random22;
    private int random2;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private  DatabaseReference myRef;
    private  DatabaseReference WholeDatabase;
    private  DatabaseReference myRef_for_score;
    private static int number = 0;
    private int money_2;

    private boolean iffer = false;
    private int Highscore1;
    private int Highscore2;
    private int Highscore3;
    private int Highscore4;
    private int Highscore5;
    private int Highscore6;
    private int Highscore7;
    private int Highscore8;
    private int Highscore9;
    private int Highscore10;
    private static SharedPreferences your_score;
    private static SharedPreferences prefs_money;
    private static SharedPreferences green;
    private static SharedPreferences blue;
    private static SharedPreferences songrandom;
    private static SharedPreferences red;
    private TextView name;
    private ProgressBar progressBar;
    private static SharedPreferences preview_background;
    private static SharedPreferences click_pref;
    private SharedPreferences shared_sound;
    private static SharedPreferences prefs_background;
    private int bigDecimal;
    private Boolean clicked_sound = false;
    private int clicks;
    private static SharedPreferences Name_saver;

    private Button silent;
    private Button Red;
    private Button Green;
    private boolean connected = false;
    private Button Blue;
    private boolean myref_boolean = false;
    private boolean myref_score = false;
    private TextView restart;
    private String path = "fire/" + "Skin" + ".png";
    private boolean buttonclick = false;
    String numberforsave = number + "";
    private Button click;


    public static int getClicker() {
        return clicker;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        first();
final int random = getRandom();

        mp = MediaPlayer.create(getApplicationContext(), random);
        coinsound = MediaPlayer.create(getApplicationContext(), R.raw.smwcoin);


        //initializingm

      // DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
      // connectedRef.addValueEventListener(new ValueEventListener() {
      //     @Override
      //     public void onDataChange(DataSnapshot snapshot) {
      //         connected = snapshot.getValue(Boolean.class);
      //         if (connected) {
      //             System.out.println("connected");
      //         } else {
      //             System.out.println("not connected");
      //         }
      //     }

      //     @Override
      //     public void onCancelled(DatabaseError error) {
      //         System.err.println("Listener was cancelled");
      //     }
      // });
      // if (connected){
      //     return;
      // }
      // else{
      //     Toast.makeText(this, "Offline", Toast.LENGTH_SHORT).show();
      // }


        //
        // Create a storage reference from our app
        click_start = (Button) findViewById(R.id.click_Start);
     //   String colorValue = prefs_background.getString("Background"," #FFFFFF");

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_main);



        //PreferenceManager initialized
        Log.d("Heute" , String.valueOf(number));
     //   RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_main);
     //   Background = getSharedPreferences("Background", Context.MODE_PRIVATE);

     //  layout.setBackgroundColor(Background.getInt("Background" , Color.WHITE));
        your_score= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        preview_background= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        SharedPreferences.Editor editor_blue = preview_background.edit();
        editor_blue.putString("Color" , "");
        if (preview_background.getString("Color" , "#rrggbb").isEmpty()){
            return;
        }
        else {
            layout.setBackgroundColor(Color.parseColor(preview_background.getString("Color", "#f1dddd")));

        }
       // SharedPreferences.Editor editor_red = red.edit();
       // editor_red.putBoolean("Color_red" , false);
 //your_score
        random22 = new Random();
        random2 = random22.nextInt(300) +1;
        prefs_money= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        click_pref= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        Name_saver = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        //initialized database
            database_for_score = FirebaseDatabase.getInstance();
            myRef_for_score = database_for_score.getReference("Highscore");
        Whole_Database = FirebaseDatabase.getInstance();
        WholeDatabase = database_for_score.getReference();
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference(getName());

        bubble = MediaPlayer.create(getApplicationContext(), R.raw.dustyroom_cartoon_bubble_pop);


            //skin



        // Read from the database








        WholeDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if( dataSnapshot.child("Highscore1").exists()&&dataSnapshot.child("Highscore2").exists()&& dataSnapshot.child("Highscore3").exists()&&
                dataSnapshot.child("Highscore4").exists()&& dataSnapshot.child("Highscore5").exists() &&dataSnapshot.child("Highscore6").exists()&&
                dataSnapshot.child("Highscore7").exists()&& dataSnapshot.child("Highscore8").exists()&& dataSnapshot.child("Highscore9").exists() &&
                        dataSnapshot.child("Highscore10").exists()) {
                    Highscore1 = dataSnapshot.child("Highscore1").child("Score").getValue(Integer.class);
                Highscore2 = dataSnapshot.child("Highscore2").child("Score").getValue(Integer.class);
                Highscore3 = dataSnapshot.child("Highscore3").child("Score").getValue(Integer.class);
                Highscore4 = dataSnapshot.child("Highscore4").child("Score").getValue(Integer.class);
                Highscore5 = dataSnapshot.child("Highscore5").child("Score").getValue(Integer.class);
                Highscore6 = dataSnapshot.child("Highscore6").child("Score").getValue(Integer.class);
                Highscore7 = dataSnapshot.child("Highscore7").child("Score").getValue(Integer.class);
                Highscore8 = dataSnapshot.child("Highscore8").child("Score").getValue(Integer.class);
                Highscore9 = dataSnapshot.child("Highscore9").child("Score").getValue(Integer.class);
                Highscore10 = dataSnapshot.child("Highscore10").child("Score").getValue(Integer.class);
                    Log.d(TAG , "datasnapshotwhole" + Highscore1);
                    Log.d(TAG, "Value is: " + value);

            }


        }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Log.d("DIr" , String.valueOf(number));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("Money").exists() && dataSnapshot.child("Click").exists()) {
                    value_money =  dataSnapshot.child("Money").getValue(Integer.class);
                    clicks = dataSnapshot.child("Click").getValue(Integer.class);


                    Log.d(TAG , "datasnapshotMoney" + clicks);

                    //put value in view;
                } else  {
                    Toast.makeText(MainActivity.this, "Not Loading", Toast.LENGTH_SHORT).show();
                }


            }





            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        Log.d("Gehts" , String.valueOf(number));



        Log.d("WIe" , String.valueOf(number));


//hello.setText( getName() );
        //Item initialized

        restart = (TextView) findViewById(R.id.restart);

        silent = (Button) findViewById(R.id.silent);

        number_final = (TextView) findViewById(R.id.Number_final);
        yourscore = (TextView) findViewById(R.id.yourscore) ;
        name = (TextView) findViewById(R.id.Name) ;
        shop = (ImageView) findViewById(R.id.shop);
        number_final.setText(number + "");
        Highlist = (ImageView) findViewById(R.id.Highlist);
         shared_sound = PreferenceManager.getDefaultSharedPreferences(this);
         name.setText("Welcome: " + getName());

        //Highscore site intent

        Highlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Highscore.class);
                Pair[] Pairs = new Pair[1];
                Pairs[0] = new Pair<View , String>(Highlist , "imageTransision2");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this , Pairs);
                startActivity(intent , options.toBundle());
                startActivity(intent);

                bubble.start();
                number = 0;
            }
        });


        Log.d("Hallo" , String.valueOf(number));
        //restarting activity when button clicked
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubble.start();
                recreate();
                number = 0;
                mp.release();
            }});

        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                clicked_sound = true;

            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubble.start();
                Intent intent = new Intent(MainActivity.this , shop.class);

                Pair[] Pairs = new Pair[1];
                Pairs[0] = new Pair<View , String>(shop , "imageTransision");

ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this , Pairs);
                startActivity(intent , options.toBundle());
                number = 0;
            }
        });


        click_start.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {



               if (shared_sound.getBoolean("Sound" , false) == true){
if (clicked_sound == true) {




}
else
{
    mp.start();
}
               //    Handler handler = new Handler();
               //    handler.postDelayed(new Runnable() {
               //        public void run() {

               //        }
               //    }, 100);   //5 seconds


clicked = true;



                   Log.d("Tag" , "Tag" +number);
                   Log.d("CLicks" , "CLicks" + clicks);
                   number = number +  clicks;
                   Log.d("Clicks" , String.valueOf(clicks));
                   Log.d("HELLO", "Register Button Clicked");
                   // setting text to points
                   number_final.setText(number + "");
                   number_final.setClickable(false);
                   Log.d("Number" , String.valueOf(number));

                   //adding money
                   money_plus_value = money_plus_value +clicks;


                   //invisibility of icons
                   shop.setVisibility(View.INVISIBLE);
                   Highlist.setVisibility(View.INVISIBLE);


                 // Log.d("Number ","number"  + random2);
                 // if (number == random2){
                 //     iffer = true;
                 //     click_start.setText("DONT CLICK");
                 //     click_start.setTextSize(50);
                 //     Handler handler = new Handler();
                 //     handler.postDelayed(new Runnable() {
                 //         public void run() {
                 //             if (click_start.isPressed()){
                 //                 number = number -50;
                 //                 iffer = false;


                 //             }

                 //             Handler handler = new Handler();
                 //             handler.postDelayed(new Runnable() {
                 //                 public void run() {
                 //                     if (iffer == true) {
                 //                         number = number + 50;
                 //                         iffer = false;
                 //                     }
                 //                     else{
                 //                         return;
                 //                     }
                 //                 }
                 //             }, 5000);
                 //         }
                 //     }, 1000);



                   timer();
                   buttonclick = true;
                   }


                   //calling timer and setting buttonclick true



               else{

                   Log.d("Tag" , "Tag1" + number);

                       number = number + clicks;

               //    Log.d("Number ","number"  + random2);
               //    if (number == random2){
               //        iffer = true;
//
//
               //        click_start.setText("DONT CLICK");
               //        click_start.setTextSize(50);
               //        if (click_start.isPressed()){
               //            number = number -50;
               //            iffer = false;
               //            click_start.setClickable(true);
               //            click_start.setTextSize(20);
//
               //        }
//
               //        Handler handler = new Handler();
               //        handler.postDelayed(new Runnable() {
               //            public void run() {
               //                number = number + 50;
               //                iffer = false;
               //                click_start.setClickable(true);
               //                click_start.setTextSize(20);
               //            }
               //        }, 5000);
//



                       Log.d("Clicks" , String.valueOf(clicks));
                       Log.d("HELLO", "Register Button Clicked");
                       // setting text to points
                       number_final.setText(number + "");
                       number_final.setClickable(false);
                       Log.d("Number" , String.valueOf(number));

                       //adding money
                       money_plus_value = money_plus_value +clicks;


                       //invisibility of icons
                       shop.setVisibility(View.INVISIBLE);
                       Highlist.setVisibility(View.INVISIBLE);


                       //calling timer and setting buttonclick true
                       timer();
                       buttonclick = true;

        Log.d("NAomi" , String.valueOf(number));
        //intent for shop activity
    }}
        });






        }





//timer method
   public void timer(){
       if (buttonclick == false){
           new CountDownTimer(30000, 1000) {

               public void onTick(long millisUntilFinished) {
                   if (iffer == false) {
                       click_start.setText("" + millisUntilFinished / 1000);
                   }
                   else{
                       return;
                   }
               }

               public void onFinish() {

                   Log.d("Nathan", String.valueOf(number));
                   //clickable false

                   click_start.setClickable(false);
                   mp.release();
                   click_start.setText( "0");

                   //setting money
                   Log.d(TAG, "valuetest" + value_money);
                   myRef.child("Money").setValue(value_money + money_plus_value);

                   money_plus_value = 0;


                   //setting visibility

                   shop.setVisibility(View.VISIBLE);

                   Highlist.setVisibility(View.VISIBLE);


                   //Highscore setting
                   if (number > Highscore1 && number > Highscore2 && number > Highscore3 && number > Highscore4
                          && number > Highscore5 && number > Highscore6
                           && number > Highscore7 && number > Highscore8 && number > Highscore9 && number > Highscore10) {
                       WholeDatabase.child("Highscore1").child("Score").setValue(number);
                       WholeDatabase.child("Highscore1").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 10000);
                       coinsound.start();
                       coinsound.pause();
                       final TextView first = (TextView) findViewById(R.id.first);
                       first.setVisibility(View.VISIBLE);
                       first.animate().scaleY(500);
                       first.animate().scaleY(500);
                       Handler handler = new Handler();
                       handler.postDelayed(new Runnable() {
                           public void run() {
                               first.setVisibility(View.INVISIBLE);
                           }
                       }, 1000);


                      // Toast.makeText(MainActivity.this, "You are now first place!Congrats!", Toast.LENGTH_SHORT).show();

                   }
                   if (number > Highscore2 && number < Highscore1) {
                       WholeDatabase.child("Highscore2").child("Score").setValue(number);
                       WholeDatabase.child("Highscore2").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 5000);
                       coinsound.start();
                    //   Toast.makeText(MainActivity.this, "You are now second place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore3 && number < Highscore2) {
                       WholeDatabase.child("Highscore3").child("Score").setValue(number);
                       WholeDatabase.child("Highscore3").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 1000);
                       coinsound.start();
                    //   Toast.makeText(MainActivity.this, "You are now third place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore4 && number < Highscore3) {
                       WholeDatabase.child("Highscore4").child("Score").setValue(number);
                       WholeDatabase.child("Highscore4").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 700);
                       coinsound.start();
                   //    Toast.makeText(MainActivity.this, "You are now fourth place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore5 && number < Highscore4) {
                       WholeDatabase.child("Highscore5").child("Score").setValue(number);
                       WholeDatabase.child("Highscore5").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 600);
                       coinsound.start();
                      // Toast.makeText(MainActivity.this, "You are now fifth place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore6 && number < Highscore5) {
                       WholeDatabase.child("Highscore6").child("Score").setValue(number);
                       WholeDatabase.child("Highscore6").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 500);
                       coinsound.start();
                      // Toast.makeText(MainActivity.this, "You are now sixth place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore7 && number < Highscore6) {
                       WholeDatabase.child("Highscore7").child("Score").setValue(number);
                       WholeDatabase.child("Highscore7").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 400);
                       coinsound.start();
                      // Toast.makeText(MainActivity.this, "You are now seventh place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore8 && number < Highscore7) {
                       WholeDatabase.child("Highscore8").child("Score").setValue(number);
                       WholeDatabase.child("Highscore8").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 300);
                       coinsound.start();
                      // Toast.makeText(MainActivity.this, "You are now eight place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore9 && number < Highscore8) {
                       WholeDatabase.child("Highscore9").child("Score").setValue(number);
                       WholeDatabase.child("Highscore9").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 200);
                       coinsound.start();
                       // Toast.makeText(MainActivity.this, "You are now ninth place!Congrats!", Toast.LENGTH_SHORT).show();
                   }
                   if (number > Highscore10 && number < Highscore9) {
                       WholeDatabase.child("Highscore10").child("Score").setValue(number);
                       WholeDatabase.child("Highscore10").child("Name").setValue(getName());
                       myRef.child("Money").setValue(value_money + 100);
                       coinsound.start();
                       Toast.makeText(MainActivity.this, "You are now tenth place!Congrats!", Toast.LENGTH_SHORT).show();

                   }
                   int score = your_score.getInt("Score", number);
                   if (number > score) {
                       //your_score
                       SharedPreferences.Editor editor = your_score.edit();
                       editor.putInt("Score", number);
                       editor.commit();


                   }

               }



           }.start();
       }
       else{







           return;
       }




   }



//task when app first time opened

public void first() {


    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    if (!prefs.getBoolean("firstTime", false)) {
        ShowPopup();

        // mark first time has ran.
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstTime", true);
        editor.commit();
    }


}

//showpopup dialog
   public void ShowPopup() {
       final Dialog dialog= new Dialog(this);


       dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
       dialog.setContentView(R.layout.dialog);
       dialog.show();
       dialog.setCancelable(false);
       green= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
       red= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
       blue= PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
       SharedPreferences.Editor editor_green = green.edit();
       editor_green.putBoolean("Color_green" , false);
       editor_green.apply();
       SharedPreferences.Editor editor_red = red.edit();

       editor_red.putBoolean("Color_red" ,false);
       editor_red.apply();
       SharedPreferences.Editor editor_blue = blue.edit();
       editor_blue.putBoolean("Color_blue" , false);
       editor_blue.apply();



      final EditText edit = (EditText) dialog.findViewById(R.id.username) ;



       Button bt_yes = (Button)dialog.findViewById(R.id.Button_dialog);


       bt_yes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseDatabase database1 = FirebaseDatabase.getInstance();
               DatabaseReference myRef1 = database1.getReference(edit.getText().toString());
               SharedPreferences.Editor edit_sound = shared_sound.edit();
               edit_sound.putBoolean("Sound" , false);

               myRef1.setValue(edit.getText().toString());
               myRef1.child("Click").setValue(1);
               myRef1.child("Money").setValue(200);
SharedPreferences.Editor editorer = Name_saver.edit();
editorer.putString("Name" , edit.getText().toString());
editorer.apply();


              SharedPreferences.Editor score_editor = your_score.edit();
              score_editor.putInt("Score" , 0);
              score_editor.apply();
               dialog.dismiss();





           }
       });}


       public static String getName(){
        nameer_s = Name_saver.getString("Name" , "ERROR");


return nameer_s;


   }
       public static int getScore(){
           int nameer = your_score.getInt("Score" , number);
           return nameer;
       }
    public int  getRandom() {
        ArrayList<Integer> products = new ArrayList<>();
        products.add(R.raw.song2);
        products.add(R.raw.song);
         randomString = products.get(new Random().nextInt(products.size()));


       return randomString;



    }

    private void downloadFile() throws IOException {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://click-bd65d.appspot.com");
        StorageReference  islandRef = storageRef.child(" Bildschirmfoto 2018-08-25 um 18.59.15.png");


        File localFile = File.createTempFile("images", "jpg");
        islandRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });
    }

    }










