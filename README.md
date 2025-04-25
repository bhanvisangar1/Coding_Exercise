# WalmartCodingExercise

An Android application that fetches and displays a list of countries from a remote JSON source using modern development practices.

## 📋 Overview

This project is a programming exercise designed to:

- Fetch a list of countries in JSON format from a remote URL
- Display the list in a `RecyclerView` while preserving the order from the JSON
- Show detailed information for each country in a custom-styled list item
- Handle loading errors and edge cases gracefully

## 🌐 API Endpoint

Data is fetched from the following public URL:
https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json

## 🚀 Features

🔄 Fetch Countries – Retrieves a list of countries in real time from a remote JSON endpoint.
🧾 RecyclerView Display – Displays all countries in a scrollable list, preserving their original order.
🗺️ Country Details View – Shows each country's name, region, code, and capital in a custom-designed card.
📶 Network Error Handling – Handles issues like no internet, timeouts, or malformed JSON gracefully.
🧪 Robust Parsing – Ignores or handles missing fields in JSON without crashing the app.

## 🛠️ Tech Stack

- **Language:** Kotlin / Java
- **Minimum SDK:** 24
- **Target SDK:** 34
- **Build System:** Gradle
- **Architecture:** MVVM / MVI / Clean Architecture
- **Language:** Kotlin
- **UI:** RecyclerView, ViewBinding
- **Networking:** Retrofit, Gson
- **Error Handling:** Try-catch, response codes, user-friendly messages

### Prerequisites

- Android Studio Flamingo or later
- Android SDK 21+
- Kotlin 1.x / Java 8+
