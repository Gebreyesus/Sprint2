# Chase Strickler
# I'm following the tutorial from freeCodeCamp found here: https://medium.freecodecamp.org/how-to-scrape-websites-with-python-and-beautifulsoup-5946935d93fe
# to learn how to scrape data from the web, specifically courses.

# import libraries
import urllib.request 
from bs4 import BeautifulSoup

# specify url
quote_page = 'http://www.augsburg.edu/cs/courses/'

# query the website and return the html to the variable 'page'
page = urllib.request.urlopen(quote_page)

# parse the html using beautiful soup and store in variable 'soup'
soup = BeautifulSoup(page, 'html.parser')

#  Take out the <div> of service id and get its value
service_id_box = soup.find('div', attrs={'class':'service_id'})

print(service_id_box)
service_id = service_id_box.text.strip() # strip() is used to remove starting and trailing

print (service_id)