# Parking Lot - Entities

## 1. ParkingLot

### Responsibility

Represents the complete parking lot.

### Why?

Owns floors, gates and parking slots.

---

## 2. ParkingFloor

### Responsibility

Represents one floor inside the parking lot.

### Why?

A parking lot can have multiple floors.

---

## ParkingSlot

### Why?

Represents one physical parking space.

### Responsibility

- Park one compatible vehicle.
- Track occupancy.
- Release itself when vehicle exits.

### State

- Slot Number
- Slot Type
- Occupied

### Future Extension

- EV Charging
- Reserved Slot
- Handicap Slot

## 4. Vehicle

### Responsibility

Represents a vehicle entering the parking lot.

### Stores
- Vechicle Type
- Vechile Number
---

## 5. Ticket

### Responsibility

Represents the parking ticket issued during entry.

### Stores
- Ticket ID
- Entry Time
- Parking Slot
- Vechicle

## 6. EntryGate

### Why does it exist?

Represents an entry point to the parking lot.

### Responsibility

Accept vehicles and generate parking tickets.

---

## 7. ExitGate

### Why does it exist?

Represents an exit point from the parking lot.

### Responsibility

Calculate parking fee and allow vehicle exit.


## 8. Payment

### Responsibility

Represents payment information during exit.

### Stores

- Amount
- Payment Status
- Payment Time


