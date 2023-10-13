package com.perso.rest.ws.restfulws.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
       users.add(new User(1,"Adam","abcde", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Eve","cdefh"));
        users.add(new User(3,"Abel"));
    }

    public List <User> findAll(){
        return users;
    }

    //public User save(User user) {

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User saveUser(User user) {
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
