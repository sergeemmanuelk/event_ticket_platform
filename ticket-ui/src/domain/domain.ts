export interface ErrorResponse {
  error: string;
}

// eslint-disable-next-line @typescript-eslint/no-explicit-any
export const isErrorResponse = (obj: any): obj is ErrorResponse => {
  return (
    obj &&
    typeof obj === "object" &&
    "error" in obj &&
    typeof obj.error === "string"
  );
};

export enum EventStatusEnum {
  DRAFT = "DRAFT",
  PUBLISHED = "PUBLISHED",
  CANCELLED = "CANCELLED",
  COMPLETED = "COMPLETED",
}

export interface CreateTicketTypeRequest {
  name: string;
  price: number;
  description: string;
  totalAvailable?: number;
}

export interface CreateEventRequest {
  name: string;
  start?: Date;
  end?: Date;
  venue: string;
  salesStart?: Date;
  salesEnd?: Date;
  status: EventStatusEnum;
  ticketTypes: CreateTicketTypeRequest[];
}
