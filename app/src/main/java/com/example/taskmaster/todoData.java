package com.example.taskmaster;

import android.media.Image;
import android.widget.ImageView;

public class todoData {
    String todoItem;
    int edit,delete;


    public todoData(String todoItem,int edit,int delete){
        this.todoItem = todoItem;
        this.delete = delete;
        this.edit = edit;

    }
}