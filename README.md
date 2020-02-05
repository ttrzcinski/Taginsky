# Taginsky
Creates version tags for CI/CD pipelines and builds.

JAVA APPLICATION working as CI/CD versioning module.
Build version in GIT/JIRA/Jenkins/TeamCity
 
Parts:
  - SET MAJOR VERSION
  - ITERATIVE MINOR VERSION
  - CURRENT DATE AND IT'S PARTS
  - SPRINT_NUMBER
    - JIRA
	  - Read from tag
	  - Read from name
	  - Read from project
  - BUILD (JOB RUN) NUMBER
  - TYPE_OF_BUILD (SNAPSHOT, FIX, HOT_FIX, NIGHTLY_BUILD, EAP, RELEASE, alpha, beta)
  
I/O:
  GIT
    - current git repository
    - remote git repository
  JIRA 
    - API
	- curl with XPath
  Jenkins 
    - API
	- curl with XPath
  - current_data'n'time
  - metadata_of_jar
  - pom_file - version tag
  - Java UUID
  
 ACTIONS:
   - PARSE VERSION from version tag
   - SPLIT VERSION tag into variables
   - INCREMENT VERSION of version tag
   - PASS VERSION as String
   - WRITE VERSION into build or run
