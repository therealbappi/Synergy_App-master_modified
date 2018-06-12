package ambika.android.com.synergy_app_final;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.ugurtekbas.fadingindicatorlibrary.FadingIndicator;

import java.util.Timer;
import java.util.TimerTask;

import br.com.bloder.magic.view.MagicButton;

public class ContactUs extends AppCompatActivity {
    ViewPager pager;
    Contactus_slider adapter;
    LinearLayout sliderlayout;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        pager = findViewById(R.id.pager);
        sliderlayout = (LinearLayout) findViewById(R.id.slidedots);
        adapter = new Contactus_slider(this);
        pager.setAdapter(adapter);
        FadingIndicator indicator = (FadingIndicator) findViewById(R.id.indicator);
        ViewPager viewpagerDefault = (ViewPager) findViewById(R.id.pager);
        Button button = findViewById(R.id.back);
        MagicButton facebook = (MagicButton) findViewById(R.id.facebook);
        facebook.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://www.facebook.com/ieteisf/"));
                startActivity(i);
            }
        });
        MagicButton insta = (MagicButton) findViewById(R.id.insta);
        facebook.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://www.facebook.com/ieteisf/"));
                startActivity(i);
            }
        });

        PushDownAnim.setPushDownAnimTo( button)
                .setOnClickListener( new View.OnClickListener(){
                    @Override
                    public void onClick( View view ){
                        Intent i= new Intent();
                        i.setClass(ContactUs.this,MainActivity.class);
                        startActivity(i);
                    }

                } );
//assigning indicator to viewpager
        indicator.setViewPager(viewpagerDefault);

//Set fill color
        indicator.setFillColor(Color.LTGRAY);
//Set stroke color
        indicator.setStrokeColor(Color.CYAN);
        /*dotscount = adapter.getCount();
        dots = new ImageView[dotscount];
        for(int i=0;i<dotscount;i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_outline_fiber_manual_record_24px));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0,0,0,0);
            sliderlayout.addView(dots[i],layoutParams);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_round_fiber_manual_record_24px));
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<dotscount;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_outline_fiber_manual_record_24px));

                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_round_fiber_manual_record_24px));


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ContactUs.MyTimer(),2000,4000);
    }
    public class MyTimer extends TimerTask {

        @Override
        public void run() {
            if(pager.getCurrentItem()==0){
                pager.setCurrentItem(1);
            }
            else if(pager.getCurrentItem()==1){
                pager.setCurrentItem(0);
            }else{
                pager.setCurrentItem(0);
            }
        }*/
    }
}
