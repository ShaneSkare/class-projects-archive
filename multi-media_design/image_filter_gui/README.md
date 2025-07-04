# HW3 Image Filter GUI

This project is a GUI-based image filtering app written in Python using **PySide6** and **Pillow (PIL)**. It allows users to search a library of images using tags or titles and apply a set of manipulations like sepia tone, negative, grayscale, or thumbnail resize.

## Features
- Search images by keywords using metadata (title and tags)
- View results instantly in the GUI
- Apply one of five filter effects:
  - None (original)
  - Sepia
  - Negative
  - Grayscale
  - Thumbnail (1/4 size)
- Displays result using QPixmap + PIL.ImageQt

## File Structure

hw3_image_filter_gui/
│
├── gui.py # Main GUI logic
├── functions.py # Image search and manipulation functions
├── image_info.py # Metadata for images (dictionary list)
├── hw3_images/ # Folder containing input JPGs
│ ├── 1.jpg
│ ├── 2.jpg
│ └── no_results.jpg
└── README.md

shell
Copy
Edit

## How to Run

### Install Requirements
`ash
pip install PySide6 Pillow
Run the App
bash
Copy
Edit
python gui.py
Sample Use
Enter a search term (e.g., "beach" or "cat").

Select a filter type from the dropdown.

Click Search.

Resulting image appears in a new window.

Notes
Ensure image_info.py provides image metadata like:

python
Copy
Edit
image_info = [
    {'id': '1', 'title': 'Beach Sunset', 'tags': ['sunset', 'beach']},
    {'id': '2', 'title': 'Forest Walk', 'tags': ['trees', 'nature']},
]
The fallback image no_results.jpg is displayed if no match is found.

