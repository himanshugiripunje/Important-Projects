# To undo existing changes/commits

      git reset --hard HEAD~1

- If you're working with a file that should never be tracked (such as sensitive configuration files), you might also want to add the file to your repository's `.gitignore` file to prevent accidental tracking in the future.
      
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
- ![image](https://github.com/himanshugiripunje/Important-Projects/assets/99471014/6f47e9e0-b1be-47bb-abf4-3c8b3effe56a)
-
- You can undo a specific commit using the revert command and its hash
- ![image](https://github.com/himanshugiripunje/Important-Projects/assets/99471014/10fbb91c-41b4-49dc-be78-056a0bab6f98)
- Note{ an  Addtional commit is adding on reverting modification}

`To create a new branch use:`

             git checkout -b <new branch name>
`To switch to an existing branch use:`

             git checkout <branch name>

# Meerge
- After working on a branch, you may need to updating another branch with the code from the current branch

# Conflict
- After merging branches if in both of the branches, the same part of the same file was updated, git doesn't know which change to keep and which to discard.
- So git creates a conflict message for manual review.

![image](https://github.com/himanshugiripunje/Important-Projects/assets/99471014/867331c0-a3d0-46d6-a97f-6d402998668c)


- The conflict message outlines where the conflict occurred as well as the current (available in the branch) and incoming changes (merging from another branch).
- After resolving the conflict, you need to commit to save the resolved merge.

# Pull Request
- Pull requests let you tell others about changes you've pushed to a branch in a repository on GitHub.
- Once a pull request is opened, you can discuss and review the potential changes with collaborators and add follow-up commits before your changes are merged into the base branch.









