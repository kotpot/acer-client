# PinTask-client

PinTask client. Build with Kotlin Multiplatform.


## Shared Module

### Common Public Utils

- Network Repository
- Local Repository
- Compose Ui Component

### Expect Interface

- NetRequest Agreement Interface [NAI]
- Local Agreement Interface [LAI]

### Android Impl

- NAI Impl: Ktor Client
- LAI: MMKV-Kotlin

### Ios Impl

- NAI Impl: Ktor Client
- LAI: MMKV-Kotlin

### MacOS Impl(X64+ArmX64)

- NAI Impl: Ktor Client, Engine Darwin
- LAI: MMKV-Kotlin

### MinGW Impl

- NAI: Ktor Client, Engine ktor-client-winhttp
- LAI: MMKV-Kotlin

## Mobile Client

Composition UI

## Desktop Client

Composition UI + Native Container

- Pin Function
- Scale Option
- File Upload
