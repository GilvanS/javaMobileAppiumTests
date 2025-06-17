package org.testes.manager;

public class UsuarioManager {

    public static final ThreadLocal<String> firstName = new ThreadLocal<>();
    public static final ThreadLocal<String> lastName = new ThreadLocal<>();
    public static final ThreadLocal<String> phoneNumber = new ThreadLocal<>();
    public static final ThreadLocal<String> email = new ThreadLocal<>();

    public static String getFirstName() {
        return firstName.get();
    }

    public static String getLastName() {
        return lastName.get();
    }

    public static String getPhoneNumber() {
        return phoneNumber.get();
    }

    public static String getEmail() {
        return email.get();
    }


    public static void setFirstName(String value) {
        firstName.set(value);
    }

    public static void setLastName(String value) {
        lastName.set(value);
    }

    public static void setPhoneNumber(String value) {
        phoneNumber.set(value);
    }

    public static void setEmail(String value) {
        email.set(value);
    }


    public static void remove() {
        firstName.remove();
        lastName.remove();
        phoneNumber.remove();
        email.remove();
    }


}
