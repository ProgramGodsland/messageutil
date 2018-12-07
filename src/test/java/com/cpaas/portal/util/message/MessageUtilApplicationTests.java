package com.cpaas.portal.util.message;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpaas.portal.util.message.resource.Message;
import com.cpaas.portal.util.message.resource.MessageParams;
import com.cpaas.portal.util.message.resource.MessageType;
import com.cpaas.portal.util.message.util.MessageSender;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessageUtilApplicationTests {

  @Autowired
  private MessageSender sender;

  @Test
  public void contextLoads() {
    MessageParams params = new MessageParams();
    params.setSubscriber("provisioning");
    params.setOriginatingMS("cpaas-rtq");
    params.setType(MessageType.notification);
    params.setMessageID(UUID.randomUUID().toString());
    params.setTransactionID(UUID.randomUUID().toString());
    params.setTerminatingMS("auto-unallocated");

    ServiceData serviceData = new ServiceData();
    serviceData.setVersion("1");
    serviceData.setEvent("update");
    serviceData.setResource("user");
    serviceData.setId(UUID.randomUUID().toString());
    serviceData.setRealm("myrealm");
    
    ObjectMapper mapper = new ObjectMapper();
    JsonNode data = mapper.valueToTree(serviceData);
    
    System.err.println("service data: " + data);
    
    Message message = new Message();
    message.setMessageParams(params);
    message.setMessageRealm("internal");
    message.setVersion("1");
    message.setServiceAction("provisioning");
    message.setServiceData(data);
    System.err.println("message:  " + message);
    sender.sendNotification("Broadcast", message);

  }

  protected class ServiceData {
    private String version;
    private String event;
    private String resource;
    private String id;
    private String realm;

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    public String getEvent() {
      return event;
    }

    public void setEvent(String event) {
      this.event = event;
    }

    public String getResource() {
      return resource;
    }

    public void setResource(String resource) {
      this.resource = resource;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getRealm() {
      return realm;
    }

    public void setRealm(String realm) {
      this.realm = realm;
    }

    @Override
    public String toString() {
      return "ServiceData [version=" + version + ", event=" + event + ", resource=" + resource
          + ", id=" + id + ", realm=" + realm + "]";
    }
  }

}
