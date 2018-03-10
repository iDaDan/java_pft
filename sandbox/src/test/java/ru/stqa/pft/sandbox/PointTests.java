package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.sandboxCDBP.Point;

public class PointTests {

    @Test
    public void testDistance() {
        Point t = new Point(7,4,3,1);
        Point e = new Point(-3)
        assert t.distance() == 5;
        Assert.assertEquals(t.distance(),5.0);
    }
}
