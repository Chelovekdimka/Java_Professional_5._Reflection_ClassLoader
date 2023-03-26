package Ex_3;//Створіть клас, в ньому визначте 3 поля,
//        до цих полів створіть конструктори та методи.
//        Використовуючи рефлексію отримайте всю інформацію про поля, методи, конструктори, а також модифікатори доступу.

import java.lang.reflect.*;
import java.util.Arrays;

public class ExampleClass {
    private int number;
    public String text;
    protected boolean flag;

    public ExampleClass() {
        number = 0;
        text = "";
        flag = false;
    }

    public ExampleClass(int number, String text, boolean flag) {
        this.number = number;
        this.text = text;
        this.flag = flag;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        Class<?> cls = ExampleClass.class;

        // отримати інформацію про поля
        System.out.println("Fields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\tName: " + field.getName());
            System.out.println("\tType: " + field.getType());
            System.out.println("\tModifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println();
        }

        // отримати інформацію про конструктори
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("\tName: " + constructor.getName());
            System.out.println("\tParameter types: " + Arrays.toString(constructor.getParameterTypes()));
            System.out.println("\tModifiers: " + Modifier.toString(constructor.getModifiers()));
            System.out.println();
        }

        // вивести інформацію про методи
        System.out.println("\nMethods:");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("\tName: " + method.getName());
            System.out.println("\tReturn Type: " + method.getReturnType());
            Class<?> ParamTypes[] = method.getParameterTypes();
            for (Class<?> paramType:
            ParamTypes) {
                System.out.println("\tParameter types: " + paramType.getName());
            }
//            System.out.println("\tParameter types: " + method.getParameterTypes().toString());
            System.out.println("\tModifier(s): " + method.getModifiers());

            System.out.println();
        }
    }
}
