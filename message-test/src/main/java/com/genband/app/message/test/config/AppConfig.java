/**
 * 
 */
package com.genband.app.message.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cpaas.portal.util.message.util.MessageFactory;

/**
 * @author irene.lu
 *
 */
@Configuration
public class AppConfig {
  @Bean
  public MessageFactory getMessageFactory() {
    return MessageFactory.getInstance();
  }
}
