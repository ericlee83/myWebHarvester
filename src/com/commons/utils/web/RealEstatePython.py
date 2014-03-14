#!/usr/bin/env python
from pyvirtualdisplay import Display
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

display = Display(visible=0, size=(800, 600))
display.start()

# now Firefox will run in a virtual display. 
# you will not see the browser.
browser = webdriver.Firefox()


browser.get('http://www.realestate.com.au/buy')
WebDriverWait(browser,1).until(EC.visibility_of_element_located((By.ID,'where')))
browser.find_element_by_id('includeSurrounding').click()
browser.find_element_by_id('where').clear()
browser.find_element_by_id('where').send_keys('Burwood, NSW 2134')
browser.find_element_by_id('searchBtn').click()
WebDriverWait(browser,3).until(EC.visibility_of_element_located((By.ID,'propertyType')))
browser.find_element_by_id('propertyType').click()
WebDriverWait(browser,3).until(EC.visibility_of_element_located((By.XPATH,'//input[@id="ddCb_propertyType_2"]')))
browser.find_element_by_xpath('//input[@type="checkbox" and @value="unit apartment"]').click()
browser.find_element_by_css_selector('button.button.plusplus').click()
eList = browser.find_elements_by_xpath('//div[starts-with(@id,"results_")]')
for element in eList:
        temp = element.find_element_by_css_selector('a.name')
        if 'burwood' in temp.get_attribute('href'):
                print temp.get_attribute('href')

browser.quit()

display.stop()

