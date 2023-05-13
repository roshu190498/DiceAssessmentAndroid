# DiceAssessmentAndroid
This is Repository for Dice Assessment Android Date : 10th May 2023

Andrroid Application for searching Gitthub public repo

API DOCS - >
    Api used is in this application from github rest API's 
        https://docs.github.com/en/rest/search?apiVersion=2022-11-28
        
    Please refer APIs docs -https://docs.github.com/en/rest/search?apiVersion=2022-11-28#search-repositories
    
    curl -L \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer <YOUR-TOKEN>"\
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/search/repositories?q=Q
  
    
  
  Application Docs
  
    Home Page 
        Home Page has search functionality with sorting params 
        
        use search bar for add a user query 
        
        based on user query we have multiple scenario Error and SUCCESS
        please find attached screenshot for same 

        ![](../../home1.png)![](../../home2.png)![](../../home3.png)![](../../home4.png)
        

    PDP Page : 
        Product Descripttion Page detail view for a repo selected
        ![](../../pdp.png)

        Go to repo url by clicking know more