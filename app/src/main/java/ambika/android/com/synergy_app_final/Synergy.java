package ambika.android.com.synergy_app_final;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.ugurtekbas.fadingindicatorlibrary.FadingIndicator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Synergy extends AppCompatActivity {
    private TextView dd,hh,mm,ss;
    private TextView eventStart,heading;
    private Handler handler;
    private Runnable runnable;
    ViewPager pager;
    Synergy_slider adapter;
    LinearLayout sliderlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synergy);
        Button button = findViewById(R.id.back);

        PushDownAnim.setPushDownAnimTo( button)
                .setOnClickListener( new View.OnClickListener(){
                    @Override
                    public void onClick( View view ){
                        Intent i= new Intent();
                        i.setClass(Synergy.this,MainActivity.class);
                        startActivity(i);
                    }

                } );
        pager = findViewById(R.id.pager);
        sliderlayout = (LinearLayout) findViewById(R.id.slidedots);
        adapter = new Synergy_slider(this);
        pager.setAdapter(adapter);
        FadingIndicator indicator = (FadingIndicator) findViewById(R.id.indicator);
        ViewPager viewpagerDefault = (ViewPager) findViewById(R.id.pager);
        indicator.setViewPager(viewpagerDefault);

//Set fill color
        indicator.setFillColor(Color.LTGRAY);
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


}
