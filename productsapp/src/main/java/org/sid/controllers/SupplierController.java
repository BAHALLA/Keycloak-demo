package org.sid.controllers;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.sid.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SupplierController {
    @Autowired
    private KeycloakRestTemplate keycloakRestTemplate;

    @GetMapping("/suppliers")
    public String suppliers(Model model) {

        ResponseEntity<PagedModel<Supplier>> responseEntity =
                keycloakRestTemplate.exchange("http://localhost:8083/suppliers", HttpMethod.GET, null,
                        new ParameterizedTypeReference<PagedModel<Supplier>>() {});
        model.addAttribute("suppliers", responseEntity.getBody().getContent());
        return "suppliers";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model, Exception e) {
        model.addAttribute("error", e.getMessage());
        return "errors";
    }
}
