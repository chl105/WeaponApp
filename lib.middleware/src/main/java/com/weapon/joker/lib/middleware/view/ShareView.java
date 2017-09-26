package com.weapon.joker.lib.middleware.view;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.weapon.joker.lib.middleware.R;
import com.weapon.joker.lib.middleware.utils.ShareUtils;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.weapon.joker.lib.middleware.view.ShareView
 *     e-mail : 1012126908@qq.com
 *     time   : 2017/09/25
 *     desc   : 分享 view
 * </pre>
 */

public class ShareView {

    private BottomSheetDialog mDialog;
    private Context mContext;
    private Activity mActivity;
    private ShareUtils mShareUtils;

    private LinearLayout mLlShareQQ;
    private LinearLayout mLlShareZone;
    private LinearLayout mLlShareWechat;
    private LinearLayout mLlShareFriendCircle;
    private LinearLayout mLlShareWeibo;
    private Button mBtCancel;


    public ShareView(Context context) {
        if (!(context instanceof Activity)) {
            throw new RuntimeException("context must is activity!");
        }
        mContext = context;
        mActivity = (Activity) context;
        mShareUtils = ShareUtils.getInstance(mActivity);
        initView(context);
    }

    private void initView(Context context) {
        mDialog = new BottomSheetDialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.view_share, null);
        mLlShareQQ = view.findViewById(R.id.ll_share_qq);
        mLlShareZone = view.findViewById(R.id.ll_share_zone);
        mLlShareWechat = view.findViewById(R.id.ll_share_we_chat);
        mLlShareFriendCircle = view.findViewById(R.id.ll_share_friend_circle);
        mLlShareWeibo = view.findViewById(R.id.ll_share_weibo);
        mBtCancel = view.findViewById(R.id.bt_share_cancel);
        initListener();
        mDialog.setContentView(view);
    }

    /**
     * 初始化 listener
     */
    private void initListener() {
        mLlShareQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShareUtils.shareToQQ();
                mDialog.cancel();
            }
        });
        mLlShareZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShareUtils.shareToQZone();
                mDialog.cancel();
            }
        });
        mLlShareWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "微信", Toast.LENGTH_SHORT).show();
                mDialog.cancel();
            }
        });
        mLlShareFriendCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "朋友圈", Toast.LENGTH_SHORT).show();
                mDialog.cancel();
            }
        });
        mLlShareWeibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "微博", Toast.LENGTH_SHORT).show();
                mDialog.cancel();
            }
        });
        mBtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "取消分享", Toast.LENGTH_SHORT).show();
                mDialog.cancel();
            }
        });
    }

    /**
     * @return BottomSheetDialog 对象
     */
    public BottomSheetDialog getBottomSheetDialog() {
        return mDialog;
    }

    /**
     * 显示 dialog
     */
    public void show() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    /**
     * 设置点击空白处是否可以关闭界面
     * @param cancelable
     */
    public void setCancelable(boolean cancelable) {
        if (mDialog != null) {
            mDialog.setCancelable(cancelable);
        }
    }


}
