package affinitas.com.affinitaspersonalitytest.schedulers

import rx.Observable

interface ThreadScheduler {
    fun <T> compose(): Observable.Transformer<T, T>
}