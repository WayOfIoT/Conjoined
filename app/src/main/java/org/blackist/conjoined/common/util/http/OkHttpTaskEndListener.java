package org.blackist.conjoined.common.util.http;

/**
 * TODO
 *
 * @author LiangLiang.Dong <1075512174@qq.com>.
 * @Date 2018/1/3 11:11.
 */
public interface OkHttpTaskEndListener {

    /**
     * called on task is completed.
     */
    void onTaskEnd(final String response);
}
