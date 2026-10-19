# SkillHub - Project Content

## Folder Structure

```
Folder PATH listing for volume Windows-SSD
Volume serial number is 5632-9ECC
C:.
|   .gitignore
|   LICENSE
|   pom.xml
|   PROJECT.md
|   README.md
|   
+---.idea
|       .gitignore
|       compiler.xml
|       encodings.xml
|       jarRepositories.xml
|       misc.xml
|       vcs.xml
|       workspace.xml
|       
+---docs
|   \---UI-Screens
|           admin-dashboard.png
|           courses.png
|           login.png
|           mark-attendance.png
|           
+---src
|   \---main
|       +---java
|       |   \---com
|       |       \---skillhub
|       |           +---filter
|       |           |       AuthenticationFilter.java
|       |           |       AuthorizationFilter.java
|       |           |       CsrfFilter.java
|       |           |       EncodingFilter.java
|       |           |       SecurityHeadersFilter.java
|       |           |       
|       |           +---listener
|       |           |       AppContextListener.java
|       |           |       RequestStatsListener.java
|       |           |       SessionTrackingListener.java
|       |           |       
|       |           +---model
|       |           |       Attendance.java
|       |           |       Course.java
|       |           |       Enrolment.java
|       |           |       Role.java
|       |           |       User.java
|       |           |       
|       |           +---servlet
|       |           |       AbstractPeopleServlet.java
|       |           |       AdminReportServlet.java
|       |           |       AdminSettingsServlet.java
|       |           |       AdminStudentServlet.java
|       |           |       AdminTrainerServlet.java
|       |           |       AdminUserServlet.java
|       |           |       AttendanceMarkServlet.java
|       |           |       AttendanceServlet.java
|       |           |       CourseServlet.java
|       |           |       DashboardServlet.java
|       |           |       EnrolmentServlet.java
|       |           |       LoginServlet.java
|       |           |       LogoutServlet.java
|       |           |       ProfileServlet.java
|       |           |       RegisterServlet.java
|       |           |       
|       |           +---store
|       |           |       InMemoryStore.java
|       |           |       
|       |           \---util
|       |                   Flash.java
|       |                   PasswordUtil.java
|       |                   Validation.java
|       |                   WebUtil.java
|       |                   
|       \---webapp
|           |   index.jsp
|           |   
|           +---assets
|           |   +---css
|           |   |       style.css
|           |   |       
|           |   \---js
|           |           app.js
|           |           
|           \---WEB-INF
|               |   web.xml
|               |   
|               +---jsp
|               |       attendance-mark.jsp
|               |       attendance.jsp
|               |       course-form.jsp
|               |       courses.jsp
|               |       dashboard.jsp
|               |       enrolments.jsp
|               |       error.jsp
|               |       login.jsp
|               |       people.jsp
|               |       person-form.jsp
|               |       profile.jsp
|               |       register.jsp
|               |       reports.jsp
|               |       settings.jsp
|               |       users.jsp
|               |       
|               \---jspf
|                       flash.jspf
|                       footer.jspf
|                       head.jspf
|                       header.jspf
|                       taglibs.jspf
|                       
\---target
    +---classes
    |   \---com
    |       \---skillhub
    |           +---filter
    |           |       AuthenticationFilter.class
    |           |       AuthorizationFilter.class
    |           |       CsrfFilter.class
    |           |       EncodingFilter.class
    |           |       SecurityHeadersFilter.class
    |           |       
    |           +---listener
    |           |       AppContextListener.class
    |           |       RequestStatsListener.class
    |           |       SessionTrackingListener.class
    |           |       
    |           +---model
    |           |       Attendance.class
    |           |       Course.class
    |           |       Enrolment.class
    |           |       Role.class
    |           |       User.class
    |           |       
    |           +---servlet
    |           |       AbstractPeopleServlet.class
    |           |       AdminReportServlet.class
    |           |       AdminSettingsServlet.class
    |           |       AdminStudentServlet.class
    |           |       AdminTrainerServlet.class
    |           |       AdminUserServlet.class
    |           |       AttendanceMarkServlet.class
    |           |       AttendanceServlet.class
    |           |       CourseServlet.class
    |           |       DashboardServlet.class
    |           |       EnrolmentServlet.class
    |           |       LoginServlet.class
    |           |       LogoutServlet.class
    |           |       ProfileServlet.class
    |           |       RegisterServlet.class
    |           |       
    |           +---store
    |           |       InMemoryStore.class
    |           |       
    |           \---util
    |                   Flash.class
    |                   PasswordUtil.class
    |                   Validation.class
    |                   WebUtil.class
    |                   
    +---generated-sources
    |   \---annotations
    \---skillhub
        |   index.jsp
        |   
        +---assets
        |   +---css
        |   |       style.css
        |   |       
        |   \---js
        |           app.js
        |           
        +---META-INF
        |       MANIFEST.MF
        |       
        \---WEB-INF
            |   web.xml
            |   
            +---classes
            |   \---com
            |       \---skillhub
            |           +---filter
            |           |       AuthenticationFilter.class
            |           |       AuthorizationFilter.class
            |           |       CsrfFilter.class
            |           |       EncodingFilter.class
            |           |       SecurityHeadersFilter.class
            |           |       
            |           +---listener
            |           |       AppContextListener.class
            |           |       RequestStatsListener.class
            |           |       SessionTrackingListener.class
            |           |       
            |           +---model
            |           |       Attendance.class
            |           |       Course.class
            |           |       Enrolment.class
            |           |       Role.class
            |           |       User.class
            |           |       
            |           +---servlet
            |           |       AbstractPeopleServlet.class
            |           |       AdminReportServlet.class
            |           |       AdminSettingsServlet.class
            |           |       AdminStudentServlet.class
            |           |       AdminTrainerServlet.class
            |           |       AdminUserServlet.class
            |           |       AttendanceMarkServlet.class
            |           |       AttendanceServlet.class
            |           |       CourseServlet.class
            |           |       DashboardServlet.class
            |           |       EnrolmentServlet.class
            |           |       LoginServlet.class
            |           |       LogoutServlet.class
            |           |       ProfileServlet.class
            |           |       RegisterServlet.class
            |           |       
            |           +---store
            |           |       InMemoryStore.class
            |           |       
            |           \---util
            |                   Flash.class
            |                   PasswordUtil.class
            |                   Validation.class
            |                   WebUtil.class
            |                   
            +---jsp
            |       attendance-mark.jsp
            |       attendance.jsp
            |       course-form.jsp
            |       courses.jsp
            |       dashboard.jsp
            |       enrolments.jsp
            |       error.jsp
            |       login.jsp
            |       people.jsp
            |       person-form.jsp
            |       profile.jsp
            |       register.jsp
            |       reports.jsp
            |       settings.jsp
            |       users.jsp
            |       
            +---jspf
            |       flash.jspf
            |       footer.jspf
            |       head.jspf
            |       header.jspf
            |       taglibs.jspf
            |       
            \---lib
                    jstl-1.2.jar
                    
```

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.skillhub</groupId>
    <artifactId>skillhub-portal</artifactId>
    <version>1.0.0</version>
    <packaging>war</packaging>
    <name>SkillHub Training Academy Portal</name>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </properties>

    <dependencies>
        <!-- Java EE 8 (javax.*) APIs: provided by Apache Tomcat 9 -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.3</version>
            <scope>provided</scope>
        </dependency>
        <!-- JSTL 1.2 is bundled inside the WAR (Tomcat does not ship it) -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>

    <build>
        <finalName>skillhub</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.4.0</version>
            </plugin>
        </plugins>
    </build>
</project>


```

## .idea\compiler.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="CompilerConfiguration">
    <annotationProcessing>
      <profile name="Maven default annotation processors profile" enabled="true">
        <sourceOutputDir name="target/generated-sources/annotations" />
        <sourceTestOutputDir name="target/generated-test-sources/test-annotations" />
        <outputRelativeToContentRoot value="true" />
        <module name="skillhub-portal" />
      </profile>
    </annotationProcessing>
  </component>
</project>

```

## .idea\encodings.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="Encoding">
    <file url="file://$PROJECT_DIR$/src/main/java" charset="UTF-8" />
    <file url="file://$PROJECT_DIR$/src/main/resources" charset="UTF-8" />
  </component>
</project>

```

## .idea\jarRepositories.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="RemoteRepositoriesConfiguration">
    <remote-repository>
      <option name="id" value="central" />
      <option name="name" value="Central Repository" />
      <option name="url" value="https://repo.maven.apache.org/maven2" />
    </remote-repository>
    <remote-repository>
      <option name="id" value="central" />
      <option name="name" value="Maven Central repository" />
      <option name="url" value="https://repo1.maven.org/maven2" />
    </remote-repository>
    <remote-repository>
      <option name="id" value="jboss.community" />
      <option name="name" value="JBoss Community repository" />
      <option name="url" value="https://repository.jboss.org/nexus/content/repositories/public/" />
    </remote-repository>
  </component>
</project>

```

## .idea\misc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="ExternalStorageConfigurationManager" enabled="true" />
  <component name="MavenProjectsManager">
    <option name="originalFiles">
      <list>
        <option value="$PROJECT_DIR$/pom.xml" />
      </list>
    </option>
  </component>
  <component name="ProjectRootManager" version="2" languageLevel="JDK_11" default="true" project-jdk-name="ms-11" project-jdk-type="JavaSDK" />
</project>

```

## .idea\vcs.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="VcsDirectoryMappings">
    <mapping directory="$PROJECT_DIR$" vcs="Git" />
  </component>
</project>

```

