package com.example.coffeemenu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.coffeemenu.model.Coffee;

@Service
public class CoffeeService {
    private final List<Coffee> coffeeList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public CoffeeService() {
        coffeeList.add(new Coffee(idCounter.getAndIncrement(), "Espresso", 45.0));
        coffeeList.add(new Coffee(idCounter.getAndIncrement(), "Latte", 55.0));
    }

    public List<Coffee> getAll() {
        return coffeeList;
    }

    public Optional<Coffee> getById(Long id) {
        return coffeeList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Coffee create(Coffee coffee) {
        coffee.setId(idCounter.getAndIncrement());
        coffeeList.add(coffee);
        return coffee;
    }

    public Optional<Coffee> update(Long id, Coffee updatedCoffee) {
        return getById(id).map(existing -> {
            existing.setName(updatedCoffee.getName());
            existing.setPrice(updatedCoffee.getPrice());
            return existing;
        });
    }

    public boolean delete(Long id) {
        return coffeeList.removeIf(c -> c.getId().equals(id));
    }
}