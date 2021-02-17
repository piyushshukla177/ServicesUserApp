package com.app.services.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.services.Baseclass.BaseFragment;
import com.app.services.MyAdapter;
import com.app.services.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostFragment extends BaseFragment {

    @BindView(R.id.rv_services)
    RecyclerView rv_services;
    @BindView(R.id.et_servicenote)
    AppCompatEditText et_servicenote;
    @BindView(R.id.bt_submit)
    AppCompatButton bt_submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        rv_services.setNestedScrollingEnabled(false);
        rv_services.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_services.setAdapter(new Adapter());
    }

    class Adapter extends RecyclerView.Adapter<Adapter.VH>{

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new VH(LayoutInflater.from(getActivity()).inflate(R.layout.inflater_post,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }

        class VH extends RecyclerView.ViewHolder{

            public VH(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}
