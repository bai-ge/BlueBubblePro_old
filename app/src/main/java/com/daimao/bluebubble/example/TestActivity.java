package com.daimao.bluebubble.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.router.Router;

/**
 * Created by baige on 2018/6/18.
 */

public class TestActivity extends XActivity implements View.OnClickListener{

    @BindView(com.daimao.bluebubble.R.id.btn_sgv)
    Button mBtnSgv;

    @BindView(com.daimao.bluebubble.R.id.btn_sgv_fragment)
    Button mBtnSgvFragment;

    @BindView(com.daimao.bluebubble.R.id.btn_sgv_empty_view)
    Button mBtnEmptyView;

    @BindView(com.daimao.bluebubble.R.id.btn_listview)
    Button mBtnListView;

    @Override
    public void initData(Bundle savedInstanceState) {
        mBtnSgv.setOnClickListener(this);
        mBtnSgvFragment.setOnClickListener(this);
        mBtnEmptyView.setOnClickListener(this);
        mBtnListView.setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return com.daimao.bluebubble.R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case com.daimao.bluebubble.R.id.btn_sgv:
                Router.newIntent(TestActivity.this).to(StaggeredGridActivity.class).launch();
                break;
            case com.daimao.bluebubble.R.id.btn_sgv_fragment:
                Router.newIntent(TestActivity.this).to(StaggeredGridActivityFragment.class).launch();
                break;
            case com.daimao.bluebubble.R.id.btn_sgv_empty_view:
                Router.newIntent(TestActivity.this).to(StaggeredGridEmptyViewActivity.class).launch();
                break;
            case com.daimao.bluebubble.R.id.btn_listview:
                Router.newIntent(TestActivity.this).to(ListViewActivity.class).launch();
                break;
        }
    }
}
