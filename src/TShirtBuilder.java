import java.util.List;
import java.util.Objects;

public class TShirtBuilder extends ClothingBuilder{
    private TShirt tShirt = new TShirt();

    @Override
    public TShirtBuilder addMaterial(String material) {
        tShirt.setMaterial(material);
        return this;
    }

    @Override
    public TShirtBuilder addId() {
        tShirt.setId();
        return this;
    }

    @Override
    public TShirtBuilder addName(String name) {
        tShirt.setName(name);
        return this;
    }

    @Override
    public TShirtBuilder addColor(String color) {
        tShirt.setColor(color);
        return this;
    }

    @Override
    public TShirtBuilder addSize(String size) {
        tShirt.setSize(size);
        return this;
    }

    @Override
    public TShirtBuilder addPrice(double price) {
        tShirt.setPrice(price);
        return this;
    }

    @Override
    public TShirt build() {
        return tShirt;
    }

    @Override
    public void buildClothing(List<Object> order) {
        TShirt tShirt;
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        tShirt = tShirtBuilder.addId().build();

        chooseMaterial(tShirt, tShirtBuilder);
        chooseColor(tShirt, tShirtBuilder);
        chooseSize(tShirt, tShirtBuilder);
        confirmItem(tShirt, order);

    }


}
