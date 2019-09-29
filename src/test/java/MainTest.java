import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void random() throws Exception {
        for (int i = 1; i <= 8; i++) {
            for (int j = 0; j < 50; j++) {
                Random rand = new Random();
                int length = i;
                String s = "";
                while (length > 0) {
                    s += rand.nextInt(10);
                    length--;
                }
                System.out.println(s);
                String.join(",", Main.getPossibleCodes(s));
            }
        }
    }

    @Test
    public void main() throws Exception {
        assertEquals("0,8", String.join(",", Main.getPossibleCodes("0")));
        assertEquals("1,2,4", String.join(",", Main.getPossibleCodes("1")));
        assertEquals("1,2,3,5", String.join(",", Main.getPossibleCodes("2")));
        assertEquals("2,3,6", String.join(",", Main.getPossibleCodes("3")));
        assertEquals("1,4,5,7", String.join(",", Main.getPossibleCodes("4")));
        assertEquals("2,4,5,6,8", String.join(",", Main.getPossibleCodes("5")));
        assertEquals("3,5,6,9", String.join(",", Main.getPossibleCodes("6")));
        assertEquals("4,7,8", String.join(",", Main.getPossibleCodes("7")));
        assertEquals("0,5,7,8,9", String.join(",", Main.getPossibleCodes("8")));
        assertEquals("6,8,9", String.join(",", Main.getPossibleCodes("9")));
        assertEquals("11,12,14,21,22,24,41,42,44", String.join(",", Main.getPossibleCodes("11")));
        assertEquals("13,15,16,19,43,45,46,49,53,55,56,59,73,75,76,79", String.join(",", Main.getPossibleCodes("46")));
    }
}