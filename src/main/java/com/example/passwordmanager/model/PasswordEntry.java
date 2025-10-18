package com.example.passwordmanager.model;


import jakarta.persistence.*;

@Entity
@Table(name = "password_entry")
public class PasswordEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // S.No auto increment

    @Column(name = "`system`")
    private String system;
    private String environment;
    private String url;
    private String username;
    @Column(name = "`password`")
    private String password;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSystem() { return system; }
    public void setSystem(String system) { this.system = system; }

    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

