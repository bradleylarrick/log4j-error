# Log4j Errors in Maven Dependency Report

This is a sample program that demonstrates the errors generated during the creation of dependency reports
by the maven-project-info-reports-plugin.

## Environment
JDK: 17  
Maven: 3.9.10  
Log4j: 2.25.1  

## Example

To demonstrate the errors, run:
```
mvn clean site
```

The results include:

```
[INFO] Generating "Maven Coordinates" report --- maven-project-info-reports-plugin:3.8.0:dependency-info
[INFO] Generating "Dependencies" report      --- maven-project-info-reports-plugin:3.8.0:dependencies
[WARNING] Failed to build parent project for org.apache.logging.log4j:log4j-core:jar:2.25.1
[WARNING] Failed to build parent project for org.apache.logging.log4j:log4j-core:jar:2.25.1
[INFO] Unable to create Maven project from repository for artifact 'org.apache.logging.log4j:log4j-core:jar:2.25.1', for more information run with -X
[WARNING] Failed to build parent project for org.apache.logging.log4j:log4j-slf4j2-impl:jar:2.25.1
[WARNING] Failed to build parent project for org.apache.logging.log4j:log4j-slf4j2-impl:jar:2.25.1
[INFO] Unable to create Maven project from repository for artifact 'org.apache.logging.log4j:log4j-slf4j2-impl:jar:2.25.1', for more information run w
ith -X
```
Executing with the -X parameter generates the following:

```
[DEBUG] Extension realms for project org.slf4j:slf4j-bom:pom:2.0.17: (none)
[DEBUG] Looking up lifecycle mappings for packaging pom from ClassRealm[plexus.core, parent: null]
[DEBUG] Unknown source: Modified invalid anchor name 'Project Transitive Dependencies' to 'Project_Transitive_Dependencies'
[DEBUG] Unknown source: Modified invalid anchor name 'Project Transitive Dependencies_compile' to 'Project_Transitive_Dependencies_compile'
[DEBUG] Extension realms for project org.apache.logging.log4j:log4j-api:jar:2.25.1: (none)
[DEBUG] Looking up lifecycle mappings for packaging jar from ClassRealm[plexus.core, parent: null]
[DEBUG] Extension realms for project org.apache.logging.log4j:log4j:pom:2.25.1: (none)
[DEBUG] Looking up lifecycle mappings for packaging pom from ClassRealm[plexus.core, parent: null]
[DEBUG] Extension realms for project org.apache.logging.log4j:log4j-bom:pom:2.25.1: (none)
[DEBUG] Looking up lifecycle mappings for packaging pom from ClassRealm[plexus.core, parent: null]
[WARNING] Failed to build parent project for org.apache.logging.log4j:log4j-api:jar:2.25.1
org.apache.maven.project.ProjectBuildingException: Some problems were encountered while processing the POMs:
[WARNING] 'build.plugins.plugin.version' for org.codehaus.gmavenplus:gmavenplus-plugin is missing. @ line 849, column 15
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-clean-plugin is missing. @ line 798, column 15
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-enforcer-plugin is missing. @ line 822, column 15
[ERROR] 'dependencies.dependency.version' for com.google.errorprone:error_prone_annotations:jar must be a valid version but is '${error-prone.version}
'. @ line 707, column 16

    at org.apache.maven.project.DefaultProjectBuilder.build (DefaultProjectBuilder.java:208)
    at org.apache.maven.project.DefaultProjectBuilder.build (DefaultProjectBuilder.java:333)
    at org.apache.maven.project.DefaultProjectBuilder.build (DefaultProjectBuilder.java:295)
    at org.apache.maven.project.DefaultProjectBuilder.initParent (DefaultProjectBuilder.java:911)
    at org.apache.maven.project.DefaultProjectBuilder.initProject (DefaultProjectBuilder.java:674)
    at org.apache.maven.project.DefaultProjectBuilder.build (DefaultProjectBuilder.java:188)
    at org.apache.maven.project.DefaultProjectBuilder.build (DefaultProjectBuilder.java:333)
    at org.apache.maven.project.DefaultProjectBuilder.build (DefaultProjectBuilder.java:295)
    at org.apache.maven.report.projectinfo.ProjectInfoReportUtils.getArtifactUrl (ProjectInfoReportUtils.java:209)
    at org.apache.maven.report.projectinfo.dependencies.renderer.DependenciesRenderer.renderArtifactRow (DependenciesRenderer.java:762)
    at org.apache.maven.report.projectinfo.dependencies.renderer.DependenciesRenderer.renderDependenciesForScope (DependenciesRenderer.java:729)
    at org.apache.maven.report.projectinfo.dependencies.renderer.DependenciesRenderer.renderDependenciesForAllScopes (DependenciesRenderer.java:287)
    at org.apache.maven.report.projectinfo.dependencies.renderer.DependenciesRenderer.renderSectionProjectTransitiveDependencies (DependenciesRenderer
.java:307)
    at org.apache.maven.report.projectinfo.dependencies.renderer.DependenciesRenderer.renderBody (DependenciesRenderer.java:218)
    at org.apache.maven.reporting.AbstractMavenReportRenderer.render (AbstractMavenReportRenderer.java:76)
    at org.apache.maven.report.projectinfo.DependenciesReport.executeReport (DependenciesReport.java:168)
    at org.apache.maven.reporting.AbstractMavenReport.generate (AbstractMavenReport.java:358)
```

The problem surfaced with version 2.25.0 if Log4j. To demonstrate a successful build with
a previous version, run:

```
mvn -Dlog4j.version=2.24.3 site

[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< org.natuna:log4j-error >-----------------------
[INFO] Building log4j-error 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- site:3.21.0:site (default-site) @ log4j-error ---
[INFO] Rendering site for default locale
[INFO] Configuring report plugin maven-project-info-reports-plugin:3.8.0
[INFO] Configured 8 reports for maven-project-info-reports-plugin:3.8.0: index, summary, dependency-info, dependency-management, dependencies, depende
ncy-convergence, plugin-management, plugins
[INFO] Skipping org.apache.maven.plugins:maven-project-info-reports-plugin:3.8.0:dependency-management report
[WARNING] No project URL defined - site links will not be relativized!
[INFO] Rendering content with org.apache.maven.skins:maven-fluido-skin:jar:2.0.0-M9 skin
[INFO] Rendering 8 report documents
[INFO] Generating "About" report             --- maven-project-info-reports-plugin:3.8.0:index
[INFO] Generating "Summary" report           --- maven-project-info-reports-plugin:3.8.0:summary
[INFO] Generating "Maven Coordinates" report --- maven-project-info-reports-plugin:3.8.0:dependency-info
[INFO] Generating "Dependencies" report      --- maven-project-info-reports-plugin:3.8.0:dependencies
[INFO] Generating "Dependency Convergence" report --- maven-project-info-reports-plugin:3.8.0:dependency-convergence
[INFO] Generating "Plugin Management" report --- maven-project-info-reports-plugin:3.8.0:plugin-management
[INFO] Generating "Plugins" report           --- maven-project-info-reports-plugin:3.8.0:plugins
[INFO] Generating "Project Information" report --- maven-site-plugin:3.21.0:project-info
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.876 s
[INFO] Finished at: 2025-07-14T08:27:23-04:00
[INFO] ------------------------------------------------------------------------
```
