package com.mateuszholik.common.extensions

inline fun <reified T : Enum<T>> String?.toEnum(defaultValue: T): T =
    enumValues<T>().find { it.name == this } ?: defaultValue
