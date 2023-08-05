package com.beerdispenser.challenge.controllers.models;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BeerDispenser {

  private final int dispenserId;
  private final float flowVolume; // Liters per second
  private boolean isOpen;
  private LocalDateTime tapStartTime;
  private float totalMoneyEarned;
  private int totalUses;

  public BeerDispenser(int dispenserId, float flowVolume) {
    this.dispenserId = dispenserId;
    this.flowVolume = flowVolume;
    this.isOpen = false;
    this.totalMoneyEarned = 0;
    this.totalUses = 0;
  }

  public float getTotalMoneyEarned(){
    float totalMoney = this.totalMoneyEarned;
    if(isOpen){
      LocalDateTime tapCloseTime = LocalDateTime.now();
      double timeDiffSeconds = Duration.between(tapStartTime, tapCloseTime).toSeconds();
      double moneyEarned = timeDiffSeconds * flowVolume;
      totalMoney += moneyEarned;
    }
    return totalMoney;
  }

  public void openTap() {
    if (!isOpen) {
      isOpen = true;
      tapStartTime = LocalDateTime.now();
    }
  }

  public void closeTap() {
    if (isOpen) {
      isOpen = false;
      LocalDateTime tapCloseTime = LocalDateTime.now();
      double timeDiffSeconds = Duration.between(tapStartTime, tapCloseTime).toSeconds();
      double moneyEarned = timeDiffSeconds * flowVolume;
      totalMoneyEarned += moneyEarned;
      totalUses++;
    }
  }
}
