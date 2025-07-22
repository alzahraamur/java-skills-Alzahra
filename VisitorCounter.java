public class VisitorCounter {
    private static int totalVisitors = 0;


    private int sessionVisits;
    private String visitorName;


    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++;
    }


    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }


    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }


    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static void main(String[] args) {

        VisitorCounter visitor1 = new VisitorCounter("Alice");
        VisitorCounter visitor2 = new VisitorCounter("Bob");
        VisitorCounter visitor3 = new VisitorCounter("Charlie");


        visitor1.recordVisit();
        visitor1.recordVisit();

        visitor2.recordVisit();

        visitor3.recordVisit();
        visitor3.recordVisit();
        visitor3.recordVisit();


        VisitorCounter.displayTotalVisitors();


        System.out.println("Total visitors counted: " + VisitorCounter.getTotalVisitors());
    }
}

