#!/bin/sh

#JAVA_HOME=/home/toptea/local/jdk170

SERVICE_NAME=service-sysmgr
SERVICE_DIR=/home/toptea/local/service/$SERVICE_NAME
JAR_NAME=$SERVICE_NAME\.jar
PID=run\.pid



case "$1" in
                start)
                        nohup $JAVA_HOME/bin/java -Xms128m -Xmx256m -jar $JAR_NAME >std.out 2>&1 &
                        echo $! >$SERVICE_DIR/$PID
                        echo "Start $SERVICE_NAME ..." 
                        ;;

                stop)
                        kill `cat $SERVICE_DIR/$PID`
                        rm -rf $SERVICE_DIR/$PID
                        echo "Stop $SERVICE_NAME ..."

                        sleep 5
                        P_ID=`ps -ef | grep -w "$SERVICE_NAME" | grep -v "grep" | awk '{print $2}'`
                        if [ "$P_ID" == "" ]
                        then
                                echo "$SERVICE_NAME process not exists or stop success!"
                        else
                                echo "$SERVICE_NAME process pid is :$P_ID"
                                echo "begin kill $SERVICE_NAME process, pid is:$P_ID"
                                kill -9 $P_ID
                        fi
                        ;;

                restart)
                        $0 stop
                        sleep 2
                        $0 start
                        echo "restart service $SERVICE_NAME!"
                        ;;

                *)
                        $0 stop
                        sleep 2
                        $0 start
                        ;;

esac
exit 0