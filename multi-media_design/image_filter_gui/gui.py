# Title: gui.py
# Description: This file defines the GUI for an image filter app built with PySide6.
#              It allows users to search images based on keywords and apply visual
#              effects like Sepia, Grayscale, Negative, and Thumbnail.
# Author: Shane Skare
# Date: 07/03/2024

import sys
from PySide6.QtWidgets import (QApplication, QWidget, QLabel, QVBoxLayout, QLineEdit, QPushButton, QComboBox, QGroupBox)
from PySide6.QtGui import QPixmap
from PySide6.QtCore import Qt
from functions import my_search, my_manipulations
from image_info import image_info
from PIL import Image, ImageQt
from __feature__ import snake_case, true_property

my_qt_app = QApplication([])

class ShowImage(QWidget):
    def __init__(self, image):
        super().__init__()
        label = QLabel()
        my_pixmap = QPixmap.from_image(ImageQt.ImageQt(image))
        # my_pixmap = QPixmap(image)
        label.pixmap = my_pixmap
        self.layout = QVBoxLayout()
        self.layout.add_widget(label)
        self.set_layout(self.layout)
        self.show()

class ImageSelector(QWidget):
   def __init__(self):
      super().__init__()

      self.resize(800, 600)
      main_layout = QVBoxLayout()
      group_box = QGroupBox("Image Search")
      search_layout = QVBoxLayout()
        
      self.lbl1 = QLabel('Enter search term and select an image manipulation:')
      search_layout.add_widget(self.lbl1)
        
      self.search_input = QLineEdit(self)
      search_layout.add_widget(self.search_input)
        
      self.my_dropdown = QComboBox(self)
      self.my_dropdown.add_items(['None', 'Sepia', 'Negative', 'Grayscale', 'Thumbnail'])
      search_layout.add_widget(self.my_dropdown)
        
      self.button = QPushButton('Search', self)
      self.button.clicked.connect(self.on_click)
      search_layout.add_widget(self.button)

      group_box.set_layout(search_layout)
      main_layout.add_widget(group_box)
      self.set_layout(main_layout)


   def on_click(self):
      manipulation = self.my_dropdown.current_text
      search_term = self.search_input.display_text
      image = Image.open(my_search(search_term))
      altered_image = my_manipulations(manipulation, image) 

      my_window = ShowImage(altered_image)
      my_window.show()  


image1 = ImageSelector()
image1.show()
sys.exit(my_qt_app.exec())