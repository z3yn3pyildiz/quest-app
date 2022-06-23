package com.example.questApp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class Use {
   @Id
   Long id;
   String userName;
   String passWord;
}
