package eventmanagement.project.itplus.eventmanagement.Model;

/**
 * Created by Dat UET on 1/10/2017.
 */

public class Event {
    private int eventID;
    private int userID;
    private String name;
    private long time;
    private String address;
    private int categoryID;
    private String description;
    private boolean status;
    private boolean kindEvent;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isKindEvent() {
        return kindEvent;
    }

    public void setKindEvent(boolean kindEvent) {
        this.kindEvent = kindEvent;
    }
}