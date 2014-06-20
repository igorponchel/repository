@echo off

call classpath.bat


%JAVA_BIN% -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB -classpath %CP% org.openorb.util.MapNamingContext -ORBPort=2001 -print
pause