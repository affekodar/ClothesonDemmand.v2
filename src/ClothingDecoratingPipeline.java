import java.util.ArrayList;

public class ClothingDecoratingPipeline {
    private final ArrayList<ClothingDecoratingCommand> pipeline = new ArrayList<>();

    public void addCommand(ClothingDecoratingCommand command) {
        pipeline.add(command);
    }
    public void execute(Clothing item, ClothingBuilder builder , OrderManager orderManager) {
        for (ClothingDecoratingCommand command : pipeline) {
            command.process(item, builder, orderManager);
        }
    }
}
