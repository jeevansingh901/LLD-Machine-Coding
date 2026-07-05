# Parking Lot - Class Diagram

## Step 1 - Core Entities

```text
                 ParkingLot
                      │
          ┌───────────┴───────────┐
          │                       │
     EntryGate               ExitGate
          │
          │
     ParkingFloor
          │
     ParkingSlot
          │
       Vehicle

Ticket -------- Vehicle
Ticket -------- ParkingSlot

Payment ------- Ticket
```

---

## Step 2 - Relationship Types

### Composition

```
ParkingLot ◆──────── ParkingFloor

ParkingFloor ◆──────── ParkingSlot
```

Reason:

- ParkingLot owns ParkingFloors.
- ParkingFloor owns ParkingSlots.

If the parent is destroyed, the child is also destroyed.

---

### Association

```
Ticket ───────── Vehicle

Ticket ───────── ParkingSlot

Payment ───────── Ticket

EntryGate ───────── ParkingLot

ExitGate ───────── ParkingLot
```

Reason:

These objects only know about each other.

Their lifecycle is independent.

---

## Step 3 - Multiplicity

```
ParkingLot
1 ◆──────── * ParkingFloor

ParkingFloor
1 ◆──────── * ParkingSlot

ParkingSlot
1 ───────── 0..1 Vehicle

Vehicle
1 ───────── 1 Ticket (Active)

Ticket
1 ───────── 0..1 Payment

ParkingLot
1 ───────── * EntryGate

ParkingLot
1 ───────── * ExitGate
```

---

## Step 4 - Final Interview Diagram

```text
                         ParkingLot
                     1
                     ◆
                     │
                     │ *
              ParkingFloor
                     1
                     ◆
                     │
                     │ *
              ParkingSlot
                     │
                0..1 │
                     │
                 Vehicle
                    ▲
                    │
        ┌───────────┘
        │
      Ticket
        │
        │
     Payment

ParkingLot ───────── EntryGate
ParkingLot ───────── ExitGate
```

---

## Design Decisions

### Composition

- ParkingLot → ParkingFloor
- ParkingFloor → ParkingSlot

### Association

- Ticket → Vehicle
- Ticket → ParkingSlot
- Payment → Ticket
- EntryGate → ParkingLot
- ExitGate → ParkingLot