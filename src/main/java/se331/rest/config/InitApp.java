package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;
import se331.rest.entity.Participant;
import se331.rest.repository.EventRepository;
import se331.rest.repository.OrganizerRepository;
import se331.rest.repository.ParticipantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
        Participant pat1,pat2,pat3,pat4,pat5;
        List<Participant> participantList;
        pat1 = participantRepository.save(Participant.builder()
                .name("Lin")
                .telNo("06471171561")
                .build());
        pat2 = participantRepository.save(Participant.builder()
                .name("Hin")
                .telNo("0638395592")
                .build());
        pat3 = participantRepository.save(Participant.builder()
                .name("Fah")
                .telNo("0656395578")
                .build());
        pat4 = participantRepository.save(Participant.builder()
                .name("Mark")
                .telNo("0631938613")
                .build());
        pat5 = participantRepository.save(Participant.builder()
                .name("Poom")
                .telNo("0819372281")
                .build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        participantList = new ArrayList<>();
        participantList.add(pat1);
        participantList.add(pat2);
        participantList.add(pat3);
        participantList.add(pat4);
        participantList.add(pat5);
        tempEvent.setParticipants(participantList);
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        pat1.getEventHistory().add(tempEvent);
        pat2.getEventHistory().add(tempEvent);
        pat3.getEventHistory().add(tempEvent);
        pat4.getEventHistory().add(tempEvent);
        pat5.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        participantList = new ArrayList<>();
        participantList.add(pat1);
        participantList.add(pat2);
        participantList.add(pat3);
        tempEvent.setParticipants(participantList);
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        pat1.getEventHistory().add(tempEvent);
        pat2.getEventHistory().add(tempEvent);
        pat3.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        participantList = new ArrayList<>();
        participantList.add(pat1);
        participantList.add(pat2);
        participantList.add(pat3);
        tempEvent.setParticipants(participantList);
        tempEvent.setOrganizer(org2);
        org1.getOwnEvents().add(tempEvent);

        pat1.getEventHistory().add(tempEvent);
        pat2.getEventHistory().add(tempEvent);
        pat3.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        participantList = new ArrayList<>();
        participantList.add(pat1);
        participantList.add(pat2);
        participantList.add(pat3);
        participantList.add(pat4);
        participantList.add(pat5);
        tempEvent.setParticipants(participantList);
        tempEvent.setOrganizer(org3);
        org1.getOwnEvents().add(tempEvent);

        pat1.getEventHistory().add(tempEvent);
        pat2.getEventHistory().add(tempEvent);
        pat3.getEventHistory().add(tempEvent);
        pat4.getEventHistory().add(tempEvent);
        pat5.getEventHistory().add(tempEvent);
    }
}