package dev.skonan.tickets.services.impl;

import dev.skonan.tickets.domain.CreateEventRequest;
import dev.skonan.tickets.domain.entities.Event;
import dev.skonan.tickets.domain.entities.TicketType;
import dev.skonan.tickets.domain.entities.User;
import dev.skonan.tickets.exceptions.UserNotFoundException;
import dev.skonan.tickets.repositories.EventRepository;
import dev.skonan.tickets.repositories.UserRepository;
import dev.skonan.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest event) {
        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with ID '%s' not found", organizerId))
                );

        List<TicketType> ticketTypesToCreate = event.getTicketTypes()
                .stream()
                .map(ticketType -> {
                    TicketType ticketTypeToCreate = new TicketType();
                    ticketTypeToCreate.setName(ticketTypeToCreate.getName());
                    ticketTypeToCreate.setDescription(ticketTypeToCreate.getDescription());
                    ticketTypeToCreate.setPrice(ticketTypeToCreate.getPrice());
                    ticketTypeToCreate.setTotalAvailable(ticketTypeToCreate.getTotalAvailable());
                    return ticketTypeToCreate;
                }).toList();

        Event eventToCreate = new Event();
        eventToCreate.setName(event.getName());
        eventToCreate.setStart(event.getStart());
        eventToCreate.setEnd(event.getEnd());
        eventToCreate.setVenue(event.getVenue());
        eventToCreate.setSalesStart(event.getSalesStart());
        eventToCreate.setSalesEnd(event.getSalesEnd());
        eventToCreate.setStatus(event.getStatus());
        eventToCreate.setOrganizer(organizer);
        eventToCreate.setTicketTypes(ticketTypesToCreate);

        return eventRepository.save(eventToCreate);
    }
}
