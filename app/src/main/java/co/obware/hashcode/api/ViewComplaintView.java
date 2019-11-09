package co.obware.hashcode.api;


import java.util.List;

import co.obware.hashcode.MVP.NoticeType;
import co.obware.hashcode.MVP.ViewComplaintType;

public interface ViewComplaintView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<ViewComplaintType> list);
    void onErrorLoading(String message);
}
