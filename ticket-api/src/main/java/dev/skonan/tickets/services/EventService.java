package dev.skonan.tickets.services;

import dev.skonan.tickets.domain.CreateEventRequest;
import dev.skonan.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
