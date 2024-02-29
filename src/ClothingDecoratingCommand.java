public interface ClothingDecoratingCommand {
    public Clothing process(Clothing item, ClothingBuilder builder, OrderManager orderManager);
}
