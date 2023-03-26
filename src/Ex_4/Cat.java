//Створіть 2 класи, Animal та Cat. У класі Animal ініціалізуйте 3 поля різних модифікаторів.
//        У класі Cat використовуючи рефлексію, отримайте доступ до полів класу Animal та змініть вміст кожного з полів.

package Ex_4;
import java.lang.reflect.Field;

public class Cat extends Animal {
    public Cat(String name, int age, boolean isAlive) {
        super(name, age, isAlive);
    }

    public void changeAnimalFields(String name, int age, boolean isAlive) {
        try {
            Field nameField = Animal.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(this, "Boris");

            Field ageField = Animal.class.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(this, 8);

            Field isAliveField = Animal.class.getDeclaredField("isAlive");
            isAliveField.setAccessible(true);
            isAliveField.set(this, false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
