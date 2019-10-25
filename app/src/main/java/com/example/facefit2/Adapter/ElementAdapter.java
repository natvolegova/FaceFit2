package com.example.facefit2.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facefit2.Objects.Element;
import com.example.facefit2.R;

import java.util.ArrayList;
import java.util.List;

public class ElementAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Element> objectModels = new ArrayList<>();
    private Context context;

    public ElementAdapter(Context context, List<Element> objectModels) {
        this.context = context;
        this.objectModels = objectModels;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_item, parent, false);
        viewHolder = new ElementAdapter.ElementViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Resources res = context.getResources();
        ElementViewHolder postActivityViewHolder = (ElementViewHolder) holder;
        String name = objectModels.get(position).getName();
        postActivityViewHolder.tv_name.setText(name);

       // String image = objectModels.get(position).getImage();
      //  postActivityViewHolder.tv_image.setText(image);

        String time = objectModels.get(position).getTimeFormatting();
        postActivityViewHolder.tv_time.setText(time);

    }
    class ElementViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_image;
        private TextView tv_time;

        public ElementViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_image = itemView.findViewById(R.id.tv_image);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }

    @Override
    public int getItemCount() {
        return objectModels.size();
    }
}
