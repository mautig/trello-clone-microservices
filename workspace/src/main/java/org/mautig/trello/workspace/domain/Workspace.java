package org.mautig.trello.workspace.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workspace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Workspace() {
    }

    public static final Workspace builder() {
        return new Workspace();
    }

    public String id() {
        return id;
    }

    public Workspace id(String id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Workspace name(String name) {
        this.name = name;
        return this;
    }

}
