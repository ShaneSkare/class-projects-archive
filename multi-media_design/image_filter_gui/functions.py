# Title: functions.py
# Description: Provides the backend logic for image searching and manipulation.
#              Includes filtering functions and image data lookup for a PySide6 GUI.
# Author: Shane Skare
# Date: 07/03/2024

import os
from PySide6.QtGui import QImage, QPixmap, QColor
from image_info import image_info
from PIL import Image

def my_search(search_term):
    search_term = search_term.lower()
    max_matches = 0
    matches = []

    for info in image_info:
        title_matches = search_term in info['title'].lower()
        tag_matches = [search_term in tag.lower() for tag in info['tags']]
        total_matches = title_matches + sum(tag_matches)
        matches.append(total_matches)

        if max_matches < total_matches:
            max_matches = total_matches

    if max_matches > 0:
        for i, num in enumerate(matches):
            if num == max_matches:
                return os.path.join('hw3_images', f'{image_info[i]['id']}.jpg')
    return os.path.join('hw3_images', 'no_results.jpg')

def my_manipulations(manipulation, image):
    if manipulation == 'None':
        return image
    elif manipulation == 'Sepia':
        return sepia(image)
    elif manipulation == 'Negative':
        return negative(image)
    elif manipulation == 'Grayscale':
        return grayscale(image)
    elif manipulation == 'Thumbnail':
        return thumbnail(image)
    return image

def sepia(image):
    w,h = image.width, image.height
    my_trgt = Image.new('RGB', (w,h))

    for y in range(h):
        for x in range(w):
            pixel = image.getpixel((x,y))
            if pixel[0] < 63:
                r,g,b = int(pixel[0] * 1.1), pixel[1], int(pixel[2] * 0.9)

            elif pixel[0] > 62 and pixel[0] < 192:
                r,g,b = int(pixel[0] * 1.15), pixel[1], int(pixel[2] * 0.85)

            else:
                r = int(pixel[0] * 1.08)
                g,b = pixel[1], int(pixel[2] * 0.5)
      
            my_trgt.putpixel((x, y), (r,g,b))
    return my_trgt

def negative(image):
    new_list = [  (255-a[0], 255-a[1], 255-a[2])  for a in image.getdata() ]
    image.putdata(new_list)
    return image

def grayscale(image):
    new_list = [ ( (a[0]+a[1]+a[2])//3, ) * 3 for a in image.getdata() ]
    image.putdata(new_list)
    return image

def thumbnail(image):
    w, h = image.width//2, image.height//2
    my_trgt = Image.new('RGB', (w+1, h+1))

    target_x = 0
    for source_x in range(0, image.width, 2):
        target_y = 0
        for source_y in range(0, image.height, 2):
            p = image.getpixel((source_x, source_y))
            my_trgt.putpixel((target_x, target_y), p)
            target_y += 1
        target_x += 1
    return my_trgt