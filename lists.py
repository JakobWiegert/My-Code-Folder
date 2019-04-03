#(a) Schreiben Sie eine Funktion append_unique(l, x), welche eine neue Liste zurückgibt, die aus den Elementen von l und dem Element x besteht, wenn x nicht in l vorkommt. Ansonsten soll eine neue Liste zurückgegeben werden, welches nur aus den Elementen von l besteht. Die übergebene Liste l soll hier nicht durch Mutation verändert werden.

#Beispiele:

#Der Funktionaufruf append_unique([-1, 5, 3], 4) gibt die Liste [-1, 5, 3, 4] zurück, da 4 nicht in [-1, 5, 3] vorkommt.

#Der Funktionaufruf append_unique([-1, 5, 3], 5) gibt dagegen die Liste [-1, 5, 3] zurück, da 5 in [-1, 5, 3] bereits vorkommt.

#Hinweis: Um eine Kopie einer Liste zu erzeugen, können Sie den Konstruktor list(l) verwenden.


def append_unique(list,toAdd):
    isInList=False
    for i in range(len(list)):
        if list[i]==toAdd:
            isInList=True
    if isInList:
        return list+[]
    else:
        newList= list+[]
        newList.append(toAdd)
        return newList



# Redefinieren Sie eine Funktion without_duplicates(l) unter Verwendung von append_unique. without_duplicates soll eine neue Liste zurückgeben, die jedes Element aus l nur genau einmal enthält. Die Ergebnisliste soll also keine Duplikate enthalten. Die übergebene Liste l soll auch hier nicht durch Mutation verändert werden.

#Beispiele:

#Der Funktionaufruf without_duplicates([-1, 5, 5, 2, -1]) gibt die Liste [-1, 5, 2] zurück.

#Der Funktionaufruf without_duplicates([-1, 5, 2]) gibt dagegen die Liste [-1, 5, 2] zurück.

#Hinweis: Sie dürfen in Teilaufgabe (b) die Funktion aus (a) verwenden, auch wenn Sie den ersten Aufgabenteil nicht gelöst haben.

def without_duplicates(list):
    newList=[]
    for i in range(len(list)):
        newList=append_unique(newList,list[i])
    return newList

list=[-1, 5, 2,2]
print(without_duplicates(list))
