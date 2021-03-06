package org.tricon.util.dbcompare.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tricon.util.dbcompare.dao.ColumnMappingRepository;
import org.tricon.util.dbcompare.models.ColumnMapping;


@RestController
public class ColumnMappingController {

	@Autowired
	private ColumnMappingRepository mappingRepository;
	
	@GetMapping("/colmapping")
    public List<ColumnMapping> getAllMapping() {
        return mappingRepository.findAll();
    }

	 @PostMapping("/colmapping")
	 public ColumnMapping createMapping(@Valid @RequestBody ColumnMapping mapping) {
	     return mappingRepository.save(mapping);
	 }
	 
	 @PostMapping("/colmappings")
	 public List<ColumnMapping> createMappings(@Valid @RequestBody List<ColumnMapping> mappings) {
	     return mappingRepository.save(mappings);
	 }
	 
	 @GetMapping("/colmappings/reqId/{reqId}")
     public List<ColumnMapping> getAllMappingByRequestId(@PathVariable(value = "reqId") Long reqId) {
         return mappingRepository.findByRequestId(reqId);
     }
	 
	 
	 
}
