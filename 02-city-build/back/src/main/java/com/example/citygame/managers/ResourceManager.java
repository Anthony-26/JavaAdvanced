package com.example.citygame.managers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.citygame.model.resources.Resource;

@Component
public class ResourceManager {
    
    private Map<String, Resource> resourcesMap = new HashMap<>();

    public ResourceManager(){
        resourcesMap.put("Fish", new Resource("Fish"));
    }

    public Resource getResource(String name){
        return this.resourcesMap.get(name);
    }

}
