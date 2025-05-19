package dev.skonan.tickets.domain.mappers;

import dev.skonan.tickets.domain.CreateEventRequest;
import dev.skonan.tickets.domain.CreateTicketTypeRequest;
import dev.skonan.tickets.domain.dtos.CreateEventRequestDto;
import dev.skonan.tickets.domain.dtos.CreateEventResponseDto;
import dev.skonan.tickets.domain.dtos.CreateTicketTypeRequestDto;
import dev.skonan.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);
    CreateEventRequest fromDto(CreateEventRequestDto dto);
    CreateEventResponseDto toDto(Event event);
}
