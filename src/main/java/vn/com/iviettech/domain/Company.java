package vn.com.iviettech.domain;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private List<User> users;
    private Account account;

    public Company(int id, String name, List<User> users, Account account) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
