package JAVA3.HW7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main.start(TestClass.class);
    }

    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();

        Method beforeSuite = null;
        Method afterSuite = null;
        List<Method> testMethods = new ArrayList<>();

        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuite = m;
                beforeSuiteCount++;
            }
            if (m.isAnnotationPresent(AfterSuit.class)) {
                afterSuite = m;
                afterSuiteCount++;
            }
            if (beforeSuiteCount > 1 || afterSuiteCount > 1)
                throw new RuntimeException("BeforeSuite и AfterSuite должны быть в единственном экземпляре.");

            if (m.isAnnotationPresent(Test.class)) {
                testMethods.add(m);
            }
        }

        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

        try {
            Object test = testClass.newInstance();

            if (beforeSuite != null) {
                System.out.println("Работает BeforeSuite");
                beforeSuite.invoke(test);
            }

            System.out.println("Работает блок тестов Test");
            for (Method m : testMethods) {
                m.invoke(test);
            }

            if (afterSuite != null) {
                System.out.println("Работает AfterSuite");
                afterSuite.invoke(test);
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
