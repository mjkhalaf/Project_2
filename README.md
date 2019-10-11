# Project_2
First the Abstract class MesoStation was edited to containt the methods the calclates letter averages and ASCEII averages on the letters of
certain station ID. The MesoInherit class extends teh abstract class to implement both methods in MesoAbstract. In this class the Mehtod 
readFile is written. This methods reads each line and stores it in a temporary array and the substring of the station ID gets copied into
the private array variable of totalStations. The calAverage() claculates the average of the asceii values of the station ID determines. 
the floor value of the average is determined by first integer value below the average and the ceiling is determined by doing the opposite, 
if the difference between the average and the floor is less than 0.5 the average is set equal to the floor, and set to equal the ceiling
otherwise. The letterAverage() method returns the char representation of the average calcualted in calAverage(). getTotalStations() and 
getStationID() were created to help access these information from other classes. 
The PosAvg class was created and it extends MesoInherit. This class constructor sets the stationID variable and extracts the totalStations
array from MesoInherit. The indexOfStation() calcualtes the number order on the list of the station ID provided. The calAverage() method
takes the index number provided by indexOfStation() and finds two pairs of stations around the index such that when the pair's indcies are
averaged are equal to the orginal index of the station. The toSting() method returns the string formated as instructed on the prompt.
The LetterAvg class was created and it extend MesoInherit as well. The constructor initializes the char average varible provided and
access the totalStations list of MesoInherit. The method numberOfStationWithLetterAvg() looks throw the array to find the number of stations 
that begin with the same letter provided in letAvg, it also keeps track of those stations and stores them in an array.
