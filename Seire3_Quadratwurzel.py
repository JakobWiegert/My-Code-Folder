# berechnet die Quadraturzel von n, wenn sqrt(n) nicht berechnebar ist, nehme n-1
def Teethbreaker(n):

    counter = 0
    isBreakable = False

    while(counter < n):
        if (counter * counter) == n:
            isBreakable = True
            return counter
        else:
            counter = counter + 1
    if isBreakable == False:
        return Teethbreaker(n - 1)


print("Ich gebe dir die Wurzel einer ganzen Zahl zurück, wenn du mir eine Zahl gibts die keine Wurzel hat nehme ich einfach die nächst Kleinere zum Wurzelziehen :)")
n = int(input("Bitte gib nun die Zahl an:"))
print(Teethbreaker(n))
