

list1 = [0, 2, 4, 6, 8, 10]
list2 = [1, 3, 5, 7, 9, 11]


def listMerging1(list1, list2):
    newList = []
    counterList1 = 0
    counterList2 = 0
    while(counterList1 < len(list1) or counterList2 < len(list2)):

        if counterList1 == len(list1) and counterList2 != len(list2):
            newList.append(list2[counterList2])
            counterList2 = counterList2 + 1

        elif counterList1 != len(list1) and counterList2 == len(list2):
            newList.append(list1[counterList1])
            counterList1 = counterList1 + 1

        else:
            if list1[counterList1] < list2[counterList2]:
                newList.append(list1[counterList1])
                counterList1 = counterList1 + 1

            elif list1[counterList1] > list2[counterList2]:
                newList.append(list2[counterList2])
                counterList2 = counterList2 + 1

    return newList


print(listMerging1(list1, list2))
# no numpy found
