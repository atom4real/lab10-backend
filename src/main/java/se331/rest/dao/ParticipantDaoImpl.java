package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Participant;
import se331.rest.repository.ParticipantRepository;

import java.util.Optional;

public class ParticipantDaoImpl implements ParticipantDao {
    @Autowired
    ParticipantRepository participantRepository;
    @Override
    public Page<Participant> getParticipant(Pageable pageRequest) {
        return participantRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Participant> findByIdParticipant(Long id) {
        return participantRepository.findById(id);
    }
}