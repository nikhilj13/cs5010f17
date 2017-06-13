// Constructor template for UTC2:
//     new UTC2 (h, m)
// Interpretation:
//     h is the UTC hour (between 0 and 23, inclusive)
//     m is the UTC minute (between 0 and 59, inclusive)
// Representation:
//     Internally, the hour is represented in Eastern Standard Time,
//     which is five hours behind UTC.

class UTC2 extends UTC0 implements UTC {

    int h;    // the hour in EST, limited to [0,23]
    int m;    // the minute, limited to [0,59]

    // the Java constructor

    UTC2 (int h, int m) {
        super ();    // calls the constructor for UTC0
        this.h = (h >= 5) ? (h - 5) : h + 19;
    }

    // public methods

    // Returns the hour, between 0 and 23 inclusive.

    public int hour () {
        if (h < 19)
            return h + 5;
        else
            return h - 19;
    }

    // Returns the minute, between 0 and 59 inclusive.

    public int minute () { return m; }

    // The isEqual, equals, hashCode, and toString
    // methods are inherited from UTC0.

    // a main method for unit testing

    public static void main (String[] args) {
        UTC2tests.main(args);
    }
}

// Unit tests for UTC2.

class UTC2tests {

    public static void main (String[] args) {
        UTC t1 = new UTC2 (15, 31);
        UTC t2 = new UTC2 (14, 31);
        UTC t3 = new UTC2 (15, 32);
        UTC t4 = new UTC2 (15, 31);

        assert t1.hour() == 15 : "wrong hour for t1";
        assert t1.minute() == 31 : "wrong minute for t1";

        assert t1.isEqual (t1) : "isEqual says this doesn't equal this";
        assert t1.isEqual (t4) : "isEqual says this doesn't equal that";
        assert ! (t1.isEqual (t2)) : "isEqual true but hour different";
        assert ! (t1.isEqual (t3)) : "isEqual true but minute different";

        System.out.println ("All unit tests of UTC2 passed.");
    }
}