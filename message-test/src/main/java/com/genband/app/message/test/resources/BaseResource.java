package com.genband.app.message.test.resources;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseResource implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1926200196809941334L;

  private static ObjectMapper mapper = new ObjectMapper();
  private static final String toStringError = "ERROR";

  @Override
  public String toString() {
    try {
      return mapper.writeValueAsString(this);
    } catch (JsonProcessingException | NullPointerException e) {
      return toStringError;
    }
  }

}
