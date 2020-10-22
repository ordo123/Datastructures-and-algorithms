/**********************************************************************
 *  Mönsterigenkänning readme.txt
 **********************************************************************/

 Ungefärligt antal timmar spenderade på labben (valfritt): 12-14h

/**********************************************************************
 *  Empirisk    Fyll i tabellen nedan med riktiga körtider i sekunder
 *  analys      när det känns vettigt att vänta på hela beräkningen.
 *              Ge uppskattningar av körtiden i övriga fall.
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
 *  Teoretisk   Ge ordo-uttryck för värstafallstiden för programmen som
 *  analys      en funktion av N. Ge en kort motivering.
 *
 **********************************************************************/

Brute: O(n^4)

Det är 4:st for looparna nästlade i varandra. Allt annat tar konstant tid


Sortering: 0(n^2 log n)


n log n


Vår sortering har 2 for loopar nästlade i varandra. Sorteringen
