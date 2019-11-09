package co.obware.hashcode.MVP;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginType {

    @Expose
    @SerializedName("indexNumber")
    private String index;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("api_key")
    private String key;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("gender")
    private String gender;

    @Expose
    @SerializedName("status")
    private String success;

    @Expose
    @SerializedName("phone")
    private String phone;

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

