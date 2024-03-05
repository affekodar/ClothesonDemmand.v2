public interface ClothingDecoratingCommand {
    Clothing process(Clothing item, ClothingBuilder builder, OrderManager orderManager);
}
