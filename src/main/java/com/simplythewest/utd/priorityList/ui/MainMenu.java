package com.simplythewest.utd.priorityList.ui;

import com.simplythewest.utd.priorityList.models.ToDoItemRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.stereotype.Component;

public class MainMenu extends HorizontalLayout{

    ToDoItemRepository myRepo;

    MainMenu(ToDoItemRepository otherToDoItemRepo)
    {
        myRepo = otherToDoItemRepo;
        add(addButton());
        add(deleteButton());
        add(clearButton());
        add(editButton());
    }

    private Button addButton()
    {
        Button addButton = new Button("Add");

        addButton.addClickListener(
            clickEvent ->
            {
                addButton.getUI().ifPresent(ui ->
                    ui.navigate("AddMenu"));
            }
        );

        return addButton;
    }

    public Button deleteButton()
    {
        Button deleteButton = new Button("Delete");

        deleteButton.addClickListener(
            clickEvent ->
                deleteButton.getUI().ifPresent(ui->
                    ui.navigate("DeleteMenu"))
        );

        return deleteButton;
    }

    private Button clearButton()
    {
        Button clearButton = new Button("Clear");

        clearButton.addClickListener(
            clickEvent ->
            {
                myRepo.deleteAllByCompletedStatus(false);
                myRepo.deleteAllByCompletedStatus(true);
            });

        return clearButton;
    }

    public Button editButton()
    {
        Button editButton = new Button("Edit Items");

        editButton.addClickListener(
            clickEvent ->
                editButton.getUI().ifPresent(ui->
                    ui.navigate("EditMenu"))
        );

        return editButton;
    }
}
