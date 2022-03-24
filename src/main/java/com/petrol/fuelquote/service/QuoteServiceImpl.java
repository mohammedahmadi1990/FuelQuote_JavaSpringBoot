package com.petrol.fuelquote.service;

import com.petrol.fuelquote.model.Quote;
import com.petrol.fuelquote.model.User;
import com.petrol.fuelquote.repository.QuoteRepository;
import com.petrol.fuelquote.web.dto.QuoteRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService{

    private QuoteRepository repo;

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        super();
        this.repo = quoteRepository;
    }

    @Override
    public List<Quote> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(QuoteRequestDto dto) {
        Quote quote = new Quote(
                dto.getRequestedGallon(),
                dto.getDeliveryAddress(),
                dto.getDeliveryDate(),
                dto.getPricePerGallon(),
                dto.getTotalAmount(),
                dto.getUser(),
                dto.getRequestDate()
        );
        repo.save(quote);
    }

    @Override
    public Quote get(long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Quote> listUserQuotes(User user) {
        return repo.findAllByUser(user);
    }
}
