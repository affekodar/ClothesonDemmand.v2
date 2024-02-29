import java.util.ArrayList;

public class ClothingDecoratingPipeline {
    private ArrayList<ClothingDecoratingCommand> pipeline = new ArrayList<>();

    public void addCommand(ClothingDecoratingCommand command) {
        pipeline.add(command);
    }
    public Clothing execute(Clothing item, ClothingBuilder builder ,OrderManager orderManager) {
        Clothing result = item;
        for (ClothingDecoratingCommand command : pipeline) {
            result = command.process(result, builder, orderManager);
        }
        return result;
    }
}
