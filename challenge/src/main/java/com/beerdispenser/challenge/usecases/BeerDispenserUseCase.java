package com.beerdispenser.challenge.usecases;

import com.beerdispenser.challenge.controllers.models.BeerDispenser;
import com.beerdispenser.challenge.controllers.models.BeerDispenserResponse;
import com.beerdispenser.challenge.exceptions.TapCreatedException;
import com.beerdispenser.challenge.exceptions.TapNotFoundException;
import com.beerdispenser.challenge.services.BeerDispenserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerDispenserUseCase {

  private final BeerDispenserService beerDispenserService;

  public BeerDispenserResponse createDispenser(int dispenserId, float flowVolume) {
    BeerDispenser dispenser = beerDispenserService.getBeerDispenser(dispenserId);
    if (dispenser != null) {
      throw new TapCreatedException("Tap with id: " + dispenserId + " is already created.");
    }

    String msg = beerDispenserService.createBeerDispenser(dispenserId, flowVolume);
    return BeerDispenserResponse.builder().msg(msg).build();
  }

  public BeerDispenserResponse deleteDispenser(int dispenserId) {

    BeerDispenser dispenser = beerDispenserService.getBeerDispenser(dispenserId);
    checkDispenser(dispenserId, dispenser);
    String msg = beerDispenserService.deleteBeerDispenser(dispenserId);
    return BeerDispenserResponse.builder().msg(msg).build();
  }

  public BeerDispenserResponse openTap(int dispenserId) {
    BeerDispenser dispenser = beerDispenserService.getBeerDispenser(dispenserId);
    checkDispenser(dispenserId, dispenser);
    String msg = beerDispenserService.openTap(dispenser);
    return BeerDispenserResponse.builder().msg(msg).build();
  }

  public BeerDispenserResponse closeTap(int dispenserId) {
    BeerDispenser dispenser = beerDispenserService.getBeerDispenser(dispenserId);
    checkDispenser(dispenserId, dispenser);
    String msg = beerDispenserService.closeTap(dispenser);
    return BeerDispenserResponse.builder().msg(msg).build();
  }

  public BeerDispenserResponse getMoneyEarned(int dispenserId) {

    BeerDispenser dispenser = beerDispenserService.getBeerDispenser(dispenserId);
    checkDispenser(dispenserId, dispenser);
    float moneyEarned = beerDispenserService.getMoneyEarned(dispenser);
    String msg = String.format("%.02f", moneyEarned);
    // Only show 2 decimals in the response but the value it is saved with all the decimals
    return BeerDispenserResponse.builder().msg(msg).build();
  }

  public BeerDispenserResponse getTotalUses(int dispenserId) {
    /*
    BeerDispenser dispenser = dispenserMap.get(dispenserId);
    return (dispenser != null) ? dispenser.getTotalUses() : 0;*/

    BeerDispenser dispenser = beerDispenserService.getBeerDispenser(dispenserId);
    checkDispenser(dispenserId, dispenser);
    String msg = String.valueOf(beerDispenserService.getTotalUses(dispenser));
    return BeerDispenserResponse.builder().msg(msg).build();
  }

  private static void checkDispenser(int dispenserId, BeerDispenser dispenser) {
    if (dispenser == null) {
      throw new TapNotFoundException("Tap with id: " + dispenserId + " not found.");
    }
  }
}
