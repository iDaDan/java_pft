package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.sandboxCDBP.Point;

public class PointTests {

    @Test
    public void testDistance() {
        Point t = new Point(7,4,3,1);
        Assert.assertEquals(t.distance(),5.0);
    }

    @Test
    public void testDistanceMinus() {
        Point e = new Point(0, 1, -4,4);
        Assert.assertEquals(e.distance(),5.0);
    }
}
