# Title: Median Filter
# Description: This program loads a set of PNG images and applies a pixel-by-pixel median filter
#              to create a noise-reduced composite image. It uses PIL for image processing and
#              `glob` to locate files by extension. Includes support for multiple image sets.
# Author: Shane Skare
# Date: 06/21/2024

from PIL import Image
from glob import glob

img_list = []

def median_a_picture(images):
    width, height = images[0].size
    new_image = Image.new('RGB', (width, height))

    for x in range(width):
        for y in range(height):

            red_values = [images[k].getpixel((x, y))[0] for k in range(len(images))]
            green_values = [images[k].getpixel((x, y))[1] for k in range(len(images))]
            blue_values = [images[k].getpixel((x, y))[2] for k in range(len(images))]

            new_image.putpixel((x,y),(my_median(red_values), my_median(green_values), my_median(blue_values)))

    return new_image

def load_images(location, type):
    for image in glob(f'{location}/*.{type}'):
        with Image.open(image) as img:
            img_list.append(img.copy())

# Task 1 - Code for my_median() function -------------------------------------------------------------------
def my_median(list):
    list.sort()
    n = len(list)
    median = list[n//2]
    return median

# Task 2---------------------------------------------------------------------------------------------------

load_images('task2_images', 'png')
print(img_list)
new_image = median_a_picture(img_list)
new_image.show()
new_image.save('task2.png')


width, height = new_image.size
for x in range(width):
    for y in range(height):
        rgb_values = [new_image.getpixel((x, y))]
        print(f"Pixel ({x}, {y}): {rgb_values}")

img_list.clear()


# Task 3----------------------------------------------------------------------------------------------------
load_images('task3_images', 'png')
print(img_list)
new_image = median_a_picture(img_list)
new_image.show()
new_image.save('task3.png')


my_list = [2, 4, 6, 237, 1]
print(my_median(my_list))
print(my_list)
