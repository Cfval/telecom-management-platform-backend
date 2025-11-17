package com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.adapter;

import com.tfg.digitalcitizen.platform.device_service.core.model.Device;
import com.tfg.digitalcitizen.platform.device_service.infrastructure.repository.mapper.DeviceEntityMapper;
import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import com.tfg.digitalcitizen.platform.line_service.core.model.LineStatus;
import com.tfg.digitalcitizen.platform.line_service.core.ports.LineRepositoryPort;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.JpaLineRepository;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.entity.LineEntity;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.mapper.LineEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LineRepositoryAdapter implements LineRepositoryPort {

    private final JpaLineRepository jpaRepository;

    @Override
    public Line save(Line line) {
        LineEntity entity = LineEntityMapper.toEntity(line);
        LineEntity saved = jpaRepository.save(entity);
        return LineEntityMapper.toDomain(saved);
    }

    @Override
    public List<Line> findAll() {
        return jpaRepository.findAll().stream()
                .map(LineEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Line> findById(Long id) {
        return jpaRepository.findById(id)
                .map(LineEntityMapper::toDomain);
    }

    @Override
    public Line update(Line line) {
        LineEntity entity = LineEntityMapper.toEntity(line);
        LineEntity updated = jpaRepository.save(entity);
        return LineEntityMapper.toDomain(updated);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Line> findActiveLines() {
        return jpaRepository.findByStatus(LineStatus.ACTIVE).stream()
                .map(LineEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Line> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId).stream()
                .map(LineEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
