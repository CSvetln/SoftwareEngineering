package com.auten.interfaces.softwareengineering

interface IParse {
    val args: Array<String>
    val isHelp: Boolean
    val login: String
    val pass: String
    val res: String
    val role: String
    val ds: String
    val de: String
    val vol: String
}