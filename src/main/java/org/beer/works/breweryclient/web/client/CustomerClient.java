package org.beer.works.breweryclient.web.client;

import org.beer.works.breweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "brewery", ignoreUnknownFields = false)
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer";
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerDto getCustomerById(UUID customerId){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + "/" + customerId, CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return  restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + customerId);
    }
}
