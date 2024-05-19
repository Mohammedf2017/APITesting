package testData;

import org.testng.annotations.DataProvider;

public class APITestsdata {

    @DataProvider(name = "DataForPost")
    public Object[][] data_for_post() {

        return new Object[][]{
                {"Graham", 1},
                {"Nikola", 2},
                {"Paul", 3},
                {"Tim", 4},
                {"Max", 5},
                {"Paul", 6},
                {"Nancy", 7},
                {"Palos", 8},
                {"Brex", 9}
        };
    }

    @DataProvider(name = "DataForDelete")
    public Object[] data_for_delete() {
        return new Object[]{
          4,5,6
        };

    }
}
