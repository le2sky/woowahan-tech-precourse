package lotto.repository;

import lotto.domain.User;

public class UserRepository {

    private static User user;

    public static void save(User user) {
        UserRepository.user = user;
    }

    public static User find() {
        return user;
    }
}
