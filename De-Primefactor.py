#das Programm nimmt eine zahl und teilt sie in Primfaktoren
def Primefactorizer(number):

    while number % 2 == 0:
        print(2)
        number=number/2
        #print(number)debug

    if isPrime(number)==False:

        counter=3
        while counter<number:
            if number % counter ==0:
                print(counter)
                number=number/counter
                #print(number)debug
            counter=counter+1
    print(int(number))



#gibt true/false zuürck wenn number (nicht) eine Primzahl ist
def isPrime(number):

    counter=2
    isPrimeV=True

    if number ==2:
        return True

    while(counter<number):
        if number % counter ==0:
            isPrimeV=False
        counter=counter+1
    return isPrimeV

n = int(input("Bitte gebe eine Zahl an:"))
Primefactorizer(n)
