@echo off

call classpath.bat

%JAVA_BIN% -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB -classpath %CP% entites.GestionnaireTransportObjet
pause