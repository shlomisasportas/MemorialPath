package com.shlomisasportas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowSearchDataActivity extends AppCompatActivity {
    ListView listView ;
    ArrayList listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_show_search_data);

        listView = (ListView) findViewById(R.id.list);

        listData = new ArrayList();

        for (int i =0; i< SearchActivity.keys.size(); i++){
            listData.add(MainActivity.allUsers.get(SearchActivity.keys.get(i)).getFirstName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listData);



        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition     = position;
                String firstName = "First Name: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getFirstName()+"\n"
                + "Last Name: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getLastName()+"\n"
                +"Date of Birth: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getDateOfBirth()+"\n"
                + "Mom's Name: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getMomName()+"\n"
                +  "Dad's Name: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getDadName()+"\n"
                + "Death Location: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getDeathLocation()+"\n"
                + "deathDate: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getDateOfDeath()+"\n"
                + "Age: "+MainActivity.allUsers.get(SearchActivity.keys.get(itemPosition)).getAge()+"\n";

                Intent i = new Intent(ShowSearchDataActivity.this, IndiviualsInfoActivity.class);
                i.putExtra("data", firstName);
                startActivity(i);
            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
