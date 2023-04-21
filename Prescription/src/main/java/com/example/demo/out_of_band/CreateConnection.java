package com.example.demo.out_of_band;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hyperledger.aries.api.AcaPyRequestFilter;

import java.util.List;


public class CreateConnection implements AcaPyRequestFilter {


    private Boolean autoAccept;
    private Boolean multiUse;


    public CreateConnection(Boolean autoAccept, Boolean multiUse) {
        autoAccept=true;
        multiUse=false;
    }

    public Boolean getAutoAccept() {
        return autoAccept;
    }

    public void setAutoAccept(Boolean autoAccept) {
        this.autoAccept = autoAccept;
    }

    public Boolean getMultiUse() {
        return multiUse;
    }

    public void setMultiUse(Boolean multiUse) {
        this.multiUse = multiUse;
    }
}
