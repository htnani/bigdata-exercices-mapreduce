#!/bin/bash
apt-get update
yes | apt-get upgrade
yes | apt-get install samba
yes bigdata | smbpasswd -a bigdata -s
mkdir /data
chown bigdata:bigdata /data
echo >> /etc/samba/smb.conf
echo "[data]" >> /etc/samba/smb.conf
echo "path = /data" >> /etc/samba/smb.conf
echo "available = yes" >> /etc/samba/smb.conf
echo "valid users = bigdata" >> /etc/samba/smb.conf
echo "browseable = yes" >> /etc/samba/smb.conf
echo "public = yes" >> /etc/samba/smb.conf
echo "writable = yes" >> /etc/samba/smb.conf
restart smbd
sudo -u hdfs hadoop fs -mkdir /user/bigdata
sudo -u hdfs hadoop fs -chown bigdata /user/bigdata
yes | apt-get install git maven
update-alternatives --set java /usr/lib/jvm/j2sdk1.6-oracle/jre/bin/java
cd /data
sudo -u bigdata git clone https://github.com/jfim/bigdata-exercices-mapreduce.git

