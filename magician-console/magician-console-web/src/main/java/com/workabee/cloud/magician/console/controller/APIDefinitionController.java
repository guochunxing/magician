package com.workabee.cloud.magician.console.controller;

import com.workabee.cloud.magician.common.abstraction.AbstractAPIDefinition;
import com.workabee.cloud.magician.console.biz.manager.APIDefinitionManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * author: chunxing
 * date: 2021/2/8 10:09
 * description:
 */
@RestController
@RequestMapping("/api/definition")
public class APIDefinitionController {

    @Resource
    APIDefinitionManager definitionManager;

    /**
     * register API metadata
     */
    @PostMapping("/register")
    public void initialize(@RequestBody AbstractAPIDefinition definition) {
        definitionManager.initialize(definition);
    }

    /**
     * update API metadata
     */
    @PutMapping
    public void update(@RequestBody AbstractAPIDefinition definition) {

    }

    /**
     * sync API metadata
     */
    @PostMapping("/sync")
    public void sync(@RequestBody AbstractAPIDefinition definition) {

    }

    /**
     * delete API metadata
     */
    @DeleteMapping
    public void delete(String name, String version) {

    }


    /**
     * offline API
     */
    @DeleteMapping("offline")
    public void offline(String name, String version) {

    }

}