## .idea\workspace.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="ArtifactsWorkspaceSettings">
    <artifacts-to-build>
      <artifact name="skillhub-portal:war exploded" />
    </artifacts-to-build>
  </component>
  <component name="AutoImportSettings">
    <option name="autoReloadType" value="SELECTIVE" />
  </component>
  <component name="ChangeListManager">
    <list default="true" id="ece527b7-1db4-43a6-9c8f-bcb28cfc5974" name="Changes" comment="Initial commit: SkillHub Training Academy portal" />
    <option name="SHOW_DIALOG" value="false" />
    <option name="HIGHLIGHT_CONFLICTS" value="true" />
    <option name="HIGHLIGHT_NON_ACTIVE_CHANGELIST" value="false" />
    <option name="LAST_RESOLUTION" value="IGNORE" />
  </component>
  <component name="Git.Settings">
    <option name="RECENT_GIT_ROOT_PATH" value="$PROJECT_DIR$" />
  </component>
  <component name="GitHubPullRequestSearchHistory">{
  &quot;lastFilter&quot;: {
    &quot;state&quot;: &quot;OPEN&quot;,
    &quot;assignee&quot;: &quot;Naditha-Roshana&quot;
  }
}</component>
  <component name="GithubPullRequestsUISettings">{
  &quot;selectedUrlAndAccountId&quot;: {
    &quot;url&quot;: &quot;https://github.com/Naditha-Roshana/skillhub-portal.git&quot;,
    &quot;accountId&quot;: &quot;816c8269-1ff8-4b14-97a6-35f49d1c19d2&quot;
  }
}</component>
  <component name="LogFilters">
    <option name="FILTER_ERRORS" value="false" />
    <option name="FILTER_WARNINGS" value="false" />
    <option name="FILTER_INFO" value="true" />
    <option name="FILTER_DEBUG" value="true" />
    <option name="CUSTOM_FILTER" />
  </component>
  <component name="ProjectColorInfo">{
  &quot;associatedIndex&quot;: 8
}</component>
  <component name="ProjectId" id="3KafZ76KxUsvrYg7ktjs0vbgyjf" />
  <component name="ProjectViewState">
    <option name="hideEmptyMiddlePackages" value="true" />
    <option name="showLibraryContents" value="true" />
  </component>
  <component name="PropertiesComponent">{
  &quot;keyToString&quot;: {
    &quot;ModuleVcsDetector.initialDetectionPerformed&quot;: &quot;true&quot;,
    &quot;RunOnceActivity.ShowReadmeOnStart&quot;: &quot;true&quot;,
    &quot;RunOnceActivity.TerminalTabsStorage.copyFrom.TerminalArrangementManager.252&quot;: &quot;true&quot;,
    &quot;RunOnceActivity.git.unshallow&quot;: &quot;true&quot;,
    &quot;Tomcat Server.Tomcat 9.executor&quot;: &quot;Run&quot;,
    &quot;com.intellij.ml.llm.matterhorn.ej.ui.settings.DefaultModelSelectionForGA.v1&quot;: &quot;true&quot;,
    &quot;git-widget-placeholder&quot;: &quot;main&quot;,
    &quot;ignore.virus.scanning.warn.message&quot;: &quot;true&quot;,
    &quot;junie.onboarding.icon.badge.shown&quot;: &quot;true&quot;,
    &quot;kotlin-language-version-configured&quot;: &quot;true&quot;,
    &quot;last_opened_file_path&quot;: &quot;C:/Users/User/OneDrive/Documents/Java Institute/WCD I/skillhub-portal&quot;,
    &quot;node.js.detected.package.eslint&quot;: &quot;true&quot;,
    &quot;node.js.detected.package.tslint&quot;: &quot;true&quot;,
    &quot;node.js.selected.package.eslint&quot;: &quot;(autodetect)&quot;,
    &quot;node.js.selected.package.tslint&quot;: &quot;(autodetect)&quot;,
    &quot;nodejs_package_manager_path&quot;: &quot;npm&quot;,
    &quot;project.structure.last.edited&quot;: &quot;Project&quot;,
    &quot;project.structure.proportion&quot;: &quot;0.15&quot;,
    &quot;project.structure.side.proportion&quot;: &quot;0.0&quot;,
    &quot;settings.editor.selected.configurable&quot;: &quot;preferences.pluginManager&quot;,
    &quot;to.speed.mode.migration.done&quot;: &quot;true&quot;,
    &quot;vue.rearranger.settings.migration&quot;: &quot;true&quot;
  }
}</component>
  <component name="RecentsManager">
    <key name="MoveFile.RECENT_KEYS">
      <recent name="C:\Users\User\OneDrive\Documents\Java Institute\WCD I\skillhub-portal\docs\UI-Screens" />
    </key>
  </component>
  <component name="RunManager">
    <configuration name="Tomcat 9" type="#com.intellij.j2ee.web.tomcat.TomcatRunConfigurationFactory" factoryName="Local" APPLICATION_SERVER_NAME="Tomcat 9" ALTERNATIVE_JRE_ENABLED="false" nameIsGenerated="true">
      <option name="UPDATING_POLICY" value="restart-server" />
      <deployment>
        <artifact name="skillhub-portal:war exploded">
          <settings>
            <option name="CONTEXT_PATH" value="/skillhub_portal_war_exploded" />
          </settings>
        </artifact>
      </deployment>
      <server-settings>
        <option name="BASE_DIRECTORY_NAME" value="ed02cf20-891c-4cca-ad07-810c76ccbb54" />
      </server-settings>
      <predefined_log_file enabled="true" id="Tomcat" />
      <predefined_log_file enabled="true" id="Tomcat Catalina" />
      <predefined_log_file id="Tomcat Manager" />
      <predefined_log_file id="Tomcat Host Manager" />
      <predefined_log_file id="Tomcat Localhost Access" />
      <RunnerSettings RunnerId="Debug">
        <option name="DEBUG_PORT" value="60811" />
      </RunnerSettings>
      <ConfigurationWrapper VM_VAR="JAVA_OPTS" RunnerId="Cover">
        <option name="USE_ENV_VARIABLES" value="true" />
        <STARTUP>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </STARTUP>
        <SHUTDOWN>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </SHUTDOWN>
      </ConfigurationWrapper>
      <ConfigurationWrapper VM_VAR="JAVA_OPTS" RunnerId="Debug">
        <option name="USE_ENV_VARIABLES" value="true" />
        <STARTUP>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </STARTUP>
        <SHUTDOWN>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </SHUTDOWN>
      </ConfigurationWrapper>
      <ConfigurationWrapper VM_VAR="JAVA_OPTS" RunnerId="Profile">
        <option name="USE_ENV_VARIABLES" value="true" />
        <STARTUP>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </STARTUP>
        <SHUTDOWN>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </SHUTDOWN>
      </ConfigurationWrapper>
      <ConfigurationWrapper VM_VAR="JAVA_OPTS" RunnerId="Run">
        <option name="USE_ENV_VARIABLES" value="true" />
        <STARTUP>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </STARTUP>
        <SHUTDOWN>
          <option name="USE_DEFAULT" value="true" />
          <option name="SCRIPT" value="" />
          <option name="VM_PARAMETERS" value="" />
          <option name="PROGRAM_PARAMETERS" value="" />
        </SHUTDOWN>
      </ConfigurationWrapper>
      <method v="2">
        <option name="Make" enabled="true" />
        <option name="BuildArtifacts" enabled="true">
          <artifact name="skillhub-portal:war exploded" />
        </option>
      </method>
    </configuration>
  </component>
  <component name="SharedIndexes">
    <attachedChunks>
      <set>
        <option value="bundled-jdk-9823dce3aa75-bf35d07a577b-intellij.indexing.shared.core-IU-252.27397.103" />
        <option value="bundled-js-predefined-d6986cc7102b-3aa1da707db6-JavaScript-IU-252.27397.103" />
      </set>
    </attachedChunks>
  </component>
  <component name="TaskManager">
    <task active="true" id="Default" summary="Default task">
      <changelist id="ece527b7-1db4-43a6-9c8f-bcb28cfc5974" name="Changes" comment="" />
      <created>1791800651417</created>
      <option name="number" value="Default" />
      <option name="presentableId" value="Default" />
      <updated>1791800651417</updated>
      <workItem from="1791800652812" duration="14086000" />
      <workItem from="1791841741288" duration="393000" />
      <workItem from="1791877781478" duration="224000" />
      <workItem from="1791967042143" duration="50000" />
      <workItem from="1791970432057" duration="92000" />
    </task>
    <task id="LOCAL-00001" summary="Initial commit: SkillHub Training Academy portal">
      <option name="closed" value="true" />
      <created>1791838343823</created>
      <option name="number" value="00001" />
      <option name="presentableId" value="LOCAL-00001" />
      <option name="project" value="LOCAL" />
      <updated>1791838343823</updated>
    </task>
    <option name="localTasksCounter" value="2" />
    <servers />
  </component>
  <component name="TypeScriptGeneratedFilesManager">
    <option name="version" value="3" />
  </component>
  <component name="Vcs.Log.Tabs.Properties">
    <option name="TAB_STATES">
      <map>
        <entry key="MAIN">
          <value>
            <State />
          </value>
        </entry>
      </map>
    </option>
  </component>
  <component name="VcsManagerConfiguration">
    <MESSAGE value="Initial commit: SkillHub Training Academy portal" />
    <option name="LAST_COMMIT_MESSAGE" value="Initial commit: SkillHub Training Academy portal" />
  </component>
</project>

```

## src\main\java\com\skillhub\filter\AuthenticationFilter.java

```java
package com.skillhub.filter;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Authentication: only the login page, registration page and static assets are public.
 * Every other URL needs a session that holds a valid "userId". The signed-in user is
 * published as the request attribute "currentUser". Also performs simple session tracking
 * (page view counter and last page visited).
 */
public class AuthenticationFilter implements Filter {
    private static final Set<String> PUBLIC_PATHS = Set.of("/login", "/register", "/index.jsp", "/");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getServletPath();

        if (path.startsWith("/assets/") || PUBLIC_PATHS.contains(path)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        User user = null;
        if (session != null) {
            Object id = session.getAttribute("userId");
            if (id instanceof Integer) {
                InMemoryStore store = WebUtil.store(req);
                user = store.findUser((Integer) id);
                if (user != null && !user.isActive()) {
                    session.removeAttribute("userId");
                    user = null;
                }
            }
        }

        if (user == null) {
            HttpSession s = req.getSession(true);
            if ("GET".equals(req.getMethod())) {
                String target = path + (req.getQueryString() == null ? "" : "?" + req.getQueryString());
                s.setAttribute("postLoginTarget", target);
            }
            Flash.info(req, "Please sign in to continue.");
            res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/login"));
            return;
        }

        // Session tracking
        Integer views = (Integer) session.getAttribute("pageViews");
        session.setAttribute("pageViews", views == null ? 1 : views + 1);
        session.setAttribute("lastPage", path);

        req.setAttribute("currentUser", user);
        chain.doFilter(request, response);
    }
}


```

## src\main\java\com\skillhub\filter\AuthorizationFilter.java

```java
package com.skillhub.filter;

import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authorisation (role based access control). Runs after AuthenticationFilter.
 * URLs not listed here are open to every signed-in user.
 */
public class AuthorizationFilter implements Filter {
    private final Map<String, Set<Role>> rules = new LinkedHashMap<>();

