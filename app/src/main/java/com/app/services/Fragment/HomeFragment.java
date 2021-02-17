package com.app.services.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.app.services.Adapters.ServicesAdapter;
import com.app.services.Baseclass.BaseFragment;
import com.app.services.MyAdapter;
import com.app.services.R;
import com.app.services.TimerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment{

    @BindView(R.id.rv_images)
    RecyclerView rv_images;
    @BindView(R.id.rv_services)
    RecyclerView rv_services;
    @BindView(R.id.rv_banner2)
    RecyclerView rv_banner2;

    @BindView(R.id.pager)
    ViewPager viewpager;

    private static int currentPage = 0;

    private static final Integer[] Photos = { R.drawable.slide,R.drawable.slide,R.drawable.slide,R.drawable.slide};
    private static final Integer[] service = { R.drawable.ic_transport, R.drawable.ic__service, R.drawable.ic__college};

    private ArrayList<Integer> ImageArray = new ArrayList<Integer>();
    private ArrayList<Integer> ImageServices = new ArrayList<Integer>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        /*viewpager = (ViewPager) view.findViewById(R.id.pager);*/
        init();
    }

    private void init() {

        for (int i = 0; i < Photos.length; i++)
            ImageArray.add(Photos[i]);

       /* viewpager.setAdapter(new TimerAdapter(getActivity(), ImageArray));

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == Photos.length) {
                    currentPage = 0;
                }
                viewpager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);*/



        
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rv_images.setLayoutManager(linearLayoutManager);
        rv_images.setAdapter(new MyAdapter(getActivity(),ImageArray));

        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);
        rv_banner2.setLayoutManager(linearLayoutManager2);
        rv_banner2.setAdapter(new MyAdapter(getActivity(),ImageArray));

        for (int i = 0; i < service.length; i++)
            ImageServices.add(service[i]);

        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),4);
        rv_services.setLayoutManager(layoutManager);
        rv_services.setAdapter(new ServicesAdapter(getActivity(),ImageServices));

        /*// Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == Photos.length) {
                    currentPage = 0;
                }
                rv_images.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);*/
    }
}
