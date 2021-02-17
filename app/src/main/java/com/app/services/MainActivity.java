package com.app.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.app.services.Baseclass.BaseActivity;
import com.app.services.Fragment.CreditFragment;
import com.app.services.Fragment.HomeFragment;
import com.app.services.Fragment.OrderFragment;
import com.app.services.Fragment.PostFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class MainActivity extends BaseActivity implements View.OnClickListener{


    @BindView(R.id.ll_home)
    LinearLayout ll_home;
    @BindView(R.id.tv_home)
    AppCompatTextView tv_home;
    @BindView(R.id.iv_home)
    AppCompatImageView iv_home;

    @BindView(R.id.ll_order)
    LinearLayout ll_order;
    @BindView(R.id.tv_order)
    AppCompatTextView tv_order;
    @BindView(R.id.iv_order)
    AppCompatImageView iv_order;

    @BindView(R.id.ll_credit)
    LinearLayout ll_credit;
    @BindView(R.id.tv_credit)
    AppCompatTextView tv_credit;
    @BindView(R.id.iv_credit)
    AppCompatImageView iv_credit;

    @BindView(R.id.ll_post)
    LinearLayout ll_post;
    @BindView(R.id.tv_post)
    AppCompatTextView tv_post;
    @BindView(R.id.iv_post)
    AppCompatImageView iv_post;

    String currentfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ll_home.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_credit.setOnClickListener(this);
        ll_post.setOnClickListener(this);

        color(0);
        loadFragment(new HomeFragment(), "HomeFragment");
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();

        if (currentfragment.equalsIgnoreCase("HomeFragment")) {
            super.onBackPressed();
        } else {
            color(0);
            loadFragment(new HomeFragment(), "HomeFragment");
        }
    }

    @Override
    public void onClick(View v) {

        if(v==ll_home){

            loadFragment(new HomeFragment(), "HomeFragment");
            color(0);

        }else if(v==ll_order){

            loadFragment(new OrderFragment(), "Fragment");
            color(1);

        }else if(v==ll_credit){

            loadFragment(new CreditFragment(), "Fragment");
            color(2);
        }else if(v==ll_post){

            loadFragment(new PostFragment(), "Fragment");
            color(3);
        }
    }

    public void loadFragment(Fragment fragment, String name) {
        // load fragment

        currentfragment = name;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        // 1. Know how many fragments there are in the stack
        final int count = getFragmentManager().getBackStackEntryCount();
        // 2. If the fragment is **not** "home type", save it to the stack
        if (name.equalsIgnoreCase("HomeFragment")) {
            transaction.addToBackStack(name);
        }
        // Commit !
        transaction.commit();

        getFragmentManager().addOnBackStackChangedListener(new android.app.FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getFragmentManager().getBackStackEntryCount() <= count) {
                    // pop all the fragment and remove the listener
                    getFragmentManager().popBackStack("Fragment", POP_BACK_STACK_INCLUSIVE);
                    getFragmentManager().removeOnBackStackChangedListener(this);
                }
            }
        });
    }

    public void color(int i){

        if(i==0){

            ll_home.setClickable(false);
            ll_order.setClickable(true);
            ll_credit.setClickable(true);
            ll_post.setClickable(true);

            iv_home.setColorFilter(ContextCompat.getColor(this, R.color.md_indigo_900), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_home.setTextColor(getResources().getColor(R.color.md_indigo_900));
            iv_order.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_order.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_credit.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_credit.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_post.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_post.setTextColor(getResources().getColor(R.color.md_grey_500));
        }else if(i==1){

            ll_home.setClickable(true);
            ll_order.setClickable(false);
            ll_credit.setClickable(true);
            ll_post.setClickable(true);

            iv_home.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_home.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_order.setColorFilter(ContextCompat.getColor(this, R.color.md_indigo_900), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_order.setTextColor(getResources().getColor(R.color.md_indigo_900));
            iv_credit.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_credit.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_post.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_post.setTextColor(getResources().getColor(R.color.md_grey_500));
        }else if(i==2){

            ll_home.setClickable(true);
            ll_order.setClickable(true);
            ll_credit.setClickable(false);
            ll_post.setClickable(true);

            iv_home.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_home.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_order.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_order.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_credit.setColorFilter(ContextCompat.getColor(this, R.color.md_indigo_900), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_credit.setTextColor(getResources().getColor(R.color.md_indigo_900));
            iv_post.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_post.setTextColor(getResources().getColor(R.color.md_grey_500));
        }else if(i ==3){

            ll_home.setClickable(true);
            ll_order.setClickable(true);
            ll_credit.setClickable(true);
            ll_post.setClickable(false);

            iv_home.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_home.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_order.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_order.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_credit.setColorFilter(ContextCompat.getColor(this, R.color.md_grey_500), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_credit.setTextColor(getResources().getColor(R.color.md_grey_500));
            iv_post.setColorFilter(ContextCompat.getColor(this, R.color.md_indigo_900), android.graphics.PorterDuff.Mode.SRC_IN);
            tv_post.setTextColor(getResources().getColor(R.color.md_indigo_900));
        }

    }
}