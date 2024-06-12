package app;
public class facts {

    private int fNumber;

    // LGA 2016 Name
    private String bFacts;

    private String sFacts;

    
    public facts(int fNumber, String bFacts, String sFacts) {
        this.fNumber = fNumber;
        this.bFacts = bFacts;
        this.sFacts = sFacts;
    }

    public int getfNumber() {
        return fNumber;
    }

    public String getBFacts() {
        return bFacts;
    }

    public String getSFacts() {
        return sFacts;
    }
}
