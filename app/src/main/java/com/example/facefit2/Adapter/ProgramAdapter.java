package com.example.facefit2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facefit2.Activities.ProgramActivity;
import com.example.facefit2.R;

import com.example.facefit2.Objects.ProgramFullInfo;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProgramFullInfo> objectModels = new ArrayList<>();
    private Context context;

    public ProgramAdapter(Context context, List<ProgramFullInfo> objectModels) {
        this.context = context;
        this.objectModels = objectModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item, parent, false);
        viewHolder = new ProgramViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Resources res = context.getResources();
        ProgramViewHolder postActivityViewHolder = (ProgramViewHolder) holder;
        String name = objectModels.get(position).getName();
        postActivityViewHolder.tv_name.setText(name);

        String image = objectModels.get(position).getImage();
        postActivityViewHolder.tv_image.setText(image);

        String time = objectModels.get(position).getTimeFormatting();
        postActivityViewHolder.tv_time.setText(time);

        String countOfElements = objectModels.get(position).getElementAddition(context);
        postActivityViewHolder.tv_countOfElements.setText(countOfElements);
    }

    class ProgramViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_image;
        private TextView tv_time;
        private TextView tv_countOfElements;

        public ProgramViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_image = itemView.findViewById(R.id.tv_image);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_countOfElements = itemView.findViewById(R.id.tv_countOfElements);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = getAdapterPosition();
                    ProgramFullInfo item = objectModels.get(id);
                     Intent intent = new Intent(context, ProgramActivity.class);
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
