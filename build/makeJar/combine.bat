@echo off
::ת����ǰ�̷�
%~d0
::�򿪵�ǰĿ¼
cd %~dp0
::��������JAR����·��
set MainJar=douwanane.jar
::������JAR����·��  �Զ����޸�
set ExternalJar=cmge0422.jar
set ExternalJar2=UnionPayPlugin11.jar
::������JAR������������
set packageName=com
set packageName2=cn
set packageName3=assets
echo =========== start combin ==============
::��ѹ��������
jar -xf %ExternalJar%
::jar -xf %ExternalJar2%
::�ϲ���JAR��
jar -uf %MainJar% %packageName% 
::������б�Ķ��������Խ��źϲ������磺
jar -uf %MainJar% %packageName2%
::jar -uf %MainJar% %packageName3%
echo =========== over ==============
echo �ٵ�һ�¾ͽ�����--СQ
pause