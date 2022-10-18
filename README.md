# MyCar Online Vehicle Booking System
### Author: Ruoqian Zhang - s3933329
***
## Instruction on how to compile and run Java program from command line
1. Set JAVA_HOME environment variable in your system.  
   Windows 10: https://www.youtube.com/watch?v=104dNWmM6Rs  
   Mac OS Big Sur: https://www.youtube.com/watch?v=9nKIcK5-uxE
2. Follow the instructions below to compile and run the program.  
   - Open the terminal and navigate to the folder where you unzip this folder.   
   - Compile the program using javac. Note *.java represent one or multiple Java files under the folder.
   - Run the program using java. Note -cp represents -classpath which is used to find classes.
***

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

    
