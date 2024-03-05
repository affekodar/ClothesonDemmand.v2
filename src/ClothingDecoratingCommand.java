public interface ClothingDecoratingCommand {
    void process(Clothing item, ClothingBuilder builder, OrderManager orderManager);
}
