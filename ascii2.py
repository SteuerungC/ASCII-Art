from PIL import Image
import sys

def avg(array, multi=True):
    return sum(array)/len(array)


image_file = sys.argv[1]
if sys.argv[2] == "m":
    multicolor = True
else:
    multicolor = False
    
image = Image.open(image_file)
pix = image.load()

for y in range(image.height):
    for x in range(image.width):
        if multicolor == True:
            darkness = avg(pix[x, y])
        else:
            darkness = pix[x, y]
        if darkness < 25:
            print("@", end="")
        elif darkness > 25 and darkness <= 50:
            print("#", end="")
        elif darkness > 50 and darkness <= 75:
            print("&", end="")
        elif darkness > 75 and darkness <= 100:
            print("$", end="")
        elif darkness > 100 and darkness <=125:
            print("%", end="")
        elif darkness > 125 and darkness <= 150:
            print("+", end="")
        elif darkness > 150 and darkness <=175:
            print("+", end="")
        elif darkness > 175 and darkness <=200:
            print(":", end="")
        elif darkness > 200 and darkness <=225:
            print("*", end="")
        elif darkness > 225 and darkness <=235:
            print(".", end="")
        elif darkness > 235:
            print(" ", end="")
            
    print()