package com.finalproject.sport.mapper;

import com.finalproject.sport.model.User;
import org.bson.Document;

import java.util.Date;

public class UsersMapper {
       public static Document userToDocument(User user) {
      return new Document()
              .append("firstName", user.getFirstName())
              .append("lastName", user.getLastName())
              .append("birthday", user.getBirthday())
              .append("gender", user.getGender());
    }

     public static User documentToUser(Document document) {
      String firstName = document.getString("firstName");
      String lastName = document.getString("lastName");
      Date date = document.getDate("birthday");
      String gender = document.getString("gender");

      return new User(firstName,lastName, date,gender);
    }
}