    @Override
    public void init(javax.servlet.FilterConfig config) {
        rules.put("/admin/", EnumSet.of(Role.ADMIN));
        rules.put("/attendance/mark", EnumSet.of(Role.ADMIN));
        rules.put("/enrolments", EnumSet.of(Role.ADMIN, Role.STUDENT));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        User user = WebUtil.currentUser(req);

        if (user != null) { // null means a public URL
            String path = req.getServletPath();
            for (Map.Entry<String, Set<Role>> rule : rules.entrySet()) {
                boolean match = rule.getKey().endsWith("/") ? path.startsWith(rule.getKey()) : path.equals(rule.getKey());
                if (match && !rule.getValue().contains(user.getRole())) {
                    InMemoryStore store = WebUtil.store(req);
                    store.log("ACCESS DENIED: " + user.getUsername() + " tried " + path);
                    res.sendError(HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }
}


```

## src\main\java\com\skillhub\filter\CsrfFilter.java

```java
package com.skillhub.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Cross-Site Request Forgery protection. A random token is kept in the session ("csrfToken")
 * and every POST form must send it back as the hidden field "_csrf".
 */
public class CsrfFilter implements Filter {
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getServletPath().startsWith("/assets/")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(true);
        String token = (String) session.getAttribute("csrfToken");
        if (token == null) {
            byte[] bytes = new byte[24];
            RANDOM.nextBytes(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            token = sb.toString();
            session.setAttribute("csrfToken", token);
        }

        if ("POST".equalsIgnoreCase(req.getMethod())) {
            String sent = req.getParameter("_csrf");
            boolean ok = sent != null && MessageDigest.isEqual(
                    token.getBytes(StandardCharsets.UTF_8), sent.getBytes(StandardCharsets.UTF_8));
            if (!ok) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid or expired security token");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}


```

## src\main\java\com\skillhub\filter\EncodingFilter.java

```java
package com.skillhub.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** Forces UTF-8 for every request and response. Encoding comes from the filter init-param in web.xml. */
public class EncodingFilter implements Filter {
    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig config) {
        String p = config.getInitParameter("encoding");
        if (p != null && !p.isBlank()) {
            encoding = p;
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        req.setCharacterEncoding(encoding);
        res.setCharacterEncoding(encoding);
        chain.doFilter(req, res);
    }
}


```

## src\main\java\com\skillhub\filter\SecurityHeadersFilter.java

```java
package com.skillhub.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Adds browser security headers and stops private pages being cached (so Back does not reveal them after logout). */
public class SecurityHeadersFilter implements Filter {

    private static final String CSP = "default-src 'self'; "
            + "script-src 'self' https://cdn.jsdelivr.net; "
            + "style-src 'self' 'unsafe-inline' https://cdn.jsdelivr.net https://fonts.googleapis.com; "
            + "font-src 'self' https://cdn.jsdelivr.net https://fonts.gstatic.com; "
            + "img-src 'self' data:; frame-ancestors 'none'; form-action 'self'";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        res.setHeader("X-Content-Type-Options", "nosniff");
        res.setHeader("X-Frame-Options", "DENY");
        res.setHeader("Referrer-Policy", "same-origin");
        res.setHeader("Content-Security-Policy", CSP);
        if (!req.getServletPath().startsWith("/assets/")) {
            res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            res.setHeader("Pragma", "no-cache");
            res.setDateHeader("Expires", 0);
        }
        chain.doFilter(request, response);
    }
}


```

## src\main\java\com\skillhub\listener\AppContextListener.java

```java
package com.skillhub.listener;

import com.skillhub.store.InMemoryStore;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Runs once when the web application starts. Creates the in-memory store, loads the demo data
 * and publishes application-wide settings in the ServletContext (application scope).
 */
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        InMemoryStore store = new InMemoryStore();
        store.seed();

        ctx.setAttribute("store", store);
        ctx.setAttribute("academyName", valueOr(ctx.getInitParameter("academyName"), "SkillHub Training Academy"));
        ctx.setAttribute("supportEmail", valueOr(ctx.getInitParameter("supportEmail"), "support@skillhub.lk"));
        ctx.setAttribute("defaultCapacity", Integer.parseInt(valueOr(ctx.getInitParameter("defaultCapacity"), "30")));
        ctx.setAttribute("registrationOpen", Boolean.parseBoolean(valueOr(ctx.getInitParameter("registrationOpen"), "true")));
        ctx.setAttribute("startedAt", new Date());
        ctx.setAttribute("activeSessions", new AtomicInteger(0));
        ctx.setAttribute("totalRequests", new AtomicLong(0));

        ctx.log("SkillHub portal initialised with demo data.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("SkillHub portal stopped. In-memory data discarded.");
    }

    private static String valueOr(String v, String def) {
        return v == null || v.isBlank() ? def : v;
    }
}


```

## src\main\java\com\skillhub\listener\RequestStatsListener.java

```java
package com.skillhub.listener;

import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/** Counts every request handled since the application started (shown on the admin reports page). */
public class RequestStatsListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        AtomicLong total = (AtomicLong) sre.getServletContext().getAttribute("totalRequests");
        if (total != null && sre.getServletRequest() instanceof HttpServletRequest) {
            total.incrementAndGet();
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // not needed
    }
}


```

## src\main\java\com\skillhub\listener\SessionTrackingListener.java

```java
package com.skillhub.listener;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Session tracking. Counts live sessions and writes sign-in / sign-out events to the activity log.
 * A session counts as a sign-in when the "userId" attribute is added to it.
 */
public class SessionTrackingListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        counter(se.getSession().getServletContext()).incrementAndGet();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        AtomicInteger c = counter(se.getSession().getServletContext());
        if (c.get() > 0) {
            c.decrementAndGet();
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("userId".equals(event.getName())) {
            describe(event, "signed in");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("userId".equals(event.getName())) {
            describe(event, "signed out");
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // not needed
    }

    private void describe(HttpSessionBindingEvent event, String action) {
        ServletContext ctx = event.getSession().getServletContext();
        InMemoryStore store = WebUtil.store(ctx);
        if (store == null || !(event.getValue() instanceof Integer)) return;
        User u = store.findUser((Integer) event.getValue());
        if (u != null) {
            store.log(u.getFullName() + " (" + u.getRole().getLabel() + ") " + action);
        }
    }

    private AtomicInteger counter(ServletContext ctx) {
        return (AtomicInteger) ctx.getAttribute("activeSessions");
    }
}


```

## src\main\java\com\skillhub\model\Attendance.java

```java
package com.skillhub.model;

import java.time.LocalDate;

/** One student's attendance for one course session. Status: PRESENT, LATE or ABSENT. */
public class Attendance {
    public static final String PRESENT = "PRESENT";
    public static final String LATE = "LATE";
    public static final String ABSENT = "ABSENT";

    private int id;
    private int courseId;
    private int studentId;
    private LocalDate date;
    private String status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


```

## src\main\java\com\skillhub\model\Course.java

```java
package com.skillhub.model;

/** A training course offered by the academy. */
public class Course {
    private int id;
    private String code;
    private String title;
    private String category;
    private String description;
    private int trainerId;
    private int durationWeeks;
    private int capacity;
    private double fee;
    private String schedule;
    private boolean active = true;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getTrainerId() { return trainerId; }
    public void setTrainerId(int trainerId) { this.trainerId = trainerId; }
    public int getDurationWeeks() { return durationWeeks; }
    public void setDurationWeeks(int durationWeeks) { this.durationWeeks = durationWeeks; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}


```

## src\main\java\com\skillhub\model\Enrolment.java

```java
package com.skillhub.model;

import java.time.LocalDate;

/** Links one student to one course. */
public class Enrolment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrolledOn = LocalDate.now();
    private String status = "ACTIVE";

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public LocalDate getEnrolledOn() { return enrolledOn; }
    public void setEnrolledOn(LocalDate enrolledOn) { this.enrolledOn = enrolledOn; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


```

## src\main\java\com\skillhub\model\Role.java

```java
package com.skillhub.model;

/** The three actor types shown in the use case diagram. */
public enum Role {
    ADMIN("Administrator"),
    TRAINER("Trainer"),
    STUDENT("Student");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


```

## src\main\java\com\skillhub\model\User.java

```java
package com.skillhub.model;

import java.time.LocalDate;

/** Account for an Administrator, Trainer or Student. */
public class User {
    private int id;
    private String username;
    private String passwordHash;
    private String fullName;
    private String email;
    private String phone;
    private Role role;
    private boolean active = true;
    private LocalDate createdAt = LocalDate.now();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public boolean isAdmin() { return role == Role.ADMIN; }
    public boolean isTrainer() { return role == Role.TRAINER; }
    public boolean isStudent() { return role == Role.STUDENT; }

    /** Two-letter initials used for avatars, e.g. "U.Anjali" becomes "UA". */
    public String getInitials() {
        if (fullName == null || fullName.isBlank()) {
            return "?";
        }
        String[] parts = fullName.trim().split("[\\s.]+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty() && sb.length() < 2) {
                sb.append(Character.toUpperCase(p.charAt(0)));
            }
        }
        return sb.length() == 0 ? "?" : sb.toString();
    }
}


```

## src\main\java\com\skillhub\servlet\AbstractPeopleServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Shared list / add / edit / delete logic for the Manage Students and Manage Trainers use cases. */
public abstract class AbstractPeopleServlet extends HttpServlet {

    protected abstract Role role();
    protected abstract String basePath();   // e.g. /admin/students
    protected abstract String navKey();     // sidebar highlight
    protected abstract String plural();     // "Students"
    protected abstract boolean allowDelete();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        String action = WebUtil.trim(req.getParameter("action"));

        if ("new".equals(action)) {
            User u = new User();
            u.setRole(role());
            showForm(req, res, u, true);
        } else if ("edit".equals(action)) {
            User u = store.findUser(WebUtil.toInt(req.getParameter("id"), -1));
            if (u == null || u.getRole() != role()) {
                res.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            showForm(req, res, u, false);
        } else {
            decorate(req);
            req.setAttribute("people", store.findUsers(role()));
            WebUtil.render(req, res, "people");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User admin = WebUtil.currentUser(req);
        String action = WebUtil.trim(req.getParameter("action"));
        int id = WebUtil.toInt(req.getParameter("id"), 0);

        if ("delete".equals(action)) {
            User u = store.findUser(id);
            if (!allowDelete() || u == null || u.getRole() != role()) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            store.deleteUser(id);
            store.log(admin.getFullName() + " deleted " + role().getLabel().toLowerCase() + " " + u.getFullName());
            Flash.success(req, u.getFullName() + " was deleted.");
            WebUtil.redirect(req, res, basePath());
            return;
        }

        User existing = id == 0 ? null : store.findUser(id);
        if (id != 0 && (existing == null || existing.getRole() != role())) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        User form = new User();
        form.setId(id);
        form.setRole(role());
        form.setFullName(WebUtil.trim(req.getParameter("fullName")));
        form.setUsername(WebUtil.trim(req.getParameter("username")));
        form.setEmail(WebUtil.trim(req.getParameter("email")));
        form.setPhone(WebUtil.trim(req.getParameter("phone")));
        form.setActive(req.getParameter("active") != null);
        String password = req.getParameter("password");

        List<String> errors = new ArrayList<>();
        if (form.getFullName().length() < 3 || form.getFullName().length() > 60) errors.add("Full name must be 3 to 60 characters.");
        if (!Validation.validUsername(form.getUsername())) errors.add("Username must be 4 to 20 characters (letters, numbers, . _ -).");
        else if (store.usernameTaken(form.getUsername(), id)) errors.add("That username is already taken.");
        if (!Validation.validEmail(form.getEmail())) errors.add("Please enter a valid email address.");
        if (!Validation.validPhone(form.getPhone())) errors.add("Phone number format is invalid.");
        boolean passwordGiven = !Validation.isBlank(password);
        if (id == 0 || passwordGiven) {
            String problem = Validation.passwordProblem(password);
            if (problem != null) errors.add(problem);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            showForm(req, res, form, id == 0);
            return;
        }
        if (existing != null) {
            form.setCreatedAt(existing.getCreatedAt());
            form.setPasswordHash(passwordGiven ? PasswordUtil.hash(password) : existing.getPasswordHash());
        } else {
            form.setPasswordHash(PasswordUtil.hash(password));
        }
        store.saveUser(form);
        store.log(admin.getFullName() + (id == 0 ? " added " : " updated ") + role().getLabel().toLowerCase() + " " + form.getFullName());
        Flash.success(req, form.getFullName() + (id == 0 ? " was added." : " was updated."));
        WebUtil.redirect(req, res, basePath());
    }

    private void showForm(HttpServletRequest req, HttpServletResponse res, User person, boolean isNew)
            throws ServletException, IOException {
        decorate(req);
        req.setAttribute("person", person);
        req.setAttribute("isNew", isNew);
        WebUtil.render(req, res, "person-form");
    }

    private void decorate(HttpServletRequest req) {
        req.setAttribute("basePath", basePath());
        req.setAttribute("navKey", navKey());
        req.setAttribute("plural", plural());
        req.setAttribute("singular", role().getLabel());
        req.setAttribute("allowDelete", allowDelete());
        req.setAttribute("isStudentList", role() == Role.STUDENT);
    }
}


```

## src\main\java\com\skillhub\servlet\AdminReportServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: System Administration - View Reports (summary, course utilisation, activity log, CSV export). */
public class AdminReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        if ("csv".equals(req.getParameter("format"))) {
            exportCsv(store, res);
            return;
        }

        ServletContext ctx = req.getServletContext();
        List<Map<String, Object>> rows = new ArrayList<>();
        double revenue = 0;
        for (Course c : store.findCourses()) {
            int enrolled = store.enrolledCount(c.getId());
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("code", c.getCode());
            row.put("title", c.getTitle());
            row.put("trainerId", c.getTrainerId());
            row.put("enrolled", enrolled);
            row.put("capacity", c.getCapacity());
            row.put("pct", c.getCapacity() == 0 ? 0 : Math.min(100, enrolled * 100 / c.getCapacity()));
            row.put("attendance", InMemoryStore.attendanceRate(store.attendanceByCourse(c.getId())));
            row.put("revenue", enrolled * c.getFee());
            revenue += enrolled * c.getFee();
            rows.add(row);
        }
        Date started = (Date) ctx.getAttribute("startedAt");

        req.setAttribute("courseRows", rows);
        req.setAttribute("totalRevenue", revenue);
        req.setAttribute("studentTotal", store.findUsers(Role.STUDENT).size());
        req.setAttribute("trainerTotal", store.findUsers(Role.TRAINER).size());
        req.setAttribute("enrolmentTotal", store.findEnrolments().size());
        req.setAttribute("overallAttendance", InMemoryStore.attendanceRate(store.findAttendance()));
        req.setAttribute("activity", store.recentLog(25));
        req.setAttribute("activeSessions", ((AtomicInteger) ctx.getAttribute("activeSessions")).get());
        req.setAttribute("totalRequests", ((AtomicLong) ctx.getAttribute("totalRequests")).get());
        req.setAttribute("startedAt", started);
        req.setAttribute("uptimeMinutes", (System.currentTimeMillis() - started.getTime()) / 60000);
        req.setAttribute("serverInfo", ctx.getServerInfo());
        req.setAttribute("javaVersion", System.getProperty("java.version"));
        WebUtil.render(req, res, "reports");
    }

    private void exportCsv(InMemoryStore store, HttpServletResponse res) throws IOException {
        res.setContentType("text/csv; charset=UTF-8");
        res.setHeader("Content-Disposition", "attachment; filename=\"skillhub-enrolments.csv\"");
        PrintWriter out = res.getWriter();
        out.println("Enrolment ID,Student,Course Code,Course Title,Enrolled On,Status");
        for (Enrolment e : store.findEnrolments()) {
            User s = store.findUser(e.getStudentId());
            Course c = store.findCourse(e.getCourseId());
            if (s == null || c == null) continue;
            out.println(e.getId() + "," + csv(s.getFullName()) + "," + csv(c.getCode()) + ","
                    + csv(c.getTitle()) + "," + e.getEnrolledOn() + "," + e.getStatus());
        }
    }

    /** Quotes a value and neutralises spreadsheet formula injection. */
    private String csv(String v) {
        String s = v == null ? "" : v;
        if (!s.isEmpty() && "=+-@".indexOf(s.charAt(0)) >= 0) {
            s = "'" + s;
        }
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}


```

## src\main\java\com\skillhub\servlet\AdminSettingsServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.util.Flash;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: System Administration - Configure Application. Changes ServletContext (application scope) settings. */
public class AdminSettingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        WebUtil.render(req, res, "settings");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext ctx = req.getServletContext();
        User admin = WebUtil.currentUser(req);
        String name = WebUtil.trim(req.getParameter("academyName"));
        String email = WebUtil.trim(req.getParameter("supportEmail"));
        int capacity = WebUtil.toInt(req.getParameter("defaultCapacity"), 0);
        boolean open = req.getParameter("registrationOpen") != null;

        List<String> errors = new ArrayList<>();
        if (name.length() < 3 || name.length() > 60) errors.add("Academy name must be 3 to 60 characters.");
        if (!Validation.validEmail(email)) errors.add("Please enter a valid support email.");
        if (capacity < 1 || capacity > 500) errors.add("Default capacity must be between 1 and 500.");
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            WebUtil.render(req, res, "settings");
            return;
        }
        ctx.setAttribute("academyName", name);
        ctx.setAttribute("supportEmail", email);
        ctx.setAttribute("defaultCapacity", capacity);
        ctx.setAttribute("registrationOpen", open);
        WebUtil.store(req).log(admin.getFullName() + " changed the application settings");
        Flash.success(req, "Application settings were saved.");
        WebUtil.redirect(req, res, "/admin/settings");
    }
}


```

## src\main\java\com\skillhub\servlet\AdminStudentServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Role;

/** Use case: Manage Students (Add, Edit, Delete, View Student List). */
public class AdminStudentServlet extends AbstractPeopleServlet {
    @Override protected Role role() { return Role.STUDENT; }
    @Override protected String basePath() { return "/admin/students"; }
    @Override protected String navKey() { return "students"; }
    @Override protected String plural() { return "Students"; }
    @Override protected boolean allowDelete() { return true; }
}


```

## src\main\java\com\skillhub\servlet\AdminTrainerServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Role;

/** Use case: Manage Trainers (Add, Edit, View Trainer List). */
public class AdminTrainerServlet extends AbstractPeopleServlet {
    @Override protected Role role() { return Role.TRAINER; }
    @Override protected String basePath() { return "/admin/trainers"; }
    @Override protected String navKey() { return "trainers"; }
    @Override protected String plural() { return "Trainers"; }
    @Override protected boolean allowDelete() { return false; }
}


```

## src\main\java\com\skillhub\servlet\AdminUserServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: System Administration - Manage Users (activate / deactivate accounts, reset passwords). */
public class AdminUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("users", WebUtil.store(req).findUsers(null));
        WebUtil.render(req, res, "users");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User admin = WebUtil.currentUser(req);
        User target = store.findUser(WebUtil.toInt(req.getParameter("id"), -1));
        String action = WebUtil.trim(req.getParameter("action"));

        if (target == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        if ("toggle".equals(action)) {
            if (target.getId() == admin.getId()) {
                Flash.error(req, "You cannot deactivate your own account.");
            } else {
                target.setActive(!target.isActive());
                store.log(admin.getFullName() + (target.isActive() ? " activated " : " deactivated ") + target.getUsername());
                Flash.success(req, target.getFullName() + (target.isActive() ? " was activated." : " was deactivated."));
            }
        } else if ("reset".equals(action)) {
            String temp = PasswordUtil.randomPassword(10);
            target.setPasswordHash(PasswordUtil.hash(temp));
            store.log(admin.getFullName() + " reset the password for " + target.getUsername());
            Flash.success(req, "Temporary password for " + target.getUsername() + ": " + temp + "  (shown once, share it securely)");
        } else {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        WebUtil.redirect(req, res, "/admin/users");
    }
}


```

## src\main\java\com\skillhub\servlet\AttendanceMarkServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: Mark Attendance (Admin only; enforced by AuthorizationFilter). */
public class AttendanceMarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        List<Course> courses = store.findCourses();
        Course selected = store.findCourse(WebUtil.toInt(req.getParameter("courseId"), 0));
        if (selected == null && !courses.isEmpty()) selected = courses.get(0);
        LocalDate date = parseDate(req.getParameter("date"));

        List<User> students = new ArrayList<>();
        Map<Integer, String> existing = new HashMap<>();
        if (selected != null) {
            for (Enrolment e : store.enrolmentsByCourse(selected.getId())) {
                User s = store.findUser(e.getStudentId());
                if (s != null && "ACTIVE".equals(e.getStatus())) students.add(s);
            }
            for (Attendance a : store.attendanceByCourse(selected.getId())) {
                if (a.getDate().equals(date)) existing.put(a.getStudentId(), a.getStatus());
            }
        }
        req.setAttribute("courses", courses);
        req.setAttribute("selectedCourse", selected);
        req.setAttribute("students", students);
        req.setAttribute("existing", existing);
        req.setAttribute("sessionDate", date.toString());
        req.setAttribute("today", LocalDate.now().toString());
        WebUtil.render(req, res, "attendance-mark");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        Course course = store.findCourse(WebUtil.toInt(req.getParameter("courseId"), 0));
        LocalDate date = parseDate(req.getParameter("date"));
        if (course == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<Integer, String> statuses = new LinkedHashMap<>();
        for (Enrolment e : store.enrolmentsByCourse(course.getId())) {
            if (!"ACTIVE".equals(e.getStatus())) continue;
            String s = WebUtil.trim(req.getParameter("status_" + e.getStudentId()));
            if (Attendance.PRESENT.equals(s) || Attendance.LATE.equals(s) || Attendance.ABSENT.equals(s)) {
                statuses.put(e.getStudentId(), s);
            }
        }
        if (statuses.isEmpty()) {
            Flash.error(req, "There are no enrolled students to mark for this course.");
            WebUtil.redirect(req, res, "/attendance/mark?courseId=" + course.getId());
            return;
        }
        store.markAttendance(course.getId(), date, statuses);
        store.log(user.getFullName() + " marked attendance for " + course.getCode() + " on " + date);
        Flash.success(req, "Attendance saved for " + course.getCode() + " on " + date + ".");
        WebUtil.redirect(req, res, "/attendance?courseId=" + course.getId());
    }

    /** Parses yyyy-MM-dd; invalid or future dates fall back to today. */
    private LocalDate parseDate(String s) {
        try {
            LocalDate d = LocalDate.parse(WebUtil.trim(s));
            return d.isAfter(LocalDate.now()) ? LocalDate.now() : d;
        } catch (DateTimeParseException e) {
            return LocalDate.now();
        }
    }
}


```

## src\main\java\com\skillhub\servlet\AttendanceServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Use cases: View Attendance (Student: own records, Trainer: records of assigned courses)
 * and View Attendance Report (Admin: all courses).
 */
public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);

        // 1. Which courses may this user look at?
        List<Course> selectable = new ArrayList<>();
        if (user.isAdmin()) {
            selectable = store.findCourses();
        } else if (user.isTrainer()) {
            selectable = store.coursesByTrainer(user.getId());
        } else {
            for (Enrolment e : store.enrolmentsByStudent(user.getId())) {
                Course c = store.findCourse(e.getCourseId());
                if (c != null) selectable.add(c);
            }
        }

        // 2. Optional course filter (must be one of the selectable courses)
        Course selected = null;
        int courseId = WebUtil.toInt(req.getParameter("courseId"), 0);
        if (courseId != 0) {
            for (Course c : selectable) {
                if (c.getId() == courseId) selected = c;
            }
            if (selected == null) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }

        // 3. Collect the records
        List<Attendance> records = new ArrayList<>();
        if (user.isStudent()) {
            for (Attendance a : store.attendanceByStudent(user.getId())) {
                if (selected == null || a.getCourseId() == selected.getId()) records.add(a);
            }
        } else if (selected != null) {
            records.addAll(store.attendanceByCourse(selected.getId()));
        } else {
            for (Course c : selectable) {
                records.addAll(store.attendanceByCourse(c.getId()));
            }
            records.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        }

        // 4. Summary numbers and per-student report
        int present = 0, late = 0, absent = 0;
        Map<Integer, int[]> perStudent = new LinkedHashMap<>();
        for (Attendance a : records) {
            int[] row = perStudent.computeIfAbsent(a.getStudentId(), k -> new int[3]);
            if (Attendance.PRESENT.equals(a.getStatus())) { present++; row[0]++; }
            else if (Attendance.LATE.equals(a.getStatus())) { late++; row[1]++; }
            else { absent++; row[2]++; }
        }
        List<Map<String, Object>> report = new ArrayList<>();
        for (Map.Entry<Integer, int[]> en : perStudent.entrySet()) {
            int[] r = en.getValue();
            int total = r[0] + r[1] + r[2];
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("studentId", en.getKey());
            row.put("present", r[0]);
            row.put("late", r[1]);
            row.put("absent", r[2]);
            row.put("rate", total == 0 ? 0 : Math.round((r[0] + r[1]) * 100f / total));
            report.add(row);
        }

        req.setAttribute("selectableCourses", selectable);
        req.setAttribute("selectedCourse", selected);
        req.setAttribute("records", records);
        req.setAttribute("presentCount", present);
        req.setAttribute("lateCount", late);
        req.setAttribute("absentCount", absent);
        req.setAttribute("rate", InMemoryStore.attendanceRate(records));
        req.setAttribute("report", report);
        WebUtil.render(req, res, "attendance");
    }
}


```

## src\main\java\com\skillhub\servlet\CourseServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Course;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Use cases: View Courses (all roles), Add Course and Edit Course (Admin only),
 * View Assigned Courses (Trainer sees only their own courses).
 */
public class CourseServlet extends HttpServlet {
    private static final String[] CATEGORIES = {"Technology", "Business", "Professional Development"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        String action = WebUtil.trim(req.getParameter("action"));

        if ("new".equals(action) || "edit".equals(action)) {
            if (!user.isAdmin()) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            Course course = new Course();
            course.setCapacity((Integer) req.getServletContext().getAttribute("defaultCapacity"));
            course.setDurationWeeks(8);
            if ("edit".equals(action)) {
                course = store.findCourse(WebUtil.toInt(req.getParameter("id"), -1));
                if (course == null) {
                    res.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }
            }
            showForm(req, res, store, course);
            return;
        }

        List<Course> list;
        if (user.isTrainer()) {
            list = store.coursesByTrainer(user.getId());
        } else if (user.isStudent()) {
            list = new ArrayList<>();
            for (Course c : store.findCourses()) {
                if (c.isActive()) list.add(c);
            }
            Set<Integer> enrolled = new HashSet<>();
            for (Course c : list) {
                if (store.isEnrolled(user.getId(), c.getId())) enrolled.add(c.getId());
            }
            req.setAttribute("enrolledIds", enrolled);
        } else {
            list = store.findCourses();
        }
        req.setAttribute("courses", list);
        WebUtil.render(req, res, "courses");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        if (!user.isAdmin()) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        int id = WebUtil.toInt(req.getParameter("id"), 0);
        Course c = new Course();
        c.setId(id);
        c.setCode(WebUtil.trim(req.getParameter("code")).toUpperCase());
        c.setTitle(WebUtil.trim(req.getParameter("title")));
        c.setCategory(WebUtil.trim(req.getParameter("category")));
        c.setDescription(WebUtil.trim(req.getParameter("description")));
        c.setTrainerId(WebUtil.toInt(req.getParameter("trainerId"), 0));
        c.setDurationWeeks(WebUtil.toInt(req.getParameter("durationWeeks"), 0));
        c.setCapacity(WebUtil.toInt(req.getParameter("capacity"), 0));
        c.setFee(WebUtil.toDouble(req.getParameter("fee"), -1));
        c.setSchedule(WebUtil.trim(req.getParameter("schedule")));
        c.setActive(req.getParameter("active") != null);

        List<String> errors = new ArrayList<>();
        if (!c.getCode().matches("^[A-Z0-9]{4,10}$")) errors.add("Course code must be 4 to 10 letters or numbers.");
        else if (store.courseCodeTaken(c.getCode(), id)) errors.add("That course code already exists.");
        if (c.getTitle().length() < 3 || c.getTitle().length() > 80) errors.add("Title must be 3 to 80 characters.");
        if (!java.util.Arrays.asList(CATEGORIES).contains(c.getCategory())) errors.add("Please choose a valid category.");
        User trainer = store.findUser(c.getTrainerId());
        if (trainer == null || trainer.getRole() != Role.TRAINER) errors.add("Please assign a trainer.");
        if (c.getDurationWeeks() < 1 || c.getDurationWeeks() > 52) errors.add("Duration must be between 1 and 52 weeks.");
        if (c.getCapacity() < 1 || c.getCapacity() > 500) errors.add("Capacity must be between 1 and 500.");
        else if (id != 0 && c.getCapacity() < store.enrolledCount(id)) errors.add("Capacity cannot be lower than the current number of enrolled students.");
        if (c.getFee() < 0) errors.add("Fee must be zero or more.");
        if (Validation.isBlank(c.getSchedule())) errors.add("Please enter the class schedule.");
        if (c.getDescription().length() > 300) errors.add("Description must be 300 characters or fewer.");

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            showForm(req, res, store, c);
            return;
        }
        store.saveCourse(c);
        store.log(user.getFullName() + (id == 0 ? " added course " : " updated course ") + c.getCode());
        Flash.success(req, "Course " + c.getCode() + (id == 0 ? " was added." : " was updated."));
        WebUtil.redirect(req, res, "/courses");
    }

    private void showForm(HttpServletRequest req, HttpServletResponse res, InMemoryStore store, Course c)
            throws ServletException, IOException {
        req.setAttribute("course", c);
        req.setAttribute("trainers", store.findUsers(Role.TRAINER));
        req.setAttribute("categories", CATEGORIES);
        WebUtil.render(req, res, "course-form");
    }
}


```

## src\main\java\com\skillhub\servlet\DashboardServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Builds the role-specific dashboard (cards, tables and summaries). */
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);

        if (user.isAdmin()) {
            adminData(req, store);
        } else if (user.isTrainer()) {
            trainerData(req, store, user);
        } else {
            studentData(req, store, user);
        }
        WebUtil.render(req, res, "dashboard");
    }

    private void adminData(HttpServletRequest req, InMemoryStore store) {
        List<Course> courses = store.findCourses();
        List<Enrolment> enrolments = store.findEnrolments();

        req.setAttribute("totalStudents", store.findUsers(Role.STUDENT).size());
        req.setAttribute("totalTrainers", store.findUsers(Role.TRAINER).size());
        req.setAttribute("totalCourses", courses.size());
        req.setAttribute("totalEnrolments", enrolments.size());
        req.setAttribute("attendanceRate", InMemoryStore.attendanceRate(store.findAttendance()));
        req.setAttribute("activeSessions", ((AtomicInteger) req.getServletContext().getAttribute("activeSessions")).get());
        req.setAttribute("totalRequests", ((AtomicLong) req.getServletContext().getAttribute("totalRequests")).get());
        req.setAttribute("recentEnrolments", enrolments.subList(0, Math.min(5, enrolments.size())));

        List<Map<String, Object>> util = new ArrayList<>();
        Map<String, Integer> categories = new LinkedHashMap<>();
        for (Course c : courses) {
            int enrolled = store.enrolledCount(c.getId());
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("code", c.getCode());
            row.put("title", c.getTitle());
            row.put("enrolled", enrolled);
            row.put("capacity", c.getCapacity());
            row.put("pct", c.getCapacity() == 0 ? 0 : Math.min(100, enrolled * 100 / c.getCapacity()));
            util.add(row);
            categories.merge(c.getCategory(), 1, Integer::sum);
        }
        req.setAttribute("courseUtil", util);
        req.setAttribute("categoryCounts", categories);
    }

    private void trainerData(HttpServletRequest req, InMemoryStore store, User user) {
        List<Course> mine = store.coursesByTrainer(user.getId());
        Set<Integer> students = new HashSet<>();
        List<Attendance> records = new ArrayList<>();
        for (Course c : mine) {
            for (Enrolment e : store.enrolmentsByCourse(c.getId())) {
                students.add(e.getStudentId());
            }
            records.addAll(store.attendanceByCourse(c.getId()));
        }
        records.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        Set<String> sessions = new HashSet<>();
        for (Attendance a : records) {
            sessions.add(a.getCourseId() + "|" + a.getDate());
        }
        req.setAttribute("myCourses", mine);
        req.setAttribute("studentCount", students.size());
        req.setAttribute("sessionCount", sessions.size());
        req.setAttribute("attendanceRate", InMemoryStore.attendanceRate(records));
        req.setAttribute("recentAttendance", records.subList(0, Math.min(6, records.size())));
    }

    private void studentData(HttpServletRequest req, InMemoryStore store, User user) {
        List<Enrolment> mine = store.enrolmentsByStudent(user.getId());
        List<Attendance> records = store.attendanceByStudent(user.getId());
        int available = 0;
        for (Course c : store.findCourses()) {
            if (c.isActive() && !store.isEnrolled(user.getId(), c.getId())) available++;
        }
        req.setAttribute("myEnrolments", mine);
        req.setAttribute("attendanceRate", InMemoryStore.attendanceRate(records));
        req.setAttribute("sessionCount", records.size());
        req.setAttribute("availableCourses", available);
        req.setAttribute("recentAttendance", records.subList(0, Math.min(5, records.size())));
    }
}


```

## src\main\java\com\skillhub\servlet\EnrolmentServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Use cases: Enrol in Course (Student), Enrol Student and View Enrolment List (Admin).
 * Access is limited to ADMIN and STUDENT by AuthorizationFilter.
 */
public class EnrolmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        List<Enrolment> list = user.isAdmin() ? store.findEnrolments() : store.enrolmentsByStudent(user.getId());
        req.setAttribute("enrolments", list);
        if (user.isAdmin()) {
            List<Course> active = new ArrayList<>();
            for (Course c : store.findCourses()) {
                if (c.isActive()) active.add(c);
            }
            req.setAttribute("students", store.findUsers(Role.STUDENT));
            req.setAttribute("activeCourses", active);
        }
        WebUtil.render(req, res, "enrolments");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        int courseId = WebUtil.toInt(req.getParameter("courseId"), -1);
        // A student can only enrol themselves; only an admin may choose the student.
        int studentId = user.isAdmin() ? WebUtil.toInt(req.getParameter("studentId"), -1) : user.getId();

        String error = store.enrol(studentId, courseId);
        if (error == null) {
            Course c = store.findCourse(courseId);
            Flash.success(req, user.isAdmin() ? "Student enrolled successfully." : "You are now enrolled in " + c.getTitle() + ".");
        } else {
            Flash.error(req, error);
        }
        WebUtil.redirect(req, res, "/enrolments");
    }
}


```

## src\main\java\com\skillhub\servlet\LoginServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Use case: Login (Student, Trainer, Admin). */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userId") instanceof Integer
                && WebUtil.store(req).findUser((Integer) session.getAttribute("userId")) != null) {
            WebUtil.redirect(req, res, "/dashboard");
            return;
        }
        WebUtil.render(req, res, "login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        String username = WebUtil.trim(req.getParameter("username"));
        String password = req.getParameter("password");

        if (Validation.isBlank(username) || Validation.isBlank(password)) {
            fail(req, res, username, "Please enter both your username and password.");
            return;
        }
        if (store.isLocked(username)) {
            fail(req, res, username, "Too many failed attempts. Please wait 5 minutes and try again.");
            return;
        }
        User user = store.authenticate(username, password);
        if (user == null) {
            store.recordFailure(username);
            store.log("Failed login attempt for '" + username + "'");
            fail(req, res, username, "Invalid username or password.");
            return;
        }

        store.clearFailures(username);
        req.changeSessionId(); // prevents session fixation
        HttpSession session = req.getSession();
        session.removeAttribute("csrfToken"); // issue a fresh token for the authenticated session
        session.setAttribute("loginTime", new Date());
        session.setAttribute("userId", user.getId());
        Flash.success(req, "Welcome back, " + user.getFullName() + "!");

        String target = (String) session.getAttribute("postLoginTarget");
        session.removeAttribute("postLoginTarget");
        WebUtil.redirect(req, res, target == null || !target.startsWith("/") ? "/dashboard" : target);
    }

    private void fail(HttpServletRequest req, HttpServletResponse res, String username, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        req.setAttribute("username", username);
        WebUtil.render(req, res, "login");
    }
}


