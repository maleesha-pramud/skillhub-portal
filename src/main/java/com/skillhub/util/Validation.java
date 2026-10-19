package com.skillhub.util;

import java.util.regex.Pattern;

/** Server-side input validation helpers. */
public final class Validation {
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern USERNAME = Pattern.compile("^[A-Za-z0-9._-]{4,20}$");
    private static final Pattern PHONE = Pattern.compile("^[0-9+\\- ]{7,15}$");

    private Validation() { }

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean validEmail(String s) {
        return s != null && s.length() <= 100 && EMAIL.matcher(s).matches();
    }

    public static boolean validUsername(String s) {
        return s != null && USERNAME.matcher(s).matches();
    }

    /** Phone is optional: blank is accepted. */
    public static boolean validPhone(String s) {
        return isBlank(s) || PHONE.matcher(s.trim()).matches();
    }

    /** Returns a message describing the problem, or null if the password is acceptable. */
    public static String passwordProblem(String p) {
        if (p == null || p.length() < 8) {
            return "Password must be at least 8 characters long.";
        }
        boolean letter = false;
        boolean digit = false;
        for (char c : p.toCharArray()) {
            if (Character.isLetter(c)) letter = true;
            if (Character.isDigit(c)) digit = true;
        }
        if (!letter || !digit) {
            return "Password must contain at least one letter and one number.";
        }
        return null;
    }
}
