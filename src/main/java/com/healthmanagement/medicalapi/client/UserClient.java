package com.healthmanagement.medicalapi.client;

import com.healthmanagement.medicalapi.model.dto.UserDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix = "host.userclient",ignoreUnknownFields = true)
public class UserClient {
    private final String USER_PATH ="/api/users/";
    private String apiHost;
    private RestTemplate restTemplate;

    public UserClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public UserDto getUserById(Long id){
        return restTemplate.getForObject(apiHost+USER_PATH+String.valueOf(id), UserDto.class);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
