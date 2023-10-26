import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.example.Main.*;
import static org.junit.Assert.assertEquals;

public class MainTests {
    @Test
    public void testSwapLastValue() {
        ArrayList<Integer> c = new ArrayList<>(List.of(-28, 8, 7, 2, -17, 5, 19, 8, 17, 20, -6, -21, -22, -35, 14, -22, -25, -27, -17, -34, 23, -34, 3, -32, 2, -10, -32));
        int min = searchIndexForMinValue(c);
        assertEquals(3, min);
        int firstNegativeNumber = searchFirstNegativeElement(c);
        assertEquals(0, firstNegativeNumber);
        int sum = searchSumOfElements(c);
        assertEquals(462, sum);
    }
}
