package quoters;

/**
 * Created by Jeka on 14/10/2015.
 */
public class Person {
    private String name;
    private String family;

    public Person(String имя, String фамилия) {
        this.name = имя;
        this.family = фамилия;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", family='").append(family).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
