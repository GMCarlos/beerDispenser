package com.beerdispenser.challenge.services;

import com.beerdispenser.challenge.controllers.models.BeerDispenser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class BeerDispenserService {

  private final Map<Integer, BeerDispenser> dispenserMap;

  public BeerDispenserService() {
    this.dispenserMap = new HashMap<>();
  }

  public BeerDispenser getBeerDispenser(int dispenserId) {
    return dispenserMap.get(dispenserId);
  }

  public String createBeerDispenser(int dispenserId, float flowVolume) {
    BeerDispenser beerDispenser = new BeerDispenser(dispenserId, flowVolume);
    dispenserMap.put(dispenserId, beerDispenser);
    return "Beer dispenser with id: " + dispenserId + " created.";
  }

  public String deleteBeerDispenser(int dispenserId) {
    dispenserMap.remove(dispenserId);
    return "Beer dispenser with id: " + dispenserId + " deleted.";
  }

  public String openTap(BeerDispenser dispenser) {
    dispenser.openTap();
    return "Beer dispenser with id: " + dispenser.getDispenserId() + " has opened the tap.";
  }

  public String closeTap(BeerDispenser dispenser) {
    dispenser.closeTap();
    return "Beer dispenser with id: " + dispenser.getDispenserId() + " has closed the tap.";
  }

  public float getMoneyEarned(BeerDispenser dispenser) {
    return (dispenser != null) ? dispenser.getTotalMoneyEarned() : 0;
  }

  public int getTotalUses(BeerDispenser dispenser) {
    return (dispenser != null) ? dispenser.getTotalUses() : 0;
  }
}
