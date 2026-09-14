public class UserShort {

    protected String lastName;
    protected String firstName;
    protected String phone;

    public UserShort(String lastName, String firstName, String phone) {
        setLastName(lastName);
        setFirstName(firstName);
        setPhone(phone);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getInitials() {
        return firstName.substring(0, 1) + ".";
    }

    public String getPhone() {
        return phone;
    }

    public void setLastName(String lastName) {
        validateName(lastName);
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName);
        this.firstName = firstName;
    }

    public void setPhone(String phone) {
        validateRequiredString(phone, "Phone", 20);
        if (!phone.matches("^\\+[0-9]{10,15}$")) {
            throw new IllegalArgumentException("Invalid phone");
        }
        this.phone = phone;
    }

    protected static void validateRequiredString(String value, String fieldName, int maxLength) {
        if (value == null || value.isBlank() || value.length() > maxLength) {
            throw new IllegalArgumentException("Invalid " + fieldName);
        }
    }

    private static void validateName(String name) {
        validateRequiredString(name, "name", 50);
        if (!name.matches("[\\p{L}-]+")) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    @Override
    public String toString() {
        return lastName + " " + getInitials() + ", phone: " + phone;
    }
}
