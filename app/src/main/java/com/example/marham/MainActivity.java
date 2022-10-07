package com.example.marham;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marham.adapters.QuestionAdapter;
import com.example.marham.models.Question;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ArrayList<Question> questions = new ArrayList<>();
    RecyclerView recyclerView;
    QuestionAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        // add items in list of questions
        questions.add(new Question("Nose Blockage ", "Normally what are the charges of nose endoscopy?", "11 months ago", "Lahore", "Asking for Self", "Female", R.drawable.nose_icon, 30));
        questions.add(new Question("NOSE BLEEDING ", "Fusce vel odio eu tortor facilisis porta nec eu nisi. Donec malesuada iaculis ultrices. Pellentesque leo nulla, lobortis vitae massa sed, posuere feugiat tortor. Fusce et aliquam metus", "11 months ago", "Lahore", "Asking for Self", "Male", R.drawable.patient_icon, 25));
        questions.add(new Question("My left side is a spot on my head ", "heart problem", "11 months ago", "Rawalpindi", "Asking for Self", "Female", R.drawable.heart_icon, 27));




        recyclerView = (RecyclerView) findViewById(R.id.questions_recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        customAdapter = new QuestionAdapter(this, questions);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SearchView searchView = (SearchView) findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                customAdapter.getFilter().filter(s);

            return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                customAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

}


