package test.homework7;

import org.junit.Assert;

class TestBase {
    protected void testToString(Object object, String expectedValue) {
        String actualValue = object.toString();
        Assert.assertEquals(expectedValue, actualValue);
    }
}