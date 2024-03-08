import java.util.Scanner;

public class SewCommand implements ClothingCommand {
    Scanner scanner = new Scanner(System.in);

    private final static String fitPrompt = """
            Choose Fit

            1. Tight
            2. Standard
            3. Loose

            Enter choice:\s""";
    private final static String sleevesPrompt = """
            Choose Sleeves

            1. 20 cm
            2. 30 cm
            3. 40 cm

            Enter choice:\s""";
    private final static String patternPrompt = """
            Choose Pattern

            1. Short
            2. Standard
            3. Long

            Enter choice:\s""";

    @Override
    public Clothing process(Clothing item) {
        if (item instanceof Pants) {
            chooseFit((Pants) item);
        } else if (item instanceof Skirt) {
            choosePattern((Skirt) item);
        } else if (item instanceof TShirt) {
            chooseSleeves((TShirt) item);
        }

        return item;
    }

    private void chooseFit(Pants pants) {
        System.out.println(fitPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> pants.setFit("Tight");
            case 2 -> pants.setFit("Standard");
            case 3 -> pants.setFit("Loose");
        }
    }

    private void chooseSleeves(TShirt tShirt) {
        System.out.println(sleevesPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> tShirt.setSleeves(20);
            case 2 -> tShirt.setSleeves(30);
            case 3 -> tShirt.setSleeves(40);
        }
    }

    private void choosePattern(Skirt skirt) {
        System.out.println(patternPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> skirt.setPattern("Short");
            case 2 -> skirt.setPattern("Standard");
            case 3 -> skirt.setPattern("Long");
        }
    }
}
