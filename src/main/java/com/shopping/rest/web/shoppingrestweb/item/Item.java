package com.shopping.rest.web.shoppingrestweb.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name="item_table")
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String listOfItems;
    private Date targetDate;
    private boolean isDone;

    protected Item(){

    }

    public Item(long id, String username, String listOfItems, Date targetDate, boolean isDone) {
        super();
        this.id = id;
        this.username = username;
        this.listOfItems = listOfItems;
        this.targetDate = targetDate;
        this.isDone = isDone;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(String listOfItems) {
        this.listOfItems = listOfItems;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
