package equality;

import java.time.LocalTime;

class CourseSection {
    private final String prefix;
    private final String number;
    private final int enrollment;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public CourseSection(final String prefix, final String number,
                         final int enrollment, final LocalTime startTime, final LocalTime endTime) {
        this.prefix = prefix;
        this.number = number;
        this.enrollment = enrollment;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {                      // check null
            return false;
        }
        if (!(other instanceof CourseSection)) { // check type
            return false;
        }
        CourseSection o = (CourseSection) other;
        if ((o.prefix == null && this.prefix != null) || (o.prefix != null && this.prefix == null)) { return false; }
        if (o.prefix != null && this.prefix != null) {
            if (!(o.prefix == this.prefix)) {
                return false;
            }
        }

        if ((o.number == null && this.number != null) || (o.number != null && this.number == null)) { return false; }
        if (o.number != null && this.number != null) {
            if (!(o.number == this.number)) {
                return false;
            }
        }

        if (!(this.enrollment == o.enrollment)) {       // check enrollment field
            return false;
        }

        if ((o.startTime == null && this.startTime != null) || (o.startTime != null && this.startTime == null)) {  // check startTime field
            return false;
        }
        if (o.startTime != null && this.startTime != null) {
            if(o.startTime.toNanoOfDay()  != this.startTime.toNanoOfDay()) {
                return false;
            }
        }

        if ((o.endTime == null && this.endTime != null) || (o.endTime != null && this.endTime == null)) {   // check endTime field
            return false;
        }
        if(o.endTime != null && this.endTime != null) {
            if(!(o.endTime.toNanoOfDay() == this.endTime.toNanoOfDay())) {
                return false;
            }
        }
        return true;
    }

    @Override public int hashCode() {
        int hashCode = 0;
        for(char ch : this.prefix.toCharArray()) {
            hashCode += Math.pow((int)ch*3, 2);
        }
        for(char ch : this.number.toCharArray()) {
            hashCode += Math.pow((int)ch*2, 3);
        }
        hashCode = hashCode % enrollment;
        hashCode += this.startTime.toNanoOfDay();
        hashCode += this.endTime.toNanoOfDay();
        return hashCode;
    }
}
