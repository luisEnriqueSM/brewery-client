package org.beer.works.breweryclient.web.config;

import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.reactor.DefaultConnectingIOReactor;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class NIORestTemplateCustomizer implements RestTemplateCustomizer {

    /*public ClientHttpRequestFactory clientHttpRequestFactory() throws IOReactorException {
        final DefaultConnectingIOReactor ioreactor = new DefaultConnectingIOReactor(IOReactorConfig.custom().
                setConnectTimeout(3000).
                setIoThreadCount(4).
                setSoTimeout(3000).
                build());

        final PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(ioreactor);
        connectionManager.setDefaultMaxPerRoute(100);
        connectionManager.setMaxTotal(1000);

        CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom()
                .setConnectionManager(connectionManager)
                .build();

        return new HttpComponentsAsyncClientHttpRequestFactory(httpAsyncClient);

    }*/

    @Override
    public void customize(RestTemplate restTemplate) {
        /*try {
            restTemplate.setRequestFactory(clientHttpRequestFactory());
        } catch (IOReactorException e) {
            e.printStackTrace();
        }*/
    }
}