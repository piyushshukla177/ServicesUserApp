package com.app.services.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.services.Adapters.OrderAdapter;
import com.app.services.Baseclass.BaseFragment;
import com.app.services.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderFragment extends BaseFragment {

    @BindView(R.id.rv_orders)
    RecyclerView rv_orders;

    OrderAdapter orderAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        rv_orders.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_orders.setAdapter(new OrderAdapter(getActivity()));
    }
}
