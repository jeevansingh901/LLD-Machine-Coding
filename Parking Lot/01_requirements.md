# Parking Lot Requirements

## Problem Statement

Design a Parking Lot System capable of parking different types of vehicles, generating parking tickets, calculating parking fees, processing payments, and freeing parking slots when vehicles exit.

---

# Functional Requirements

1. Support Multiple Floors
2. Support Multiple Entry Gates
3. Support Multiple Exit Gates
4. Supoort Different Vehicle Types
   -Bike
   -Car
   -Auto
   -Truck
5. Allocate Nearest avialable Parking Slots.
6. Generate a parking ticket at the Enty.
7. Calculate parking fee during exit.
8. Accept payment.
9. Free the parking slot after successful payment.
10. Prevent parking if no slot is available.

# Non Functional Requirements

1. Extensible design.
2. Follow SOLID principles.
3. Loose coupling.
4. Easy to maintain.
5. Scalable to multiple floors.
6. Easy to test.
7. Production-ready architecture.

---

# Assumptions

- No online reservation.
- One vehicle occupies one slot.
- Payment is done only during exit.
- Parking fee is based on duration.