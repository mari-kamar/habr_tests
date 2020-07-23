#!/bin/bash
echo "Запуск скрипта настройки окружения для параллельного тестирования"
echo "Скачивание selenoid"
curl -Lo cm https://github.com/aerokube/cm/releases/download/1.2.0/cm_darwin_amd64
echo "Смена прав для файла"
chmod +x ./cm
echo "Запуск selenoid"
./cm selenoid start --vnc
echo "Обновление/скачивание браузеров"
./cm selenoid update
echo "Запуск selenoid-ui"
./cm selenoid-ui start
echo "Запуск тестов"
mvn clean test -DsuiteXmlFile=testng.xml