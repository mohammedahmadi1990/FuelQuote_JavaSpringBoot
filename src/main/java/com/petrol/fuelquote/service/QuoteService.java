package com.petrol.fuelquote.service;

import com.petrol.fuelquote.model.Quote;
import com.petrol.fuelquote.model.User;
import com.petrol.fuelquote.web.dto.QuoteRequestDto;
import java.util.List;

public interface QuoteService {

    List<Quote> listAll();
    void save(QuoteRequestDto dto);
    Quote get(long id);
    List<Quote> listUserQuotes(User user);

}
