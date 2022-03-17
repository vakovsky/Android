package bg.tcom.c12v1gr.demo122applivation;

public class User {
    String userName;
    String eMail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    public User(String userName, String eMail, String id) {
        this.userName = userName;
        this.eMail = eMail;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
