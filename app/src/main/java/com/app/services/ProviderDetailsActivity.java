package com.app.services;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.services.Adapters.ReviewAdapter;
import com.app.services.Baseclass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProviderDetailsActivity extends BaseActivity {

    @BindView(R.id.rv_reviews)
    RecyclerView rv_reviews;
    @BindView(R.id.iv_back)
    AppCompatImageView iv_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_details);

        ButterKnife.bind(this);

        rv_reviews.setNestedScrollingEnabled(false);
        rv_reviews.setLayoutManager(new LinearLayoutManager(ProviderDetailsActivity.this));
        rv_reviews.setAdapter(new ReviewAdapter());

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
