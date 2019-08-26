package com.iroshana.recycleviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> exampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText textInsert;
    private Button buttonInsert;
//    private EditText textRemove;
//    private Button buttonRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItemList();
        buildRecyclerView();
        setButtons();
    }

    private void insertItem(int position) {
        exampleList.add(new ExampleItem(R.drawable.ic_android, "New item at position " + position, "Line " + position));
        mAdapter.notifyItemInserted(position);
    }


    private void removeItem(int position) {
        exampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        exampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createItemList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 3", "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 5", "Line 6"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onItemDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void setButtons() {
        textInsert = findViewById(R.id.editTextInsert);
        buttonInsert = findViewById(R.id.buttonInsert);
//        textRemove = findViewById(R.id.editTextRemove);
//        buttonRemove = findViewById(R.id.buttonRemove);


        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textInsert.getText().equals("")) {
                    int position = Integer.parseInt(textInsert.getText().toString());
                    insertItem(position);
                } else {
                    throw new RuntimeException();
                }
            }
        });

//        buttonRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = Integer.parseInt(textRemove.getText().toString());
//                removeItem(position);
//            }
//        });
    }
}
