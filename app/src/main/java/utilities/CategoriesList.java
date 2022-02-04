package utilities;

import java.io.Serializable;

public class CategoriesList implements Serializable {
    private String type,status,name,id,category_image;

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCategory_image() {
        return category_image;
    }
}
