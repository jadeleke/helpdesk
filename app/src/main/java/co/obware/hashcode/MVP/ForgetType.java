package co.obware.hashcode.MVP;

public class ForgetType {

    private String Email;
    private String success;
    private String message;

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return Email;
    }

    public String getSuccess() {
        return success;
    }
}
