#!/bin/sh
# ----------------------------------------------------------------------------
# Maven Wrapper Start Up Script
# ----------------------------------------------------------------------------

# Check if JAVA_HOME is set
if [ -z "$JAVA_HOME" ]; then
  JAVA_HOME=$(/usr/libexec/java_home 2>/dev/null)
fi

if [ -z "$JAVA_HOME" ]; then
  echo "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH."
  echo "Please set the JAVA_HOME variable in your environment to match the"
  echo "location of your Java installation."
  exit 1
fi

# Maven Wrapper configuration
MAVEN_WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES=".mvn/wrapper/maven-wrapper.properties"

# Resolve Maven home from wrapper properties
if [ -f "$MAVEN_WRAPPER_PROPERTIES" ]; then
  DISTRIBUTION_URL=$(grep "^distributionUrl=" "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2-)
  MAVEN_HOME="$HOME/.m2/wrapper/dists"
fi

# Use the Maven wrapper to run the Maven command
exec "$JAVA_HOME/bin/java" \
  -classpath "$MAVEN_WRAPPER_JAR" \
  -Dmaven.multiModuleProjectDirectory="$PWD" \
  org.apache.maven.wrapper.MavenWrapperMain \
  "$@"
