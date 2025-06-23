package ru.netolgy.repository;

import org.springframework.stereotype.Repository;
import ru.netolgy.domain.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    // Тестовые пользователи (в реальном приложении заменить на БД)
    private final Map<String, User> users = Map.of(
            "admin", new User("admin", "admin123", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)),
            "user", new User("user", "userPass", List.of(Authorities.READ, Authorities.WRITE))
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        User foundUser = users.get(user.toLowerCase());
        if (foundUser != null && foundUser.getPassword().equals(password)) {
            return foundUser.getAuthorities();
        }
        return Collections.emptyList(); // Пустой список при несовпадении
    }

    // Вспомогательный класс для хранения данных пользователя
    private static class User {
        private final String login;
        private final String password;
        private final List<Authorities> authorities;

        public User(String login, String password, List<Authorities> authorities) {
            this.login = login;
            this.password = password;
            this.authorities = authorities;
        }

        public String getPassword() {
            return password;
        }

        public List<Authorities> getAuthorities() {
            return authorities;
        }
    }
}
