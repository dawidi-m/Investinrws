package com.perso.rest.ws.restfulws.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class User {
    private Integer id;

    @Size(min=2,max = 15,message = "Username must be more than 2 and less than 15 characters")
    private String username;
    private String image;

    @Past(message = "Creation Date should be in the Past")
    private LocalDate creationDate;

    public User(Integer id, String username, String image,LocalDate creationDate) {
        this.id = id;
        this.username = username;
        this.image = image;
        this.creationDate  = creationDate;
    }

    public User(Integer id, String username, String image) {
        this.id = id;
        this.username = username;
        this.image = image;
        this.creationDate = LocalDate.now().minusYears(2);

    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.image = null;
        this.creationDate = LocalDate.now().minusYears(1);
    }

    public User() {
    }
}
