# Klassendefinition für eine Menge


class Set:

    # Konstruktor für leere Menge
    def __init__(self):
        self.l = []

    # Prüfe ob Element x in Menge vorkommt
    def has_elem(self, x):
        i = 0
        while i < len(self.l) and self.l[i] != x:
            i = i + 1
        return i < len(self.l)

    # Füge Element x zur Menge hinzu
    def add_elem(self, x):
        if not self.has_elem(x):
            self.l.append(x)

    # Entferne Element x aus der Menge
    def delete_elem(self, x):
        i = 0
        while i < len(self.l) and self.l[i] != x:
            i = i + 1
        if i < len(self.l):
            self.l[i:i + 1] = []

       # checkt ob die Menge leeer ist
    def is_empty(self):
        if self.l == []:
            return True
        return False

# printet die Menge aus
    def __str__(self):
        return "Menge"+str(self.l)

    # addiert 2 mengen
    def union(self, toAdd):
        for i in range(len(toAdd.l) ):
            self.add_elem(toAdd.l[i])

    # welche in einer Menge nur die Elemente lässt, die in einer zweiten Menge auch vorkommen (Schnitt)
    def intersect(self, toCut):
        for i in range(len(toCut.l) ):
            if not self.has_elem(toCut.l[i]):
                self.delete_elem(toCut.l[i])

    # welche aus einer Menge alle Elemente enfernt, die in einer zweiten Menge auch vorkommen (Differenz).
    def difference(self, toSub):
        for i in range(len(toSub.l)):
            if self.has_elem(toSub.l[i]):
                self.delete_elem(toSub.l[i])

    # welche alle Elemente einer Liste zu der Menge hinzufügt
    def add_list(self, list):
        for i in range(len(list) ):
            self.add_elem(list[i])

       # gibt die liste zurück
    def to_list(self):
        giveItBack = []
        for i in range(len(self.l) ):
            giveItBack.append(self.l[i])
        return giveItBack

#debug

test = Set()
test2 = Set()
k = 0
while k < 100:
    test.add_elem(k)
    test2.add_elem(k * 2)
    k = k + 1

print(test.l[len(test.l) ])
list1 = test.to_list()
print(test)

print(list1[1])
