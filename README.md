# RestServiceCounterApi
Intelliment Task

To consume the paragraph I have given the webservice URL in my service class - "SearchParagraphService.java"
(http://localhost:portnumber/RestServiceCounterApi/paragraph/getText). Once after the hosting the web application change the url details 
in the above mentioned file. 

So, to test the same I have created a Paragraph Controller and Paragraph Service to retrieve the paragraph text.

The following URL's to test the webservice are:

http://localhost:portnumber/RestServiceCounterApi/counter-api/search - For retrieving the count of the search text (Task1)

http://localhost:portnumber/RestServiceCounterApi/counter-api/getTop/5 - For retrieving the highest counts from the sample paragraph (Task 2)

I have created a maven project so after maven install, a war will be generated. Deploy the war file to the web server and testing can be done.



