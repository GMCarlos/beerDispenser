package com.beerdispenser.challenge.controller;

import com.beerdispenser.challenge.service.BeerDispenserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beer-dispensers")
@AllArgsConstructor
public class BeerDispenserController {
  private final BeerDispenserService dispenserService;

  @PostMapping("/{dispenserId}")
  public void createDispenser(@PathVariable int dispenserId, @RequestParam float flowVolume) {
    dispenserService.createDispenser(dispenserId, flowVolume);
  }

  @PostMapping("/{dispenserId}/open")
  public void openTap(@PathVariable int dispenserId) {
    dispenserService.openTap(dispenserId);
  }

  @PostMapping("/{dispenserId}/close")
  public void closeTap(@PathVariable int dispenserId) {
    dispenserService.closeTap(dispenserId);
  }

  @GetMapping("/{dispenserId}/money-earned")
  public double getMoneyEarned(@PathVariable int dispenserId) {
    return dispenserService.getMoneyEarned(dispenserId);
  }

  @GetMapping("/{dispenserId}/total-uses")
  public int getTotalUses(@PathVariable int dispenserId) {
    return dispenserService.getTotalUses(dispenserId);
  }
}
