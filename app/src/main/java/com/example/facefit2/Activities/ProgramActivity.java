package com.example.facefit2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.facefit2.Adapter.ElementAdapter;
import com.example.facefit2.Adapter.ProductAdapter;
import com.example.facefit2.App;
import com.example.facefit2.Data.DatabaseHelper;
import com.example.facefit2.Objects.Element;
import com.example.facefit2.Objects.Product;
import com.example.facefit2.Objects.ProgramFullInfo;
import com.example.facefit2.R;

import java.util.ArrayList;
import java.util.List;

public class ProgramActivity extends AppCompatActivity {
    private TextView tv_name, tv_time, tv_counts, tv_text_desc, tv_product_title;
    private ImageView iv_program_img;
    private Button btn_start;
    private Toolbar toolbar;
    private DatabaseHelper databaseHelper;
    private ProgramFullInfo program;
    private ElementAdapter elementAdapter;
    private ProductAdapter productAdapter;
    private RecyclerView rv_product_list, rv_element_list;
    private List<Element> elementList;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        initView();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        databaseHelper = App.getInstance().getDatabaseInstance();
        program = databaseHelper.ProgramDao().getProgramsFullInfoById(id);
        initElements();
        initProducts();
    }

    private void initProducts() {
        rv_product_list = findViewById(R.id.rv_product_list);
        tv_product_title = findViewById(R.id.tv_product_title);
        productList =  databaseHelper.ProductDao().getProductsByProgram(program.get_id());
        if(productList.size()>0){
            tv_product_title.setVisibility(View.VISIBLE);
            productAdapter = new ProductAdapter(this, productList, 0);
            rv_product_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            rv_product_list.setAdapter(productAdapter);
        }
    }

    private void initElements() {
        rv_element_list = findViewById(R.id.rv_element_list);
        elementList =  databaseHelper.ElementDao().getElementsByProgram(program.get_id());
        elementAdapter = new ElementAdapter(this, elementList);
        rv_element_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv_element_list.getContext(),DividerItemDecoration.VERTICAL);
        rv_element_list.addItemDecoration(dividerItemDecoration);
        rv_element_list.setAdapter(elementAdapter);
    }

    protected void onResume() {
        super.onResume();
        String name = program.getName();
        tv_name.setText(name);
        String time = program.getTimeFormatting();
        tv_time.setText(time);
        String counts = program.getElementAddition(this);
        tv_counts.setText(counts);
        String textDesc = program.getText_desc();
        tv_text_desc.setText(textDesc);
    }
    private void initView() {
        tv_name = findViewById(R.id.tv_name);
        tv_time = findViewById(R.id.tv_time);
        tv_counts = findViewById(R.id.tv_counts);
        tv_text_desc = findViewById(R.id.tv_text_desc);
        iv_program_img = findViewById(R.id.iv_program_img);

        btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProgram();
            }
        });
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void startProgram() {

    }
}
