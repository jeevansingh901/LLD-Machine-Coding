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

## 3. ParkingSlot

### Responsibility

Represents one parking space.

### Stores

- Slot Number
- Vehicle Type
- Occupied Status

---

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


