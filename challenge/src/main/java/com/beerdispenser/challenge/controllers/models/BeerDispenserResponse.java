package com.beerdispenser.challenge.controllers.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BeerDispenserResponse {
    private String msg;
}
