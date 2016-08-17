package pronab.broadcast;

/**
 * Created by Mobile App Develop on 17-8-16.
 */
public class CallLog {
    String number;
    int count;
    public CallLog(String number, int count) {
        this.number = number;
        this.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
