# Parking Lot - Entities

## 1. ParkingLot

### Why?

Represents the complete parking lot.

### Responsibility

* Manage the entire parking lot.
* Manage all parking floors.
* Manage all entry and exit gates.

### State

* Parking Lot ID
* Name
* Address
* Parking Floors
* Entry Gates
* Exit Gates

### Relationships

* HAS-A `ParkingFloor`
* HAS-A `EntryGate`
* HAS-A `ExitGate`

### Future Extension

* Multiple parking lots
* Centralized parking management
* Dynamic pricing

---

## 2. ParkingFloor

### Why?

Represents a single floor inside the parking lot.

### Responsibility

* Manage all parking slots on the floor.
* Find an available parking slot.
* Track floor occupancy.

### State

* Floor Number
* Parking Slots

### Relationships

* BELONGS TO `ParkingLot`
* HAS-A `ParkingSlot`

### Future Extension

* Floor-wise occupancy statistics
* Reserved zones
* EV charging zones

---

## 3. ParkingSlot

### Why?

Represents one physical parking space.

### Responsibility

* Park one compatible vehicle.
* Track occupancy.
* Release itself when the vehicle exits.

### State

* Slot Number
* Slot Type
* Occupancy Status

### Relationships

* BELONGS TO `ParkingFloor`
* CAN HOLD one `Vehicle`

### Future Extension

* EV charging slot
* Reserved slot
* Handicap slot
* VIP slot

---

## 4. Vehicle

### Why?

Represents a vehicle entering the parking lot.

### Responsibility

* Carry vehicle information.
* Identify the type of vehicle.

### State

* Vehicle Number
* Vehicle Type

### Relationships

* ASSOCIATED WITH `Ticket`
* PARKED IN `ParkingSlot`

### Future Extension

* Electric Vehicle
* VIP Vehicle
* Handicap Vehicle

---

## 5. Ticket

### Why?

Represents the parking ticket issued when a vehicle enters the parking lot.

### Responsibility

* Record parking information.
* Track parking duration.
* Link the vehicle with its parking slot.

### State

* Ticket ID
* Entry Time
* Parking Slot
* Vehicle
* Ticket Status

### Relationships

* ASSOCIATED WITH `Vehicle`
* ASSOCIATED WITH `ParkingSlot`
* ASSOCIATED WITH `Payment`

### Future Extension

* QR Code
* Barcode
* Lost Ticket Handling

---

## 6. EntryGate

### Why?

Represents an entry point to the parking lot.

### Responsibility

* Accept incoming vehicles.
* Generate parking tickets.
* Allocate parking slots.

### State

* Gate ID
* Gate Name

### Relationships

* BELONGS TO `ParkingLot`

### Future Extension

* Automatic Number Plate Recognition (ANPR)
* RFID Entry
* FastTag Support

---

## 7. ExitGate

### Why?

Represents an exit point from the parking lot.

### Responsibility

* Calculate parking fees.
* Process vehicle exit.
* Release occupied parking slots.

### State

* Gate ID
* Gate Name

### Relationships

* BELONGS TO `ParkingLot`
* ASSOCIATED WITH `Payment`
* ASSOCIATED WITH `Ticket`

### Future Extension

* Automatic payment
* FastTag support
* UPI payment
* Card payment

---

## 8. Payment

### Why?

Represents the payment made during vehicle exit.

### Responsibility

* Store payment details.
* Track payment status.
* Complete the parking transaction.

### State

* Payment ID
* Amount
* Payment Time
* Payment Status
* Payment Method

### Relationships

* ASSOCIATED WITH `Ticket`

### Future Extension

* Refund
* Partial payment
* Multiple payment methods
* Online payment
