

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
            String middleName,
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
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email не может быть пустым"
            );
        }

        if (email.length() > 255) {
            throw new IllegalArgumentException(
                    "Email не может содержать более 255 символов"
            );
        }

        if (!email.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        )) {
            throw new IllegalArgumentException(
                    "Некорректный формат email"
            );
        }
    }

    public static void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException(
                    "Пароль не может быть пустым"
            );
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать минимум 8 символов"
            );
        }

        if (password.length() > 255) {
            throw new IllegalArgumentException(
                    "Пароль не может содержать более 255 символов"
            );
        }
    }

    public static void validateLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(
                    "Фамилия не может быть пустой"
            );
        }

        if (lastName.length() > 50) {
            throw new IllegalArgumentException(
                    "Фамилия не может содержать более 50 символов"
            );
        }

        if (!lastName.matches("[\\p{L}-]+")) {
            throw new IllegalArgumentException(
                    "Фамилия может содержать только буквы и дефис"
            );
        }
    }

    public static void validateFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException(
                    "Имя не может быть пустым"
            );
        }

        if (firstName.length() > 50) {
            throw new IllegalArgumentException(
                    "Имя не может содержать более 50 символов"
            );
        }

        if (!firstName.matches("[\\p{L}-]+")) {
            throw new IllegalArgumentException(
                    "Имя может содержать только буквы и дефис"
            );
        }
    }

  
    public static void validatePhone(String phone) {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException(
                    "Телефон не может быть пустым"
            );
        }

        if (!phone.matches("^\\+[0-9]{10,15}$")) {
            throw new IllegalArgumentException(
                    "Телефон должен быть в международном формате, например +447911123456"
            );
        }
    }
}