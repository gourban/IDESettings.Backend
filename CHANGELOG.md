# Changelog

Versioning note: configs are distributed as immutable, numbered files (e.g. `goUrban_v3.xml`)
consumed via raw GitHub URLs, so a "new version" is a new file rather than an edit to an existing
one. Pick the highest version unless you have a reason not to.

## CheckStyle — `checkStyleConfig/goUrban_v3.xml`
- Added `jakarta` support for the Spring Boot 2 -> 3 migration by adding
  `standardPackageRegExp = ^(java|jakarta|javax)\.` to the existing `CustomImportOrder` module, so
  `jakarta` groups contiguously with `java`/`javax` instead of falling into `THIRD_PARTY_PACKAGE`.
  The other groups stay blank-separated.
- Set `sortImportsInGroupAlphabetically = false`. Alphabetical sorting would force `jakarta, java,
  javax`, but the desired order is `java, jakarta, javax`; CustomImportOrder cannot enforce a custom
  within-group order, so the order is produced by the shared IntelliJ CodeStyle. CheckStyle still
  enforces grouping, contiguity of the family, and blank-line separation between groups.
- Backwards compatible: code with no `jakarta` imports cannot newly fail — the only change versus
  `goUrban_v2` is the relaxation of within-group alphabetical enforcement (IntelliJ still sorts on
  Optimize Imports). The rest of the ruleset is unchanged.
- Verified to load and run on Checkstyle 13.x (the version pin in the CheckStyle-IDEA plugin was
  previously a 10.x release; no config changes were needed for the engine upgrade).
- Pinned the runtime suppression file to the versioned `suppression_v3.xml` (instead of the shared
  `suppression.xml`) so this config version is reproducible and unaffected by later suppression edits.

## CheckStyle — `checkStyleConfig/goUrban_v2.xml`
- Updated `PackageName` pattern to allow underscores (Java style).
- Replaced the removed `JavadocMethod` `scope` property with `accessModifiers`.

## CheckStyle — `checkStyleConfig/goUrban_v1.xml`
- Initial Google-style configuration.

## CodeStyle — `codestyles/goUrban_v2.xml`
- Added `jakarta` to the import layout, contiguous with `java` and `javax` (order: `java`, `jakarta`,
  `javax`, no blank line between them) to match CheckStyle `goUrban_v3.xml`. This codestyle is what
  produces the `java -> jakarta -> javax` order on Optimize Imports.
- Normalised the legacy top-level `IMPORT_LAYOUT_TABLE` to the same `java`/`jakarta`/`javax` order
  (it previously listed `javax` before `java`).

## CodeStyle — `codestyles/goUrban_v1.xml`
- Initial code style scheme.
