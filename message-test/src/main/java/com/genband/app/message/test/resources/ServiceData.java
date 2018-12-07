package com.genband.app.message.test.resources;

public class ServiceData extends BaseResource {
  /**
   * 
   */
  private static final long serialVersionUID = 2350819608763593226L;

  private String event;
  private String resource;
  private String id;
  private String realm;
  private String version;

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

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}
