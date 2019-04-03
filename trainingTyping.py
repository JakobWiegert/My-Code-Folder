import random

#creates some random text to train fast typing

words = ["hello", "test", "going", "where", "defcon", "run", "Sam", "Panda",
         "currently", "live", "General", "lol", "Gameboy", "32", "quarry", "Moon", "Money", "Tree", "Clown"]


def randomTextGen(words, length):
    random.seed()
    lenOfText = length
    text = ""

    j = 0
    for i in range(lenOfText - 1):
        j = j + 1
        text = text + " " + str(words[random.randint(0, len(words) - 1)])
        if j == 10:
            text = text + "\n"
            j = 0

    return text


textTest = randomTextGen(words, 1000)
print(textTest)

with open('trainingToTypeFast.txt', 'w') as save:
    save.write(textTest)
