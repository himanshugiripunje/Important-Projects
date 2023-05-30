# if my jenkins user is forgotten
- cat /var/lib/jenkins/config.xml 
- ![image](https://github.com/himanshugiripunje/Theory-notes/assets/99471014/2cf097d0-6855-4f7a-a520-c7cb6a8eadf0)
- Apply Changes –
-  Restart Jenkins service to apply the changes.

**Again access in a web browser**
-  ![image](https://github.com/himanshugiripunje/Theory-notes/assets/99471014/789bba10-e683-4ba5-86ce-2c909e65875d)

*Delete Admin Account – Select the Admin user account to delete. Then click the "Delete" button to detele the selected account:*
- Enable Security Again 
- Now once you deleted old admin user. 
- To reset all security options, go to the “Jenkins” ->“Manage Jenkins” option in left-hand side option lists. Now click on the “Configure Global Security” option

*You will see all option as bellow, do all below mentioned changes on this page*
- Enable the “Enable Security” option.
- In Security Realm option select “Jenkins own database”
- **Make sure to uncheck the “Allow users to sign up” option under the “Jenkins own database” option.**

![image](https://github.com/himanshugiripunje/Theory-notes/assets/99471014/bb1dc0f6-31f4-437b-a0dc-cf8c49103f5c)

# And
![image](https://github.com/himanshugiripunje/Theory-notes/assets/99471014/91ae6aea-17eb-4488-988c-1f73e532853c)

- Save Changes – Save all changes made above.
- Create Admin Account – You will be redirected to “Create First Admin User”. Input all required details to create a new Admin account.

![image](https://github.com/himanshugiripunje/Theory-notes/assets/99471014/2fe83001-c704-42ae-bef6-f6570557097a)
- Login as New Admin User – Now, you can access your Jenkins dashboard using the newly created Admin account.
- 
