package org.tricon.util.dbcompare.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tricon.util.dbcompare.models.RowCombined;
import org.tricon.util.dbcompare.service.CompareService;

@RestController
public class HomeController {

  private final Logger					_LOGGER	= LoggerFactory.getLogger(HomeController.class);

  @Autowired
  private CompareService compareService;
	
  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Index";
  }
  
  @RequestMapping("/compare/{reqId}")
  @ResponseBody
  public List<RowCombined> compare(@PathVariable(value="reqId") Long reqId){
	  _LOGGER.debug("Calling  compareService for request id: {} ",reqId);
	  return compareService.compare(reqId);
  }

}
