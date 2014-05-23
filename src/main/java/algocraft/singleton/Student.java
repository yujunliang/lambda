package algocraft.singleton;

import algocraft.cache.TwoKeySelfPopulatingCache;
import com.google.common.base.Objects;

import java.util.Collection;

import static algocraft.cache.TwoKeySelfPopulatingCache.create;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Student {
    private final static TwoKeySelfPopulatingCache<String, String, Student> STUDENTS = create(Student::new);

    public final String firstName;
    public final String lastName;

    private Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println(toString() + "Created.");
    }

    public static Student valueOf(String firstName, String lastName) {
        return STUDENTS.valueOf(firstName, lastName);
    }

    public static Collection<Student> values() {
        return STUDENTS.values();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName);
    }

    @Override
    public boolean equals(Object that) {
        return reflectionEquals(this, that);
    }

}