```

## src\main\java\com\skillhub\servlet\LogoutServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Use case: Logout. Includes "Invalidate Session" and "Redirect to Login". */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate Session
        }
        Flash.success(req, "You have been signed out successfully."); // new session only carries this message
        WebUtil.redirect(req, res, "/login"); // Redirect to Login
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        WebUtil.redirect(req, res, "/dashboard"); // logout is POST-only (protected by the CSRF token)
    }
}


```

## src\main\java\com\skillhub\servlet\ProfileServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Use case: Update Profile (Student and Trainer; Admin can also update their own). Also shows session tracking details. */
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        showProfile(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        String action = WebUtil.trim(req.getParameter("action"));
        List<String> errors = new ArrayList<>();

        if ("password".equals(action)) {
            String current = req.getParameter("current");
            String next = req.getParameter("password");
            String confirm = req.getParameter("confirm");
            if (!PasswordUtil.verify(current, user.getPasswordHash())) errors.add("Your current password is incorrect.");
            String problem = Validation.passwordProblem(next);
            if (problem != null) errors.add(problem);
            else if (!next.equals(confirm)) errors.add("New passwords do not match.");
            if (errors.isEmpty()) {
                user.setPasswordHash(PasswordUtil.hash(next));
                store.saveUser(user);
                Flash.success(req, "Your password was changed.");
                WebUtil.redirect(req, res, "/profile");
                return;
            }
        } else {
            User form = new User();
            form.setFullName(WebUtil.trim(req.getParameter("fullName")));
            form.setEmail(WebUtil.trim(req.getParameter("email")));
            form.setPhone(WebUtil.trim(req.getParameter("phone")));
            form.setRole(user.getRole());
            form.setUsername(user.getUsername());
            if (form.getFullName().length() < 3 || form.getFullName().length() > 60) errors.add("Full name must be 3 to 60 characters.");
            if (!Validation.validEmail(form.getEmail())) errors.add("Please enter a valid email address.");
            if (!Validation.validPhone(form.getPhone())) errors.add("Phone number format is invalid.");
            if (errors.isEmpty()) {
                user.setFullName(form.getFullName());
                user.setEmail(form.getEmail());
                user.setPhone(form.getPhone());
                store.saveUser(user);
                Flash.success(req, "Your profile was updated.");
                WebUtil.redirect(req, res, "/profile");
                return;
            }
            req.setAttribute("formUser", form);
        }
        req.setAttribute("errors", errors);
        showProfile(req, res);
    }

    private void showProfile(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession();
        req.setAttribute("sessionCreated", new Date(s.getCreationTime()));
        req.setAttribute("sessionLastAccess", new Date(s.getLastAccessedTime()));
        req.setAttribute("sessionTimeoutMinutes", s.getMaxInactiveInterval() / 60);
        req.setAttribute("sessionIdShort", s.getId().substring(0, Math.min(8, s.getId().length())) + "...");
        WebUtil.render(req, res, "profile");
    }
}


