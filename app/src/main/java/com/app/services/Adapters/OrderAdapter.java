package com.app.services.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.services.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewholder> {

    Context context;

    public OrderAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_order,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        if(position == 0){
            holder.ll_amount.setVisibility(View.GONE);
            holder.tv_assignedname.setText("Waiting for Approval");
            holder.tv_status.setText("Cancel Request");
            holder.tv_status.setTextColor(context.getResources().getColor(R.color.md_red_600));
            /*holder.tv_status.setBackground(context.getResources().getDrawable(R.drawable.buttonred));*/
        }else if(position == 1){
            holder.tv_assignedname.setText("Ajay Kumar");
            holder.ll_amount.setVisibility(View.VISIBLE);
            holder.tv_status.setText("Confirmed");
            holder.tv_call.setVisibility(View.VISIBLE);
            holder.tv_status.setTextColor(context.getResources().getColor(R.color.md_green_600));
            /*holder.tv_status.setBackground(context.getResources().getDrawable(R.drawable.buttongreen));*/
        }else if(position == 2){
            holder.tv_assignedname.setText("Vijay Kumar");
            holder.ll_amount.setVisibility(View.VISIBLE);
            holder.tv_status.setText("Completed");
            holder.tv_call.setVisibility(View.VISIBLE);
            holder.tv_status.setTextColor(context.getResources().getColor(R.color.md_grey_500));
            /*holder.tv_status.setBackground(context.getResources().getDrawable(R.drawable.buttongrey));*/
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class viewholder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_status)
        TextView tv_status;
        @BindView(R.id.tv_assignedname)
        TextView tv_assignedname;
        @BindView(R.id.tv_amount)
        TextView tv_amount;
        @BindView(R.id.tv_call)
        TextView tv_call;
        @BindView(R.id.ll_amount)
        LinearLayout ll_amount;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
