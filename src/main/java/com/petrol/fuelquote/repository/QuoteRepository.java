package com.petrol.fuelquote.repository;

import com.petrol.fuelquote.model.Quote;
import com.petrol.fuelquote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findAllByUser(User user);
}