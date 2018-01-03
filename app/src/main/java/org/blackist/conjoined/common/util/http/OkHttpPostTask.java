package org.blackist.conjoined.common.util.http;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * TODO
 *
 * @author LiangLiang.Dong <1075512174@qq.com>.
 * @Date 2018/1/3 9:57.
 */
public class OkHttpPostTask extends AsyncTask<String, Void, String> {

    private boolean mHasHeader = false;
    private OnTaskEndListener mOnTaskEndListener;

    public OkHttpPostTask setHeader(boolean hasHeader) {
        mHasHeader = hasHeader;
        return this;
    }

    public OkHttpPostTask setOnTaskEndListener(OnTaskEndListener onTaskEndListener) {
        this.mOnTaskEndListener = onTaskEndListener;
        return this;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            if (params[0] != null && params[1] != null) {
                final String response = mHasHeader
                        ? OkHttpHelper.postPlainWithHeader(params)
                        : OkHttpHelper.postPlain(params);
                // call on task end listener.
                if (mOnTaskEndListener != null) {
                    mOnTaskEndListener.onTaskEnd(response);
                }
                return response;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * OnTaskEndListener.
     */
    public interface OnTaskEndListener {

        /**
         * called on task is completed.
         */
        void onTaskEnd(final String response);
    }
}
