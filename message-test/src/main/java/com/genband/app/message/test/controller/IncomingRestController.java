/**
 * 
 */
package com.genband.app.message.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpaas.portal.util.message.resource.Message;
import com.genband.app.message.test.resources.ServiceData;
import com.genband.app.message.test.service.MessageService;


/**
 * @author irene.lu
 *
 */
@RestController
public class IncomingRestController {
  @Autowired
  private MessageService msgSvc;
  
  @RequestMapping(path="/message/test", method=RequestMethod.POST)
  public ResponseEntity<?> triggerMessageNotification(@RequestBody ServiceData serviceData){
    Message msg = msgSvc.sendMessage(serviceData);
    if(msg == null) {
      System.err.println("Message is null!!!");
      return new ResponseEntity<String>("No message sent", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    System.err.println("Message is: " + msg);
    ResponseEntity<String> response = new ResponseEntity<String>(msg.getServiceAction(), HttpStatus.CREATED);
    return response;
  }
}
