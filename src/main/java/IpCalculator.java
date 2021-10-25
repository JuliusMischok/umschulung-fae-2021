import java.util.ArrayList;
import java.util.List;

public class IpCalculator {

    public static void main(String[] args) {

        String inputIp = "192.168.2.1";
        String inputSnm = "255.255.0.0";

        IpAddress myIpAddress = new IpAddress(192, 168, 2, 1);
        System.out.println("IP: " + myIpAddress.toString());
        System.out.println("IP (bin): " + myIpAddress.toBinaryString());

        IpAddress mySubnetMask = new IpAddress(255, 255, 0, 0);
        System.out.println("SNM: " + mySubnetMask.toString());
        System.out.println("SNM (bin): " + mySubnetMask.toBinaryString());

        System.out.println("SNM(1): " + mySubnetMask.getFirst());
        System.out.println("SNM(2): " + mySubnetMask.getSecond());
        System.out.println("SNM(3): " + mySubnetMask.getThird());
        System.out.println("SNM(4): " + mySubnetMask.getFourth());


        List<Integer> parsedValues = List.of(212, 13, 2, 1);
        IpAddress userInput = new IpAddress(parsedValues);
        System.out.println("Input: " + userInput.toString());
        System.out.println("Input: " + userInput.toBinaryString());
        userInput.setSecond(15);
        System.out.println("Input: " + userInput.toString());
        System.out.println("Input: " + userInput.toBinaryString());

    }
}
