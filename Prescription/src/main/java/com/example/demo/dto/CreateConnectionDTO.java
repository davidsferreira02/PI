package com.example.demo.dto;

import lombok.Data;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;


@Data
public class CreateConnectionDTO {

  InvitationCreateRequest invitationCreateRequest;
  CreateInvitationFilter createInvitationFilter;



}
