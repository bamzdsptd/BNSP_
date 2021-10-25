package com.example.bnsp_.javaClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bnsp_.R;

import java.util.ArrayList;

public class CustomCursorAdapter extends RecyclerView.Adapter<CustomCursorAdapter.ViewHolder>{
    private ArrayList<CourseModal> courseModalArrayList;
    private Context context;

    public CustomCursorAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModal modal = courseModalArrayList.get(position);
        if (modal.getStatus().equalsIgnoreCase("pemasukkan")){
            holder.imageArrow.setImageResource(R.drawable.ic_baseline_arrow_back_24);
            holder.nominal.setText("[ + ] Rp." + modal.getNominal());
        }else {
            holder.imageArrow.setImageResource(R.drawable.ic_baseline_arrow_forward_24);
            holder.nominal.setText("[ - ] Rp." + modal.getNominal());
        }
        holder.keterangan.setText(modal.getKeterangan());
        holder.tanggal.setText(modal.getTanggal());


    }

    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nominal, keterangan, tanggal;
        private ImageView imageArrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nominal = itemView.findViewById(R.id.nominal_row_data);
            keterangan = itemView.findViewById(R.id.deskripsi_row_data);
            tanggal = itemView.findViewById(R.id.tanggal_row_data);
            imageArrow = itemView.findViewById(R.id.imageView_row_data);


        }
    }

}
