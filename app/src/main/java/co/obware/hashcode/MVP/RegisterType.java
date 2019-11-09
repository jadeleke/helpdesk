package co.obware.hashcode.MVP;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterType {

    @Expose
    @SerializedName("indexNumber")
    private String index;

    @Expose
    @SerializedName( "api_key" )
    private String apikey;

    @Expose
    @SerializedName("phone")
    private String number;

    @Expose
    @SerializedName("gender")
    private String gender;

    @Expose
    @SerializedName("name")
    private String userName;

    @Expose
    @SerializedName( "message" )
    private String message;

    @Expose
    @SerializedName("status")
    private Boolean status;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("password")
    private String password;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public String getGender() {
        return gender;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
