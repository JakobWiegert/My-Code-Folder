def ggt(a, b):
    if a == b:
        return a
    else:
        if a > b:
            return ggt(a - b, b)
        else:
            return ggt(b - a, a)


print(ggt(12, 18))
