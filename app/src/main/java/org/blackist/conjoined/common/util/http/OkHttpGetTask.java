package org.blackist.conjoined.common.util.http;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * TODO
 *
 * @author LiangLiang.Dong <1075512174@qq.com>.
 * @Date 2018/1/3 11:07.
 */
public class OkHttpGetTask extends AsyncTask<String, Void, String> {

    private boolean mHasHeader = false;
    private OkHttpTaskEndListener mOnTaskEndListener;

    public OkHttpGetTask setHeader(boolean hasHeader) {
        mHasHeader = hasHeader;
        return this;
    }

    public OkHttpGetTask setOnTaskEndListener(OkHttpTaskEndListener onTaskEndListener) {
        this.mOnTaskEndListener = onTaskEndListener;
        return this;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            if (params[0] == null)
                return null;
            String result = mHasHeader
                    ? OkHttpHelper.getWithHeader(params)
                    : OkHttpHelper.get(params[0]);
            if (mOnTaskEndListener != null) {
                mOnTaskEndListener.onTaskEnd(result);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
