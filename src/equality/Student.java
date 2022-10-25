package equality;

import java.util.List;
import java.util.Objects;
import java.util.Objects.*;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   @Override public boolean equals(Object other) {
      if(other == null) { return false; }
      if(this.getClass() != other.getClass()) { return false; }
      Student o = (Student)other;
      if(!(Objects.equals(this.surname,o.surname))) { return false; }
      if(!(Objects.equals(this.givenName,o.givenName))) { return false; }
      if(!(this.age == o.age)) { return false; }
      if(!(Objects.equals(this.currentCourses, o.currentCourses))) { return false; }
      return true;
   }

   @Override public int hashCode() {
      return Objects.hash(surname, givenName, age, currentCourses);
   }

}
