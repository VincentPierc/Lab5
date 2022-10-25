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
        if ((o.prefix == null && this.prefix != null) || (o.prefix != null && this.prefix == null)) { // check prefix field
            return false;
        }
        if (this.prefix != null && o.prefix != null) {
            if (this.prefix.length() != o.prefix.length()) {
                return false;
            }
            for (int i = 0; i < this.prefix.length(); i++) {
                if (this.prefix.charAt(i) != o.prefix.charAt(i)) {
                    return false;
                }
            }
        }

        if ((o.number == null && this.number != null) || (o.number != null && this.number == null)) {   // check number field
            return false;
        }
        if (this.number != null && o.number != null) {
            if (this.number.length() != o.number.length()) {
                return false;
            }
            for (int i = 0; i < this.number.length(); i++) {
                if (this.number.charAt(i) != o.number.charAt(i)) {
                    return false;
                }
            }
        }
        if (!(this.enrollment == o.enrollment)) {       // check enrollment field
            return false;
        }

        if ((o.startTime == null && this.startTime != null) || (o.startTime != null && this.startTime == null)) {  // check startTime field
            return false;
        }
        if (o.startTime == null && this.startTime == null) {        //TODO replace equals
            if (!(o.startTime.equals(this.startTime))) {
                return false;
            }
        }
        if ((o.endTime == null && this.endTime != null) || (o.endTime != null && this.endTime == null)) {   // check endTime field
            return false;
        }
        if(o.endTime == null && this.endTime == null) {
            if (!(o.endTime.equals(this.endTime))) {                //TODO replace equals
                return false;
            }
        }
        return true;
    }

    @Override public int hashCode() {
    }
}
