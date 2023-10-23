package org.mautig.trello.workspace.model.request;

import java.io.Serializable;

public class WorkspaceRequest implements Serializable {

    private String name;

    public WorkspaceRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
