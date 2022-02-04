package utilities;

import java.io.Serializable;

public class subcategories implements Serializable {
    private String category,id,name,status,typemasterid;

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getTypemasterid() {
        return typemasterid;
    }
}
