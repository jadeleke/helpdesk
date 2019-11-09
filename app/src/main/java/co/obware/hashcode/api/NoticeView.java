package co.obware.hashcode.api;


import java.util.List;

import co.obware.hashcode.MVP.NoticeType;

public interface NoticeView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<NoticeType> list);
    void onErrorLoading(String message);
}
