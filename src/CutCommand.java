import java.util.Scanner;

public class CutCommand implements ClothingCommand {
    Scanner scanner = new Scanner(System.in);
    private final static String lengthPrompt = """
            Choose Length

            1. 100
            2. 120
            3. 140

            Enter choice:\s""";
    private final static String waistlinePrompt = """
            Choose Waistline

            1. 80 cm
            2. 100 cm
            3. 120 cm

            Enter choice:\s""";
    private final static String neckPrompt = """
            Choose Neck

            1. 30 cm
            2. 40 cm
            3. 50 cm\s

            Enter choice:\s""";

    @Override
    public Clothing process(Clothing item) {
        if (item instanceof Pants) {
            chooseLength((Pants) item);
        } else if (item instanceof Skirt) {
            chooseWaistline((Skirt) item);
        } else if (item instanceof TShirt) {
            chooseNeck((TShirt) item);
        }

        return item;
    }

    private void chooseNeck(TShirt tShirt) {
        System.out.println(neckPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> tShirt.setNeck(30);
            case 2 -> tShirt.setNeck(40);
            case 3 -> tShirt.setNeck(50);
        }
    }

    private void chooseWaistline(Skirt skirt) {
        System.out.println(waistlinePrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> skirt.setWaistline(80);
            case 2 -> skirt.setWaistline(100);
            case 3 -> skirt.setWaistline(120);
        }
    }

    private void chooseLength(Pants pants) {
        System.out.println(lengthPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> pants.setLength(100);
            case 2 -> pants.setLength(120);
            case 3 -> pants.setLength(140);
        }
    }

}
