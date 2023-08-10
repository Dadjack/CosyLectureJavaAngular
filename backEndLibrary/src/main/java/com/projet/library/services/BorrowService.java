package com.projet.library.services;

import com.projet.library.entities.BorrowEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class BorrowService {
    BorrowEntity borrow = new BorrowEntity();

  public long calculateDuration(BorrowEntity borrow) {
      return ChronoUnit.DAYS.between(borrow.getStartDate(), borrow.getEndDate());
  }

    public long calculateDelay(BorrowEntity borrow) {
        return ChronoUnit.DAYS.between(borrow.getEndDate(), LocalDateTime.now());
    }

  public float calculatePenalty(BorrowEntity borrow) {
      long duration = calculateDuration(borrow);
      float amount = 0;
      while (duration > 30) {
          amount += 0.5;
          duration++;
      }
        return amount;
  }
}