```

## src\main\java\com\skillhub\servlet\RegisterServlet.java

```java
package com.skillhub.servlet;

import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: Register Account (Student self-registration). */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (!registrationOpen(req)) {
            Flash.error(req, "Online registration is currently closed. Please contact the academy.");
            WebUtil.redirect(req, res, "/login");
            return;
        }
        req.setAttribute("formUser", new User());
        WebUtil.render(req, res, "register");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (!registrationOpen(req)) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        InMemoryStore store = WebUtil.store(req);
        User u = new User();
        u.setFullName(WebUtil.trim(req.getParameter("fullName")));
        u.setUsername(WebUtil.trim(req.getParameter("username")));
        u.setEmail(WebUtil.trim(req.getParameter("email")));
        u.setPhone(WebUtil.trim(req.getParameter("phone")));
        u.setRole(Role.STUDENT);
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");

        List<String> errors = new ArrayList<>();
        if (u.getFullName().length() < 3 || u.getFullName().length() > 60) errors.add("Full name must be 3 to 60 characters.");
        if (!Validation.validUsername(u.getUsername())) errors.add("Username must be 4 to 20 characters (letters, numbers, . _ -).");
        else if (store.usernameTaken(u.getUsername(), 0)) errors.add("That username is already taken.");
        if (!Validation.validEmail(u.getEmail())) errors.add("Please enter a valid email address.");
        if (!Validation.validPhone(u.getPhone())) errors.add("Phone number format is invalid.");
        String pwProblem = Validation.passwordProblem(password);
        if (pwProblem != null) errors.add(pwProblem);
        else if (!password.equals(confirm)) errors.add("Passwords do not match.");

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("formUser", u);
            WebUtil.render(req, res, "register");
            return;
        }
        u.setPasswordHash(PasswordUtil.hash(password));
        store.saveUser(u);
        store.log("New student registered: " + u.getFullName());
        Flash.success(req, "Account created. You can now sign in.");
        WebUtil.redirect(req, res, "/login");
    }

    private boolean registrationOpen(HttpServletRequest req) {
        return Boolean.TRUE.equals(req.getServletContext().getAttribute("registrationOpen"));
    }
}


