public class Main {

        public static void main(String[] args) {

            System.out.println(inWords(12345));
            System.out.println(inWords(10203040));
            System.out.println(inWords(150));
        }


        public static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        public static final String[] teen = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        public static final String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        public static String inWords(long s) {
            if (s == 0) return "zero";
            else return numberInWords(s);
        }

        public static String numberInWords(long s) {
            if (s < 10) {
                return units[(int) s];
            } else if (s < 20) {
                return teen[(int) (s % 10)];
            } else if (s < 100) {
                return tens[(int) (s / 10)] + " " + units[(int) (s % 10)];
            } else if (s < 1000) {
                return units[(int) (s / 100)] + " hundred and " + numberInWords(s % 100);
            } else if (s < 10000) {
                return units[(int) (s / 1000)] + " thousand " + numberInWords(s % 1000);
            } else if (s < 100000) {
                return numberInWords(s / 1000) + " thousand " + numberInWords(s % 1000);
            } else if (s < 10000000) {
                return numberInWords(s / 100000) + " lakh " + numberInWords(s % 100000);
            } else if (s < 1000000000) {
                return numberInWords(s / 10000000) + " crore " + numberInWords(s % 10000000);
            } else if (s < 10000000000L) {
                return numberInWords(s / 1000000000) + " billion " + numberInWords(s % 1000000000);
            } else {
                System.out.println("Entered number is greater than 10000000000");
            }
            return "";
        }


}