/**********************************************************************
 *  M�nsterigenk�nning readme.txt
 **********************************************************************/

 Ungef�rligt antal timmar spenderade p� labben (valfritt): 12-14h

/**********************************************************************
 *  Empirisk    Fyll i tabellen nedan med riktiga k�rtider i sekunder
 *  analys      n�r det k�nns vettigt att v�nta p� hela ber�kningen.
 *              Ge uppskattningar av k�rtiden i �vriga fall.
 *
 **********************************************************************/
    
      N       brute       sortering
 ----------------------------------
    150       25ms           7ms
    200       40ms           12ms
    300       60ms           24ms
    400       114ms          40ms
    800       624ms          119ms
   1600       5116ms         422ms
   3200       44281ms        1717ms
   6400       ~39sek         7.4sek
  12800       ~353sek        ~33sek


/**********************************************************************
 *  Teoretisk   Ge ordo-uttryck f�r v�rstafallstiden f�r programmen som
 *  analys      en funktion av N. Ge en kort motivering.
 *
 **********************************************************************/

Brute: O(n^4)

Det �r 4:st for looparna n�stlade i varandra. Allt annat tar konstant tid


Sortering: 0(n^2 log n)


n log n


V�r sortering har 2 for loopar n�stlade i varandra. Sorteringen
