package co.obware.hashcode.MVP;

import com.google.gson.annotations.SerializedName;

public class CategoryType {

    @SerializedName("id")
    private String Message;

    @SerializedName("text")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
