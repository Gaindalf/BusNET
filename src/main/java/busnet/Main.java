package busnet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        String name = "123";
        System.out.println(name);
        System.out.println(new BCryptPasswordEncoder().encode(name));
    }
}
