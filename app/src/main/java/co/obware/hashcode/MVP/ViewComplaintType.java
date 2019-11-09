package co.obware.hashcode.MVP;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewComplaintType {

    @Expose
    @SerializedName("id") private int id;

    @Expose
    @SerializedName("header") private String title;

    @Expose
    @SerializedName("details") private String content;

    @Expose
    @SerializedName("number") private String date;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public ViewComplaintType(String tv_header, String tv_details, String tv_number){
        this.title = tv_header;
        this.content =tv_details;
        this.date = tv_number;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

}