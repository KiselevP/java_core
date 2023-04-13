import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruitList = new ArrayList<>();

    public void throwFruitInBox(T fruit) {
        fruitList.add(fruit);
    }

    public void transferFruit(Box<T> box, int a) throws Exception {
        if (fruitList.size() < a) {
            throw new Exception("Недостаточно фруктов для перемещения");
        }
        for (int i = 0; i < a; i++) {
            box.throwFruitInBox(fruitList.get(0));
            fruitList.remove(0);
        }
    }

    public int getCountFruitInBox() {
        return fruitList.size();
    }

    public double getWeightBox() {
        double result = 0;
        for (int i = 0; i < fruitList.size(); i++) {
            result += fruitList.get(i).getWeight();
        }
        return result;
    }

    public boolean compare(Box<?> box) {
        return this.getWeightBox() == box.getWeightBox();
    }

}
