package org.mautig.trello.workspace.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mautig.trello.workspace.domain.Workspace;
import org.mautig.trello.workspace.model.request.WorkspaceRequest;
import org.mautig.trello.workspace.model.response.WorkspaceResponse;
import org.mautig.trello.workspace.repository.WorkspaceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceResource {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceResource(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    @GetMapping
    public ResponseEntity<List<WorkspaceResponse>> getWorkspace() {
        return ResponseEntity.ok(workspaceRepository.findAll()
                .stream().map(workspace -> toResponse(workspace))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkspaceResponse> getWorkspaceById(
            @PathVariable String id) {
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow();
        return ResponseEntity.ok(toResponse(workspace));
    }

    @PostMapping
    public ResponseEntity<WorkspaceResponse> postWorkspace(
            @RequestBody WorkspaceRequest request) {
        Workspace workspace = Workspace.builder()
                .name(request.getName());
        workspaceRepository.save(workspace);
        return ResponseEntity.ok(toResponse(workspace));
    }

    private WorkspaceResponse toResponse(Workspace workspace) {
        return WorkspaceResponse.builder()
                .id(workspace.id())
                .name(workspace.name())
                .build();
    }
}
