/**
 * Created by yrpant on 12/15/15.
 */
public class AssertionClass {

    public static void test(int observedValue, int expectedValue)
    {


        assert observedValue==expectedValue : "Assertion Fails. The observed value: "+observedValue+" does not match expected value";

        System.out.println("Assertion Pass");
    }
}
