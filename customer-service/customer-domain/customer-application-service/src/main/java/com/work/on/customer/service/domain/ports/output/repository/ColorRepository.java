package com.work.on.customer.service.domain.ports.output.repository;

import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ColorRepository {

    Optional<Color> findColor(Long color);

    Color createColor(Color color);

    Optional<List<Color>> getAllColors();
}
