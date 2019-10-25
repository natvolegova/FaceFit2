package com.example.facefit2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facefit2.Adapter.ProgramAdapter;
import com.example.facefit2.App;
import com.example.facefit2.Data.DatabaseHelper;
import com.example.facefit2.Objects.ProgramFullInfo;
import com.example.facefit2.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private DatabaseHelper databaseHelper;
    private ProgramAdapter programAdapter;
    private List<ProgramFullInfo> programElements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = App.getInstance().getDatabaseInstance();
        programElements = databaseHelper.ProgramDao().getProgramsFullInfo();
        initView();
        initPrograms();
    }

    private void initPrograms() {
        programAdapter = new ProgramAdapter(this, programElements);
        rvList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvList.getContext(),DividerItemDecoration.VERTICAL);
        rvList.addItemDecoration(dividerItemDecoration);
        rvList.setAdapter(programAdapter);
    }

    private void initView() {
        rvList = findViewById(R.id.rv_list);
    }

}
