# Median Filter Image Processor

This Python project applies a median filter to a stack of PNG images to reduce noise and generate a cleaner composite image. The program uses the Pillow library for image manipulation and glob to gather input files from specified folders.

## Features
- Loads all images in a given folder (by extension)
- Applies a pixel-wise median filter across multiple images
- Outputs a new image with noise-reduced pixels
- Prints RGB values of each pixel (optional debug)

## Project Structure
- 	ask2_images/ – Folder containing input PNGs for Task 2
- 	ask3_images/ – Folder containing input PNGs for Task 3
- 	ask2.png and 	ask3.png – Output composite images

## How to Run

### Requirements
`ash
pip install Pillow
Run
bash
Copy
Edit
python median_filter.py
Output
Opens and saves task2.png and task3.png after filtering

Sample Output
less
Copy
Edit
Pixel (0, 0): [(120, 125, 130)]
Pixel (1, 0): [(118, 122, 127)]
...
Notes
my_median() uses in-place sort and returns middle element

Prints final pixel RGB values for verification (can be commented out)

Assumes all input images are the same size

References
Pillow Documentation

GeeksForGeeks - List Size

GeeksForGeeks - glob for recursion

