package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offers;
import ru.netology.repository.OffersRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OffersManagerTest {

    private OffersManager offers = new OffersManager(new OffersRepository());

    Offers first = new Offers(1, 1000, "DME", "SWO", 3);
    Offers second = new Offers(2, 1500, "DME", "SWO", 5);
    Offers third = new Offers(3, 1170, "DME", "SWO", 1);
    Offers four = new Offers(4, 1220, "DME", "SWO", 2);
    Offers fifth = new Offers(5, 1030, "DME", "SWO", 6);
    Offers sixth = new Offers(6, 1150, "DME", "SWO", 8);
    Offers seventh = new Offers(7, 1002, "DME", "SWO", 4);

    @BeforeEach
    public void SetUp(){
        offers.add(first);
        offers.add(second);
        offers.add(third);
        offers.add(four);
        offers.add(fifth);
        offers.add(sixth);
        offers.add(seventh);
    }

    @Test
    void shouldShowAll(){
        Offers[] actual = offers.findTickets("SWO","DME");
        Offers[] expected = new Offers[]{first, second, third, four, fifth, sixth,seventh};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }


}