#import numpy

# Sortiere Array a mit Insertionsort
def insertion_sort(a) :

	for i in range(len(a)) :

		j = i
		ins = a[i]  # merkt sich das einzufügende Element

		while j > 0 and ins < a[j-1] :
			a[j] = a[j-1]  # verschiebe aktuelles Element
			j = j - 1

		a[j] = ins  # füge das gemerkte Element ein


# Testprogramm

arr = [1,2,4,5,9,0,7,2,3,1]
#arr = numpy.array([1,2,4,5,9,0,7,2,3,1])
insertion_sort(arr)
print(arr)
