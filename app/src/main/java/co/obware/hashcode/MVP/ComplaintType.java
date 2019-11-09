package co.obware.hashcode.MVP;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComplaintType {
    @Expose
    @SerializedName("description")
    private String Complaint;

    @Expose
    @SerializedName("cat_id")
    private String id;

    @Expose
    @SerializedName("indexNumber")
    private String index;

    @Expose
    @SerializedName("success")
    private Boolean success;

    public void setIndex(String index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess(){
        return success;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String complaint) {
        Complaint = complaint;
    }

}
