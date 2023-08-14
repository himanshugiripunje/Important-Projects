# To undo existing changes/commits

      git reset --hard HEAD~1
      
# already commited files are to present in working directory
- if you want to add data in your file but you already commited so, in this situation this cmd will get back working-area your code from local-repository.
      
      git reset --mixed HEAD~1
      
# to clone repo in another branch


      - git clone -v branch_name repo_url

# How To Untrack the file

            git rm --cached my_file

# how to undoing the changes
- It is quite possible that you might make some mistake while working on a project.
- Git has two commands to undo your changes yu made.

1. `Reset` - It enables you to revert recent changes you made.
2. `revert`

         git reset --soft HEAD-1
            git reset <reset_type> HEAD-<number of commits to undo>

   `types of field allow following`
- Soft: uncommit and keep (staged) changes
- hard: uncommit and delete changes

REVERT

- Every commit associated with a `hash`



