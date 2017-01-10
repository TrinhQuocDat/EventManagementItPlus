package eventmanagement.project.itplus.eventmanagement.Model;

/**
 * Created by Dat UET on 1/10/2017.
 */

public class Like {
    private int likeID;
    private int eventID;
    private int userID;

    public int getLikeID() {
        return likeID;
    }

    public void setLikeID(int likeID) {
        this.likeID = likeID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
