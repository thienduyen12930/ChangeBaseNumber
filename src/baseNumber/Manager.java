package baseNumber;
import baseNumber.Menu;


public class Manager extends Menu<String>{

    public static final char[] hexDigits = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    
    static String[] menu = {" Convert From Binary.", " Convert From Decimal.", " Convert From Hexa.", " Exit"};

    public Manager() {
        super("===========Menu===========", menu);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String binary = Validate.checkInputBinary();
                convertFromBinary(binary);
                break;
            case 2:
                String decimal = Validate.checkInputDecimal();
                convertFromDecimal(decimal);
                break;
            case 3:
                String hexa = Validate.checkInputHexaDecimal();
                convertFromHexa(hexa);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;

        }
    }
    
    public static int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = Validate.checkInputIntLimit(1, 2);
        return result;
    }

    public static void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: "
                        + convertBinaryToDecimal(binary)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertBinaryToHexa(binary));
                break;
        }
    }

    public static void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertDecimalToBinary(decimal)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertDecimalToHexa(decimal));
                break;
        }
    }

    public static void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertHexaToBinary(hexa)
                );
                break;
            case 2:
                System.out.println("Decimal: "
                        + convertHexaToDecimal(hexa));
                break;
        }
    }
    public static String convertBinaryToDecimal(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.toString(decimal);
    }
    public static String convertBinaryToHexa(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }
    public static int convertHexaToDecimal(String hexadecimal) {
        int decimal = Integer.parseInt(hexadecimal, 16);
        return decimal;
    }

    public static String convertHexaToBinary(String hexadecimal) {
        String binary = Integer.toBinaryString(convertHexaToDecimal(hexadecimal));
        return binary;
    }
    public static String convertDecimalToBinary(String decimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        return binary;
    }
    public static String convertDecimalToHexa(String decimal) {
        String hexa = "";
        int deci = Integer.parseInt(decimal);
        while (deci != 0) {
            hexa = hexDigits[deci % 16] + hexa;
            deci /= 16;
        }
        return hexa;
    }

}