```

## src\main\java\com\skillhub\store\InMemoryStore.java

```java
package com.skillhub.store;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.util.PasswordUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Application data held entirely in memory (no database), as required by the assessment.
 * One instance is created by AppContextListener and stored in the ServletContext (application scope).
 * All collections are thread-safe because many request threads share this object.
 */
public class InMemoryStore {
    private static final int LOCK_MAX_FAILURES = 5;
    private static final long LOCK_WINDOW_MS = 5 * 60 * 1000L;
    private static final DateTimeFormatter LOG_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final Map<Integer, Course> courses = new ConcurrentHashMap<>();
    private final Map<Integer, Enrolment> enrolments = new ConcurrentHashMap<>();
    private final Map<Integer, Attendance> attendance = new ConcurrentHashMap<>();
    private final AtomicInteger userSeq = new AtomicInteger();
    private final AtomicInteger courseSeq = new AtomicInteger();
    private final AtomicInteger enrolSeq = new AtomicInteger();
    private final AtomicInteger attSeq = new AtomicInteger();
    private final Deque<String> activityLog = new ConcurrentLinkedDeque<>();
    private final Map<String, long[]> failedLogins = new ConcurrentHashMap<>();
    private final String dummyHash = PasswordUtil.hash("not-a-real-password");

    // ---------------------------------------------------------------- users

    public List<User> findUsers(Role role) {
        return users.values().stream()
                .filter(u -> role == null || u.getRole() == role)
                .sorted(Comparator.comparingInt(User::getId))
                .collect(Collectors.toList());
    }

    public User findUser(int id) {
        return users.get(id);
    }

    public User findByUsername(String username) {
        if (username == null) return null;
        for (User u : users.values()) {
            if (u.getUsername().equalsIgnoreCase(username.trim())) return u;
        }
        return null;
    }

    public boolean usernameTaken(String username, int exceptId) {
        User u = findByUsername(username);
        return u != null && u.getId() != exceptId;
    }

    public synchronized User saveUser(User u) {
        if (u.getId() == 0) {
            u.setId(userSeq.incrementAndGet());
        }
        users.put(u.getId(), u);
        return u;
    }

    public synchronized void deleteUser(int id) {
        users.remove(id);
        enrolments.values().removeIf(e -> e.getStudentId() == id);
        attendance.values().removeIf(a -> a.getStudentId() == id);
    }

    /** Returns the user when the credentials are valid and the account is active, otherwise null. */
    public User authenticate(String username, String password) {
        User u = findByUsername(username);
        if (u == null) {
            PasswordUtil.verify(password, dummyHash); // keep timing similar for unknown users
            return null;
        }
        if (!u.isActive()) {
            return null;
        }
        return PasswordUtil.verify(password, u.getPasswordHash()) ? u : null;
    }

    public boolean isLocked(String username) {
        String key = username.toLowerCase();
        long[] rec = failedLogins.get(key);
        if (rec == null) return false;
        if (System.currentTimeMillis() - rec[1] > LOCK_WINDOW_MS) {
            failedLogins.remove(key);
            return false;
        }
        return rec[0] >= LOCK_MAX_FAILURES;
    }

    public synchronized void recordFailure(String username) {
        String key = username.toLowerCase();
        long[] rec = failedLogins.get(key);
        if (rec == null || System.currentTimeMillis() - rec[1] > LOCK_WINDOW_MS) {
            failedLogins.put(key, new long[] {1, System.currentTimeMillis()});
        } else {
            rec[0]++;
        }
    }

    public void clearFailures(String username) {
        failedLogins.remove(username.toLowerCase());
    }

    // -------------------------------------------------------------- courses

    public List<Course> findCourses() {
        return courses.values().stream()
                .sorted(Comparator.comparingInt(Course::getId))
                .collect(Collectors.toList());
    }

    public Course findCourse(int id) {
        return courses.get(id);
    }

    public List<Course> coursesByTrainer(int trainerId) {
        return findCourses().stream().filter(c -> c.getTrainerId() == trainerId).collect(Collectors.toList());
    }

    public boolean courseCodeTaken(String code, int exceptId) {
        return courses.values().stream()
                .anyMatch(c -> c.getCode().equalsIgnoreCase(code) && c.getId() != exceptId);
    }

    public synchronized Course saveCourse(Course c) {
        if (c.getId() == 0) {
            c.setId(courseSeq.incrementAndGet());
        }
        courses.put(c.getId(), c);
        return c;
    }

    public int enrolledCount(int courseId) {
        return (int) enrolments.values().stream()
                .filter(e -> e.getCourseId() == courseId && "ACTIVE".equals(e.getStatus()))
                .count();
    }

    // ----------------------------------------------------------- enrolments

    /** Newest first. */
    public List<Enrolment> findEnrolments() {
        return enrolments.values().stream()
                .sorted(Comparator.comparingInt(Enrolment::getId).reversed())
                .collect(Collectors.toList());
    }

    public List<Enrolment> enrolmentsByStudent(int studentId) {
        return findEnrolments().stream().filter(e -> e.getStudentId() == studentId).collect(Collectors.toList());
    }

    public List<Enrolment> enrolmentsByCourse(int courseId) {
        return findEnrolments().stream().filter(e -> e.getCourseId() == courseId).collect(Collectors.toList());
    }

    public boolean isEnrolled(int studentId, int courseId) {
        return enrolments.values().stream().anyMatch(e -> e.getStudentId() == studentId
                && e.getCourseId() == courseId && "ACTIVE".equals(e.getStatus()));
    }

    /** Enrols a student. Returns an error message, or null on success. */
    public synchronized String enrol(int studentId, int courseId) {
        User s = findUser(studentId);
        Course c = findCourse(courseId);
        if (s == null || s.getRole() != Role.STUDENT) return "The selected student was not found.";
        if (c == null || !c.isActive()) return "The selected course is not available.";
        if (isEnrolled(studentId, courseId)) return s.getFullName() + " is already enrolled in " + c.getCode() + ".";
        if (enrolledCount(courseId) >= c.getCapacity()) return c.getCode() + " is full. No seats are available.";
        Enrolment e = new Enrolment();
        e.setId(enrolSeq.incrementAndGet());
        e.setStudentId(studentId);
        e.setCourseId(courseId);
        e.setEnrolledOn(LocalDate.now());
        enrolments.put(e.getId(), e);
        log(s.getFullName() + " enrolled in " + c.getCode());
        return null;
    }

    // ----------------------------------------------------------- attendance

    public List<Attendance> findAttendance() {
        return sortAttendance(attendance.values());
    }

    public List<Attendance> attendanceByCourse(int courseId) {
        return sortAttendance(attendance.values().stream()
                .filter(a -> a.getCourseId() == courseId).collect(Collectors.toList()));
    }

    public List<Attendance> attendanceByStudent(int studentId) {
        return sortAttendance(attendance.values().stream()
                .filter(a -> a.getStudentId() == studentId).collect(Collectors.toList()));
    }

    /** Saves (or replaces) attendance for each student for the given course and date. */
    public synchronized void markAttendance(int courseId, LocalDate date, Map<Integer, String> statuses) {
        for (Map.Entry<Integer, String> en : statuses.entrySet()) {
            attendance.values().removeIf(a -> a.getCourseId() == courseId
                    && a.getStudentId() == en.getKey() && a.getDate().equals(date));
            Attendance a = new Attendance();
            a.setId(attSeq.incrementAndGet());
            a.setCourseId(courseId);
            a.setStudentId(en.getKey());
            a.setDate(date);
            a.setStatus(en.getValue());
            attendance.put(a.getId(), a);
        }
    }

    /** Percentage of sessions attended (PRESENT or LATE). */
    public static int attendanceRate(Collection<Attendance> records) {
        if (records.isEmpty()) return 0;
        long attended = records.stream().filter(a -> !Attendance.ABSENT.equals(a.getStatus())).count();
        return (int) Math.round(attended * 100.0 / records.size());
    }

    private static List<Attendance> sortAttendance(Collection<Attendance> src) {
        List<Attendance> list = new ArrayList<>(src);
        list.sort(Comparator.comparing(Attendance::getDate).thenComparingInt(Attendance::getId).reversed());
        return list;
    }

    // ---------------------------------------------------------- activity log

    public void log(String message) {
        String clean = message == null ? "" : message.replaceAll("[\\r\\n\\t]", " ");
        activityLog.addFirst(LocalDateTime.now().format(LOG_TIME) + "  " + clean);
        while (activityLog.size() > 100) {
            activityLog.pollLast();
        }
    }

    public List<String> recentLog(int max) {
        return activityLog.stream().limit(max).collect(Collectors.toList());
    }

    // ------------------------------------------------------------- seed data

