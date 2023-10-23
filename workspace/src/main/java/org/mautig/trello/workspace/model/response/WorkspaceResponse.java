package org.mautig.trello.workspace.model.response;

import java.io.Serializable;

public class WorkspaceResponse implements Serializable {

    private final String id;
    private final String name;

    private WorkspaceResponse(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public static WorkspaceResponse.Builder builder() {
        return new WorkspaceResponse.Builder();
    }

    public static class Builder {
        private String id;
        private String name;

        public String id() {
            return id;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public String name() {
            return name;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public WorkspaceResponse build() {
            return new WorkspaceResponse(this);
        }
    }

}
