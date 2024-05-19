import org.testng.annotations.Test;

public class TestNGTest1 {
    @Test(priority =3)
    void setup(){
        System.out.println("Program in setup");
    }
    @Test(priority =2)
    void testSteps(){
        System.out.println("Program in testSteps");
    }
    @Test(priority = 1)
    void tearDown(){
        System.out.println("Program in tearDown");
    }
}
