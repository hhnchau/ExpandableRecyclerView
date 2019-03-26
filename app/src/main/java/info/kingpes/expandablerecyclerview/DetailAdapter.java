package info.kingpes.expandablerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {
    private List<DetailModel> lists;

    public DetailAdapter(List<DetailModel> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.txt.setText(lists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt;

        MyViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.name);
        }
    }
}
