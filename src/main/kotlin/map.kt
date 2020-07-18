package main.kotlin

fun main() {
    val map = HashMap<Char, Int>()
    map['a'] = map.getOrDefault('a', 0) + 1
    if (map.containsKey('a')) {
        map['a'] = map['a']!! + 1
    }
}