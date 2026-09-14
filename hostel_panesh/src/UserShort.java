public class UserShort {

    private String lastName;
    private String initials;
    private String phone;

    public UserShort(User user) {
        this.lastName = user.getLastName();
        this.initials = user.getFirstName().substring(0, 1) + ".";
        this.phone = user.getPhone();
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitials() {
        return initials;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return lastName + " " + initials + ", телефон: " + phone;
    }
}
