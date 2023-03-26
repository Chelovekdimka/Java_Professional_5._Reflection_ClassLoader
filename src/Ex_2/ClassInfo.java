//Напишіть програму, яка виводитиме всю інформацію про клас, користувач сам вибирає, який саме клас цікавить.

package Ex_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) {
        try {
            // отримати назву класу від користувача
            System.out.print("Введіть назву класу: ");
            Scanner scanner = new Scanner(System.in);
            String className = scanner.next();

            // отримати об'єкт Class для заданої назви класу
            Class<?> cls = Class.forName(className);

            // вивести назву класу
            System.out.println("Назва класу: " + cls.getName());

            // вивести інформацію про конструктори
            System.out.println("Конструктори:");
            Constructor<?>[] constructors = cls.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.toString());
            }

            // вивести інформацію про поля
            System.out.println("Поля:");
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                System.out.println(field.toString());
            }

            // вивести інформацію про методи
            System.out.println("Методи:");
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e);
        }
    }
}