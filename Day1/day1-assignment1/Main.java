public class Main {
    public static void printCalendar(int month, int year) {

        if(!isValidDate(month,year)){
            System.out.println("Invalid input. Please provide a valid month and year.");
            System.exit(0);
        }

        int daysInMonth = getDaysInMonth(month, year);
        int firstDayOfWeek = getFirstDayOfWeek(month, year);

        System.out.println("Su Mo Tu We Th Fr Sa");

        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i == 0 && j < firstDayOfWeek) || day > daysInMonth) {
                    System.out.print("   ");
                } else {
                    System.out.printf("%2d ", day);
                    day++;
                }
            }
            System.out.println();
        }
    }
    private static boolean isValidDate(int month,int year){
        return month >= 1 && month <= 12 && year >= 0;
    }
    private static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year) && month == 2) {
            return 29;
        }
        return daysInMonth[month];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int getFirstDayOfWeek(int month, int year) {

        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int day = 0;

        return (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
    }


    public static void main(String[] args) {
        printCalendar(1, 2023);

    }


}