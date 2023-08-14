# To undo existing changes/commits

      git reset --hard HEAD~1
      
# already commited files are to present in working directory
- if you want to add data in your file but you already commited so, in this situation this cmd will get back working-area your code from local-repository.
      
      git reset --mixed HEAD~1
      
# to clone repo in another branch


      - git clone -v branch_name repo_url

# How To Untrack the file

            git rm --cached my_file
