/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.cibertec.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


public class Gatewayconfig {
    
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer-service", r -> r.path("/api/customer/**")
                        .uri("http://localhost:8081"))
                .route("restaurant-service", r -> r.path("/api/restaurant/**")
                        .uri("http://localhost:8081"))
                .route("shoppingcartt-service", r -> r.path("/api/shoppingcart/**")
                        .uri("http://localhost:8081"))
                .build();
    }
}
