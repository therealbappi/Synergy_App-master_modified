package ambika.android.com.synergy_app_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.List;

public class Faqs extends AppCompatActivity {
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        /*YoYo.with(Techniques.FlipInY)
                .duration(3000)

                .playOn(findViewById(R.id.recyclerView));
        YoYo.with(Techniques.Landing)
                .duration(2000)
                .playOn(findViewById(R.id.fi));*/


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Question: Is Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra) good for VIt?",
                        "Answer:13.3 inch, Silver, 1.35 kg is fine for Vit students"));

        productList.add(
                new Product(
                        1,
                        "Question: Is Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home) good for VIt?",
                        "Answer: 14 inch, Gray, 1.659 kg is fine for Vit students"));

        productList.add(
                new Product(
                        1,
                        "Question:Is Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10) good for Vit?",
                        "Answer: 13.3 inch, Silver, 1.35 kg is fine for Vit students"
                ));
        productList.add(
                new Product(
                        1,
                        "Question: Is Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra) good for VIt?",
                        "Answer:13.3 inch, Silver, 1.35 kg is fine for Vit students"));

        productList.add(
                new Product(
                        1,
                        "Question: Is Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home) good for VIt?",
                        "Answer: 14 inch, Gray, 1.659 kg is fine for Vit students"));

        productList.add(
                new Product(
                        1,
                        "Question:Is Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10) good for Vit?",
                        "Answer: 13.3 inch, Silver, 1.35 kg is fine for Vit students"
                ));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    public void home(View view) {
        Intent i= new Intent();
        i.setClass(Gallery.this,MainActivity.class);
        startActivity(i);
    }
}
