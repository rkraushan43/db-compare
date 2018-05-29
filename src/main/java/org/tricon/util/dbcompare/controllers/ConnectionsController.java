package org.tricon.util.dbcompare.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tricon.util.dbcompare.dao.ConnectionsRepository;
import org.tricon.util.dbcompare.models.Connections;

@RestController
//@RequestMapping("/connections")
public class ConnectionsController {

	@Autowired
	private ConnectionsRepository connectionsRepository;
	
	 @GetMapping("/connections")
     public List<Connections> getAllConnections() {
         return connectionsRepository.findAll();
     }

	 @PostMapping("/connections")
	 public Connections createConnection(@Valid @RequestBody Connections connections) {
	     return connectionsRepository.save(connections);
	 }
	 
	 @GetMapping("/connections/{id}")
     public Connections getConnectionById(@PathVariable(value = "id") Long connectionId) {
         return connectionsRepository.getOne(connectionId);
     }
	 
	 @GetMapping("/connections/reqId/{reqId}")
     public List<Connections> getAllConnectionsByReqId(@PathVariable(value = "reqId") Long reqId) {
         return connectionsRepository.findByRequestId(reqId);
     }
	 
}
