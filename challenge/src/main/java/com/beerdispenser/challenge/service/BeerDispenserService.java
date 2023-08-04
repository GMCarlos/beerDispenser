package com.beerdispenser.challenge.service;

import com.beerdispenser.challenge.controller.model.BeerDispenser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class BeerDispenserService {
  private final Map<Integer, BeerDispenser> dispenserMap;

  public BeerDispenserService() {
    this.dispenserMap = new HashMap<>();
  }

  public void createDispenser(int dispenserId, float flowVolume) {
    BeerDispenser dispenser = new BeerDispenser(dispenserId, flowVolume);
    dispenserMap.put(dispenserId, dispenser);
  }

  public void openTap(int dispenserId) {
    BeerDispenser dispenser = dispenserMap.get(dispenserId);
    if (dispenser != null) {
      dispenser.openTap();
    }
  }

  public void closeTap(int dispenserId) {
    BeerDispenser dispenser = dispenserMap.get(dispenserId);
    if (dispenser != null) {
      dispenser.closeTap();
    }
  }

  public double getMoneyEarned(int dispenserId) {
    BeerDispenser dispenser = dispenserMap.get(dispenserId);
    return (dispenser != null) ? dispenser.getTotalMoneyEarned() : 0;
  }

  public int getTotalUses(int dispenserId) {
    BeerDispenser dispenser = dispenserMap.get(dispenserId);
    return (dispenser != null) ? dispenser.getTotalUses() : 0;
  }
}
