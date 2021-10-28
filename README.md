Prerequsites:
1. Running Docker container with MySql DB
2. Db port 3306
3. Change username and password in application.properties
4. Run the application
5. Add Companies trough Post /addCompany
   {
   "companyName":""
   }
   Or trought SQL Script to company Table
   
6.Add users trough Post /addUser
{
"lastName":"Smith",
"firstName":"John",
"company_id":"1"
}
Or trought SQL Script to appUser Table