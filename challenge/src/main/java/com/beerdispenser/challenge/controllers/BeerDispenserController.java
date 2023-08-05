package com.beerdispenser.challenge.controllers;

import com.beerdispenser.challenge.controllers.models.BeerDispenserResponse;
import com.beerdispenser.challenge.usecases.BeerDispenserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beer-dispensers")
@AllArgsConstructor
public class BeerDispenserController {
  private final BeerDispenserUseCase beerDispenserUseCase;

  @PostMapping(value = "/{dispenserId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDispenserResponse> createDispenser(
      @PathVariable int dispenserId, @RequestParam float flowVolume) {
    return new ResponseEntity<>(
        beerDispenserUseCase.createDispenser(dispenserId, flowVolume), HttpStatus.CREATED);
  }

  @PostMapping(value = "/{dispenserId}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDispenserResponse> deleteDispenser(@PathVariable int dispenserId) {
    return ResponseEntity.ok(beerDispenserUseCase.deleteDispenser(dispenserId));
  }

  @PostMapping(value = "/{dispenserId}/open", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDispenserResponse> openTap(@PathVariable int dispenserId) {
    return ResponseEntity.ok(beerDispenserUseCase.openTap(dispenserId));
  }

  @PostMapping("/{dispenserId}/close")
  public ResponseEntity<BeerDispenserResponse> closeTap(@PathVariable int dispenserId) {
    return ResponseEntity.ok(beerDispenserUseCase.closeTap(dispenserId));
  }

  @GetMapping("/{dispenserId}/money-earned")
  public ResponseEntity<BeerDispenserResponse> getMoneyEarned(@PathVariable int dispenserId) {
    return ResponseEntity.ok(beerDispenserUseCase.getMoneyEarned(dispenserId));
  }

  @GetMapping("/{dispenserId}/total-uses")
  public ResponseEntity<BeerDispenserResponse> getTotalUses(@PathVariable int dispenserId) {
    return ResponseEntity.ok(beerDispenserUseCase.getTotalUses(dispenserId));
  }
}
