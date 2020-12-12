package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 2:42 上午
 */

public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("Slip");
            String slip = ts.getSlip();
            System.out.println(ts);
            System.out.println(slip);
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
