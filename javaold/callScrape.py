from mathematicians import simple_get
website = input("What is the URL of the degree requirments page of your university?: ")
type(website)
raw_html = simple_get(website)
len(raw_html)
f = open("degree.html", "wb")
f.write(raw_html)