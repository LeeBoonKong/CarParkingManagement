package unimyiw.carparkingmanagement2;

/**
 * Created by Lee Boon Kong on 30/11/2017.
 */

public class Mall {

    String firstHour;
    String id;
    String name;
    String perHour;
    String publicHoliday;
    String remainingSpace;
    String totalSpace;

    public Mall() {

    }

    public Mall(String firstHour, String id, String name, String perHour, String publicHoliday, String remainingSpace, String totalSpace) {
        this.firstHour = firstHour;
        this.id = id;
        this.name = name;
        this.perHour = perHour;
        this.publicHoliday = publicHoliday;
        this.remainingSpace = remainingSpace;
        this.totalSpace = totalSpace;
    }

    public String getFirstHour() {
        return firstHour;
    }

    public int getId() {
        return Integer.parseInt(id);
    }

    public String getName() {
        return name;
    }

    public String getPerHour() {
        return perHour;
    }

    public String getPublicHoliday() {
        return publicHoliday;
    }

    public int getRemainingSpace() {
        return Integer.parseInt(remainingSpace);
    }

    public int getTotalSpace() {
        return Integer.parseInt(totalSpace);
    }
}