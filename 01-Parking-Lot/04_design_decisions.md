# Parking Lot - Design Decisions

## Decision 1

### Problem

Should ParkingLot directly manage ParkingSlots?

### Decision
Introduce a parkingfloor and Each parkingfloor consist of mutiple parking slot.


### Why?

A parking lot can have multiple floors.

Each floor manages its own parking slots.

This follows Single Responsibility Principle.

### Alternative

ParkingLot directly contains all ParkingSlots.

### Trade-offs

Simpler design for a small system.

Poor scalability for multiple floors


## Decision 2

### Problem

How should ParkingLot own ParkingFloor?

### Decision

Use Composition.

### Why?

ParkingFloor cannot exist without ParkingLot.

Deleting ParkingLot deletes all its floors.

### Alternative

Association.

### Trade-offs

Composition models real-world ownership better.

## Decision 3

### Problem

Should Vehicle only be a String?

### Decision

Create a separate Vehicle entity.

### Why?

Vehicle has its own identity and state.

Future requirements may introduce:

- Car
- Bike
- Truck
- Electric Vehicle

### Alternative

Store vehicle number inside Ticket.

### Trade-offs

Entity is more extensible.


## Decision 4

### Problem

How do we track parked vehicles?

### Decision

Generate a Ticket.

### Why?

Ticket links:

- Vehicle
- Parking Slot
- Entry Time

Without Ticket, calculating parking duration becomes difficult.

### Alternative

Store everything inside ParkingSlot.

### Trade-offs

Ticket separates parking history from parking slot.


## Decision 5

### Problem

How should payment information be stored?

### Decision

Introduce a Payment entity.

### Why?

Payment is an independent business concept.

It stores:

- Amount
- Status
- Time

Future payment methods can be added easily.

### Alternative

Store payment fields inside Ticket.

### Trade-offs

Separate entity is cleaner and extensible.