    /** Loads the demo data: one admin, one trainer, one student, four courses. */
    public void seed() {
        User admin = newUser("admin", "Admin@123", "Naditha Roshana", "naditha.roshana@skillhub.lk", "0771234501", Role.ADMIN);
        User trainer = newUser("anjali", "Trainer@123", "U.Anjali", "u.anjali@skillhub.lk", "0771234502", Role.TRAINER);
        User student = newUser("student", "Student@123", "One Student", "one.student@skillhub.lk", "0771234503", Role.STUDENT);

        Course c1 = newCourse("JEE101", "Java EE Web Development", "Technology",
                "Servlets, JSP, sessions, filters, listeners and WAR deployment on Apache Tomcat.",
                trainer.getId(), 12, 25, 85000, "Mon & Wed, 6:00 - 8:00 PM");
        Course c2 = newCourse("WEB201", "Modern Frontend Development", "Technology",
                "Responsive interfaces with HTML5, CSS3, JavaScript and Bootstrap.",
                trainer.getId(), 10, 30, 65000, "Tue & Thu, 6:00 - 8:00 PM");
        newCourse("BUS110", "Project Management Essentials", "Business",
                "Planning, scheduling, risk and stakeholder management for new project leaders.",
                trainer.getId(), 8, 20, 48000, "Saturday, 9:00 AM - 1:00 PM");
        newCourse("PRO150", "Professional Communication Skills", "Professional Development",
                "Business writing, presentations and workplace communication.",
                trainer.getId(), 6, 40, 30000, "Sunday, 10:00 AM - 12:00 PM");

        enrolDirect(student.getId(), c1.getId(), LocalDate.now().minusDays(30));
        enrolDirect(student.getId(), c2.getId(), LocalDate.now().minusDays(21));

        String[] statuses = {Attendance.PRESENT, Attendance.PRESENT, Attendance.LATE, Attendance.PRESENT, Attendance.ABSENT};
        for (int i = 0; i < statuses.length; i++) {
            LocalDate d = LocalDate.now().minusDays((statuses.length - i) * 3L);
            Map<Integer, String> m = new ConcurrentHashMap<>();
            m.put(student.getId(), statuses[i]);
            markAttendance(c1.getId(), d, m);
            Map<Integer, String> m2 = new ConcurrentHashMap<>();
            m2.put(student.getId(), i == 3 ? Attendance.LATE : Attendance.PRESENT);
            markAttendance(c2.getId(), d.plusDays(1), m2);
        }
        log("System started. Demo data loaded for " + admin.getFullName() + ", " + trainer.getFullName()
                + " and " + student.getFullName());
    }

    private User newUser(String username, String password, String name, String email, String phone, Role role) {
        User u = new User();
        u.setUsername(username);
        u.setPasswordHash(PasswordUtil.hash(password));
        u.setFullName(name);
        u.setEmail(email);
        u.setPhone(phone);
        u.setRole(role);
        u.setCreatedAt(LocalDate.now().minusDays(60));
        return saveUser(u);
    }

    private Course newCourse(String code, String title, String cat, String desc, int trainerId,
                             int weeks, int cap, double fee, String schedule) {
        Course c = new Course();
        c.setCode(code);
        c.setTitle(title);
        c.setCategory(cat);
        c.setDescription(desc);
        c.setTrainerId(trainerId);
        c.setDurationWeeks(weeks);
        c.setCapacity(cap);
        c.setFee(fee);
        c.setSchedule(schedule);
        return saveCourse(c);
    }

    private void enrolDirect(int studentId, int courseId, LocalDate on) {
        Enrolment e = new Enrolment();
        e.setId(enrolSeq.incrementAndGet());
        e.setStudentId(studentId);
        e.setCourseId(courseId);
        e.setEnrolledOn(on);
        enrolments.put(e.getId(), e);
    }
}


```

## src\main\java\com\skillhub\util\Flash.java

```java
package com.skillhub.util;

import javax.servlet.http.HttpServletRequest;

/** One-time messages stored in the session and shown after a redirect. */
public final class Flash {
    private Flash() { }

    public static void success(HttpServletRequest req, String msg) { set(req, "success", msg); }
    public static void error(HttpServletRequest req, String msg) { set(req, "danger", msg); }
    public static void info(HttpServletRequest req, String msg) { set(req, "info", msg); }

    private static void set(HttpServletRequest req, String type, String msg) {
        req.getSession(true).setAttribute("flashType", type);
        req.getSession(true).setAttribute("flashMsg", msg);
    }
}


```

## src\main\java\com\skillhub\util\PasswordUtil.java

```java
package com.skillhub.util;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/** Salted PBKDF2 password hashing. Passwords are never stored in plain text. */
public final class PasswordUtil {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int ITERATIONS = 65536;
    private static final int KEY_BITS = 256;

    private PasswordUtil() { }

    /** Returns "base64(salt):base64(hash)". */
    public static String hash(String password) {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        byte[] hash = pbkdf2(password.toCharArray(), salt);
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verify(String password, String stored) {
        if (password == null || stored == null) {
            return false;
        }
        String[] parts = stored.split(":");
        if (parts.length != 2) {
            return false;
        }
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] expected = Base64.getDecoder().decode(parts[1]);
        byte[] actual = pbkdf2(password.toCharArray(), salt);
        return MessageDigest.isEqual(expected, actual); // constant-time comparison
    }

    /** Random temporary password containing upper, lower and digit characters. */
    public static String randomPassword(int length) {
        String upper = "ABCDEFGHJKLMNPQRSTUVWXYZ";
        String lower = "abcdefghijkmnpqrstuvwxyz";
        String digits = "23456789";
        String all = upper + lower + digits;
        StringBuilder sb = new StringBuilder();
        sb.append(upper.charAt(RANDOM.nextInt(upper.length())));
        sb.append(lower.charAt(RANDOM.nextInt(lower.length())));
        sb.append(digits.charAt(RANDOM.nextInt(digits.length())));
        while (sb.length() < Math.max(length, 8)) {
            sb.append(all.charAt(RANDOM.nextInt(all.length())));
        }
        return sb.toString();
    }

    private static byte[] pbkdf2(char[] password, byte[] salt) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return factory.generateSecret(new PBEKeySpec(password, salt, ITERATIONS, KEY_BITS)).getEncoded();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Password hashing is unavailable", e);
        }
    }
}


```

## src\main\java\com\skillhub\util\Validation.java

```java
package com.skillhub.util;

import java.util.regex.Pattern;

/** Server-side input validation helpers. */
public final class Validation {
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern USERNAME = Pattern.compile("^[A-Za-z0-9._-]{4,20}$");
    private static final Pattern PHONE = Pattern.compile("^[0-9+\\- ]{7,15}$");

    private Validation() { }

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean validEmail(String s) {
        return s != null && s.length() <= 100 && EMAIL.matcher(s).matches();
    }

    public static boolean validUsername(String s) {
        return s != null && USERNAME.matcher(s).matches();
    }

    /** Phone is optional: blank is accepted. */
    public static boolean validPhone(String s) {
        return isBlank(s) || PHONE.matcher(s.trim()).matches();
    }

    /** Returns a message describing the problem, or null if the password is acceptable. */
    public static String passwordProblem(String p) {
        if (p == null || p.length() < 8) {
            return "Password must be at least 8 characters long.";
        }
        boolean letter = false;
        boolean digit = false;
        for (char c : p.toCharArray()) {
            if (Character.isLetter(c)) letter = true;
            if (Character.isDigit(c)) digit = true;
        }
        if (!letter || !digit) {
            return "Password must contain at least one letter and one number.";
        }
        return null;
    }
}


```

## src\main\java\com\skillhub\util\WebUtil.java

```java
package com.skillhub.util;

import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Small helpers shared by all servlets. */
public final class WebUtil {
    private WebUtil() { }

    public static InMemoryStore store(ServletContext ctx) {
        return (InMemoryStore) ctx.getAttribute("store");
    }

    public static InMemoryStore store(HttpServletRequest req) {
        return store(req.getServletContext());
    }

    /** The signed-in user, placed on the request by AuthenticationFilter. */
    public static User currentUser(HttpServletRequest req) {
        return (User) req.getAttribute("currentUser");
    }

    /** Forwards to /WEB-INF/jsp/{view}.jsp using a RequestDispatcher. */
    public static void render(HttpServletRequest req, HttpServletResponse res, String view)
            throws ServletException, IOException {
        attachLookups(req);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/" + view + ".jsp");
        rd.forward(req, res);
    }

    public static void redirect(HttpServletRequest req, HttpServletResponse res, String path) throws IOException {
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + path));
    }

    public static String trim(String s) {
        return s == null ? "" : s.trim();
    }

    public static int toInt(String s, int def) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    public static double toDouble(String s, double def) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    /** Lookup maps so JSP pages can show names without extra queries. */
    private static void attachLookups(HttpServletRequest req) {
        InMemoryStore store = store(req);
        Map<Integer, String> userNames = new HashMap<>();
        Map<Integer, Integer> enrolByStudent = new HashMap<>();
        Map<Integer, Integer> coursesByTrainer = new HashMap<>();
        Map<Integer, Integer> enrolByCourse = new HashMap<>();
        Map<Integer, Course> courseMap = new HashMap<>();

        for (User u : store.findUsers(null)) {
            userNames.put(u.getId(), u.getFullName());
            if (u.getRole() == Role.STUDENT) enrolByStudent.put(u.getId(), 0);
            if (u.getRole() == Role.TRAINER) coursesByTrainer.put(u.getId(), 0);
        }
        for (Course c : store.findCourses()) {
            courseMap.put(c.getId(), c);
            enrolByCourse.put(c.getId(), 0);
            coursesByTrainer.merge(c.getTrainerId(), 1, Integer::sum);
        }
        for (Enrolment e : store.findEnrolments()) {
            if ("ACTIVE".equals(e.getStatus())) {
                enrolByCourse.merge(e.getCourseId(), 1, Integer::sum);
                enrolByStudent.merge(e.getStudentId(), 1, Integer::sum);
            }
        }
        req.setAttribute("userNames", userNames);
        req.setAttribute("courseMap", courseMap);
        req.setAttribute("enrolByCourse", enrolByCourse);
        req.setAttribute("enrolByStudent", enrolByStudent);
        req.setAttribute("coursesByTrainer", coursesByTrainer);
    }
}


