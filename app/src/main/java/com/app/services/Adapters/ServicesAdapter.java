package com.app.services.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.services.R;
import com.app.services.ServiceActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.serviceVH> {

    ArrayList<Integer> Servicelist;
    private Context context;
    private LayoutInflater inflater;

    String[] Servicename= {"Recharge", "Service Providers", "Colleges/Schools"};

    public ServicesAdapter(Context context,ArrayList<Integer> list) {
        this.context=context;
        Servicelist =list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public serviceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new serviceVH(inflater.inflate(R.layout.inflater_service,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull serviceVH holder, int position) {

        holder.iv_service.setImageResource(Servicelist.get(position));
        holder.tv_servicename.setText(Servicename[position]);

        holder.rl_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ServiceActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Servicelist.size();
    }

    class serviceVH extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_service)
        AppCompatImageView iv_service;
        @BindView(R.id.tv_servicename)
        AppCompatTextView tv_servicename;
        @BindView(R.id.rl_layout)
        RelativeLayout rl_layout;

        public serviceVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
