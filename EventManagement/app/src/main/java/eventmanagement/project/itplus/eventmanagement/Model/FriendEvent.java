package eventmanagement.project.itplus.eventmanagement.Model;

/**
 * Created by Dat UET on 1/10/2017.
 */

public class FriendEvent {
    private int userID;
    private int eventID;
    private long joinTime;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(long joinTime) {
        this.joinTime = joinTime;
    }
}
