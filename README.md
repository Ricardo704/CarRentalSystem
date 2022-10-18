# MyCar Online Vehicle Booking System
### Author: Ruoqian Zhang 


## Functionalities Achieved
- Menu selection and user input operations  
- Basic input validation  
- Calculation of payment  
- Vehicle information and reservation details printing  
- All information from the given file parsed correctly  

## Unit Testing
Unit testings are implemented to "VehicleUtil", "InputUtil" and "InputReader" classes,
covered most searching functionalities, payment calculations and input validations.   
> Tested methods:  
>- searchByBrand
>- searchByType
>- searchByPassengers
>- searchByID
>- calculateTotalFee
>- printDetails
>- testGetRentDay
>- checkEmail
>- csvRead

## Input Validation & Exception handling  
Implemented in following methods:
>- getInteger - The method to check if input is an integer, used in following methods:   
>  + main 
>  + selectVehicle
>  + filterByPassenger
>  + reserve  
>- getRentDay
>- checkEmail

## Additional functionalities 
Validated if user's input for passenger number is less or equal to the number of seats in the vehicle to be reserved.

    
