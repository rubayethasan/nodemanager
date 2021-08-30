package com.rubayet.nodemanager.controller;

import com.rubayet.nodemanager.model.ApiNode;
import com.rubayet.nodemanager.repository.ApiNodeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/nodes")
public class ApiNodeController {

    private final ApiNodeRepository apiNodeRepository;

    public ApiNodeController(ApiNodeRepository apiNodeRepository) {
        this.apiNodeRepository = apiNodeRepository;
    }

    @GetMapping
    public List<ApiNode> getApiNodes() {
        return apiNodeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ApiNode getApiNodes(@PathVariable Long id) {
        return apiNodeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createApiNode(@RequestBody ApiNode apiNode) throws URISyntaxException {
        ApiNode savedApiNode = apiNodeRepository.save(apiNode);
        return ResponseEntity.created(new URI("/nodes/" + savedApiNode.getId())).body(savedApiNode);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateApiNode(@PathVariable Long id, @RequestBody ApiNode apiNode) {
        ApiNode currentApiNode = apiNodeRepository.findById(id).orElseThrow(RuntimeException::new);
        currentApiNode.setName(apiNode.getName());
        currentApiNode.setType(apiNode.getType());
        currentApiNode.setOverview(apiNode.getOverview());
        currentApiNode = apiNodeRepository.save(apiNode);
        return ResponseEntity.ok(currentApiNode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteApiNode(@PathVariable Long id) {
        apiNodeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
