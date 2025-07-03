import java.security.SecureRandom;

public class GeneratorPassword {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:',.<>?/|\"";
    private static final String DIGITS = "0123456789";
    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + SPECIAL_CHARS + DIGITS ;
    private static SecureRandom random = new SecureRandom();

    public static String generatePassword(int length) {
        if (length < 1)
        {
            throw new IllegalArgumentException("Укажите длину пароля (больше 0-я).");
        }
        StringBuilder password = new StringBuilder(length);

        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));

        for (int i = 4; i < length; i++)
        {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        return shuffleString(password.toString());
    }
    private static String shuffleString(String input) {
        char[] array = input.toCharArray();
        for (int i = array.length - 1; i > 0; i--)
        {
            int j = random.nextInt(i + 1);

            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return new String(array);
    }
    public static void main(String[] args)
    {
        int passwordLength = 111;
        String password = generatePassword(passwordLength);
        System.out.println("Сгенерированный пароль: " + password);
    }
}
