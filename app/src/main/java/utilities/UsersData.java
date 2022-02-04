package utilities;

import java.io.Serializable;

public class UsersData implements Serializable {
    private String address,approvalstatus,email,fertilizer_licence_document,gst_document,id,
            identity,is_verified,mobile,money,name,pesticide_licence_document,preferred_transport,
            profile_pic,registered_on,registration_document,seed_licence_document,shop_name,status,Token,
            typemasterinfo,wallet;

    public String getAddress() {
        return address;
    }

    public String getApprovalstatus() {
        return approvalstatus;
    }

    public String getEmail() {
        return email;
    }

    public String getFertilizer_licence_document() {
        return fertilizer_licence_document;
    }

    public String getGst_document() {
        return gst_document;
    }

    public String getId() {
        return id;
    }

    public String getIdentity() {
        return identity;
    }

    public String getIs_verified() {
        return is_verified;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getPesticide_licence_document() {
        return pesticide_licence_document;
    }

    public String getPreferred_transport() {
        return preferred_transport;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public String getRegistered_on() {
        return registered_on;
    }

    public String getRegistration_document() {
        return registration_document;
    }

    public String getSeed_licence_document() {
        return seed_licence_document;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return Token;
    }

    public String getTypemasterinfo() {
        return typemasterinfo;
    }

    public String getWallet() {
        return wallet;
    }
}
