#counts the number of chars in a string
def count_occurrences(t, z):
    def count_helper(i):
        if i >= len(t):
            return 0
        else:
            if t[i] == z:
                return 1 + count_helper(i + 1)
            else:
                return count_helper(i + 1)
    return count_helper(0)


print(count_occurrences("heö,,ssflloö", "s"))
