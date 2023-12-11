#!/usr/bin/env python
# coding: utf-8

# In[3]:


import requests
from concurrent.futures import ThreadPoolExecutor

URL = "http://localhost:8003/api/v1/weather-details" 
TOTAL_REQUESTS = 10000  

def send_request():
    response = requests.get(URL)
    print(response.json)

with ThreadPoolExecutor(max_workers=100) as executor:
    futures = [executor.submit(send_request) for _ in range(TOTAL_REQUESTS)]

for future in futures:
    future.result()


# In[ ]:




