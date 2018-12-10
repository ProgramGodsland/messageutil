/**
 * 
 */
package com.genband.app.message.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpaas.portal.util.message.producer.Producer;
import com.cpaas.portal.util.message.resource.Message;
import com.cpaas.portal.util.message.util.MessageFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genband.app.message.test.resources.ServiceData;

/**
 * @author irene.lu
 *
 */
@Service
public class MessageService {
  @Autowired
  private MessageFactory messageFactory;
  @Autowired
  private Producer producer;
  
  private ObjectMapper mapper = new ObjectMapper();
  
  public Message sendMessage(ServiceData serviceData) {
    JsonNode data = mapper.valueToTree(serviceData);
    Message msg = messageFactory.buildMessage("internal", "provisioning", data, System.getenv("SERVICE_NAME"), System.getenv("SERVICE_NAME"));
    try {
      producer.produce(msg, "Broadcast", "ProvisionExchange");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
    return msg;
  }
}
