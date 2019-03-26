package info.kingpes.expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<DetailModel> lstDetail = new ArrayList<>();
        lstDetail.add(new DetailModel("Chau"));

        List<DetailModel> lstDetail1 = new ArrayList<>();
        lstDetail1.add(new DetailModel("Hoan"));

        List<DetailModel> lstDetail2 = new ArrayList<>();
        lstDetail2.add(new DetailModel("Tri"));

        List<DetailModel> lstDetail3 = new ArrayList<>();
        lstDetail3.add(new DetailModel("Dai"));

        List<HeaderModel> lst = new ArrayList<>();
        lst.add(new HeaderModel("Chau", lstDetail));
        lst.add(new HeaderModel("Hoan", lstDetail1));
        lst.add(new HeaderModel("Tri", lstDetail2));
        lst.add(new HeaderModel("Dai", lstDetail3));


        RecyclerView rcv = findViewById(R.id.rcv);
        ExpandableAdapter adapter = new ExpandableAdapter(this, lst);
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcv.setAdapter(adapter);


    }
}
