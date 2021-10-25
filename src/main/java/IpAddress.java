import java.util.List;

public class IpAddress {
    private int first;
    private int second;
    private int third;
    private int fourth;

    public IpAddress(int first, int second, int third, int fourth) {
        setFirst(first);
        setSecond(second);
        setThird(third);
        setFourth(fourth);
    }

    public IpAddress(List<Integer> parsedValues) {
        if (parsedValues == null) {
            throw new IllegalArgumentException("null not permitted");
        }
        if (parsedValues.size() != 4) {
            throw new IllegalArgumentException("exactly 4 elements expected");
        }

        this.setFirst(parsedValues.get(0));
        this.setSecond(parsedValues.get(1));
        this.setThird(parsedValues.get(2));
        this.setFourth(parsedValues.get(3));
    }

    public void setFirst(int paramFirst) {
        if (paramFirst < 0 || paramFirst > 255) {
            throw new IllegalArgumentException("component 'first' out of bounds");
        }

        this.first = paramFirst;
    }

    public void setSecond(int paramSecond) {
        System.out.println("attempting to set " + paramSecond + " as second ip component");

        if (paramSecond < 0 || paramSecond > 255) {
            throw new IllegalArgumentException("component 'second' out of bounds");
        } else {
            this.second = paramSecond;
        }
    }

    public void setThird(int third) {
        if (third < 0 || third > 255) {
            throw new IllegalArgumentException("component 'third' out of bounds");
        }

        this.third = third;
    }

    public void setFourth(int fourth) {
        if (fourth < 0 || fourth > 255) {
            throw new IllegalArgumentException("component 'fourth' out of bounds");
        }

        this.fourth = fourth;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return this.third;
    }

    public int getFourth() {
        return fourth;
    }

    public void validate() {
        if (this.first < 0 || this.first > 255) {
            throw new IllegalArgumentException();
        }
        if (this.second < 0 || this.second > 255) {
            throw new IllegalArgumentException("component 'second' out of bounds");
        }
        if (this.third < 0 || this.third > 255) {
            throw new IllegalArgumentException();
        }
        if (this.fourth < 0 || this.fourth > 255) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.first + "." + this.second + "." + this.third + "." + this.fourth;
    }

    public String toBinaryString() {
        String result = ipComponentToBinaryByte(this.first);
        result += ipComponentToBinaryByte(this.second);
        result += ipComponentToBinaryByte(this.third);
        result += ipComponentToBinaryByte(this.fourth);

        return result;
    }

    private String ipComponentToBinaryByte(int component) {
        String componentBin = Integer.toBinaryString(component);

        while (componentBin.length() < 8) {
            componentBin = "0" + componentBin;
        }

        return componentBin;
    }
}
