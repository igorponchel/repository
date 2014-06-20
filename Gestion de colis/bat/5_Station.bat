@echo off

call classpath.bat

set /p NOM_STATION=Nom de la station ?

%JAVA_BIN% -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB -classpath %CP% entites.Station %NOM_STATION%
pause