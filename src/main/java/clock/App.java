package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("[ERROR]: No arguments provided, type -help for more info.");
            System.exit(1);
        }
        if (args[0].equals("-help") || args[0].equals("-h")) {
            System.out.println(
                    "[INFO]: Useful commands: \n\t-help: for info\n\t-c: display the current time\n\t-t <time>: display a timer. Example -t 0 0 5 means 5 seconds.");
        }
        if (args[0].equals("-c")) {
            displayClock();
        }
        if (args[0].equals("-t")) {
            if (args.length < 4) {
                System.out.println("[ERROR]: No timestamp provided, type -help for more info.");
                System.exit(1);
            }
            if (args.length > 4) {
                System.out.println("[ERROR]: Incorrect arguments provided, type -help for more info.");
                System.exit(1);
            }
            int h = Integer.parseInt(args[1]);
            if (h > 24)
                h = 24;
            int m = Integer.parseInt(args[2]);
            int s = Integer.parseInt(args[3]);
            displayTimer(h, m, s);
        }
        if (args.length > 1) {
            System.out.println("[ERROR]: Incorrect arguments provided, type -help for more info.");
            System.exit(1);
        }
    }

    private static void displayTimer(int h, int m, int s) throws InterruptedException {
        GUI gui = new GUI("Timer");

        int totSec = (h * 60 * 60) + (m * 60) + s;
        String t;

        while (true) {
            totSec--;
            if (totSec <= 0)
                System.exit(0);

            h = totSec / 3600;
            m = totSec / 60 - h * 60;
            s = totSec - h * 3600 - m * 60;

            String hour, min, sec;
            if (h < 10)
                hour = "0" + h;
            else
                hour = "" + h;
            if (m < 10)
                min = "0" + m;
            else
                min = "" + m;
            if (s < 10)
                sec = "0" + s;
            else
                sec = "" + s;

            t = hour + ":" + min + ":" + sec;

            // t = "" + totSec;

            gui.updateLabel(t);
            Thread.sleep(1000);

        }
    }

    private static void displayClock() throws InterruptedException {
        GUI gui = new GUI("Clock");

        SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");

        while (true) {
            String t = date.format(Calendar.getInstance().getTime());
            gui.updateLabel(t);

            Thread.sleep(1000);
        }
    }
}
