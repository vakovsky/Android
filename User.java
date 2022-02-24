package bg.tcom.c12v1gr.demo122applivation;

public class User {
    String userName;
    String eMail;

    public User(String userName, String eMail) {
        this.userName = userName;
        this.eMail = eMail;
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
