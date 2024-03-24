package com.ciphersentinel.server.model;

import jakarta.persistence.*;

@Entity
@Table(name = "credentials")
public class Credential
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String username;
    private String password;

    public int getId()
    {
        return id;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}
