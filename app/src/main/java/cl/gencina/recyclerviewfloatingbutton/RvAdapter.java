package cl.gencina.recyclerviewfloatingbutton;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.gencina.recyclerviewfloatingbutton.databinding.ItemBinding;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private List<String> data;

    public void setInfo(List<String> data){
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind( data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ItemBinding binding;

        public MyViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String info){
            binding.tvNombre.setText(info);
        }

    }


}
