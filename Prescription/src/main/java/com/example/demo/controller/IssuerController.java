package com.example.demo.controller;

import com.example.demo.aca.dto.*;

import com.example.demo.service.IssuerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@RestController
@RequestMapping("/issuer")
@RequiredArgsConstructor
public class IssuerController {


    @NonNull
    private final IssuerService issuerService;

    @PostMapping("/create-invitation")
    public CreateInvitationResponseDTO createConnection(Model model) {
        return issuerService.createConnection();
    }

    @GetMapping("/create-invitation")
    public CreateInvitationResponseDTO createConnection() {
        return issuerService.createConnection();
    }

    @PostMapping("/accept-request")
    public AcceptRequestResponseDTO acceptConnectionRequest(@RequestBody AcceptRequestDTO acceptRequestDTO) {

        return issuerService.acceptConnectionInvitationRequest(acceptRequestDTO);

    }


    @PostMapping("/schemas")
    public SchemaResponseDTO schema(@RequestBody() SchemaDTO schemaDTO) {


        return issuerService.schema(schemaDTO);
    }

    @PostMapping("/credential-definitions")
    public CredentialDefinitionResponseDTO credentialDefinitions(@RequestBody() CredentialDefinitionDTO credentialDefinitionDTO) {
        return issuerService.credentialDefinition(credentialDefinitionDTO);
    }


    @GetMapping("/login")
    public ModelAndView login(@RequestParam("username") String username) {
        // Verificar o valor do campo "username"
        if (username.equals("doctor")) {
            // Redirecionar para a página do médico
            return new ModelAndView("redirect:/doctor");
        } else if (username.equals("patient")) {
            // Redirecionar para a página do paciente
            return new ModelAndView("redirect:/patient");
        } else {
            // Redirecionar para uma página de erro ou exibir uma mensagem de erro
            return new ModelAndView("redirect:/error");
        }
    }


}
