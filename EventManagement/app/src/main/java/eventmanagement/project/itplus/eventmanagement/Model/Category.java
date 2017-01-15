package eventmanagement.project.itplus.eventmanagement.Model;

/**
 * Created by Dat UET on 1/10/2017.
 */

public class Category {
    private int categoryID;
    private String name;
    private String image;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
