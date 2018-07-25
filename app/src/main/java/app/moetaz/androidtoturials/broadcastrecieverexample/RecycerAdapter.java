package app.moetaz.androidtoturials.broadcastrecieverexample;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.moetaz.androidtoturials.R;

public class RecycerAdapter extends RecyclerView.Adapter<RecycerAdapter.MyviewHolder> {
    private ArrayList<IncomingNumber> arrayList = new ArrayList<>();


    public RecycerAdapter(ArrayList<IncomingNumber> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        holder.id.setText(Integer.toString(arrayList.get(position).getId()));
        holder.number.setText(arrayList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView id ,number;
        public MyviewHolder(View itemView) {
            super(itemView);
            id =itemView.findViewById(R.id.textid);
            number =itemView.findViewById(R.id.textNumber);
        }
    }
}
