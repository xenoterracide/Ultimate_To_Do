package com.simplythewest.utd;

import java.io.Serializable;

public class ToDoDTO implements Serializable{

    private String description = "";
    private int priority = 0;


    public void getDescription(String description)
    {
        this.description = description;
    }

    public void setPriority(String priority)
    {
        switch (priority) {
            case "High": this.priority = 1;
                break;
            case "Medium": this.priority = 2;
                break;
            default: this.priority = 3;
        }
    }
}
