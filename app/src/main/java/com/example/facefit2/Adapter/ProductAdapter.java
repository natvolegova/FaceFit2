package com.example.facefit2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facefit2.Activities.ProductActivity;
import com.example.facefit2.Objects.Product;
import com.example.facefit2.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HORISONTAL_LAYOUT = 0;
    private static final int VERTICAL_LAYOUT = 1;

    private List<Product> objectModels = new ArrayList<>();
    private Context context;
    private int layoutType;

    public ProductAdapter(Context context, List<Product> objectModels, int layoutType) {
        this.context = context;
        this.objectModels = objectModels;
        this.layoutType = layoutType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;

        if (layoutType == HORISONTAL_LAYOUT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_h, parent, false);
            viewHolder = new HorisontalViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_v, parent, false);
            viewHolder = new VerticalViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Resources res = context.getResources();
        if(layoutType== HORISONTAL_LAYOUT)
        {
            HorisontalViewHolder hActivityViewHolder = (HorisontalViewHolder)holder;
            String name = objectModels.get(position).getName();

            /*
            String img_preview = objectModels.get(position).getImage();
            if (img_preview!=null) {
                int resID = res.getIdentifier(img_preview, "raw", context.getPackageName());
                hActivityViewHolder.tv_img_preview.setImageResource(resID);
                hActivityViewHolder.tv_img_preview.setVisibility(View.VISIBLE);
            }
            */
            hActivityViewHolder.tv_name.setText(name);
        }
        else {
            VerticalViewHolder vActivityViewHolder = (VerticalViewHolder)holder;
            String name = objectModels.get(position).getName();
            String img_preview = objectModels.get(position).getImage();
             /*
            if (img_preview!=null) {
                int resID = res.getIdentifier(img_preview, "raw", context.getPackageName());
                vActivityViewHolder.tv_img_preview.setImageResource(resID);
                vActivityViewHolder.tv_img_preview.setVisibility(View.VISIBLE);
            }
            */
            vActivityViewHolder.tv_name.setText(name);
        }
    }

    class HorisontalViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private ImageView tv_img_preview;

        public HorisontalViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_img_preview = itemView.findViewById(R.id.iv_image);

            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowmanager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(width/3, RecyclerView.LayoutParams.WRAP_CONTENT));


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = getAdapterPosition();
                    Product item = objectModels.get(id);
                    Intent intent = new Intent(context, ProductActivity.class);
                    intent.putExtra("id", item.get_id());
                    context.startActivity(intent);
                }
            });
        }
    }

    class VerticalViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private ImageView tv_img_preview;

        public VerticalViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_img_preview = itemView.findViewById(R.id.iv_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = getAdapterPosition();
                    Product item = objectModels.get(id);
                    Intent intent = new Intent(context, ProductActivity.class);
                    intent.putExtra("id", item.get_id());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return objectModels.size();
    }
}
