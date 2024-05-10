package com.example.projetoEmakers.exceptions.general;

import javax.swing.text.html.parser.Entity;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id){
        super("Entity not found with id: " + id);
    }
}
