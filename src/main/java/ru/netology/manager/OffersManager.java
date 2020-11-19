package ru.netology.manager;

import ru.netology.domain.Offers;
import ru.netology.repository.OffersRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OffersManager {
    private OffersRepository repository;

    public OffersManager(OffersRepository repository) {
        this.repository = repository;
    }
    public void add(Offers product) {
        repository.save(product);
    }

    public Offers[] findAll() {
        Offers[] offers = repository.getAll();
        Offers[] result = new Offers[offers.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = offers[i];
        }
        return result;
    }

    public Offers[] findTickets(String from, String to){
        Offers[] offers = repository.getAll();
        int index = 0;
        Offers[] tmp = new Offers[offers.length]; //длина массива?
        for (Offers offer : offers) {
            if (offer.getArrivalAirport().equals(from)) {
                if (offer.getDepartureAirport().equals(to)){
                    tmp[index] = offer;
                    index++;
                }
            }
        }
        return tmp;
    }


}
