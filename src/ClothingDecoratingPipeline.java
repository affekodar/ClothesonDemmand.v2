import java.util.ArrayList;

public class ClothingDecoratingPipeline {
    private final ArrayList<ClothingCommand> pipeline = new ArrayList<>();

    public void addCommand(ClothingCommand command) {
        pipeline.add(command);
    }

    public void execute(Clothing item) {
        Clothing result = item;
        for (ClothingCommand command : pipeline) {
            result = command.process(result);
        }
    }
}
