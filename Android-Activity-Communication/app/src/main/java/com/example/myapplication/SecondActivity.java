package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ItemAdapter itemAdapter;
    private List<Item> itemList = new ArrayList<>();
    private Intent fromMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fromMain = getIntent();

        Item stuId = new Item(fromMain.getStringExtra("stuId"), R.drawable.ic_baseline_credit_card_24);
        itemList.add(stuId);
        Item stuName = new Item(fromMain.getStringExtra("stuName"), R.drawable.ic_baseline_account_box_24);
        itemList.add(stuName);
        Item stuGender = new Item(fromMain.getStringExtra("stuGender"), R.drawable.ic_baseline_wc_24);
        itemList.add(stuGender);
        Item stuSchool = new Item(fromMain.getStringExtra("stuSchool"), R.drawable.ic_baseline_account_balance_24);
        itemList.add(stuSchool);
        Item stuMajor = new Item(fromMain.getStringExtra("stuMajor"), R.drawable.ic_baseline_school_24);
        itemList.add(stuMajor);
        Item stuClass = new Item(fromMain.getStringExtra("stuClass"), R.drawable.ic_baseline_assignment_ind_24);
        itemList.add(stuClass);

        itemAdapter = new ItemAdapter(SecondActivity.this,
                R.layout.item_item, itemList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemAdapter);
    }
}
