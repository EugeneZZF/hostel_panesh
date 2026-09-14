import java.util.Objects;

public class User extends UserShort {

    private long id;
    private String email;
    private String password;

    public User(long id, String email, String password,
                String lastName, String firstName, String phone) {
        super(lastName, firstName, phone);
        setId(id);
        setEmail(email);
        setPassword(password);
    }

    // Format: id;email;password;lastName;firstName;phone
    public User(String userData) {
        this(split(userData));
    }

    private User(String[] data) {
        this(Long.parseLong(data[0]), data[1], data[2], data[3], data[4], data[5]);
    }

    private static String[] split(String userData) {
        String[] data = userData.split(";", -1);
        if (data.length != 6) {
            throw new IllegalArgumentException("Six values are required");
        }
        return data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateRequiredString(email, "email", 255);
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        validateRequiredString(password, "password", 255);
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must have 8 characters");
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", email='" + email + "', password='" + password
                + "', lastName='" + lastName + "', firstName='" + firstName
                + "', phone='" + phone + "'}";
    }

    public String toShortString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User)) return false;
        User user = (User) object;
        return id == user.id && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, lastName, firstName, phone);
    }
}
