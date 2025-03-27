package org.botnicholas.projects.demopagination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parents/{parentId}")
public class ChildController {
//    Path can contain parent, but not be the same!!!
//    @GetMapping
//    public String parentFromChild() {
//        return "Hello from Parent From Child";
//    }

    @GetMapping("/children/{childId}")
    public String accessParent(@PathVariable int childId, @PathVariable int parentId) {
        return "Hello from Child " + childId + " and Parent " + parentId;
    }
}
