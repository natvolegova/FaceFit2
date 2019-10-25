package com.example.facefit2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.facefit2.App;
import com.example.facefit2.Data.DatabaseHelper;
import com.example.facefit2.Objects.Product;
import com.example.facefit2.R;

public class ProductActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DatabaseHelper databaseHelper;
    private ImageView iv_image;
    private TextView tv_name, tv_text_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initView();
        databaseHelper = App.getInstance().getDatabaseInstance();
    }

    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Product product = databaseHelper.ProductDao().getById(id);
        tv_name.setText(product.getName());
        String htmlText = product.getText_desc();
        if (htmlText != null) {
            tv_text_desc.setText(HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_COMPACT));
        }
    }

    private void initView() {
        tv_name = findViewById(R.id.tv_name);
        tv_text_desc = findViewById(R.id.tv_text_desc);
        iv_image = findViewById(R.id.iv_image);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}
