#!/usr/bin/env bash

rm -rf build/doc
java -jar dokka-fatjar.jar src/main/kotlin -output build/doc/ -format markdown -module BotClient-Kotlin
