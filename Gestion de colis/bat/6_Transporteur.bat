@echo off

call classpath.bat

set /p NUM_TRANSPORTEUR=Num�ro de transporteur ?

%JAVA_BIN% -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB -classpath %CP% entites.Transporteur %NUM_TRANSPORTEUR%
pause