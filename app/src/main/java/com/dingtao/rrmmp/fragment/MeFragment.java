package com.dingtao.rrmmp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dingtao.rrmmp.R;
import com.dingtao.rrmmp.activity.LoginActivity;
import com.dingtao.rrmmp.activity.SetActivity;
import com.dingtao.rrmmp.adapter.CircleAdpater;
import com.dingtao.rrmmp.bean.Circle;
import com.dingtao.rrmmp.bean.Result;
import com.dingtao.rrmmp.bean.UserInfo;
import com.dingtao.rrmmp.core.DataCall;
import com.dingtao.rrmmp.core.WDFragment;
import com.dingtao.rrmmp.core.db.DaoMaster;
import com.dingtao.rrmmp.core.db.UserInfoDao;
import com.dingtao.rrmmp.core.exception.ApiException;
import com.dingtao.rrmmp.presenter.CirclePresenter;
import com.dingtao.rrmmp.util.recyclerview.SpacingItemDecoration;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author dingtao
 * @date 2019/1/2 10:28
 * qq:1940870847
 */
public class MeFragment extends WDFragment {

    @BindView(R.id.me_bg)
    SimpleDraweeView mMeBg;
    @BindView(R.id.me_avatar)
    SimpleDraweeView mMeAvatar;
    @BindView(R.id.me_nickname)
    TextView mMeName;
    @BindView(R.id.me_info)
    RelativeLayout mMeInfo;
    @BindView(R.id.me_circle)
    RelativeLayout mMeCircle;
    @BindView(R.id.me_foot)
    RelativeLayout mMeFoot;
    @BindView(R.id.me_wallet)
    RelativeLayout mMeWallet;
    @BindView(R.id.me_address)
    RelativeLayout mMeAddress;

    private CircleAdpater mCircleAdapter;

    CirclePresenter circlePresenter;

    @Override
    public String getPageName() {
        return "我的Fragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_me;
    }

    @Override
    protected void initView() {
        mMeBg.setImageURI(Uri.parse(LOGIN_USER.getHeadPic()));
        mMeAvatar.setImageURI(Uri.parse(LOGIN_USER.getHeadPic()));
        mMeName.setText(LOGIN_USER.getNickName());
    }

    @OnClick(R.id.logout_btn)
    public void logout(){
        UserInfoDao userInfoDao = DaoMaster.newDevSession(getActivity(),UserInfoDao.TABLENAME).getUserInfoDao();
        userInfoDao.delete(LOGIN_USER);//删除用户
        startActivity(new Intent(getActivity(),LoginActivity.class));//跳转登录页
        getActivity().finish();//本页面关闭
    }

    @OnClick(R.id.me_setting)
    public void setting(){
        startActivity(new Intent(getActivity(),SetActivity.class));
    }

}
