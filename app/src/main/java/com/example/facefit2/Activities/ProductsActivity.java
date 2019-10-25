package com.example.facefit2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.facefit2.Adapter.ProductAdapter;
import com.example.facefit2.App;
import com.example.facefit2.Data.DatabaseHelper;
import com.example.facefit2.Objects.Product;
import com.example.facefit2.R;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DatabaseHelper databaseHelper;
    private ProductAdapter productAdapter;
    private RecyclerView rv_product_list;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initView();
        databaseHelper = App.getInstance().getDatabaseInstance();
        initProducts();
    }

    private void initProducts() {
        rv_product_list = findViewById(R.id.rv_product_list);
        productList =  databaseHelper.ProductDao().getAllElements();
        productAdapter = new ProductAdapter(this, productList, 1);
        rv_product_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv_product_list.getContext(),DividerItemDecoration.VERTICAL);
        rv_product_list.addItemDecoration(dividerItemDecoration);
        rv_product_list.setAdapter(productAdapter);
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
