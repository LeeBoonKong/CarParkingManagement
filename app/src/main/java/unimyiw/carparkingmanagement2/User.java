package unimyiw.carparkingmanagement2;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Lee Boon Kong on 6/12/2017.
 */

@IgnoreExtraProperties
public class User {

    public String credit;
    public String name;
    public String phoneNo;
    public String uid;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String credit, String name, String phoneNo, String uid) {
        this.name = name;
        this.credit = credit;
        this.phoneNo = phoneNo;
        this.uid = uid;
    }

    public String getCredit() {
        return credit;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getUid() { return  uid;}
}
