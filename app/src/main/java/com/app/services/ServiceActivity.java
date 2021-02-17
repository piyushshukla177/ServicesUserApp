package com.app.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.services.Baseclass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceActivity extends BaseActivity {


    @BindView(R.id.rv_subcategories)
    RecyclerView rv_subcategories;
    @BindView(R.id.rv_providerslist)
    RecyclerView rv_providerslist;


    private String[] titles = {"E-Book", "Presentations", "Case discussions", "Videos/Animations","Knowledge Links"};
    private int[] icons = {R.drawable.ic__college};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);

        rv_subcategories.setLayoutManager(new LinearLayoutManager(ServiceActivity.this));
        rv_subcategories.setAdapter(new CategoryAdapter());

        rv_providerslist.setLayoutManager(new LinearLayoutManager(ServiceActivity.this));
        rv_providerslist.setAdapter(new providers());
    }

    class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryvh>{

        @NonNull
        @Override
        public categoryvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new categoryvh(LayoutInflater.from(ServiceActivity.this).inflate(R.layout.inflater_subcategory,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull categoryvh holder, int position) {

            holder.rl_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.rl_layout.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
                }
            });

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class categoryvh extends RecyclerView.ViewHolder{

            @BindView(R.id.rl_layout)
            RelativeLayout rl_layout;

            public categoryvh(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }


    class providers extends RecyclerView.Adapter<providers.Vh>{


        @NonNull
        @Override
        public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Vh(LayoutInflater.from(ServiceActivity.this).inflate(R.layout.inflater_serviceperson,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull Vh holder, int position) {

            holder.ll_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(ServiceActivity.this,ProviderDetailsActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class Vh extends RecyclerView.ViewHolder{

            @BindView(R.id.ll_layout)
            LinearLayout ll_layout;

            public Vh(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}
