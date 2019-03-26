package info.kingpes.expandablerecyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpandableAdapter extends RecyclerView.Adapter<ExpandableAdapter.MyViewHolder> {
    private List<HeaderModel> lists;
    private List<Integer> expand = new ArrayList<>();
    private Context context;

    public ExpandableAdapter(Context context, List<HeaderModel> lists) {
        this.lists = lists;
        this.context = context;

        for (int i = 0; i < lists.size(); i++) {
            expand.add(0);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.categoryTitle.setText(lists.get(position).getTitle());


        holder.rc.setLayoutManager(new LinearLayoutManager(context));

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (expand.get(holder.getAdapterPosition()) % 2 == 0) {
                    holder.rc.setVisibility(View.VISIBLE);
                } else {
                    holder.rc.setVisibility(View.GONE);
                }
                expand.set(holder.getAdapterPosition(), expand.get(holder.getAdapterPosition()) + 1);
            }
        });

        List<DetailModel> l = lists.get(holder.getAdapterPosition()).getItems();
        DetailAdapter adapter = new DetailAdapter(l);
        holder.rc.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private TextView categoryTitle;
        private RecyclerView rc;

        MyViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            rc = itemView.findViewById(R.id.innerRecyclerView);

        }
    }
}
