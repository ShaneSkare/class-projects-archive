# Title: HW4 - Flask Image Gallery
# Description: A Flask web application that displays three random images from a dataset and 
#              shows detailed metadata when an image is clicked. Uses HTML, CSS, Flask, 
#              Bootstrap, and Pillow for image rendering and formatting.
# Author: Shane Skare
# Date: 07/10/2024
# Notes:
# - Uses `url_for()` for routing and accessing static assets.
# - Image metadata is pulled from a `image_info.py` file and image file using Pillow.
# References:
#   https://www.geeksforgeeks.org/flask-url-helper-function-flask-url_for/
#   https://sentry.io/answers/serve-static-files-flask/

import random
from flask import Flask, render_template, flash, redirect
from flask_bootstrap import Bootstrap5
from PIL import Image
from wtforms.validators import DataRequired
from image_info import image_info

app = Flask(__name__)
bootstrap = Bootstrap5(app)

@app.route('/')
def index():
   three_images = []
   random.shuffle(image_info)

   for i in range(0,9,4):
      three_images.append(image_info[i])
   return render_template('index.html', images=three_images)

@app.route('/detail/<image_id>')
def detail(image_id):

   photo = {}
   for img in image_info:
      if img['id'] == image_id:
         photo['title'] = img['title']

   image_path = f'static/images/{image_id}.jpg'
   with Image.open(image_path) as img:
      photo['format'] = img.format
      photo['mode'] = img.mode
      photo['width'], photo['height'] = img.size
      photo['id'] = f'images/{image_id}.jpg'

   return render_template('detail.html', photo=photo)
   
