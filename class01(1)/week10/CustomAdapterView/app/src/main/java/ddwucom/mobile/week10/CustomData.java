package ddwucom.mobile.week10;

public class CustomData {

    private long _id;
    private String dong;
    private String sigu;
    private String weather;

    public CustomData(long _id, String dong, String sigu, String weather) {
        this._id = _id;
        this.dong = dong;
        this.sigu = sigu;
        this.weather = weather;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getSigu() {
        return sigu;
    }

    public void setSigu(String sigu) {
        this.sigu = sigu;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