```

## src\main\webapp\WEB-INF\web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <display-name>SkillHub Training Academy Portal</display-name>
    <description>Training management portal: students, trainers, courses, enrolments and attendance.</description>

    <!-- ===================== Application-wide settings (ServletContext init-params) ===================== -->
    <context-param>
        <param-name>academyName</param-name>
        <param-value>SkillHub Training Academy</param-value>
    </context-param>
    <context-param>
        <param-name>supportEmail</param-name>
        <param-value>support@skillhub.lk</param-value>
    </context-param>
    <context-param>
        <param-name>defaultCapacity</param-name>
        <param-value>30</param-value>
    </context-param>
    <context-param>
        <param-name>registrationOpen</param-name>
        <param-value>true</param-value>
    </context-param>

    <!-- ===================== Listeners ===================== -->
    <listener><listener-class>com.skillhub.listener.AppContextListener</listener-class></listener>
    <listener><listener-class>com.skillhub.listener.SessionTrackingListener</listener-class></listener>
    <listener><listener-class>com.skillhub.listener.RequestStatsListener</listener-class></listener>

    <!-- ===================== Filters (execution order = order of the mappings) ===================== -->
    <filter>
        <filter-name>EncodingFilter</filter-name>
        <filter-class>com.skillhub.filter.EncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter>
        <filter-name>SecurityHeadersFilter</filter-name>
        <filter-class>com.skillhub.filter.SecurityHeadersFilter</filter-class>
    </filter>
    <filter>
        <filter-name>AuthenticationFilter</filter-name>
        <filter-class>com.skillhub.filter.AuthenticationFilter</filter-class>
    </filter>
    <filter>
        <filter-name>AuthorizationFilter</filter-name>
        <filter-class>com.skillhub.filter.AuthorizationFilter</filter-class>
    </filter>
    <filter>
        <filter-name>CsrfFilter</filter-name>
        <filter-class>com.skillhub.filter.CsrfFilter</filter-class>
    </filter>

    <filter-mapping><filter-name>EncodingFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>SecurityHeadersFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>AuthenticationFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>AuthorizationFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>CsrfFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>

    <!-- ===================== Servlets ===================== -->
    <servlet><servlet-name>LoginServlet</servlet-name><servlet-class>com.skillhub.servlet.LoginServlet</servlet-class></servlet>
    <servlet><servlet-name>LogoutServlet</servlet-name><servlet-class>com.skillhub.servlet.LogoutServlet</servlet-class></servlet>
    <servlet><servlet-name>RegisterServlet</servlet-name><servlet-class>com.skillhub.servlet.RegisterServlet</servlet-class></servlet>
    <servlet><servlet-name>DashboardServlet</servlet-name><servlet-class>com.skillhub.servlet.DashboardServlet</servlet-class></servlet>
    <servlet><servlet-name>CourseServlet</servlet-name><servlet-class>com.skillhub.servlet.CourseServlet</servlet-class></servlet>
    <servlet><servlet-name>EnrolmentServlet</servlet-name><servlet-class>com.skillhub.servlet.EnrolmentServlet</servlet-class></servlet>
    <servlet><servlet-name>AttendanceServlet</servlet-name><servlet-class>com.skillhub.servlet.AttendanceServlet</servlet-class></servlet>
    <servlet><servlet-name>AttendanceMarkServlet</servlet-name><servlet-class>com.skillhub.servlet.AttendanceMarkServlet</servlet-class></servlet>
    <servlet><servlet-name>ProfileServlet</servlet-name><servlet-class>com.skillhub.servlet.ProfileServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminStudentServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminStudentServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminTrainerServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminTrainerServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminUserServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminUserServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminSettingsServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminSettingsServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminReportServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminReportServlet</servlet-class></servlet>

    <servlet-mapping><servlet-name>LoginServlet</servlet-name><url-pattern>/login</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>LogoutServlet</servlet-name><url-pattern>/logout</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>RegisterServlet</servlet-name><url-pattern>/register</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>DashboardServlet</servlet-name><url-pattern>/dashboard</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>CourseServlet</servlet-name><url-pattern>/courses</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>EnrolmentServlet</servlet-name><url-pattern>/enrolments</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AttendanceServlet</servlet-name><url-pattern>/attendance</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AttendanceMarkServlet</servlet-name><url-pattern>/attendance/mark</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>ProfileServlet</servlet-name><url-pattern>/profile</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminStudentServlet</servlet-name><url-pattern>/admin/students</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminTrainerServlet</servlet-name><url-pattern>/admin/trainers</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminUserServlet</servlet-name><url-pattern>/admin/users</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminSettingsServlet</servlet-name><url-pattern>/admin/settings</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminReportServlet</servlet-name><url-pattern>/admin/reports</url-pattern></servlet-mapping>

    <!-- ===================== Session management ===================== -->
    <session-config>
        <session-timeout>20</session-timeout>
        <cookie-config>
            <name>SKILLHUBSESSION</name>
            <http-only>true</http-only>
            <!-- Set <secure>true</secure> when the site is served over HTTPS -->
        </cookie-config>
        <tracking-mode>COOKIE</tracking-mode>
    </session-config>

    <!-- ===================== JSP configuration ===================== -->
    <jsp-config>
        <jsp-property-group>
            <description>All JSP pages: UTF-8, JSTL tag libraries pre-loaded, no stray whitespace</description>
            <url-pattern>*.jsp</url-pattern>
            <page-encoding>UTF-8</page-encoding>
            <scripting-invalid>true</scripting-invalid>
            <trim-directive-whitespaces>true</trim-directive-whitespaces>
            <include-prelude>/WEB-INF/jspf/taglibs.jspf</include-prelude>
        </jsp-property-group>
        <jsp-property-group>
            <description>Shared JSP fragments (header, footer, flash messages)</description>
            <url-pattern>*.jspf</url-pattern>
            <page-encoding>UTF-8</page-encoding>
            <scripting-invalid>true</scripting-invalid>
        </jsp-property-group>
    </jsp-config>

    <!-- ===================== Security ===================== -->
    <!-- Declarative security: block HTTP methods the application never uses (TRACE, PUT, DELETE, OPTIONS...). -->
    <security-constraint>
        <display-name>Block unused HTTP methods</display-name>
        <web-resource-collection>
            <web-resource-name>Unsupported methods</web-resource-name>
            <url-pattern>/*</url-pattern>
            <http-method-omission>GET</http-method-omission>
            <http-method-omission>POST</http-method-omission>
            <http-method-omission>HEAD</http-method-omission>
        </web-resource-collection>
        <auth-constraint/>
    </security-constraint>

    <!-- Authentication (login filter + session) and authorisation (role filter) are implemented in
         AuthenticationFilter and AuthorizationFilter; see the report, section 10. -->

    <!-- ===================== Error pages ===================== -->
    <error-page><error-code>400</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>403</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>404</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>405</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>500</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><exception-type>java.lang.Throwable</exception-type><location>/WEB-INF/jsp/error.jsp</location></error-page>

    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>


```

## target\skillhub\WEB-INF\web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <display-name>SkillHub Training Academy Portal</display-name>
    <description>Training management portal: students, trainers, courses, enrolments and attendance.</description>

    <!-- ===================== Application-wide settings (ServletContext init-params) ===================== -->
    <context-param>
        <param-name>academyName</param-name>
        <param-value>SkillHub Training Academy</param-value>
    </context-param>
    <context-param>
        <param-name>supportEmail</param-name>
        <param-value>support@skillhub.lk</param-value>
    </context-param>
    <context-param>
        <param-name>defaultCapacity</param-name>
        <param-value>30</param-value>
    </context-param>
    <context-param>
        <param-name>registrationOpen</param-name>
        <param-value>true</param-value>
    </context-param>

    <!-- ===================== Listeners ===================== -->
    <listener><listener-class>com.skillhub.listener.AppContextListener</listener-class></listener>
    <listener><listener-class>com.skillhub.listener.SessionTrackingListener</listener-class></listener>
    <listener><listener-class>com.skillhub.listener.RequestStatsListener</listener-class></listener>

    <!-- ===================== Filters (execution order = order of the mappings) ===================== -->
    <filter>
        <filter-name>EncodingFilter</filter-name>
        <filter-class>com.skillhub.filter.EncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter>
        <filter-name>SecurityHeadersFilter</filter-name>
        <filter-class>com.skillhub.filter.SecurityHeadersFilter</filter-class>
    </filter>
    <filter>
        <filter-name>AuthenticationFilter</filter-name>
        <filter-class>com.skillhub.filter.AuthenticationFilter</filter-class>
    </filter>
    <filter>
        <filter-name>AuthorizationFilter</filter-name>
        <filter-class>com.skillhub.filter.AuthorizationFilter</filter-class>
    </filter>
    <filter>
        <filter-name>CsrfFilter</filter-name>
        <filter-class>com.skillhub.filter.CsrfFilter</filter-class>
    </filter>

    <filter-mapping><filter-name>EncodingFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>SecurityHeadersFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>AuthenticationFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>AuthorizationFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>
    <filter-mapping><filter-name>CsrfFilter</filter-name><url-pattern>/*</url-pattern></filter-mapping>

    <!-- ===================== Servlets ===================== -->
    <servlet><servlet-name>LoginServlet</servlet-name><servlet-class>com.skillhub.servlet.LoginServlet</servlet-class></servlet>
    <servlet><servlet-name>LogoutServlet</servlet-name><servlet-class>com.skillhub.servlet.LogoutServlet</servlet-class></servlet>
    <servlet><servlet-name>RegisterServlet</servlet-name><servlet-class>com.skillhub.servlet.RegisterServlet</servlet-class></servlet>
    <servlet><servlet-name>DashboardServlet</servlet-name><servlet-class>com.skillhub.servlet.DashboardServlet</servlet-class></servlet>
    <servlet><servlet-name>CourseServlet</servlet-name><servlet-class>com.skillhub.servlet.CourseServlet</servlet-class></servlet>
    <servlet><servlet-name>EnrolmentServlet</servlet-name><servlet-class>com.skillhub.servlet.EnrolmentServlet</servlet-class></servlet>
    <servlet><servlet-name>AttendanceServlet</servlet-name><servlet-class>com.skillhub.servlet.AttendanceServlet</servlet-class></servlet>
    <servlet><servlet-name>AttendanceMarkServlet</servlet-name><servlet-class>com.skillhub.servlet.AttendanceMarkServlet</servlet-class></servlet>
    <servlet><servlet-name>ProfileServlet</servlet-name><servlet-class>com.skillhub.servlet.ProfileServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminStudentServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminStudentServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminTrainerServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminTrainerServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminUserServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminUserServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminSettingsServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminSettingsServlet</servlet-class></servlet>
    <servlet><servlet-name>AdminReportServlet</servlet-name><servlet-class>com.skillhub.servlet.AdminReportServlet</servlet-class></servlet>

    <servlet-mapping><servlet-name>LoginServlet</servlet-name><url-pattern>/login</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>LogoutServlet</servlet-name><url-pattern>/logout</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>RegisterServlet</servlet-name><url-pattern>/register</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>DashboardServlet</servlet-name><url-pattern>/dashboard</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>CourseServlet</servlet-name><url-pattern>/courses</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>EnrolmentServlet</servlet-name><url-pattern>/enrolments</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AttendanceServlet</servlet-name><url-pattern>/attendance</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AttendanceMarkServlet</servlet-name><url-pattern>/attendance/mark</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>ProfileServlet</servlet-name><url-pattern>/profile</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminStudentServlet</servlet-name><url-pattern>/admin/students</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminTrainerServlet</servlet-name><url-pattern>/admin/trainers</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminUserServlet</servlet-name><url-pattern>/admin/users</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminSettingsServlet</servlet-name><url-pattern>/admin/settings</url-pattern></servlet-mapping>
    <servlet-mapping><servlet-name>AdminReportServlet</servlet-name><url-pattern>/admin/reports</url-pattern></servlet-mapping>

    <!-- ===================== Session management ===================== -->
    <session-config>
        <session-timeout>20</session-timeout>
        <cookie-config>
            <name>SKILLHUBSESSION</name>
            <http-only>true</http-only>
            <!-- Set <secure>true</secure> when the site is served over HTTPS -->
        </cookie-config>
        <tracking-mode>COOKIE</tracking-mode>
    </session-config>

    <!-- ===================== JSP configuration ===================== -->
    <jsp-config>
        <jsp-property-group>
            <description>All JSP pages: UTF-8, JSTL tag libraries pre-loaded, no stray whitespace</description>
            <url-pattern>*.jsp</url-pattern>
            <page-encoding>UTF-8</page-encoding>
            <scripting-invalid>true</scripting-invalid>
            <trim-directive-whitespaces>true</trim-directive-whitespaces>
            <include-prelude>/WEB-INF/jspf/taglibs.jspf</include-prelude>
        </jsp-property-group>
        <jsp-property-group>
            <description>Shared JSP fragments (header, footer, flash messages)</description>
            <url-pattern>*.jspf</url-pattern>
            <page-encoding>UTF-8</page-encoding>
            <scripting-invalid>true</scripting-invalid>
        </jsp-property-group>
    </jsp-config>

    <!-- ===================== Security ===================== -->
    <!-- Declarative security: block HTTP methods the application never uses (TRACE, PUT, DELETE, OPTIONS...). -->
    <security-constraint>
        <display-name>Block unused HTTP methods</display-name>
        <web-resource-collection>
            <web-resource-name>Unsupported methods</web-resource-name>
            <url-pattern>/*</url-pattern>
            <http-method-omission>GET</http-method-omission>
            <http-method-omission>POST</http-method-omission>
            <http-method-omission>HEAD</http-method-omission>
        </web-resource-collection>
        <auth-constraint/>
    </security-constraint>

    <!-- Authentication (login filter + session) and authorisation (role filter) are implemented in
         AuthenticationFilter and AuthorizationFilter; see the report, section 10. -->

    <!-- ===================== Error pages ===================== -->
    <error-page><error-code>400</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>403</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>404</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>405</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><error-code>500</error-code><location>/WEB-INF/jsp/error.jsp</location></error-page>
    <error-page><exception-type>java.lang.Throwable</exception-type><location>/WEB-INF/jsp/error.jsp</location></error-page>

    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>


```

