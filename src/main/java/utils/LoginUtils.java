package utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginUtils {
    public static void loginCristianMoga(Robot robot) {

        for (int i = 0; i < 2; i++) {
            waitTime(3000);

            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);

            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);

            robot.keyPress(KeyEvent.VK_I);
            robot.keyRelease(KeyEvent.VK_I);

            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);

            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);

            robot.keyPress(KeyEvent.VK_I);
            robot.keyRelease(KeyEvent.VK_I);

            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);

            robot.keyPress(KeyEvent.VK_N);
            robot.keyRelease(KeyEvent.VK_N);

            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyRelease(KeyEvent.VK_PERIOD);

            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);

            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);

            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);

            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_SHIFT);

            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);

            robot.keyRelease(KeyEvent.VK_SHIFT);

            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);

            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);

            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);

            robot.keyPress(KeyEvent.VK_N);
            robot.keyRelease(KeyEvent.VK_N);

            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);

            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);

            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);

            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);

            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);

            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_3);

            robot.keyPress(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_0);

            robot.keyPress(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_0);

            robot.keyPress(KeyEvent.VK_9);
            robot.keyRelease(KeyEvent.VK_9);

            robot.keyPress(KeyEvent.VK_SHIFT);

            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);

            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);

            robot.keyRelease(KeyEvent.VK_SHIFT);

            waitTime(1000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    private static void waitTime(int milies) {
        try {
            Thread.sleep(milies);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
