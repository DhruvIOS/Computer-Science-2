public class Time {
    private int hrs;
    private int mins;
    private int secs;


    public Time() {
        this.hrs = 0;
        this.mins = 0;
        this.secs = 0;
    }


    public Time(int hrs, int mins, int secs) {
        this.hrs = hrs >= 0 && hrs < 24 ? hrs : 0;
        this.mins = mins >= 0 && mins < 60 ? mins : 0;
        this.secs = secs >= 0 && secs < 60 ? secs : 0;
    }


    public void set(int hrs, int mins, int secs) {
        this.hrs = hrs >= 0 && hrs < 24 ? hrs : 0;
        this.mins = mins >= 0 && mins < 60 ? mins : 0;
        this.secs = secs >= 0 && secs < 60 ? secs : 0;
    }

    public void printMilitary() {
        System.out.printf("%02d:%02d:%02d", hrs, mins, secs);
    }

    
    public void printStandard() {
        String ampm = hrs < 12 ? "AM" : "PM";
        int stdHrs = hrs > 12 ? hrs - 12 : hrs;
        System.out.printf("%02d:%02d:%02d %s", stdHrs, mins, secs, ampm);
    }



    public int getHrs() {
        return hrs;
    }

    public int getMins() {
        return mins;
    }

    public int getSecs() {
        return secs;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hrs, mins, secs);
    }

    
    public boolean equals(Time other) {
        return this.hrs == other.hrs && this.mins == other.mins && this.secs == other.secs;
    }

    
    public void copy(Time other) {
        this.hrs = other.hrs;
        this.mins = other.mins;
        this.secs = other.secs;
    }

   
    public Time getCopy() {
        return new Time(this.hrs, this.mins, this.secs);
    }


    public void advanceSecs() {
        secs++;
        if (secs >= 60) {
            secs = 0;
            mins++;
            if (mins >= 60) {
                mins = 0;
                hrs++;
                if (hrs >= 24) {
                    hrs = 0;
                }
            }
        }
    }

    
    public boolean lessThan(Time other) {
        if (this.hrs < other.hrs) {
            return true;
        } else if (this.hrs == other.hrs) {
            if (this.mins < other.mins) {
                return true;
            } else if (this.mins == other.mins) {
                return this.secs < other.secs;
            }
        }
        return false;
    }



public boolean notEquals(Time other) {
    return !this.equals(other);
}


public boolean lessOrEquals(Time other) {
    return this.lessThan(other) || this.equals(other);
}


public boolean greaterThan(Time other) {
    return !this.lessOrEquals(other);
}


public boolean greaterOrEquals(Time other) {
    return !this.lessThan(other);
}


public String toMilitary() {
    return String.format("%02d:%02d:%02d", hrs, mins, secs);
}


public String toStandard() {
    String ampm = hrs < 12 ? "AM" : "PM";
    int stdHrs = hrs > 12 ? hrs - 12 : (hrs == 0 ? 12 : hrs);  // Adjusting for midnight and noon cases
    return String.format("%02d:%02d:%02d %s", stdHrs, mins, secs, ampm);
}

public void advanceSec() {
    secs++;
    if (secs >= 60) {
        secs = 0;
        advanceMins();
    }
}

public void advanceMins() {
    mins++;
    if (mins >= 60) {
        mins = 0;
        advanceHrs();
    }
}

public void advanceHrs() {
    hrs++;
    if (hrs >= 24) {
        hrs = 0;
    }
}
}



