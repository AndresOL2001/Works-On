package com.work.on.customer.service.dataaccess.adapter;

import com.work.on.customer.service.dataaccess.entity.ColorEntity;
import com.work.on.customer.service.dataaccess.repository.ColorJpaRepository;
import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.ports.output.repository.ColorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ColorRepositoryImpl implements ColorRepository {

    private final ColorJpaRepository colorrJpaRepository;

    public ColorRepositoryImpl(ColorJpaRepository colorrJpaRepository) {
        this.colorrJpaRepository = colorrJpaRepository;
    }

    @Override
    public Optional<Color> findColor(Long color) {
        ColorEntity colorEntity = colorrJpaRepository.findById(color).get();
        return Optional.of(Color.newBuilder()
                .id(colorEntity.getColorId())
                .hex(colorEntity.getHexadecimal())
                .build());
    }

    @Override
    public Color createColor(Color color) {
        ColorEntity colorEntity = ColorEntity.builder().colorId(color.getId()).hexadecimal(color.getHex()).build();
        colorEntity = colorrJpaRepository.save(colorEntity);
        return Color.newBuilder().hex(colorEntity.getHexadecimal()).id(colorEntity.getColorId()).build();
    }

    @Override
    public Optional<List<Color>> getAllColors() {
        return Optional.of(colorrJpaRepository.findAll().stream().map(colorEntity ->
                Color.newBuilder().hex(colorEntity.getHexadecimal()).id(colorEntity.getColorId()).build())
                .collect(Collectors.toList()));
    }
}
