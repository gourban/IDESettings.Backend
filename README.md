# CodeStyle
File -> Settings -> Tools -> Settings Repository
Add https://github.com/gourban/IDESettings.Backend to the "Read-only Sources"

Then synchronize the settings by calling VCS -> Sync Settings -> Merge

Make sure the correct CodeStyle config is avtive:
File -> Settings -> Editor -> CodeStyle
It should say "goUrban_v2" after "Scheme:"

# CheckStyle Setup
## Plugin installation
File -> Settings -> Plugins -> Marketplace -> CheckStyle-IDEA

## Checkstyle version
Set the Checkstyle version used by the plugin to the latest available
(File -> Settings -> Other Settings -> Checkstyle -> "Checkstyle version").
It was previously pinned to a 10.x release; `goUrban_v3.xml` is verified to run on Checkstyle 13.x.

## Set checkStyle config
File -> Settings -> Other Settings -> Checkstyle
Set "Scan Scope" to "Only Java sources (including tests)"
Add configuration file from URL "https://raw.githubusercontent.com/gourban/IDESettings.Backend/master/checkStyleConfig/goUrban_v3.xml" and set it active

# Import order convention
`goUrban_v3` (CheckStyle) and `goUrban_v2` (CodeStyle) add support for the `jakarta` package
introduced by the Spring Boot 2 -> 3 migration. `jakarta` is grouped together with `java` and
`javax` as one contiguous block (no blank line between the three), ordered `java`, `jakarta`,
`javax`. Other groups are separated by a single blank line:

```
<static imports>

<same-package imports>

java.*
jakarta.*
javax.*

<everything else>
```

How it is enforced: CheckStyle (`goUrban_v3`) guarantees that `jakarta` is grouped with `java`/`javax`,
that the three are contiguous, and that the other groups are blank-separated. The `java -> jakarta ->
javax` order *within* that block is produced and maintained by the shared IntelliJ CodeStyle
(`goUrban_v2`) on Optimize Imports — CheckStyle does not enforce a custom (non-alphabetical) order
within a group, so it is not checked there. In practice everyone formats with the shared CodeStyle,
so the order stays consistent.

This is backwards compatible: code with no `jakarta` imports cannot newly fail (`goUrban_v3` only
relaxes within-group alphabetical enforcement relative to `goUrban_v2`; IntelliJ still sorts on
Optimize Imports).

