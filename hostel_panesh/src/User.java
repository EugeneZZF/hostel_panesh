
public class User {

    private long id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String phone;

    public User(
            long id,
            String email,
            String password,
            String lastName,
            String firstName,
            String phone
    ) {
        validateId(id);
        validateEmail(email);
        validatePassword(password);
        validateLastName(lastName);
        validateFirstName(firstName);
        validatePhone(phone);

        this.id = id;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        validateId(id);
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public static void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID должен быть больше 0"
            );
        }
    }

    public static void validateEmail(String email) {
        validateRequiredString(email, "Email", 255);

        if (!email.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        )) {
            throw new IllegalArgumentException(
                    "Некорректный формат email"
            );
        }
    }

    public static void validatePassword(String password) {
        validateRequiredString(password, "Пароль", 255);

        if (password.length() < 8) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать минимум 8 символов"
            );
        }
    }

    public static void validateLastName(String lastName) {
        validateName(lastName, "Фамилия");
    }

    public static void validateFirstName(String firstName) {
        validateName(firstName, "Имя");
    }

    public static void validatePhone(String phone) {
        validateRequiredString(phone, "Телефон", 20);

        if (!phone.matches("^\\+[0-9]{10,15}$")) {
            throw new IllegalArgumentException(
                    "Телефон должен быть в международном формате, например +447911123456"
            );
        }
    }

    private static void validateName(String name, String fieldName) {
        validateRequiredString(name, fieldName, 50);

        if (!name.matches("[\\p{L}-]+")) {
            throw new IllegalArgumentException(
                    fieldName + " может содержать только буквы и дефис"
            );
        }
    }

    private static void validateRequiredString(
            String value,
            String fieldName,
            int maxLength
    ) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    fieldName + " не может быть пустым"
            );
        }

        if (value.length() > maxLength) {
            throw new IllegalArgumentException(
                    fieldName + " не может содержать более "
                            + maxLength
                            + " символов"
            );
        }
    }
}