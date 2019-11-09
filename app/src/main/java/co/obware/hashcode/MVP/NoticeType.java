package co.obware.hashcode.MVP;

public class NoticeType {
    private int id;
    private String title;
    private String content;
    private int image;
    private String date;
    private String number;


    public NoticeType(int image, String tv_header, String tv_details, String tv_number) {
        this.title = tv_header;
        this.content = tv_details;
        this.date = tv_number;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}