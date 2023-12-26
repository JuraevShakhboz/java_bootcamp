package dars_49;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println("Ismi: "+name+"\nYoshi: "+age);
    }
}
