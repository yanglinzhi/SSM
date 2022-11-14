package com.ylz.pojo;

/**
 * @author 杨霖志
 * @date 2022/9/15
 */

public class User {
   private String username;
   private Integer  id;
   private String password;

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public User() {
   }

   public User(String username, Integer id, String password) {
      this.username = username;
      this.id = id;
      this.password = password;
   }

   @Override
   public String toString() {
      return "User{" +
              "username='" + username + '\'' +
              ", id=" + id +
              ", password='" + password + '\'' +
              '}';
   }
}
