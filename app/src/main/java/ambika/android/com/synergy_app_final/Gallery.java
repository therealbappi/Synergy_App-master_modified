package ambika.android.com.synergy_app_final;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.ugurtekbas.fadingindicatorlibrary.FadingIndicator;

public class Gallery extends AppCompatActivity {
    private  String[] imageurls = {"https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/29136207_1838595156151602_4968855163755298816_n.jpg?_nc_cat=0&oh=0f7f45abba6618a31477f8c41f33e40d&oe=5B86E635",
    "http://synergy.ietevit.in/164.jpg","http://synergy.ietevit.in/161.jpg","http://synergy.ietevit.in/16.jpg",
            "https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/29133900_1838599789484472_7730035886837989376_n.jpg?_nc_cat=0&oh=13aefdc6034e1aeba10f82b25ca59e5d&oe=5B83F881",
            "https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/29135998_1838599616151156_8231799255124148224_n.jpg?_nc_cat=0&oh=31443977044483a391402f6007fdb9c6&oe=5BBC9903",
            "https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/29197122_1838598426151275_2467686134365290496_n.jpg?_nc_cat=0&oh=86748337b7b63126003e572c6af18ac6&oe=5B8CAF8F",
    "https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/29136709_1838599532817831_5117727930054606848_n.jpg?_nc_cat=0&oh=627ca4c58a9c8364a193406b03a6f218&oe=5B7CF20F",
    "https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/29178562_1838599946151123_4413039945581592576_n.jpg?_nc_cat=0&oh=754924a2ed5a278476063f82f87aaafb&oe=5B87ACCD"};
    LinearLayout sliderlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Button button = findViewById(R.id.back);

        PushDownAnim.setPushDownAnimTo( button)
                .setOnClickListener( new View.OnClickListener(){
                    @Override
                    public void onClick( View view ){
                        Intent i= new Intent();
                        i.setClass(Gallery.this,MainActivity.class);
                        startActivity(i);
                    }

                } );
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        Galleryadapter galleryadapter = new Galleryadapter(this,imageurls);
        viewPager.setAdapter(galleryadapter);
        sliderlayout = (LinearLayout) findViewById(R.id.slidedots);
        FadingIndicator indicator = (FadingIndicator) findViewById(R.id.indicator);
//assigning indicator to viewpager
        indicator.setViewPager(viewPager);

//Set fill color
        indicator.setFillColor(Color.LTGRAY);
//Set stroke color
        indicator.setStrokeColor(Color.CYAN);

    }
}
