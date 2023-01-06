echo Presiona la tecla Enter para crear las 4 instancias
echo Nombre: Elvis Herrera
echo Materia: Programación Distribuida
CD build
CD install
CD examen01_emherrerat
start java -Dserver.port=8080 -classpath lib/* com.distribuida.servidor
start java -Dserver.port=8081 -classpath lib/* com.distribuida.servidor
start java -Dserver.port=9090 -classpath lib/* com.distribuida.servidor
start java -Dserver.port=9091 -classpath lib/* com.distribuida.servidor
PAUSE