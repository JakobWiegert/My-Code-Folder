
def quer(num):
    if num <= 9:
        return num
    else:
        return num % 10 + int(quer(num / 10))


print(quer(345))
