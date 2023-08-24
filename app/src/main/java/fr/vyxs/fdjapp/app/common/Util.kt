package fr.vyxs.fdjapp.app.common

import kotlinx.coroutines.*

fun <T, V> debounceMap(consumer: (V) -> Unit, map: (T) -> V): (T) -> Unit {
    var job: Job? = null
    return { param: T ->
        job?.cancel()
        job = CoroutineScope(Dispatchers.IO).launch {
            delay(1000L)
            consumer(map(param))
        }
    }
}