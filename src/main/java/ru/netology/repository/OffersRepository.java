package ru.netology.repository;

import org.junit.Test;
import ru.netology.domain.Offers;

import java.util.Arrays;

public class OffersRepository {
    private Offers[] items = new Offers[0];

    public void save(Offers item) {
        int length = items.length + 1;
        Offers[] tmp = new Offers[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Offers[] findAll() {
        return items;
    }

    public Offers findById(int id) {
        for (Offers item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Offers[] tmp = new Offers[length];
        int index = 0;
        for (Offers item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Offers[] getAll() {
        return items;
    }
}
