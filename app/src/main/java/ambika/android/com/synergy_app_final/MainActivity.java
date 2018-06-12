package ambika.android.com.synergy_app_final;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alexfu.countdownview.CountDownView;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView aboutus,synergy,events,gallery,faqs,contactus,culturalnight;
    int[] images ={R.drawable.vlsi,R.drawable.ml,R.drawable.robo,R.drawable.code,R.drawable.paperpresentation,R.drawable.android};
    String[] eventnames ={"VLSI Workshop","Machine Learning Workshop","Robotics Workshop","CodeOlympia",
            "Paper Presentation (CSE/ECE/EEE)","Android APP DEV WORKSHOP"};
    int i;
    private PopupWindow popup;
    private CoordinatorLayout clayout;
    Intent intenttab;
    private TextView dd,hh,mm,ss;
    private TextView eventStart,heading;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutus = (CardView) findViewById(R.id.aboutus);
        synergy = (CardView) findViewById(R.id.synergy);
        events = (CardView) findViewById(R.id.events);
        gallery = (CardView) findViewById(R.id.gallery);
        faqs = (CardView) findViewById(R.id.faqs);
        contactus = (CardView) findViewById(R.id.contactus);
        culturalnight = (CardView) findViewById(R.id.culturalnight);
        clayout = (CoordinatorLayout) findViewById(R.id.Clayout);

        aboutus.setOnClickListener(this);
        synergy.setOnClickListener(this);
        events.setOnClickListener(this);
        gallery.setOnClickListener(this);
        faqs.setOnClickListener(this);
        contactus.setOnClickListener(this);
        culturalnight.setOnClickListener(this);
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder()
                    .normalImageRes(images[i])
                    .normalText(eventnames[i]);
            bmb.addBuilder(builder);
            builder.listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    if(index ==1){
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,Machinelearning.class);
                        startActivity(intent);
                    }
                    if(index ==0){
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,Vlsi.class);
                        startActivity(intent);
                    }
                    if(index ==2){
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,Robotics.class);
                        startActivity(intent);
                    }
                    if(index ==3){
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,Codeolympia.class);
                        startActivity(intent);
                    }
                    if(index ==5){
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,Appdev.class);
                        startActivity(intent);
                    }
                    if(index ==4){
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,Paperpresentation.class);
                        startActivity(intent);
                    }
                }
            });
        }
        Intent in = getIntent();
        dd = (TextView)findViewById(R.id.txtDay);
        hh = (TextView)findViewById(R.id.txtHour);
        mm = (TextView)findViewById(R.id.txtMinute);
        ss = (TextView)findViewById(R.id.txtSecond);
        eventStart = (TextView)findViewById(R.id.eventStart);
        heading = (TextView)findViewById(R.id.heading);
        countDownStart();

    }
    public void countDownStart(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                try{
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
                    Date futureDate = dateFormat.parse("21-02-2019");
                    Date currentDate = new Date();
                    if(!currentDate.after(futureDate)){
                        long diff = futureDate.getTime()-currentDate.getTime();
                        long days = diff/(24*60*60*1000);
                        diff-=days*(24*60*60*1000);
                        long hours = diff/(60*60*1000);
                        diff-=hours*(60*60*1000);
                        long minutes = diff/(60*1000);
                        diff-=minutes*(60000);
                        long seconds = diff/1000;
                        dd.setText(""+String.format("%02d",days));
                        hh.setText(""+String.format("%02d",hours));
                        mm.setText(""+String.format("%02d",minutes));
                        ss.setText(""+String.format("%02d"+seconds));

                    }
                    else{
                        eventStart.setVisibility(View.VISIBLE);
                        heading.setText("HURRAH!!!");
                        eventStart.setText("SYNERGY HAS STARTED");
                        textViewGone();
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
        };
        handler.postDelayed(runnable,1*1000);

    }
    public void textViewGone(){
        findViewById(R.id.linearLayout1).setVisibility(View.GONE);
        findViewById(R.id.linearLayout2).setVisibility(View.GONE);
        findViewById(R.id.linearLayout3).setVisibility(View.GONE);
        findViewById(R.id.linearLayout4).setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.contactus:
                Intent i = new Intent();
                i.setClass(MainActivity.this,ContactUs.class);
                startActivity(i);
                break;
                case R.id.aboutus:
                    Intent i6 = new Intent();
                    i6.setClass(MainActivity.this,Aboutus.class);
                    startActivity(i6);
                break;

            case R.id.synergy:
                Intent i5 = new Intent();
                i5.setClass(MainActivity.this,Synergy.class);
                startActivity(i5);
                break;
            case R.id.events:
                Toast.makeText(MainActivity.this,"Click on the Ham Button to get the Event List",Toast.LENGTH_LONG).show();
                break;
            case R.id.gallery:
                Intent i2 = new Intent();
                i2.setClass(MainActivity.this,Gallery.class);
                startActivity(i2);
                break;
            case R.id.faqs:
                Intent i3 = new Intent();
                i3.setClass(MainActivity.this,Faqs.class);
                startActivity(i3);
               break;
            case R.id.culturalnight:
                Intent i4 = new Intent();
                i4.setClass(MainActivity.this,Culturalnight.class);
                startActivity(i4);
                break;


        }


    }
}
