
import random
def easyAI():
    value = random.randint(0,6)
    with open("easyAI.txt", "w") as f:
        f.write(value)

if __name__ == "__main__":
    easyAI()