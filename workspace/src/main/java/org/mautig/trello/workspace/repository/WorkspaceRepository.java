package org.mautig.trello.workspace.repository;

import org.mautig.trello.workspace.domain.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, String> {

}
