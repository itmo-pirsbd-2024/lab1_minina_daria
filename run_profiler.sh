#!/bin/bash

# Укажите путь к async-profiler
ASYNC_PROFILER_HOME=/Users/dascha/IdeaProjects/lab1/async-profiler

# Сборка проекта
./gradlew build

# Запуск нагрузочного теста с профилированием
java -agentpath:${ASYNC_PROFILER_HOME}/build/lib/libasyncProfiler.dylib=start,event=cpu,file=profile.html -cp build/classes/java/main org.example.PerformanceRunner