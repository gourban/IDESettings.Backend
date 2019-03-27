# CodeStyle
File -> Settings -> Tools -> Settings Repository
Add gourban@vs-ssh.visualstudio.com:v3/gourban/Core/IDESettings.Backend to the "Read-only Sources"

Then synchronize the settings by calling VCS -> Sync Settings -> Merge

Make sure the correct CodeStyle config is avtive:
File -> Settings -> Editor -> CodeStyle
It should say "goUrban_v1" after "Scheme:"

# CheckStyle Setup
## Plugin installation
File -> Settings -> Plugins -> Marketplace -> CheckStyle-IDEA

## Set checkStyle config
File -> Settings -> Other Settings -> Checkstyle
Set "Scan Scope" to "Only Java sources (including tests)"
Add configuration file "checkStyleConfig/google_checks.xml" and set it active

