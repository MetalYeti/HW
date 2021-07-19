package JAVA2.HW1;

public enum DayOfWeek {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private int order;

    DayOfWeek(int order) {
        this.order =  order;
    }

    public int getWorkingHours() {
        return (6 - order) * 8;
    }
}
