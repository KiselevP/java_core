public class Realise {
    public static void main(String[] args) throws Exception {

        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange1 = new Box<>();

        boxApple1.throwFruitInBox(new Apple());
        boxApple1.throwFruitInBox(new Apple());
        boxApple1.throwFruitInBox(new Apple());

        boxOrange1.throwFruitInBox(new Orange());
        boxOrange1.throwFruitInBox(new Orange());


        boxApple1.transferFruit(boxApple2, 3);




        System.out.println(boxApple1.getCountFruitInBox() + " шт");
        System.out.println(boxApple1.getWeightBox() + "кг");

        System.out.println(boxOrange1.getCountFruitInBox() + " шт");
        System.out.println(boxOrange1.getWeightBox() + "кг");

        System.out.println(boxApple2.compare(boxOrange1));;
    }
}
