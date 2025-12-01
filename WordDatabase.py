

def getFile():
    file = open("wordsAdd.txt", "r")
    words = file.read().splitlines()
    file.close()
    return words

def checkDuplicate(word: str) -> bool:
    file = open("MiniPlay/src/main/resources/word_database.txt", "r")
    words = file.read().splitlines()
    file.close()
    try:
        words.index(word)

    except ValueError:
        return False
    
    return True

def splitWordFromClue(lines: list):
    for line in lines:
        word, clue = line.split(" ", 1)
        if not checkDuplicate(word):
            wordFile = open("MiniPlay/src/main/resources/word_database.txt", "a")
            clueFile = open("MiniPlay/src/main/resources/clue_database.txt", "a")
            wordFile.write("\n" + word)
            clueFile.write("\n" + clue)
            wordFile.close()
            clueFile.close()
            print("Not Dup")

        print(f"Word: {word}, Clue: {clue}")


splitWordFromClue(getFile())