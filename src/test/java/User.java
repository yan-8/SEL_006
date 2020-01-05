public class User {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static Builder newEntity() {
        return new User().new Builder();
    }

    public class Builder {
        public Builder() {
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}