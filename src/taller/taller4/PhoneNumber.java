package taller.taller4;

public class PhoneNumber implements Comparable<PhoneNumber> {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        int result = Integer.compare(this.areaCode, o.areaCode);
        if(result != 0) {
            return result;
        }
        result = Integer.compare(this.prefix, o.prefix);
        if(result != 0) {
            return result;
        }
        return Integer.compare(this.lineNumber, o.lineNumber);

    }

    @Override
    public String toString() {
        return "%d-%d-%d".formatted(areaCode, prefix, lineNumber);
    }
}

