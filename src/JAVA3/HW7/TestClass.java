package JAVA3.HW7;

public class TestClass {

    @Test(priority = 6)
    public void test1() {
        System.out.println("Запустили тест1");
    }

    @Test(priority = 5)
    public void test2() {
        System.out.println("Запустили тест2");
    }

    @AfterSuit
    public void test3() {
        System.out.println("Запустили тест3");
    }

    @Test(priority = 8)
    public void test4() {
        System.out.println("Запустили тест4");
    }

    @BeforeSuite
    @Test(priority = 7)
    public void test5() {
        System.out.println("Запустили тест5");
    }

}
