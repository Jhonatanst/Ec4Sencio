package com.jhonatan.hunnids.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jhonatan.hunnids.databinding.ItemShowResumeBinding;
import com.jhonatan.hunnids.model.Movie;
import com.jhonatan.hunnids.model.Series;
import com.jhonatan.hunnids.model.Shows;

import java.util.List;


import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;


public class RVResumeAdapter  extends RecyclerView.Adapter<RVResumeAdapter.ResumeVH> {
    private List<Shows> showModels;

    public RVResumeAdapter(List<Shows> showModels) {
        this.showModels = showModels;
    }

    @NonNull
    @Override
    public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemShowResumeBinding binding = ItemShowResumeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ResumeVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeVH holder, int position) {
        holder.bind(showModels.get(position));
    }

    @Override
    public int getItemCount(){
        return showModels.size();
    }

    class ResumeVH extends RecyclerView.ViewHolder{

        private ItemShowResumeBinding binding;
        public ResumeVH(ItemShowResumeBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(Shows shows) {
            if(shows instanceof Movie){
                binding.txtSeason.setVisibility(View.GONE);

            }else if(shows instanceof Series){
                binding.txtSeason.setVisibility(View.VISIBLE);
                binding.txtSeason.setText("Season" + ((Series) shows).getSeason());
            }
            binding.txtName.setText(shows.getName());

            ImageLoader imageLoader= Coil.imageLoader(binding.getRoot().getContext());
            ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                    .data(shows.getImgUrl())
                    .crossfade(true)
                    .target(binding.imgShow)
                    .build();
            imageLoader.enqueue(request);

        }
    }
}
