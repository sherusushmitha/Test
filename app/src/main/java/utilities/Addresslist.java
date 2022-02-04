package utilities;

import java.io.Serializable;

public class Addresslist implements Serializable {
    private String address,city,district,email,id,landmark,mobile,
            modeoftransport,name,pincode,transportname,user_id;

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getLandmark()  {
        return landmark;
    }

    public String getMobile() {
        return mobile;
    }

    public String getModeoftransport() {
        return modeoftransport;
    }

    public String getName() {
        return name;
    }

    public String getPincode() {
        return pincode;
    }

    public String getTransportname() {
        return transportname;
    }

    public String getUser_id() {
        return user_id;
    }
}
