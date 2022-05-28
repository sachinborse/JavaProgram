import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Win {
    void getWindow(LocalTime eta, Double preETA, Double postETA, Double roundOff) {
        int d = eta.getMinute();
        int min;
        if (d == 0) {
            d = 60;
        } else if (d < roundOff) {
            d += 60;
        }
        double div = d / roundOff;
        if (div - Math.floor(d / roundOff) <= 0.50)
            min = (int) Math.floor(div);
        else
            min = (int) Math.ceil(div);
        min *= roundOff;

        LocalTime startEDW = eta.minusMinutes(d);
        LocalTime endEDW = eta.minusMinutes(d);

        startEDW = startEDW.plusMinutes((long) (min - preETA));
        endEDW = endEDW.plusMinutes((long) (min + postETA));

        System.out.println("ETA: " + eta + "\nPreETA: " + preETA + "\nPostETA: " + postETA + "\nRoundOff: " + roundOff);
        System.out.println("StartEDW: " + startEDW + "\nEndEDW: " + endEDW);
    }
}

public class S2 {
    public static void main(String[] args) {
        Win w = new Win();
        LocalTime t = LocalTime.parse("23:09:22", DateTimeFormatter.ISO_TIME);
        w.getWindow(t, 1.0, 1.0, 45.0);
    }
}